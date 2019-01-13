package Carte;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Classe Trick qui définit les différents Tricks du jeu. 
 * 
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
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
	
	/**
	 * Enumération des différents noms possibles pour les tricks en correspondance avec les valeurs statiques. 
	 */
	public static String[] VALEURS = {"The Pair of Rabbits", "The Hat Trick", "The Hungry Rabbit", "The Rabbit that didn't like Carrots", "The Carrot Hat Trick", "The Slightly Easier Hat Trick", "The Vegetable Patch","The Bunch of Carrots", "The Vegetable Hat Trick", "The Other Hat Trick", "The Dove Hat Trick", "The Salad Fruit"} ;
	
	/**
	 * Valeur du trick qui permet d'accéder au nom et aux props liés. 
	 */
	private int valeur;
	
	/**
	 * Nom du trick
	 */
    private String nomtrick;
    
    /**
     * Points que rapporte la réalisation du Trick. 
     */
    private int pointstricks;
    
    /**
     * Collection de props qui permettent la réalisation du Trick.
     */
    private ArrayList<Prop> prop1 = new ArrayList<Prop>();
    
    /**
     * Collection de props qui permettent la réalisation du Trick. 
     */
    private ArrayList<Prop> prop2 = new ArrayList<Prop>();

    /**
     * Booléen qui indique si le trick est réussi ou pas. 
     */
    private boolean trickreussi;

    private boolean faceUp;
    private String [] IMAGE = {"image/PairRabbits.PNG","image/HatTrick.PNG","image/HungryRabbit.PNG","image/RabbitNotCarrots.PNG","image/CarrotsHat.PNG","image/SlightEasy.PNG","image/table.PNG","image/table.PNG","image/Vegetable.PNG","image/OtherHat.PNG","image/table.PNG","image/table.PNG"};
    private String simage;
	public static void ajoutervaleurs(int cartesAjoutees) {
		for (int i = 9; i < (4+cartesAjoutees); i++ ) {
			System.out.println("Donner le nom du Trick : ");
			Scanner nomprop = new Scanner(System.in);
			String nomProp = nomprop.nextLine();
			VALEURS[i] = nomProp;
			
		}
	}

	/**
	 * Méthode qui retourne les caractéristiques du Trick : son nom, le nombre de points qu'il rapporte et les props nécessaires pour réaliser la combinaison. 
	 * 
	 * @return String qui affiche les caractéristiques du Trick. 
	 */
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

	/**
	 * Constructeur pour créer les Tricks que l'on va utiliser dans le jeu. 
	 * 
	 * @see Trick#creerTrickdeBase()
	 * @param valeur
	 * 		Valeur qui permet d'indiquer les caractéristiques du Trick a créé. 
	 */
	public Trick(int valeur) {
		super();
		this.valeur = valeur;
		if (this.valeur <= 11) {
			this.creerTrickdeBase();
		}
		this.simage = IMAGE[valeur]; 
	}
	
	/**
	 * Méthode qui va permettre de donner les caractérisiques de l'objet Trick en fonction de la valeur de l'attribut Valeur. 
	 * 
	 * @see Trick#Trick(int)
	 */
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

	/**
	 * Permet de retourner les props possibles pour réaliser le trick. 
	 * @return Les prop1
	 */
	public ArrayList<Prop> getProp1() {
		return prop1;
	}
	
	/**
	 * Permet de retourner les props possibles pour réaliser le trick. 
	 * @return Les prop2
	 */
	public ArrayList<Prop> getProp2() {
		return prop2;
	}
	
	/**
	 * Permet de récupérer la valeur du Trick. 
	 * 
	 * @return La valeur du Trick
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * Permet de mettre en place la valeur du Trick. 
	 * 
	 * @param valeur
	 * 		Valeur du trick. 
	 * 		
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Permet de récupérer le nom du Trick. 
	 * 
	 * @return  Retourne le nom du Trick. 
	 */
	public String getNomtrick() {
		return nomtrick;
	}

	/**
	 * Permet de mettre en place le nom du Trick. 
	 * 
	 * 
	 * @param nomtrick
	 * 		Le nom du Trick. 
	 */
	public void setNomtrick(String nomtrick) {
		this.nomtrick = nomtrick;
	}

	/**
	 * Permet de récupérer le nombre de points si on réussit le trick. 
	 * @return  le nombre de points. 
	 */
	public int getPointstricks() {
		return pointstricks;
	}

	/**
	 * Permet de mettre en place le nombre de points si on réussit le trick. 
	 * 
	 * @param pointstricks
	 * 		Le nombre de points du trick. 
	 */
	public void setPointstricks(int pointstricks) {
		this.pointstricks = pointstricks;
	}

	/**
	 * Permet de savoir si le trick est réussi. 
	 * 
	 * @return Booléen indiquant si le trick est réussi. 
	 */
	public boolean isTrickreussi() {
		return trickreussi;
	}

	/**
	 * Permet d'indiquer si le trick est réussi. 
	 * 
	 * @param trickreussi
	 * 		Booléen indiquant si le trick est réussi. 
	 */
	public void setTrickreussi(boolean trickreussi) {
		this.trickreussi = trickreussi;
	}

	public String getsimage(int i) {
		
		return IMAGE[i] ;
	}

}
