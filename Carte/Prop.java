package Carte;
import java.util.Scanner;

public class Prop extends Carte {
    public final static int THELETTUCE = 0;
    public final static int THEHAT = 1;
    public final static int CARROTS = 2;
    public final static int THERABBIT = 3;
    public final static int THEOTHERRABBIT = 4;
    public final static int THEDOVE = 5;
    public final static int THEANANAS = 6;
    public final static int THEAPPLE = 7;
	
	public static String[] VALEURS = {"The Lettuce", "The Hat", "Carrots", "The Rabbit", "The Other Rabbit", "The Dove", "The Ananas", "The Apple"};
	
	private int valeur;
	private boolean isFaceUp =false;
    private String nomP;
    private String[] IMAGE = {"image/Lettuce.PNG","image/Hat.PNG","image/Carrots.PNG","image/Rabbit.PNG","image/OtherRabbit.PNG","image/PropVerso.PNG","image/PropVerso.PNG","image/PropVerso.PNG"};
    private String simage;
    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomP == null) ? 0 : nomP.hashCode());
		result = prime * result + valeur;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prop other = (Prop) obj;
		if (nomP == null) {
			if (other.nomP != null)
				return false;
		} else if (!nomP.equals(other.nomP))
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}
	public Prop(int valeur) {
		super();
		this.valeur = valeur;
		this.nomP = VALEURS[valeur];
		this.simage = IMAGE[valeur]; 
	}
	public void ajouterCartes(int cartesAjoutees, int valeur) {
		int propsAjoutees = cartesAjoutees;
		while (propsAjoutees > 0) {
			
		}
	}
	
	public void afficherNom(int j) {
		if (this.isFaceUp==true) {
			System.out.println((j+1)+". "+this.nomP);
		}
		else {
			System.out.println((j+1)+". Non Visible.");
		}
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
	public String getsimage(int i) {
		return this.IMAGE[i];
	}

}
