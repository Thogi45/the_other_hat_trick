import java.util.ArrayList;

/**
 * Classe des joueurs permettant d'enregistrer toutes les informations sur eux. 
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */

public abstract class Joueur {
	/**
	 * Nom du joueur
	 */
    private String nom;
    
    /**
     * Permet d'indiquer si le joueur a d�cid� de r�aliser le tour qu'on lui propose ou alors de piocher une carte pour d�couvrir une nouvelle carte. 
     */
    private int choixTrick;

    /**
     * Permet de calculer, en fin de partie, le nombre de points du joueur. 
     */
    private int point;

    /**
     * Permet de conna�tre l'�tat du jeu actuel. 
     */
    private Jeu jeu; 

    /**
     * Main du joueur.
     */
    private ArrayList<Prop> Main = new ArrayList<Prop> ();
    
    /**
     * Tricks que le joueur peut r�aliser durant ce tour. Il peut soit r�aliser le trick qu'on lui propose ou alors piocher une carte pour d�couvrir un nouveau trick.
     */
    private ArrayList<Trick> trickARealiser = new ArrayList<Trick>();
    
    /**
     * Tricks que le joueur a r�ussi � faire. 
     */
    private ArrayList<Trick> tricksRealises = new ArrayList<Trick>();
   
    /**
     * Bool�en qui indique quel joueur doit jouer ce tour. 
     */
    private boolean estPremierAJouer;
    
    /**
     * Entier qui indique sur quelle variante on joue.
     */
    private int variante; 
    /**
     * Permet d'indiquer � l'objet joueur sur quelle variante on joue. 
     * @param variante
     * 		Indique la valeur de la variante. 
     */
    public void setVariante(int variante) {
    	this.variante = variante;
    }
    
    /**
     * Permet de r�cup�rer la valeur de la variante.
     * 
     * @return l'entier indiquant sur quelle variante on joue.
     */
    public int getVariante() {
    	return variante;
    }
    
    /**
     * Permet de r�cup�rer la valeur de l'attribut choixTrick qui indique si le joueur a choisi de faire un nouveau tour ou pas. 
     * @return l'entier indiquant le choix du joueur. 
     */
	public int getChoixTrick() {
		return choixTrick;
	}
	
	/**
	 * Permet d'ajouter des points au joueur. 
	 * @param pt
	 * 		Valeur � ajouter au nombre de points du joueurs.
	 * @see Jeu#compterPoints()
	 */
	public void addPoint(int pt) {
		this.point = this.point + pt;
	}

	/**
	 * Permet d'indiquer � l'objet joueur le trick choisi et que l'on va essayer de r�aliser durant son tour.  
	 * @param choixTrick
	 * 		Entier indiquant le choix du joueur. 
	 */
	public void setChoixTrick(int choixTrick) {
		this.choixTrick = choixTrick;
	}

	/**
	 * Permet de savoir si c'est au tour du joueur de jouer. S'il est � true alors c'est � son tour de jouer. 
	 * @return bool�en permettant de savoir si c'est au tour du joueur de jouer. 
	 */
	public boolean isEstPremierAJouer() {
		return estPremierAJouer;
	}

	/**
	 * Permet d'envoyer l'�tat du jeu actuel. 
	 * @param jeu
	 * 		Etat du jeu actuel.
	 */
	public abstract void setJeu(Jeu jeu);
	
	/**
	 * L'�tat du jeu actuel n'est envoy� qu'aux joueurs virtuels pour faire r�fl�chir l'intelligence artificielle. Gr�ce � l'h�ritage, cette m�thode n'est appel�e que dans le cas d'un joueur virtuel. 
	 * @param jeu
	 * 		Etat du jeu actuel. 
	 */
	public void setJeu1(Jeu jeu) {
		this.jeu = jeu;
	}
	
	/**
	 * Permet d'indiquer si c'est au joueur de jouer. 
	 * @param estPremierAJouer
	 * 		Bool�en permettant de savoir si c'est au tour du joueur de jouer.
	 */
	public void setEstPremierAJouer(boolean estPremierAJouer) {
		this.estPremierAJouer = estPremierAJouer;
	}

	/**
	 * Permet d'ajouter un nouveau trick r�ussi � la collection tricksRealises qui correspond aux tricks r�ussis. 
	 * @param trickReussi
	 * 		Trick r�ussi. 
	 */
	public void addTrickRealises(Trick trickReussi) {
		this.tricksRealises.add(trickReussi);
	}

	/**
	 * Permet de r�cup�rer la collection avec tous les tricks r�alis�s. 
	 * @return Collection avec tous les tricks r�ussis. 
	 */
	public ArrayList<Trick> getTricksRealises() {
		return tricksRealises;
	}

