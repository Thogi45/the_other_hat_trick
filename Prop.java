import java.util.Scanner;

public class Prop extends Carte {
    public final static int THELETTUCE = 0;
    public final static int THEHAT = 1;
    public final static int CARROTS = 2;
    public final static int THERABBIT = 3;
    public final static int THEOTHERRABBIT = 4;
	
	public static String[] VALEURS = {"The Lettuce", "The Hat", "Carrots", "The Rabbit", "The Other Rabbit"};
	
	private int valeur;
	private boolean isFaceUp;
    private String nomP;
    
	public Prop(int valeur) {
		super();
		this.valeur = valeur;
		
	}

	public boolean getIsFaceUp() {
		return isFaceUp;
	}

	public int getValeur() {
		return valeur;
	}

	public String toString() {
		return Prop.VALEURS[this.valeur];
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public static void ajoutervaleurs(int cartesAjoutees) {
		for (int i = 4; i < (4+cartesAjoutees); i++ ) {
			System.out.println("Donner le nom du prop : ");
			Scanner nomprop = new Scanner(System.in);
			String nomProp = nomprop.nextLine();
			VALEURS[i] = nomProp;
		}
	}
	public void setIsFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public Prop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prop(String nomP) {
		super();
		
		this.nomP = nomP;
	}

	public void melanger() {
    }

    public void changerprop() {
    }

    public void choisir2propspourswitch() {
    }

}
