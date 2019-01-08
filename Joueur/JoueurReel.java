package Joueur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import Carte.Prop;
import Carte.Trick;
import Modele.Jeu;
import Vue.PanelTrick;


public class JoueurReel extends Joueur {
    private double age;
    private Jeu JeuActuel;
    private Trick trickP;
   
	public void setCarteMain(Prop carteMain) {
		this.getMain().add(carteMain);
	}

	public JoueurReel(double age, String nom) {
		super();
		this.age = age;
		super.setNom(nom);
		
	}
	
	public boolean donnerProp (ArrayList<Prop> propCentre, String echange) {
		boolean OK = false;
		int ech = -1;
		while (OK == true) {
		if (propCentre.size()>1) {
		System.out.println("==================");
		System.out.println("Quelle carte voulez-vous donner � " + echange + " ?" );
		Scanner sc = new Scanner(System.in);
		ech = sc.nextInt() -1;
		if (ech == 0 || ech == 1) {
			OK = true;
		}
		} 
		}
		if (ech == 0) {
			return true; 
		}
		else {
			return false; 
		}
		}
	
	public ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre) {
		int k = this.getMain().size();
		ArrayList<Prop> props = propCentre;
		boolean OK = false;
		for (int i = 0; i<this.getMain().size(); i++) {
			this.getMain().get(i).setIsFaceUp(false);
		}
		props.addAll(getMain());
		for (int i =0; i<props.size();i++) {
			System.out.println((i+1) + ". " + props.get(i).getNomP());
		}
		int k1 = props.size();
		int p = 0;
		System.out.println("==================");
		System.out.println("Vous devez choisir " + k + " cartes parmi toutes ces cartes.");
		while (OK ==false) {
			this.supprimerMain();
			for (int j=1;j<=k;j++) {
				System.out.println("==================");
				System.out.println("S�lectionnez la position de la carte n�"+j+" � ajouter dans votre jeu.");
				try {
					this.JeuActuel.pause();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int pos = this.JeuActuel.getiPropFinTour();
				if (pos>=0 && pos <k1) {
					p++;
					this.setCarteMain(props.get(pos));
					props.remove(pos);
				}
			}
			if (p == k) {
				OK = true;
			}
			else {
				p=0;
				props.addAll(getMain());
				for (int i =0; i<props.size();i++) {
					System.out.println((i+1) + ". " + props.get(i).getNomP());
				}
				System.out.println("Vous avez fait une erreur, veuillez recommencer");
			}
		}
		return props;
		
	}
	
	public void retournerCarte() {
		int j = 0;
		int pos = 0;
		boolean OK=false;
		for (int i = 0; i<this.getMain().size();i++) {
			if (this.getMain().get(i).getIsFaceUp()) {
				j=j+1;
			}
			else if (this.getMain().get(i).getIsFaceUp()== false) {
				pos = i;
			}
			
		}
		if (j==(this.getMain().size()-1)) {
			this.getMain().get(pos).setIsFaceUp(true);
		}
		else if (j == this.getMain().size()) {
			System.out.println("Vos cartes sont d�j� retourn�es.");
		}
		else {
			while (OK == false) {
				System.out.println("Choisissez une carte � montrer (entrer une position)");
				this.JeuActuel.getiPropFinTour();
				int choixProp = this.JeuActuel.getiPropFinTour();
				System.out.println("==================");
				if (this.getMain().get(choixProp).getIsFaceUp()==false) {
					this.getMain().get(choixProp).setIsFaceUp(true);
					OK = true;
				}
				else {
					System.out.println("Vous avez choisi une carte d�j� retourn�e ou une position qui n'existe pas");
				}
		}
	}
	}
	
	
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		super.setTrickARealiser(trickARealiser);
		boolean OK = false;
		boolean trickChoix =false;
		while (OK == false) {
		
		System.out.println(this.getTrickARealiser().get(0).toString());
		System.out.println("Voulez-vous r�aliser ce Trick ?");	
			
		this.JeuActuel.FlipTrick();
		
		
		if (this.JeuActuel.getbChoixTrick()) {
			
			System.out.println("=====================");
			System.out.println("Le nouveau tour est donc :");
			System.out.println(this.getTrickARealiser().get(1).toString());
			
			this.setChoixTrick(1);
			trickChoix = true;
			OK = true;
			this.JeuActuel.updateTrickGraphic(); 
		}
		else  {
			System.out.println("=====================");
			System.out.println("Le tour � r�aliser est donc ");
			System.out.println(this.getTrickARealiser().get(0).toString());
			
			
			this.setChoixTrick(0);
			trickChoix = false;
			OK = true;
			
		}
		
		
		this.JeuActuel.setChanged();
		this.JeuActuel.notifyObservers("ChoisirProp");
		try {
			this.JeuActuel.pause();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		this.JeuActuel.setChanged();
		this.JeuActuel.notifyObservers("Change the TrickPile");
	
			
		
		
		try {
			this.JeuActuel.pause();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		}
 
		System.out.println("=====================");
		
	
		return trickChoix;
	}

	

	public Object[] jouer() {
		Object[] valeurs;
		valeurs = new Object[4];
		valeurs[0] = this.getNom();
		System.out.println(this.afficherMain());
		
		if (this.getVariante() != 2) {
			//System.out.println("Quel prop voulez-vous �changer ?");
			
		boolean OK = false;
		while (OK==false) {
			
			this.JeuActuel.continu();
			System.out.println("\nEntrer la position de la carte � �changer avec un notre joueur");
			//Scanner sc = new Scanner(System.in);
			//int rep = sc.nextInt()-1;
			
			int rep = this.JeuActuel.getiPropChoisi1();
			//this.JeuActuel.continu();;
			//System.out.println("valeur 1   " +rep);
			if (rep < this.getMain().size() && rep >= 0) {
			valeurs[1] = rep;
			}
			
			else {
				valeurs[1] =0;
			}
			this.JeuActuel.ChoisirAdversaire();
			try {
				this.JeuActuel.pause();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(valeurs[1]);
			
			//Scanner sc1 = new Scanner(System.in);
			//String rep1 = sc1.nextLine();
			
			//System.out.println(rep1);
			// valeur iAdversaire from Mouse Clique
			String rep1 = this.JeuActuel.getNomAdversaire();
			valeurs[2] = (String) rep1;
			//if (this.getVariante() != 2) {
			//System.out.println("\nEntrer la position de la carte � choisir chez le joueur s�lectionn�");
			
			//Scanner sc2 = new Scanner(System.in);
			//int rep2 = sc2.nextInt()-1;
			int rep2 = this.JeuActuel.getiPropChoisi2();
			System.out.println(rep2);
			//if (rep2 < this.getMain().size() && rep2 >= 0) {
				valeurs[3] = rep2;
				OK = true;
				//}
			//}
			/*else {
				valeurs[3] = 0;
				OK = true;
			}*/
			
		}
		
		
		}
		
		return valeurs;
		
	}
		
		
		
	
	public void setJeuActuel(Jeu j) {
		this.JeuActuel = j;
	}
	
	public Jeu getJeuActuel () {
		return this.JeuActuel;
	}

	public void setJeu(Jeu jeu) {
		return;
	}
	
	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	
    

}
