package Modele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import Carte.Prop;
import Carte.Trick;
import Joueur.Difficile;
import Joueur.Facile;
import Joueur.Joueur;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Joueur.Moyen;
import Vue.MainGraphique;
import javafx.scene.chart.Chart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



//import sun.jvm.hotspot.debugger.proc.ppc64.ProcPPC64Thread;

public class Jeu  extends Observable implements Runnable {
    private String etat;

    private String joueurEnCours;
    
    private String joueurEchange = "";
    

    private int nbredecartes;
    
    private int nbredeJoueursR= 0;
    
    private int nbredeJoueursV=0;
    
    private int nbredeJoueurs=0;
    
    private int variante = 0;
    
    private boolean finPartie = false;
    
    private ArrayList<Trick> trickD = new ArrayList<Trick> ();
    
    private ArrayList<Trick> trickP = new ArrayList<Trick> ();
    
    private ArrayList<Prop> prop = new ArrayList<Prop> ();

    private ArrayList<Joueur> joueur = new ArrayList<Joueur> ();
    
    private ArrayList<JoueurVirtuel> joueurV = new ArrayList<JoueurVirtuel> ();
    
    private ArrayList<JoueurReel> joueurR = new ArrayList<JoueurReel>();
    
    private boolean BChoixTrick; 
    private int JoueurChoisi; 
    public Jeu getJeu() {
    	return this;
    }
   
    public Jeu (int nbrJ, int nbrJR, int nbrJV, String nom, Double age, String niveau) {
    	//super(); 
    	
    	JoueurReel joueurR = new JoueurReel(age,nom);
    	this.joueurR.add(joueurR);
    	this.joueurR.get(0).setJeuActuel(this);
    	for (int i =0; i < 2 ; i++ ) {
    		if (niveau == "f") {
    			this.joueurV.add(new JoueurVirtuel(new Facile()));
    		}
    		else if (niveau =="m") {
    			this.joueurV.add(new JoueurVirtuel(new Moyen()));
    		}
    		else if (niveau == "d") {
    			this.joueurV.add(new JoueurVirtuel(new Difficile()));
    		}
    		this.joueurV.get(i).setNom("ordi "+ (i+1));
    		this.joueurV.get(i).setEstPremierAJouer(false);
    	}	
    	this.setNbredeJoueurs(nbrJ);
    	this.nbredeJoueursR = nbrJR;
    	this.nbredeJoueursV = nbrJV;
    	
    	this.joueur.add(joueurR);
    	this.joueur.add(joueurV.get(0));
    	this.joueur.add(joueurV.get(1));
    	
    	this.joueur.get(0).setEstPremierAJouer(true);
    	this.creerCartesdeBase();
  
    	
    	//this.start();
    	
    }
    
    
    public void distribuerProps () {
    	int nbreProps = this.prop.size();
    	int nbreJoueur = this.joueur.size();
    	int propsauC = nbreProps%nbreJoueur;
    	int j=0;
    	for (int i = 0; i<(nbreProps-propsauC); i++) { 			
    		this.joueur.get(j).setCarteMain(this.prop.get(0));
    		this.prop.remove(0);
    		j++;
    		if (j==nbreJoueur) {
    			j=0;
    		}
    	}
    	//this.commencer();
    }

	public int getNbredeJoueurs() {
		return nbredeJoueurs;
	}

	public void setNbredeJoueurs(int nbredeJoueurs) {
		this.nbredeJoueurs = nbredeJoueurs;
	}

	public ArrayList<Trick> gettrickD() {
		return trickD;
	}

	public void settrickD(ArrayList<Trick> trickD) {
		this.trickD = trickD;
	}

	public ArrayList<Prop> getProp() {
		return prop;
	}

	public void setProp(ArrayList<Prop> prop) {
		this.prop = prop;
	}

	public ArrayList<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(ArrayList<Joueur> joueur) {
		this.joueur = joueur;
	}

	public ArrayList<JoueurVirtuel> getJoueurV() {
		return joueurV;
	}

	public void setJoueurV(ArrayList<JoueurVirtuel> joueurV) {
		this.joueurV = joueurV;
	}

	public ArrayList<JoueurReel> getJoueurR() {
		return joueurR;
	}

	public void setJoueurR(ArrayList<JoueurReel> joueurR) {
		this.joueurR = joueurR;
	}

	