	/**
	 * Permet de r�cup�rer l'�tat du jeu actuel � partir d'un objet joueur. 
	 * @return L'�tat du jeu actuel. 
	 */
	public Jeu getJeu() {
		return jeu;
	}

	/**
	 * Constructeur de la classe Joueur. 
	 */
	public Joueur() {
	}

	/**
	 * Le joueur r�cup�re tous les tricks qu'il peut r�aliser pendant le tour soit deux tricks possibles. Il en connait un, il choisit s'il veut le faire ou pas. 
	 * 
	 * @param trickARealiser
	 * 		Collection avec les deux tricks que le joueur peut r�aliser. 
	 * @return Choix du joueur de faire le trick qu'on lui montrer ou alors de d�couvrir l'autre trick. 
	 */
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		this.trickARealiser = trickARealiser;
		return false;
	}

	/**
	 * R�cup�rer les tricks que le joueur peut faire durant son tour. 
	 * 
	 * @return Les tricks r�alisables durant ce tour. 
	 */
	public ArrayList<Trick> getTrickARealiser() {
		return trickARealiser;
	}

	/**
	 * R�cup�rer le nom du joueur. 
	 * 
	 * @return Le nom du joueur. 
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Mettre en place un nom pour le joueur. 
	 * 
	 * @param nom
	 * 		Nom du joueur. 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * R�cup�rer le nombre de points du joueur. 
	 * 
	 * @return Le nombre de points du joueur. 
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * R�cup�rer la main du joueur. 
	 * 
	 * @return Collection de la main du joueur. 
	 */
	public ArrayList<Prop> getMain() {
		return Main;
	}

	/**
	 * Mettre un nombre de points au joueur. 
	 * 
	 * @param point
	 * 		Points du joueur. 
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Ajouter une nouvelle carte dans la main du joueur. 
	 * 
	 * @param carteMain
	 * 		Carte � ajouter dans la main du joueur. 
	 */
	void setCarteMain(Prop carteMain) {
		this.Main.add(carteMain);
	}
	
	/**
	 * Supprimer une carte de la main du joueur. 
	 * 
	 * @param index
	 * 		Position de la carte � supprimer dans la main du joueur. 
	 */
	public void removeCarteMain(int index) {
		this.Main.remove(index);
	}
	
	/**
	 * Permet d'afficher, � la console, la main du joueur. 
	 * @return
	 * 		Un string montrant la main du joueur. 
	 */
	public String afficherMain() {
		String Main = "Props : "+this.Main.get(0).toString();
		for (int i=1; i<this.Main.size();i++ ) {
			Main = Main +", " + this.Main.get(i).toString();
		}
		return Main;
	}
	
	/**
	 * Permet d'afficher en fin de partie, le nom du joueur et son nombre de points. 
	 * 
	 * @return
	 * 		Un string indiquant le nom du joueur et son nombre de points. 
	 */
	public String toString2() {
		return "[ " + this.nom + ", " + "Points = " + this.point + " ]";
	}
	
	/**
	 * Permet d'ajouter plusieurs props d'un coup � la main du joueur. 
	 * @param propsCentre
	 * 		Props � ajouter � la main du joueur. 
	 */
	public void addMain(ArrayList<Prop> propsCentre) {
		this.Main.addAll(propsCentre);
	}
	
	/**
	 * M�thode permettant au joueur de retourner une carte de sa main quand il �choue lors de la r�alisation d'un Trick. 
	 */
	public abstract void retournerCarte();
	
	/**
	 * M�thode permettant de choisir quels props on veut �changer et avec quel joueur. 
	 * 
	 * @return Tableau d'objets qui retourne le nom des joueurs pour l'�change et la position des cartes pour l'�change. 
	 */
	public abstract Object[] jouer();
	
	/**
	 * M�thode permettant, lorsque l'on a r�ussi son tour, de choisir les nouveaux props que l'on veut dans sa main. 
	 * 
	 * @param propCentre
	 * 		On r�cup�re la collection des props au centre. 
	 * @return les nouveaux props au centre. 
	 */
	public abstract ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre);

	/**
	 * M�thode permettant de supprimer toute la main du joueur. 
	 */
	public void supprimerMain() {
		int a = this.Main.size();
		Main.removeAll(Main);
	}
	
	/**
	 * M�thode permettant d'afficher le nom du joueur et sa main. 
	 */
	public String toString() {
		return "[" + nom  + ", " + this.afficherMain() + "]" + "\n=====================";
	}

  

    
}
