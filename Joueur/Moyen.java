package Joueur;
import java.util.ArrayList;
import java.util.Iterator;

import Carte.Prop;
import Carte.Trick;
import Modele.Jeu;

public class Moyen implements Strategie {
	
	private Jeu jeuActuel;

	public void setJeu(Jeu jeuActuel) {
		this.jeuActuel = jeuActuel;
	}

	public Jeu getJeu() {
		return this.jeuActuel;
	}
    public void fairejouerIA() {
    	System.out.println("Je suis un joueur "+ Moyen.class.getName());
    	
    }

	@Override
	public Object[] fairejouerIA(Joueur joueurA) {
		Object[] valeurs; 
		valeurs = new Object[4];
		valeurs[0] = (String) joueurA.getNom();
		boolean OK = false;
		int pos = -1;
		Trick trickEnJeu = this.jeuActuel.getTrickP().get(jeuActuel.getTrickP().size()-1);
		ArrayList<Prop> propsPossibles = new ArrayList<Prop>();
		propsPossibles.addAll(trickEnJeu.getProp1());
		propsPossibles.addAll(trickEnJeu.getProp2());
		for (int i = 0; i<joueurA.getMain().size();i++) {
			if (propsPossibles.contains(joueurA.getMain().get(i))==false) {
				pos = i;
			}
		}
		int posA = -1;
		if (pos == -1) {
			posA = (int) Math.round(Math.random()*(joueurA.getMain().size()-1));
		}
		else {
			posA = pos;
		}
		valeurs[1] = (int) posA;
		for (int j = 0; j<this.jeuActuel.getNbredeJoueurs();j++) {
			if (this.jeuActuel.getJoueur().get(j).getNom().equals(joueurA.getNom())==false) {
				for (int l = 0; l <this.jeuActuel.getJoueur().get(j).getMain().size();l++) {
					if (this.jeuActuel.getJoueur().get(j).getMain().get(l).getIsFaceUp()==true) {
						if (propsPossibles.contains(this.jeuActuel.getJoueur().get(j).getMain().get(l))) {
						valeurs[2] = (String) this.jeuActuel.getJoueur().get(j).getNom();
						valeurs[3] = (int) l;
						}
					}
				}
			}
		}
		int k=-1;
		if (valeurs[2]==null) {
			boolean OK1 = false;
			while (OK1 == false) {
				k = (int) Math.round(Math.random()*(jeuActuel.getNbredeJoueurs()-1));
				if ((jeuActuel.getJoueur().get(k).getNom().equals(joueurA.getNom()))==false) {
					OK1 = true;
				}
				
				}
				valeurs[2] = (String) jeuActuel.getJoueur().get(k).getNom();
				int posB =(int) Math.round(Math.random());
				valeurs[3] = (int) posB;
		}

		return valeurs;
	}

	@Override
	public int choisirTrickIA(ArrayList<Trick> tricksPossibles, Joueur j1) {
		int choix = 0;
		Trick trickPile = tricksPossibles.get(0);
		ArrayList<Prop> mainJoueur = new ArrayList<Prop>();
		mainJoueur.addAll(j1.getMain());
		int p1 = 0;
		int p2 = 0;
		Iterator<Prop> itMain = mainJoueur.iterator();
		boolean OK = false;
		while (itMain.hasNext() && OK == false) {
			Prop ptest = itMain.next();
			if (trickPile.getProp1().contains(ptest)) {
				p1 = p1 + 1 ;
				if (p1 > 2) {
					p1 = 0;
				}
			}
			if (trickPile.getProp2().contains(ptest)) {
				p2 = p2 + 1;
				if (p2 > 2) {
					p2 = 0;
				}
			}
		}
		int somme = p2 + p1;
		if (somme  == 2) {
			if (j1.getMain().size() <= 2) {
			choix = 1;
			}
			else {
			choix = 0;
			}	
		}
		else if (somme == 1) {
			choix = 0;
		}
		else if (somme == 0) {
			choix = 1;
		}
		else {
			choix = 0;
		}
 		return choix;
	}

	@Override
	public int retournerCarteIA() {
		return (int) Math.round(Math.random()*(jeuActuel.getJoueur().get(0).getMain().size()-1));
	}

	@Override
	public int melangerPropsCentreIA(ArrayList<Prop> props, int pos) {
		int k = (int) Math.round(Math.random()*(props.size()-1));
		return k;
	}

}