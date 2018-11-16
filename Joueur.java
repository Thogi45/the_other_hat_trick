import java.util.ArrayList;

public abstract class Joueur {
    private String nom;
    
    private int choixTrick;

    private int point;

    private Jeu jeu; 
    
    private Prop cartesChoisies;

    private ArrayList<Prop> Main = new ArrayList<Prop> ();

    private ArrayList<Trick> trickARealiser = new ArrayList<Trick>();
    
    private ArrayList<Trick> tricksRealises = new ArrayList<Trick>();

    private boolean nouveauTrick;
    
    private boolean estPremierAJouer;

	public void setChoixTrick(int choixTrick) {
		this.choixTrick = choixTrick;
	}

	public boolean isEstPremierAJouer() {
		return estPremierAJouer;
	}

	public abstract void setJeu(Jeu jeu);
	
	public void setJeu1(Jeu jeu) {
		this.jeu = jeu;
	}
	
	public void setEstPremierAJouer(boolean estPremierAJouer) {
		this.estPremierAJouer = estPremierAJouer;
	}

	public Joueur() {
		super();

	}
	


	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		this.trickARealiser = trickARealiser;
		return false;
	}

	/**
	 * @return the trickARealiser
	 */
	public ArrayList<Trick> getTrickARealiser() {
		return trickARealiser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Prop getCartesChoisies() {
		return cartesChoisies;
	}

	public void setCartesChoisies(Prop cartesChoisies) {
		this.cartesChoisies = cartesChoisies;
	}
				
	public void setCarteMain(Prop carteMain) {
		this.Main.add(carteMain);
	}
	
	public String afficherMain() {
		String Main = "Les cartes du Joueur sont :";
		for (int i=0; i<this.Main.size();i++ ) {
			Main = Main +"\n" + this.Main.get(i).toString();
		}
		return Main;
	}
	
	public abstract ArrayList<String> jouer();
	
	public boolean isNouveauTrick() {
		return nouveauTrick;
	}

	public void setNouveauTrick(boolean nouveauTrick) {
		this.nouveauTrick = nouveauTrick;
	}

	public void voirCartes() {
    }

    public void retournerCarte() {
    }

    public void choisirSonTrick() {
    }

    public void garderleTrick() {
    }

    public void mettreajourlamain() {
    }
    
}
