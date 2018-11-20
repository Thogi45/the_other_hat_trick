import java.util.Scanner;
import java.util.ArrayList;

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
	public final static int THEDOVEHATTRICK = 10;
	public final static int THESALADFRUIT = 11;
	
	public static String[] VALEURS = {"The Pair of Rabbits", "The Hat Trick", "The Hungry Rabbit", "The Rabbit that didn't like Carrots", "The Carrot Hat Trick", "The Slightly Easier Hat Trick", "The Vegetable Patch","The Bunch of Carrots", "The Vegetable Hat Trick", "The Other Hat Trick", "The Dove Hat Trick", "The Salad Fruit"} ;
	// Test pour Git Test
	private int valeur;
    private String nomtrick;
    private int pointstricks;
    private ArrayList<Prop> prop1 = new ArrayList<Prop>();
    private ArrayList<Prop> prop2 = new ArrayList<Prop>();

    private boolean trickreussi;
    private boolean faceUp;
    
	public static void ajoutervaleurs(int cartesAjoutees) {
		for (int i = 9; i < (4+cartesAjoutees); i++ ) {
			System.out.println("Donner le nom du Trick : ");
			Scanner nomprop = new Scanner(System.in);
			String nomProp = nomprop.nextLine();
			VALEURS[i] = nomProp;
			
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String proP1 = " Prop1 = " + prop1.get(0).getNomP();
		if (prop1.size()>1 ) {
		for (int i = 1; i<prop1.size();i++) {
		 proP1 = proP1 + ", " + prop1.get(i).getNomP();
		}
		}
		String proP2 = " Prop2 = " + prop2.get(0).getNomP();
		if (prop2.size()>1) {
		for (int j =1; j <prop2.size();j++) {
			proP2 =  proP2 + ", " + prop2.get(j).getNomP();
		}
		}
		return "Trick [" + nomtrick + ", points = " + pointstricks + "," + proP1 +","+ proP2+ "]";
	}


	public Trick() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void ajouterCartes(int tricksAjoutes, int valeur) {
		
	
	}
    public void realiserTrickenjeu() {
    }

    public void melanger() {
    }

    public void activertrick() {
    	this.faceUp = true;
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
		if (this.valeur <= 11) {
			this.creerTrickdeBase();
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public void creerTrickdeBase () {
		if (this.valeur == 0) {
			this.pointstricks = 5;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(3));
			this.prop2.add(new Prop(4));
		}
		else if (this.valeur == 1) {
			this.pointstricks = 5;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(1));
			this.prop2.add(new Prop(3));
		}
		else if (this.valeur == 2) {
			this.pointstricks = 1;
			this.nomtrick = VALEURS[this.valeur];;
			this.prop1.add(new Prop(3));
			this.prop1.add(new Prop(4));
			this.prop2.add(new Prop(2));
			this.prop2.add(new Prop(0));
		}
		else if (this.valeur == 3) {
			this.pointstricks = 4;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(3));
			this.prop1.add(new Prop(4));
			this.prop2.add(new Prop(0));

		}
		else if (this.valeur == 4) {
			this.pointstricks = 3;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(1));
			this.prop2.add(new Prop(2));

		}
		else if (this.valeur == 5) {
			this.pointstricks = 4;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(1));
			this.prop2.add(new Prop(3));
			this.prop2.add(new Prop(4));
			}
		else if (this.valeur == 6) {
			this.pointstricks = 3;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(2));
			this.prop2.add(new Prop(0));

		}
		else if (this.valeur == 7) {
			this.pointstricks = 2;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(2));
			this.prop2.add(new Prop(2));

		}
		else if (this.valeur == 8) {
			this.pointstricks = 2;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(1));
			this.prop2.add(new Prop(2));
			this.prop2.add(new Prop(0));

		}
		else if (this.valeur == 9) {
			this.pointstricks = 6;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(1));
			this.prop2.add(new Prop(4));

		}
		else if (this.valeur == 10) {
			this.pointstricks = 5;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(5));
			this.prop2.add(new Prop(1));
		
		}
		else if (this.valeur == 11) {
			this.pointstricks = 4;
			this.nomtrick = VALEURS[this.valeur];
			this.prop1.add(new Prop(6));
			this.prop2.add(new Prop(5));

		}
	}
	
	
	
	// commentaire

	/**
	 * @return the prop1
	 */
	public ArrayList<Prop> getProp1() {
		return prop1;
	}
	/**
	 * @return the prop2
	 */
	public ArrayList<Prop> getProp2() {
		return prop2;
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


	public boolean isTrickreussi() {
		return trickreussi;
	}

	public void setTrickreussi(boolean trickreussi) {
		this.trickreussi = trickreussi;
	}
	//test
	

    
}
