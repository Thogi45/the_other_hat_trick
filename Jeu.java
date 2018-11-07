import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private String etat;

    private String joueurEnCours;

    private int nbredecartes;
    
    private int nbredeJoueursR;
    
    private int nbredeJoueursV;

    public List<Joueur> joueur = new ArrayList<Joueur> ();

    public List<Carte> carte = new ArrayList<Carte> ();

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

	public List<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
	}

	public List<Carte> getCarte() {
		return carte;
	}

	public void setCarte(List<Carte> carte) {
		this.carte = carte;
	}
	
	public Jeu(int nbredecartes, int nbredeJoueursR, int nbredeJoueursV) {
		super();
		this.nbredeJoueursV = nbredeJoueursV;
		this.nbredeJoueursR = nbredeJoueursR;
		this.nbredecartes = nbredecartes;
	}

    public void finir() {
    }

    public void classer() {
    }

    public void compterlesScores() {
    }
    
    public void creerJoueurs() {

    }
    
    public void creerCartes() {
    	
    }
	public void commencer() {


    }

}
