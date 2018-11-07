import java.util.Scanner;

public class Trick extends Carte {
	public final static int THEPAIROFRABBITS = 0;
	public final static int THEHATTRICK = 1;
	public final static int THEHUNGRYRABBIT = 2;
	public final static int THERABBITTHATDIDNTLIKECARROTS = 3;
	public final static int THECARROTHATTRICK = 4;
	public final static int THESLIGHTLYEASIERHATTRICK = 5;
	public final static int THEVEGETABLEPATCH = 6;
	public final static int THEBUNCHOFCARROTS = 7;
	public final static int THEVEGETABLEHATTRICK = 8;
	public final static int THEOTHERHATTRICK = 9;
	
	public static String[] VALEURS = {"The Pair of Rabbits", "The Hat Trick", "The Hungry Rabbit", "The Rabbit that didn't like Carrots", "The Carrot Hat Trick", "The Slightly Easier Hat Trick", "The Vegetable Patch","The Bunch of Carrots", "The Vegetable Hat Trick", "The Other Hat Trick"} ;
	
	private int valeur;
    private String nomtrick;
    private int pointstricks;
    private int[] prop1 = {-1, -1, -1};
    private int[] prop2 = {-1, -1, -1};
    private boolean trickreussi;
    
	public static void ajoutervaleurs(int cartesAjoutees) {
		for (int i = 9; i < (4+cartesAjoutees); i++ ) {
			System.out.println("Donner le nom du Trick : ");
			Scanner nomprop = new Scanner(System.in);
			String nomProp = nomprop.nextLine();
			VALEURS[i] = nomProp;
		}
	}

    public void realiserTrickenjeu() {
    }

    public void melanger() {
    }

    public void activertrick() {
    }

    public void recuperertrick() {
    }

    public void devoilercarte() {
    }

    public void deplacerdanstrickdeck() {
    }

	public Trick(int valeur) {
		super();
		this.valeur = valeur;
		
		// TODO Auto-generated constructor stub
	}
	
	public void creerTrickdeBase () {
		if (this.valeur == 0) {
			this.pointstricks = 5;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 3;
			this.prop2[0] = 4;
		}
		else if (this.valeur == 1) {
			this.pointstricks = 5;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 1;
			this.prop2[0] = 3;
		}
		else if (this.valeur == 2) {
			this.pointstricks = 1;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 3;
			this.prop1[1] = 4;
			this.prop2[0] = 2;
			this.prop2[1] = 0;
		}
		else if (this.valeur == 3) {
			this.pointstricks = 4;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 3;
			this.prop1[1] = 4;
			this.prop2[0] = 0;
		}
		else if (this.valeur == 4) {
			this.pointstricks = 3;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 1;
			this.prop2[0] = 2;
		}
		else if (this.valeur == 5) {
			this.pointstricks = 4;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 1;
			this.prop2[0] = 3;
			this.prop2[1] = 4;
		}
		else if (this.valeur == 6) {
			this.pointstricks = 3;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 2;
			this.prop2[0] = 0;
		}
		else if (this.valeur == 7) {
			this.pointstricks = 2;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 2;
			this.prop2[0] = 2;
		}
		else if (this.valeur == 8) {
			this.pointstricks = 2;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 1;
			this.prop2[0] = 2;
			this.prop2[1] = 0;
		}
		else if (this.valeur == 9) {
			this.pointstricks = 6;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1[0] = 1;
			this.prop2[0] = 4;
		}
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getNomtrick() {
		return nomtrick;
	}

	public void setNomtrick(String nomtrick) {
		this.nomtrick = nomtrick;
	}

	public int getPointstricks() {
		return pointstricks;
	}

	public void setPointstricks(int pointstricks) {
		this.pointstricks = pointstricks;
	}

	public Prop[] getProppourtrick() {
		return proppourtrick;
	}

	public void setProppourtrick(Prop[] proppourtrick) {
		this.proppourtrick = proppourtrick;
	}

	public boolean isTrickreussi() {
		return trickreussi;
	}

	public void setTrickreussi(boolean trickreussi) {
		this.trickreussi = trickreussi;
	}
	//test
	

    
}
