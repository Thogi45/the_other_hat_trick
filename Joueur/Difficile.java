package Joueur;
import Modele.Jeu;

public class Difficile implements Strategie {
	
	private Jeu jeuActuel;

	public void setJeu(Jeu jeuActuel) {
		this.jeuActuel = jeuActuel;
	}

	public Jeu getJeu() {
		return this.jeuActuel;
	}
	
    public void fairejouerIA() {
    	System.out.println("Je suis un joueur "+ Difficile.class.getName());
    }

}