	public int getNbredeJoueursV() {
		return nbredeJoueursV;
	}

	public void setNbredeJoueursV(int nbredeJoueursV) {
		this.nbredeJoueursV = nbredeJoueursV;
	}

	public int getNbredeJoueursR() {
		return nbredeJoueursR;
	}

	public void setNbredeJoueursR(int nbredeJoueursR) {
		this.nbredeJoueursR = nbredeJoueursR;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(String joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public int getNbredecartes() {
		return nbredecartes;
	}

	public void setNbredecartes(int nbredecartes) {
		this.nbredecartes = nbredecartes;
	}
	
	public void jouerAvecVariantes( int variante) {
		this.variante = variante;
		if (variante == 3) {
			System.out.println("Dans cette variante, vous ajoutez autant de joueurs et de cartes que vous voulez.");
			System.out.println("\nA combien de joueurs voulez-vous jouer ?");
			Scanner sc = new Scanner(System.in);
	    	setNbredeJoueurs(sc.nextInt());
		}
		if (variante == 1 || variante == 3) {
			if (variante == 1) {
				this.setNbredeJoueurs(3);
			}
			System.out.println("Packs disponibles (Vous pouvez ajouter tous les packs) :\n");
			System.out.println("Pack 1 (Props et trickDs de base x2)");
			System.out.println("\nPack 2 (Nouveaux trickDs et Props)");
			System.out.println("\nQuels packs d'extension voulez-vous ajouter ? (1, 2, 12, 122)");
			Scanner sc1 = new Scanner(System.in);
			int extension = sc1.nextInt();
			if (extension == 1 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(0));
				this.prop.add(new Prop(1));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(3));
				this.prop.add(new Prop(4));
				for (int i = 0; i<9; i++) {
					this.trickD.add(new Trick(i));
					}	
			}
			if (extension == 2 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(5));
				this.prop.add(new Prop(6));
				this.prop.add(new Prop(7));
				this.trickD.add(new Trick(10));
				this.trickD.add(new Trick(11));
				if (extension == 122) {
					this.prop.add(new Prop(5));
					this.prop.add(new Prop(6));
					this.prop.add(new Prop(7));
					this.trickD.add(new Trick(10));
					this.trickD.add(new Trick(11));
				}
			}
		}
		if (variante == 2) {
			System.out.println("Dans cette variante, vous ajoutez 3 nouveaux joueurs");
			System.out.println("\nVous n'avez donc plus qu'une carte et il va vous falloir combiner avec les props de vos adversaires ou le prop du milieu");
			this.setNbredeJoueurs(6);			
		}
		this.creerJoueurs();
	}

	/*public Jeu(int nbredecartes, int nbredeJoueursR, int nbredeJoueursV) {
		super();
		this.nbredeJoueursV = nbredeJoueursV;
		this.nbredeJoueursR = nbredeJoueursR;
		this.nbredecartes = nbredecartes;
	}*/
	
	
	
    public void creerJoueurs() {
    	int joueursR = this.nbredeJoueursR;
    	int joueursV = this.nbredeJoueursV;
    	int jR = 0, jV =0;
    	
    	while (this.nbredeJoueurs != (jR+jV)) {
    	System.out.println("\nNombre de Joueurs Reels ?");
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	setNbredeJoueursR(A);
    	jR = joueursR+A;
    	System.out.println("\nNombre de Joueurs Virtuels ?");
    	Scanner sc1 = new Scanner(System.in);
    	int B =  sc1.nextInt();
    	setNbredeJoueursV(B);
    	jV = joueursV+B;
    	}
    	if (this.nbredeJoueursV !=0) {
    		System.out.println("Quel est le niveau des joueurs\nFacile Moyen Difficile");
    		Scanner niveau = new Scanner(System.in);
    		String niv = niveau.nextLine();
    		char carac = niv.charAt(0);
       	for (int i=joueursV; i < this.nbredeJoueursV ; i++ ) {
    		if (carac == 'F' || carac == 'f') {
    			this.joueurV.add(new JoueurVirtuel(new Facile()));
    		}
    		else if (carac == 'M' || carac == 'm') {
    			this.joueurV.add(new JoueurVirtuel(new Moyen()));
    		}
    		else if (carac == 'D' || carac == 'd') {
    			this.joueurV.add(new JoueurVirtuel(new Difficile()));
    		}
    		this.joueurV.get(i).setNom("ordi "+ (i+1));
    		this.joueurV.get(i).setEstPremierAJouer(false);
    		
    	}
   		if (this.nbredeJoueursR == 0) {
   			int m = (int) Math.random()*this.nbredeJoueursV;
   			this.joueurV.get(m).setEstPremierAJouer(true);
   		}

       	}

        	if (this.nbredeJoueursR !=0) {
            	double ageplusjeune = 200 ;
            	System.out.println("Vous allez entrer le nom des Joueurs et leur age");
            	int i = 0;
            	int plusjeune[];
            	plusjeune = new int[this.getNbredeJoueursR()];
        	for (int j=joueursR; j<(this.nbredeJoueursR); j++) {
        		System.out.println("Quel est le nom de joueur " + (j+1) + " ?");
        		Scanner nomJ = new Scanner(System.in);
        		String nom = nomJ.nextLine();
        		System.out.println("Quel est son age ?");
        		Scanner ageJ = new Scanner(System.in);
        		double age = ageJ.nextDouble();
        		this.joueurR.add(new JoueurReel(age, nom));
        		this.joueurR.get(j).setEstPremierAJouer(false);
        		if (joueursR == 0) {
        		if (age < ageplusjeune) {
        			ageplusjeune = age ;
        			i = 0;
        	    	plusjeune[i] = j;	
        		}
        		else if (age == ageplusjeune) {
        			i = i + 1 ;
        			plusjeune[i] = j;
        		}
        		
        	}
        	}
        	
        	int n = (int)(Math.random()*i);
        	this.joueurR.get(plusjeune[n]).setEstPremierAJouer(true);

    }
        	this.joueur.addAll(joueurR);
        	this.joueur.addAll(joueurV);
        	System.out.println("=============================");
        	this.creerCartesdeBase();

    }
    
    public void creerCartesdeBase() {
		this.prop.add(new Prop(0));
		this.prop.add(new Prop(1));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(3));
		this.prop.add(new Prop(4));
		Collections.shuffle(this.prop);
		for (int i = 0; i<9; i++) {
		this.trickD.add(new Trick(i));
		}
		Collections.shuffle(this.trickD);
		this.trickD.add(new Trick(9));
		this.distribuerProps();
    }
    
    
	public int commencer() {
		int j=0;
		while (this.joueur.get(j).isEstPremierAJouer()==false && j<this.nbredeJoueurs) {
			j = j+1;
		}
		if (this.joueur.get(j).isEstPremierAJouer()==true) {
			System.out.println("La personne qui joue est :\n "+ this.joueur.get(j).toString());
			this.joueur.get(j).setJeu(this);
			this.joueur.get(j).setEstPremierAJouer(false);
			if (j+1 == this.nbredeJoueurs){
				this.joueur.get(0).setEstPremierAJouer(true);
			   }
			else {
				this.joueur.get(j+1).setEstPremierAJouer(true);
			}
		}
		
		this.piocherUneCarteTrick(this.joueur.get(j).setTrickARealiser(this.mettreAJourLaPile()));
		this.gererActionsDeJeu(j);
		return j;
    }

	
	public void gererActionsDeJeu(int j) {
		this.joueur.get(j).setJeu(this);
		this.afficherPlateau();
		ArrayList<String> nomJ = new ArrayList<String> ();
		for (int i =0; i < this.nbredeJoueurs;i++) {
			if (j != i) {
			nomJ.add(this.joueur.get(i).getNom());
			}
		}
		if (this.variante==2) {
			nomJ.add("PropsCentre");
		}
		boolean OK = false;
		Object[] infosSwitch = new Object[4];
		while (OK == false) {
			this.joueur.get(j).setVariante(this.variante);
			infosSwitch = this.joueur.get(j).jouer();
			String nomJoueur = (String) infosSwitch[2];
				if (nomJ.contains(nomJoueur)==true  ) {
					OK = true;
				}
		}
		if (this.variante == 2) {
			this.ajouterProps(infosSwitch);
		}
		else {
		this.switcherProps(infosSwitch);
		}
		if (this.finPartie == false) {
		this.commencer();
		}
		else {
			this.gererFinDePartie();
		}
		}
	
	/**
	 * @return the trickP
	 */
	public ArrayList<Trick> getTrickP() {
		return trickP;
	}

	public void ajouterProps(Object[] infosSwitch) {
		String joueurActuel = (String) infosSwitch[0];
		String joueurEchange = (String) infosSwitch[2];
		this.joueurEchange = joueurEchange;
		int A = 0;
		int E = -1;
		int posPropJA = (int) infosSwitch[1];
		int posPropJE = (int) infosSwitch[3];
		for (int j=0; j<this.nbredeJoueurs;j++) { 
			if (joueurActuel.equals(this.joueur.get(j).getNom())) {
				A = j;
			}
			if (joueurEchange.equals(this.joueur.get(j).getNom()) ) {
				E = j;
			}
		}
		if (E== -1) {
			this.joueur.get(A).setCarteMain(this.prop.get(0));
		}
		else {
		this.joueur.get(A).setCarteMain(this.joueur.get(E).getMain().get(posPropJE));
		}
		System.out.println("==================");
		System.out.println(this.joueur.get(A).afficherMain());
		this.testerTrick(A);
		
	}
	
	public void switcherProps(Object[] infosSwitch) {
		String joueurActuel = (String) infosSwitch[0];
		String joueurEchange = (String) infosSwitch[2];
		int A = 0;
		int E = 0;
		int posPropJA = (int) infosSwitch[1];
		int posPropJE = (int) infosSwitch[3];
		for (int j=0; j<this.nbredeJoueurs;j++) { 
			if (joueurActuel.equals(this.joueur.get(j).getNom())) {
				A = j;
			}
			if (joueurEchange.equals(this.joueur.get(j).getNom())) {
				E = j;
			}
		}
	
		this.joueur.get(E).setCarteMain(this.joueur.get(A).getMain().get(posPropJA));
		this.joueur.get(A).setCarteMain(this.joueur.get(E).getMain().get(posPropJE));
		this.joueur.get(E).removeCarteMain(posPropJE);
		this.joueur.get(A).removeCarteMain(posPropJA);
		System.out.println("==================");
		System.out.println(this.joueur.get(A).afficherMain());
		
		this.testerTrick(A);
	}
	
	public void gererFinDePartie() {
		this.compterPoints();
		System.out.println("Le jeu est terminé, le décompte également.");
		System.out.println("Le classement est : ");
		this.afficherClassement();
		
	}
	
	public void afficherClassement() {
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		classement.addAll(this.joueur);
		int place = this.nbredeJoueurs;
		int points = 4000;
		int permut = 0;
		int k = -1;
		boolean permutOver = false;
		while ( permutOver == false) {
			points = 4000;
			for (int i = 0; i < this.nbredeJoueurs-permut; i++) {
				if (classement.get(i).getPoint() <= points) {
					points = classement.get(i).getPoint();
					k = i;
				}
			}
			permut++;
			classement.add(classement.get(k));
			classement.remove(k);
			if (permut == this.nbredeJoueurs) {
				permutOver=true;
			}
		}
		int clas = 1;
		for (int j=this.nbredeJoueurs-1; j>=0 ; j--) {
			System.out.println(clas + ". "+classement.get(j).toString2());
			System.out.println(classement.get(j).afficherMain());
			clas = clas + 1;
		}
	}
	
	
	public void compterPoints() {
		boolean OK = false ;
		if (this.trickP.get(this.trickP.size()-1).getValeur()==9) {
			OK = true;
		}
		for (int j = 0; j < this.nbredeJoueurs; j++) {
			for (int i = 0; i <this.joueur.get(j).getTricksRealises().size();i++) {
				this.joueur.get(j).addPoint(this.joueur.get(j).getTricksRealises().get(i).getPointstricks());
			}
			if (OK == true) {
				for (int k = 0; k < this.joueur.get(j).getMain().size(); k++) {
					if (this.joueur.get(j).getMain().get(k).getValeur() == 1 || this.joueur.get(j).getMain().get(k).getValeur() == 4) {
						this.joueur.get(j).addPoint(-3);
					}
				}
			}
		}
		
		
	}
	
	public void testerTrick (int j) {
		int i = this.joueur.get(j).getChoixTrick();
		Trick trickEnJeu = this.joueur.get(j).getTrickARealiser().get(i);
		ArrayList<Prop> mainJoueur = new ArrayList<Prop>();
		mainJoueur.addAll(this.joueur.get(j).getMain());
		Iterator<Prop> itMain = mainJoueur.iterator();
	
		boolean OK = false;
		while (itMain.hasNext() && OK == false) {
			if (trickEnJeu.getProp1().contains(itMain.next())) {
				itMain.remove();
				OK = true;
			}
		}
		boolean OK2 = false;
		Iterator<Prop> itMain2 =  mainJoueur.iterator();
		if (OK == true) {
			while (itMain2.hasNext() && OK2 == false) {
				if (trickEnJeu.getProp2().contains(itMain2.next())) {
					OK2 = true;
				}
			}
		
		}
		if (OK2 == true) {
			System.out.println("==================");
			System.out.println("BRAVO, vous avez réussi !");
			System.out.println("==================");
			this.joueur.get(j).addTrickRealises(trickEnJeu);
			this.trickP.remove(this.trickP.size()-1);
			this.prop = this.joueur.get(j).melangerPropsCentre(this.prop);
			if (this.variante == 2) {
			this.gererMainsVariante2(this.joueur.get(j).donnerProp(this.prop, this.joueurEchange));
			}
		}
		else {
			this.gererVariante(this.variante, j);
			System.out.println("==================");
			System.out.println("Vous avez échoué");
			System.out.println("==================");
			if (this.finPartie == false) {
			this.joueur.get(j).retournerCarte();
			}
		}
	
	}
	
	public void gererVariante(int variante, int j) {
		if (this.variante==2) {
			this.joueur.get(j).getMain().remove(1);
		}
	}
	

	public void gererMainsVariante2 (boolean choixProp) {
		int k = -1;
		for (int i = 0; i<this.nbredeJoueurs;i++) {
			if (this.joueur.get(i).getNom().equals(joueurEchange)) {
				k = i;
			}
		}
		
		if (choixProp == true) {
				this.joueur.get(k).setCarteMain(this.prop.get(0));
				this.prop.remove(0);
		}
		else {
			this.joueur.get(k).setCarteMain(this.prop.get(1));
			this.prop.remove(1);
		}
		
	}

	public void afficherPlateau() {
		for (int i = 0; i<this.nbredeJoueurs; i++) {
			System.out.println(this.joueur.get(i).getNom() + " :");
			for (int j = 0; j<this.joueur.get(i).getMain().size();j++) {
				this.joueur.get(i).getMain().get(j).afficherNom(j);
			}
		}
		if (this.variante == 2) {
			for (int k = 0; k<this.prop.size();k++) {
			System.out.println("PropsCentre :");
			this.prop.get(k).afficherNom(k);
			}
		}
	}
	
	
	public void piocherUneCarteTrick(boolean choix) {
		if (choix == true) {
		this.trickP.add(this.trickD.get(0));
		this.trickD.remove(0);
		}
		if (trickD.size() == 0) {
			System.out.println("Ceci est le dernier tour !!!!!!");
			System.out.println("==================");
			this.finPartie = true;
			
		}
		else {
		}
	}
	
	public ArrayList<Trick> mettreAJourLaPile() {
		if (this.trickP.isEmpty()==true) {
		this.trickP.add(this.trickD.get(0));
		this.trickD.remove(0);
		}
		ArrayList<Trick> trickAFaire = new ArrayList<Trick>();
		trickAFaire.add(this.trickP.get(this.trickP.size()-1));
		trickAFaire.add(this.trickD.get(0));
		return trickAFaire;
		
	}
	
	public void start() {
		Thread myThreat = new Thread(this);
		myThreat.start();
	}

	public void run() {
		this.joueur.get(0).setEstPremierAJouer(true);
		this.commencer();
		
		
	
	}

	public void FlipTrick() {
		// TODO Auto-generated method stub
		
		this.setChanged();
		this.notifyObservers("FlipTrick");
			}
	public boolean getBChoixTrick() { 
		return this.BChoixTrick; 
	}
	
	public void setBChoixtrick(boolean b) {
		this.BChoixTrick = b;
	}
	public void ChoixJoueur() {
		this.setChanged();
		this.notifyObservers("ChoixJoueur");
	}
	public int getJoueurChoisi() {
		return this.JoueurChoisi; 
	}
	public void setJoueurChoisi(int i) { 
		this.JoueurChoisi = i;
	}
	@Override
	public synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}
}