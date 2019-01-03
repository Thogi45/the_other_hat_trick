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
     * Permet d'indiquer si le joueur a décidé de réaliser le tour qu'on lui propose ou alors de piocher une carte pour découvrir une nouvelle carte. 
     */
    private int choixTrick;

    /**
     * Permet de calculer, en fin de partie, le nombre de points du joueur. 
     */
    private int point;

    /**
     * Permet de connaître l'état du jeu actuel. 
     */
    private Jeu jeu; 

    /**
     * Main du joueur.
     */
    private ArrayList<Prop> Main = new ArrayList<Prop> ();
    
    /**
     * Tricks que le joueur peut réaliser durant ce tour. Il peut soit réaliser le trick qu'on lui propose ou alors piocher une carte pour découvrir un nouveau trick.
     */
    private ArrayList<Trick> trickARealiser = new ArrayList<Trick>();
    
    /**
     * Tricks que le joueur a réussi à faire. 
     */
    private ArrayList<Trick> tricksRealises = new ArrayList<Trick>();
   
    /**
     * Booléen qui indique quel joueur doit jouer ce tour. 
     */
    private boolean estPremierAJouer;
    
    /**
     * Entier qui indique sur quelle variante on joue.
     */
    private int variante; 
    /**
     * Permet d'indiquer à l'objet joueur sur quelle variante on joue. 
     * @param variante
     * 		Indique la valeur de la variante. 
     */
    public void setVariante(int variante) {
    	this.variante = variante;
    }
    
    /**
     * Permet de récupérer la valeur de la variante.
     * 
     * @return l'entier indiquant sur quelle variante on joue.
     */
    public int getVariante() {
    	return variante;
    }
    
    /**
     * Permet de récupérer la valeur de l'attribut choixTrick qui indique si le joueur a choisi de faire un nouveau tour ou pas. 
     * @return l'entier indiquant le choix du joueur. 
     */
	public int getChoixTrick() {
		return choixTrick;
	}
	
	/**
	 * Permet d'ajouter des points au joueur. 
	 * @param pt
	 * 		Valeur à ajouter au nombre de points du joueurs.
	 * @see Jeu#compterPoints()
	 */
	public void addPoint(int pt) {
		this.point = this.point + pt;
	}

	/**
	 * Permet d'indiquer à l'objet joueur le trick choisi et que l'on va essayer de réaliser durant son tour.  
	 * @param choixTrick
	 * 		Entier indiquant le choix du joueur. 
	 */
	public void setChoixTrick(int choixTrick) {
		this.choixTrick = choixTrick;
	}

	/**
	 * Permet de savoir si c'est au tour du joueur de jouer. S'il est à true alors c'est à son tour de jouer. 
	 * @return booléen permettant de savoir si c'est au tour du joueur de jouer. 
	 */
	public boolean isEstPremierAJouer() {
		return estPremierAJouer;
	}

	/**
	 * Permet d'envoyer l'état du jeu actuel. 
	 * @param jeu
	 * 		Etat du jeu actuel.
	 */
	public abstract void setJeu(Jeu jeu);
	
	/**
	 * L'état du jeu actuel n'est envoyé qu'aux joueurs virtuels pour faire réfléchir l'intelligence artificielle. Grâce à l'héritage, cette méthode n'est appelée que dans le cas d'un joueur virtuel. 
	 * @param jeu
	 * 		Etat du jeu actuel. 
	 */
	public void setJeu1(Jeu jeu) {
		this.jeu = jeu;
	}
	
	/**
	 * Permet d'indiquer si c'est au joueur de jouer. 
	 * @param estPremierAJouer
	 * 		Booléen permettant de savoir si c'est au tour du joueur de jouer.
	 */
	public void setEstPremierAJouer(boolean estPremierAJouer) {
		this.estPremierAJouer = estPremierAJouer;
	}

	/**
	 * Permet d'ajouter un nouveau trick réussi à la collection tricksRealises qui correspond aux tricks réussis. 
	 * @param trickReussi
	 * 		Trick réussi. 
	 */
	public void addTrickRealises(Trick trickReussi) {
		this.tricksRealises.add(trickReussi);
	}

	/**
	 * Permet de récupérer la collection avec tous les tricks réalisés. 
	 * @return Collection avec tous les tricks réussis. 
	 */
	public ArrayList<Trick> getTricksRealises() {
		return tricksRealises;
	}

	/**
	 * Permet de récupérer l'état du jeu actuel à partir d'un objet joueur. 
	 * @return L'état du jeu actuel. 
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
	 * Le joueur récupère tous les tricks qu'il peut réaliser pendant le tour soit deux tricks possibles. Il en connait un, il choisit s'il veut le faire ou pas. 
	 * 
	 * @param trickARealiser
	 * 		Collection avec les deux tricks que le joueur peut réaliser. 
	 * @return Choix du joueur de faire le trick qu'on lui montrer ou alors de découvrir l'autre trick. 
	 */
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		this.trickARealiser = trickARealiser;
		return false;
	}

	/**
	 * Récupérer les tricks que le joueur peut faire durant son tour. 
	 * 
	 * @return Les tricks réalisables durant ce tour. 
	 */
	public ArrayList<Trick> getTrickARealiser() {
		return trickARealiser;
	}

	/**
	 * Récupérer le nom du joueur. 
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
	 * Récupérer le nombre de points du joueur. 
	 * 
	 * @return Le nombre de points du joueur. 
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Récupérer la main du joueur. 
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
	 * 		Carte à ajouter dans la main du joueur. 
	 */
	void setCarteMain(Prop carteMain) {
		this.Main.add(carteMain);
	}
	
	/**
	 * Supprimer une carte de la main du joueur. 
	 * 
	 * @param index
	 * 		Position de la carte à supprimer dans la main du joueur. 
	 */
	public void removeCarteMain(int index) {
		this.Main.remove(index);
	}
	
	/**
	 * Permet d'afficher, à la console, la main du joueur. 
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
	 * Permet d'ajouter plusieurs props d'un coup à la main du joueur. 
	 * @param propsCentre
	 * 		Props à ajouter à la main du joueur. 
	 */
	public void addMain(ArrayList<Prop> propsCentre) {
		this.Main.addAll(propsCentre);
	}
	
	/**
	 * Méthode permettant au joueur de retourner une carte de sa main quand il échoue lors de la réalisation d'un Trick. 
	 */
	public abstract void retournerCarte();
	
	/**
	 * Méthode permettant de choisir quels props on veut échanger et avec quel joueur. 
	 * 
	 * @return Tableau d'objets qui retourne le nom des joueurs pour l'échange et la position des cartes pour l'échange. 
	 */
	public abstract Object[] jouer();
	
	/**
	 * Méthode permettant, lorsque l'on a réussi son tour, de choisir les nouveaux props que l'on veut dans sa main. 
	 * 
	 * @param propCentre
	 * 		On récupère la collection des props au centre. 
	 * @return les nouveaux props au centre. 
	 */
	public abstract ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre);

	/**
	 * Méthode permettant de supprimer toute la main du joueur. 
	 */
	public void supprimerMain() {
		int a = this.Main.size();
		Main.removeAll(Main);
	}
	
	/**
	 * Méthode permettant d'afficher le nom du joueur et sa main. 
	 */
	public String toString() {
		return "[" + nom  + ", " + this.afficherMain() + "]" + "\n=====================";
	}

  

    
}
