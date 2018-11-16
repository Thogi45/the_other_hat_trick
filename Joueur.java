import java.util.ArrayList;

public class Joueur {
    private String nom;

    private int point;

    private Prop cartesChoisies;

    private ArrayList<Prop> cartesMain;

    private Trick tricksRealises;

    private boolean nouveauTrick;

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

	public ArrayList<Prop> getCartesMain() {
		return cartesMain;
	}

	public void setCartesMain(ArrayList<Prop> cartesMain) {
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
