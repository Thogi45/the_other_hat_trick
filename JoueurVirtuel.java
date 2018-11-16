import java.util.ArrayList;

public class JoueurVirtuel extends Joueur {
    private int niveaudujoueur;
    
    private Strategie S1;

    private String nom;
    
    public void setJeu(Jeu jeu) {
    	this.setJeu1(jeu);
    }

	public JoueurVirtuel(Strategie s1) {
		super();
		S1 = s1;
	}

	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		this.setTrickARealiser(trickARealiser);
		return false;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void jouer() {
		S1.fairejouerIA();
	}
    
	public static void main(String[] args) {

	}
	

}
