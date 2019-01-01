package Joueur;
import java.util.ArrayList;

import Carte.Prop;
import Carte.Trick;
import Modele.Jeu;

public class Facile implements Strategie {

	private Jeu jeuActuel;

	public void setJeu(Jeu jeuActuel) {
		this.jeuActuel = jeuActuel;
	}

	public Jeu getJeu() {
		return this.jeuActuel;
	}



@Override
public Object[] fairejouerIA(Joueur joueurA) {
	Object[] valeurs; 
	valeurs = new Object[4];
	valeurs[0] = (String) joueurA.getNom();
	boolean OK = false;
	int k=-1;
	int posA = (int) Math.round(Math.random()*(joueurA.getMain().size()-1));
	valeurs[1] = (int) posA;
	while (OK == false) {
	k = (int) Math.round(Math.random()*(jeuActuel.getNbredeJoueurs()-1));
	if ((jeuActuel.getJoueur().get(k).getNom().equals(joueurA.getNom()))==false) {
		OK = true;
	}
	
	}
	valeurs[2] = (String) jeuActuel.getJoueur().get(k).getNom();
	int posB =(int) Math.round(Math.random());
	valeurs[3] = (int) posB;
	return valeurs;
}

@Override
public int choisirTrickIA(ArrayList<Trick> trickPossible, Joueur j1) {
	int k = (int) Math.round(Math.random());
	return k;

}

@Override
public int retournerCarteIA() {
	return (int) Math.round(Math.random()*(jeuActuel.getJoueur().get(0).getMain().size()-1));
}

public int melangerPropsCentreIA(ArrayList<Prop> props, int pos) {
	int k = (int) Math.round(Math.random()*(props.size()-1));
	return k;
}







}

