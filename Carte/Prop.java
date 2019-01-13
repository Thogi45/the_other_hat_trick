package Carte;
import java.util.Scanner;
/**
 * Classe Prop qui définit les différents Props du jeu. 
 * 
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class Prop extends Carte {
    public final static int THELETTUCE = 0;
    public final static int THEHAT = 1;
    public final static int CARROTS = 2;
    public final static int THERABBIT = 3;
    public final static int THEOTHERRABBIT = 4;
    public final static int THEDOVE = 5;
    public final static int THEANANAS = 6;
    public final static int THEAPPLE = 7;
	
	/**
	 * Enumération des différents noms possibles pour les props en correspondance avec les valeurs statiques. 
	 */
	public static String[] VALEURS = {"The Lettuce", "The Hat", "Carrots", "The Rabbit", "The Other Rabbit", "The Dove", "The Ananas", "The Apple"};
	
	/**
	 * Valeur du prop qui permet d'accéder au nom lié. 
	 */
	private int valeur;
	
	/**
	 * Permet de savoir si la carte est faceUp ou faceDown.
	 */
	private boolean isFaceUp =false;

    private String[] IMAGE = {"image/Lettuce.PNG","image/Hat.PNG","image/Carrots.PNG","image/Rabbit.PNG","image/OtherRabbit.PNG","image/PropVerso.PNG","image/PropVerso.PNG","image/PropVerso.PNG"};
    private String simage;
    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
=======
	
	/**
	 * Nom du prop.

	 */
    private String nomP;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomP == null) ? 0 : nomP.hashCode());
		result = prime * result + valeur;
		return result;
	}

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
	
	/**
	 * Constructeur pour créer les Props que l'on va utiliser dans le jeu.  
	 * 
	 * @param valeur
	 * 		Valeur qui permet d'indiquer les caractéristiques du prop. 
	 */
	public Prop(int valeur) {
		super();
		this.valeur = valeur;
		this.nomP = VALEURS[valeur];
		this.simage = IMAGE[valeur]; 
	}
	
	/**
	 * Permet d'afficher le nom du prop si celui-ci est face UP. 
	 * 
	 * @param j
	 * 		Position du prop dans la main du joueur.
	 */
	public void afficherNom(int j) {
		if (this.isFaceUp==true) {
			System.out.println((j+1)+". "+this.nomP);
		}
		else {
			System.out.println((j+1)+". Non Visible.");
		}
	}

	/**
	 * Permet de savoir si la carte est visible ou pas. 
	 * 
	 * @return Booléen qui indique si la carte est visible ou pas.  
	 */
	public boolean getIsFaceUp() {
		return isFaceUp;
	}

	/**
	 * Permet de récupérer la valeur du prop.
	 * 
	 * @return La valeur du prop. 
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * Permet de donner le nom du prop.
	 * 
	 * @return Nom du prop.
	 */
	public String toString() {
		return Prop.VALEURS[this.valeur];
	}

	/**
	 * Permet de mettre en place la valeur du prop. 
	 * 
	 * @param valeur
	 * 		Valeur du prop. 
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Permet d'indiquer si la carte est face up ou face down. 
	 * 
	 * @param isFaceUp
	 * 		Booléen qui indique si la carte est faceUp ou faceDown. 
	 */
	public void setIsFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	/**
	 * Permet de récupérer le nom du Prop. 
	 * 
	 * @return le nom du prop. 
	 */
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
