
public class Joueur {
    private String nom;

    private int point;

    private Prop cartesChoisies;

    private Prop cartesMain;

    private Trick tricksRealises;

    private boolean nouveauTrick;
    
    private boolean estPremierAJouer;
    
	public boolean isEstPremierAJouer() {
		return estPremierAJouer;
	}

	public void setEstPremierAJouer(boolean estPremierAJouer) {
		this.estPremierAJouer = estPremierAJouer;
	}

	public Joueur() {
		super();

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

	public Prop getCartesMain() {
		return cartesMain;
	}

	public void setCartesMain(Prop cartesMain) {
		this.cartesMain = cartesMain;
	}

	public Trick getTricksRealises() {
		return tricksRealises;
	}

	public void setTricksRealises(Trick tricksRealises) {
		this.tricksRealises = tricksRealises;
	}

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
