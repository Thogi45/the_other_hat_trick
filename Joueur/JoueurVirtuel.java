package Joueur;
import java.util.ArrayList;
import java.util.Scanner;

import Carte.Prop;
import Carte.Trick;
import Modele.Jeu;

public class JoueurVirtuel extends Joueur {
    private int niveaudujoueur;
    
    private Strategie S1;


    
    public void setJeu(Jeu jeu) {
    	S1.setJeu(jeu);
    	this.setJeu1(jeu);
    }
    
	public void setCarteMain(Prop carteMain) {
		this.getMain().add(carteMain);
	}

	public JoueurVirtuel(Strategie s1) {
		super();
		S1 = s1;
	}

	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		super.setTrickARealiser(trickARealiser);
		boolean trickChoix = false;
		System.out.println("Le tour à réaliser est : " + this.getTrickARealiser().get(0).toString());
		super.setTrickARealiser(trickARealiser);
		this.setChoixTrick(S1.choisirTrickIA(trickARealiser, this));
		if (this.getChoixTrick()==0) {
			System.out.println("=====================");
			System.out.println("L'ordi a choisi de garder ce tour.");
			System.out.println("Le tour à réaliser est donc ");
			System.out.println(this.getTrickARealiser().get(0).toString());
			trickChoix = false;
		}
		else {
			System.out.println("=====================");
			System.out.println("L'ordi a choisi de faire un nouveau tour");
			System.out.println("Le nouveau tour est donc :");
			System.out.println(this.getTrickARealiser().get(1).toString());
			this.setChoixTrick(1);
			trickChoix = true;
		}
		System.out.println("=====================");
		return trickChoix;
	}
	public JoueurVirtuel() {
		super();
	}


	public int getNiveaudujoueur() {
		return niveaudujoueur;
	}

	public void setNiveaudujoueur(int niveaudujoueur) {
		this.niveaudujoueur = niveaudujoueur;
	}

	public Strategie getS1() {
		return S1;
	}

	public void setS1(Strategie s1) {
		S1 = s1;
	}

	public Object[] jouer() {
		return S1.fairejouerIA(this);
	}
    
	public static void main(String[] args) {

	}
	public ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre) {
		int k = this.getMain().size();
		ArrayList<Prop> props = propCentre;
		boolean OK = false;
		for (int i = 0; i<this.getMain().size(); i++) {
			this.getMain().get(i).setIsFaceUp(false);
		}
		props.addAll(getMain());
		int k1 = props.size();
		int p=0;
		while (OK ==false) {
			this.supprimerMain();
			for (int j=1;j<=k;j++) {
				int pos = S1.melangerPropsCentreIA(props, k);
				if (pos>=0 && pos <k1) {
					p++;
					this.setCarteMain(props.get(pos));
					props.remove(pos);
				}
				else {
					System.out.println("Problem");
				}
			}
			if (p == k) {
				OK = true;
			}
			else {
				p=0;
				props.addAll(getMain());
				System.out.println("Vous avez fait une erreur, veuillez recommencer");
			}
		}
		return props;
		
	}

	@Override
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
			System.out.println("Les cartes sont déjà retournées.");
		}
		else {
			while (OK == false) {
				System.out.println("L'ordi va choisir une carte à montrer (entrer une position)");
				int choixProp = S1.retournerCarteIA();
				System.out.println("==================");
				if (this.getMain().get(choixProp).getIsFaceUp()==false) {
					this.getMain().get(choixProp).setIsFaceUp(true);
					OK = true;
				}
				else {
					System.out.println("L'ordi a choisi une carte déjà retournée ou une position qui n'existe pas");
				}
		}
	}
		
	}

	@Override
	public boolean donnerProp(ArrayList<Prop> propCentre, String echange) {
		// TODO Auto-generated method stub
		return false;
	}
	}


