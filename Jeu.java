import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Classe permettant de g�rer toutes les actions du jeu : de l'initialisation � la fin de partie. Classe la plus importante de notre programme.
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class Jeu {

    private String joueurEnCours;
/**
 * Attribut donnant le nom du joueur choisit pour l'�change de props. 
 * 
 * @see Jeu
 * @see Jeu#ajouterProps(Object[])
 * @see Jeu#switcherProps(Object[])
 */
    private String joueurEchange = "";
    /**
     * Attribut indiquant le nombre de Joueurs R�els.
     * 
     * @see Jeu
     * @see Jeu#setNbredeJoueursR(int)
     */
    private int nbredeJoueursR=0;
    /**
     * Attribut indiquant le nombre de Joueurs Virtuels.
     * 
     * @see Jeu
     * @see Jeu#setNbredeJoueursV(int)
     */
    private int nbredeJoueursV=0;
    /**
     * Attribut indiquant le nombre de Joueurs.
     * 
     * @see Jeu
     * @see Jeu#setNbredeJoueurs(int)
     */
    private int nbredeJoueurs=0;
    
    /**
     * Attribut indiquant la variante choisie lors de l'initialisation de la partie. 
     * 
     * @see DemarrageJeu
     * @see DemarrageJeu#lancerLeJeu()
     * @see Jeu
     * @see Jeu#jouerAvecVariantes(int)
     */
    private int variante = 0;
    
    /**
     * Bool�en indiquant si la partie est termin�e ou pas. Il est modifi� en cours de partie quand le Trick Deck est vide.
     * 
     * @see Jeu
     * @see Jeu#piocherUneCarteTrick(boolean)
     */
    private boolean finPartie = false;
    
    /**
     * Collection des Tricks pr�sents dans le Trick Deck. Choix d'un ArrayList en d�but de cr�ation mais pourrait tr�s bien �tre une LinkedList.
     * <p>
     * Possibilit� de r�cup�rer un Trick Deck ou de mettre en place un nouveau Trick Deck. 
     * 
     * @see Jeu
     * @see Jeu#gettrickD()
     * @see Jeu#settrickD(ArrayList)
     */
    private ArrayList<Trick> trickD = new ArrayList<Trick> ();
    
    /**
     * Collection des Tricks pr�sents dans le Trick Pile. Choix d'un ArrayList en d�but de cr�ation mais pourrait tr�s bien �tre une LinkedList.
     * <p>
     * Possibilit� de r�cup�rer le Trick Pile. 
     * 
     * @see Jeu
     * @see Jeu#getTrickP()
     */   
    private ArrayList<Trick> trickP = new ArrayList<Trick> ();
    
    /**
     * Collection des Props. Apr�s la m�thode Jeu.distribuerProps(), cette collection contient tous les props Centre. 
     * <p>
     * Possibilit� de r�cup�rer la collection de props ou d'en mettre en place une nouvelle. 
     * 
     * @see Jeu
     * @see Jeu#distribuerProps()
     * @see Jeu#getProp()
     * @see Jeu#setProp(ArrayList)
     * @see Prop
     */
    private ArrayList<Prop> prop = new ArrayList<Prop> ();

    /**
     * Collection des Joueurs (Virtuels et Reels).
     * <p>
     * Possibilit� d'ajouter des joueurs � la collection, de r�cup�rer la collection ou de mettre en place une nouvelle collection de joueurs. 
     * 
     * @see Jeu
     * @see Jeu#creerJoueurs()
     * @see Jeu#getJoueur()
     * @see Jeu#setJoueur(ArrayList)
     * 
     */
    private ArrayList<Joueur> joueur = new ArrayList<Joueur> ();
    
    /**
     * Collection des Joueurs Virtuels.
     * <p>
     * Possibilit� de r�cup�rer la collection ou de mettre en place une nouvelle collection de joueurs Virtuels. 
     * 
     * @see Jeu
     * @see Jeu#getJoueurV()
     * @see Jeu#setJoueurV(ArrayList)
     * 
     */
    private ArrayList<JoueurVirtuel> joueurV = new ArrayList<JoueurVirtuel> ();
    /**
     * Collection des Joueurs R�els.
     * <p>
     * Possibilit� de r�cup�rer la collection ou de mettre en place une nouvelle collection de joueurs R�els. 
     * 
     * @see Jeu
     * @see Jeu#getJoueurR()
     * @see Jeu#setJoueurR(ArrayList)
     * 
     */
    private ArrayList<JoueurReel> joueurR = new ArrayList<JoueurReel>();
    
    /**
     * Permet de r�cup�rer le jeu dans son �tat actuel. 
     * @return le jeu actuel avec toutes les informations sur les joueurs, les tricks et les props
     */
    public Jeu getJeu() {
    	return this;
    }

    /**
     * Permet de retourner la valeur de la variante. 
     * @return Valeur de la variante. 
     */
	public int getVariante() {
		return variante;
	}

	/**
	 * M�thode pour distribuer les props en d�but de partie. Le reste de la division euclidienne du nombre de props par le nombre de joueurs constituera les props du milieu. 
	 */
	public void distribuerProps () {
    	int nbreProps = this.prop.size();
    	int nbreJoueur = this.joueur.size();
    	//propsauC calcule le reste de la division euclidienne du nombre de props par le nombre de Joueur
    	int propsauC = nbreProps%nbreJoueur;
    	int j=0;
    	// On distribue aux joueurs le quotient de la divisien euclidienne du nombre de props par le nombre de Joueur
    	for (int i = 0; i<(nbreProps-propsauC); i++) { 			
    		this.joueur.get(j).setCarteMain(this.prop.get(0));
    		this.prop.remove(0);
    		j++;
    		if (j==nbreJoueur) {
    			j=0;
    		}
    	}
    	//Une fois la distribution des props effectu�e, on peut lancer la partie. 
    	this.commencer();
    }

	/**
	 * Indique le nombre de Joueurs au total. 
	 * @return un entier indiquant le nombre de Joueurs au total.
	 */
	public int getNbredeJoueurs() {
		return nbredeJoueurs;
	}

	/**
	 * Permet d'indiquer � l'objet Jeu combien il y a-t-il de joueurs en tout. 
	 * 
	 * @param nbredeJoueurs
	 * 		On entre, en param�tre, le nombre de joueurs. 
	 */
	public void setNbredeJoueurs(int nbredeJoueurs) {
		this.nbredeJoueurs = nbredeJoueurs;
	}

	/**
	 * R�cup�re le Trick Deck. M�thode pas utilis�e. 
	 * 
	 *
	 * @return La collection du Trick Deck. 
	 */
	public ArrayList<Trick> gettrickD() {
		return trickD;
	}

	/**
	 * Met en place un nouveau Trick Deck. M�thode pas utilis�e. 
	 * @param trickD
	 * 		Une collection de Tricks
	 */
	public void settrickD(ArrayList<Trick> trickD) {
		this.trickD = trickD;
	}

	/**
	 * R�cup�re le tas de Props. 
	 * 
	 * @return le tas de Props qui, apr�s la m�thode distribuerProps(), correspond aux props centre. 
	 * @see Jeu#distribuerProps()
	 */
	public ArrayList<Prop> getProp() {
		return prop;
	}

	/**
	 * Met en place un nouveau tas de Props. 
	 * 
	 * @param prop
	 * 		une collection de Props
	 */
	public void setProp(ArrayList<Prop> prop) {
		this.prop = prop;
	}

	/**
	 * R�cup�re la collection de tous les joueurs pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @return la collection de tous les joueurs pr�sents dans l'objet Jeu en cours. 
	 */
	public ArrayList<Joueur> getJoueur() {
		return joueur;
	}

	/**
	 * Met en place une nouvelle collection de Joueurs. 
	 * 
	 * @param joueur
	 * 		Une collection de Joueurs
	 */
	public void setJoueur(ArrayList<Joueur> joueur) {
		this.joueur = joueur;
	}

	/**
	 * R�cup�re la collection de tous les joueurs virtuels pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @return la collection de tous les joueurs virtuels pr�sents dans l'objet Jeu en cours. 
	 */
	public ArrayList<JoueurVirtuel> getJoueurV() {
		return joueurV;
	}

	/**
	 * Met en place une nouvelle collection de Joueurs virtuels. 
	 * 
	 * @param joueurV
	 * 		Une collection de Joueurs virtuels
	 */
	public void setJoueurV(ArrayList<JoueurVirtuel> joueurV) {
		this.joueurV = joueurV;
	}

	/**
	 * R�cup�re la collection de tous les joueurs r�els pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @return la collection de tous les joueurs r�els pr�sents dans l'objet Jeu en cours. 
	 */
	public ArrayList<JoueurReel> getJoueurR() {
		return joueurR;
	}

	/**
	 * Met en place une nouvelle collection de Joueurs r�els. 
	 * 
	 * @param joueurR
	 * 		Une collection de Joueurs r�els
	 */
	public void setJoueurR(ArrayList<JoueurReel> joueurR) {
		this.joueurR = joueurR;
	}

	/**
	 * Constructeur pour la classe Jeu
	 */
	public Jeu() {

	}

	/**
	 * Donne le nombre de joueurs virtuels pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @return le nombre de joueurs virtuels pr�sents dans l'objet Jeu en cours. 
	 */
	public int getNbredeJoueursV() {
		return nbredeJoueursV;
	}

	/**
	 * Permet d'indiquer le nombre de joueurs virtuels pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @param nbredeJoueursV
	 * 		le nombre de joueurs virtuels
	 */
	public void setNbredeJoueursV(int nbredeJoueursV) {
		this.nbredeJoueursV = nbredeJoueursV;
	}

	/**
	 * Donne le nombre de joueurs r�els pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @return le nombre de joueurs r�els pr�sents dans l'objet Jeu en cours. 
	 */
	public int getNbredeJoueursR() {
		return nbredeJoueursR;
	}

	/**
	 * Permet d'indiquer le nombre de joueurs r�els pr�sents dans l'objet Jeu en cours. 
	 * 
	 * @param nbredeJoueursR
	 * 		le nombre de joueurs r�els
	 */
	public void setNbredeJoueursR(int nbredeJoueursR) {
		this.nbredeJoueursR = nbredeJoueursR;
	}

	/**
	 * Permet de r�cup�rer le nom du joueur actuellement en train de jouer. 
	 * 
	 * @return le nom du joueur. 
	 */
	public String getJoueurEnCours() {
		return joueurEnCours;
	}

	/**
	 * Permet d'indiquer � l'objet Jeu en cours le nom du joueur actuellement en train de jouer. 
	 * 
	 * @param joueurEnCours
	 * 		Retourne le nom du joueur en train de jouer. 
	 */
	public void setJoueurEnCours(String joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	/**
	 * En fonction de la variante choisie, l'utilisateur va pouvoir entrer plusieurs donn�es qui vont d�terminer la fa�on dont il d�sire jouer. Il peut d�cider d'ajouter plusieurs joueurs ou encore plusieurs cartes.
	 * <p>
	 * Variable 1 : 3 joueurs mais plus de cartes par joueur. 
	 * Variable 2 : 6 joueurs peuvent jouer en tout et chaque joueur � 1 carte. 
	 * Variable 3 : Possibilit� d'ajouter des joueurs (jusqu'� 6) et des cartes.
	 * 
	 * 
	 * @param variante
	 * 		Variante de jeu choisie par l'utilisateur. 
	 * @see DemarrageJeu#lancerLeJeu()
	 */
	public void jouerAvecVariantes(int variante) {
		this.variante = variante;
		//L'utilisateur indique � combien de joueurs il veut jouer si il a choisit la variante 3. 
		if (variante == 3) {
			System.out.println("Dans cette variante, vous ajoutez autant de joueurs (pas plus de 6) et de cartes que vous voulez.");
			System.out.println("\nA combien de joueurs voulez-vous jouer ?");
			Scanner sc = new Scanner(System.in);
	    	setNbredeJoueurs(sc.nextInt());
		}
		
		//Si les variantes 1 ou 3 sont choisies, on va pouvoir ajouter des cartes. 
		if (variante == 1 || variante == 3) {
			// Pour la variante 1, on a 3 joueurs forc�ment. 
			if (variante == 1) {
				this.setNbredeJoueurs(3);
			}
			
			//On va proposer � l'utilisateur, les cartes qu'il d�sire ajouter au jeu. 
			System.out.println("Packs disponibles (Vous pouvez ajouter tous les packs) :\n");
			System.out.println("Pack 1 (Props et trickDs de base x2)");
			System.out.println("\nPack 2 (Nouveaux trickDs et Props)");
			System.out.println("\nQuels packs d'extension voulez-vous ajouter ? Entrez : 1, 2, 12 ou 122");
			System.out.println("1. Pack 1");
			System.out.println("2. Pack 2");
			System.out.println("12. Pack 1 et Pack 2");
			System.out.println("122. Pack 1 et Pack 2 x2");
			Scanner sc1 = new Scanner(System.in);
			int extension = sc1.nextInt();
			//En fonction de son choix, on va ajouter les cartes correspondantes.  
			if (extension == 1 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(0));
				this.prop.add(new Prop(1));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(3));
				this.prop.add(new Prop(4));
				for (int i = 0; i<9; i++) {
					this.trickD.add(new Trick(i));
					}	
			}
			if (extension == 2 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(5));
				this.prop.add(new Prop(6));
				this.prop.add(new Prop(7));
				this.trickD.add(new Trick(10));
				this.trickD.add(new Trick(11));
				if (extension == 122) {
					this.prop.add(new Prop(5));
					this.prop.add(new Prop(6));
					this.prop.add(new Prop(7));
					this.trickD.add(new Trick(10));
					this.trickD.add(new Trick(11));
				}
			}
		}
		//Si la variante 2 est choise, aucune carte est cr��e et le nombre de joueurs passe automatiquement � 6. 
		if (variante == 2) {
			System.out.println("Dans cette variante, vous ajoutez 3 nouveaux joueurs");
			System.out.println("\nVous n'avez donc plus qu'une carte et il va vous falloir combiner avec les props de vos adversaires ou le prop du milieu");
			this.setNbredeJoueurs(6);			
		}
		
		//Une fois la gestion des variantes termin�e, on peut cr�er les joueurs. 
		this.creerJoueurs();
	}

	/**
	 * Classe permettant de cr�er tous les joueurs qui vont participer � la partie en cours. 
	 * <P>
	 * Dans un premier temps, on s'assurera que la somme du nombre de joueurs r�els et du nombre de joueurs virtuels est �gale au nombre de joueurs total. 
	 * <P>
	 * Ensuite, on enregistre les informations sur les joueurs. Pour les joueurs virtuels, on demande leur niveau de jeu (facile ou moyen). Pour les joueurs r�els, on demande le nom des joueurs et ensuite leur �ge. 
	 * <P>
	 * Enfin, si il y a des joueurs r�els, on cherche quel est le joueur le plus jeune. Si plusieurs joueurs ont le m�me �ge, on tire au hasard un joueur parmi ces joueurs.   
	 *
	 * @see Jeu#jouerAvecVariantes(int)
	 * @see DemarrageJeu#lancerLeJeu()
	 */
    public void creerJoueurs() {
    	int joueursR = this.nbredeJoueursR;
    	int joueursV = this.nbredeJoueursV;
    	int jR = 0, jV =0;
    	
    	//Tant que le nombre de joueurs entr�s n'est pas �gal au nombre de joueurs total enregistr� pr�cedemment, l'utilisateur doit continuer � entrer le nombre de joueurs. 
    	while (this.nbredeJoueurs != (jR+jV)) {
    	System.out.println("\nNombre de Joueurs Reels ?");
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	setNbredeJoueursR(A);
    	jR = joueursR+A;
    	System.out.println("\nNombre de Joueurs Virtuels ?");
    	Scanner sc1 = new Scanner(System.in);
    	int B =  sc1.nextInt();
    	setNbredeJoueursV(B);
    	jV = joueursV+B;
    	}
    	
    	//Si il y a des joueurs virtuels, on demande le niveau des joueurs. 
    	if (this.nbredeJoueursV !=0) {
    		System.out.println("Quel est le niveau des joueurs\nFacile Moyen");
    		Scanner niveau = new Scanner(System.in);
    		String niv = niveau.nextLine();
    		char carac = niv.charAt(0);
       	for (int i=joueursV; i < this.nbredeJoueursV ; i++ ) {
    		if (carac == 'F' || carac == 'f') {
    			this.joueurV.add(new JoueurVirtuel(new Facile()));
    		}
    		else if (carac == 'M' || carac == 'm') {
    			this.joueurV.add(new JoueurVirtuel(new Moyen()));
    		}
    		this.joueurV.get(i).setNom("ordi "+ (i+1));
    		this.joueurV.get(i).setEstPremierAJouer(false);
    		
    	}
       	//Si il n'y pas de joueurs r�els, on d�termine al�atoiement quel joueur virtuel va commencer. 
   		if (this.nbredeJoueursR == 0) {
   			int m = (int) Math.random()*this.nbredeJoueursV;
   			this.joueurV.get(m).setEstPremierAJouer(true);
   		}

       	}
    	//Si il y a des joueurs r�els, on demande le nom et l'�ge des joueurs tout en retenant � chaque fois l'�ge du plus jeune. 
        	if (this.nbredeJoueursR !=0) {
            	double ageplusjeune = 200 ;
            	System.out.println("Vous allez entrer le nom des Joueurs et leur age");
            	int i = 0;
            	int plusjeune[];
            	plusjeune = new int[this.getNbredeJoueursR()];
        	for (int j=joueursR; j<(this.nbredeJoueursR); j++) {
        		System.out.println("Quel est le nom de joueur " + (j+1) + " ?");
        		Scanner nomJ = new Scanner(System.in);
        		String nom = nomJ.nextLine();
        		System.out.println("Quel est son age ?");
        		Scanner ageJ = new Scanner(System.in);
        		double age = ageJ.nextDouble();
        		this.joueurR.add(new JoueurReel(age, nom));
        		this.joueurR.get(j).setEstPremierAJouer(false);
        		if (joueursR == 0) {
        		if (age < ageplusjeune) {
        			ageplusjeune = age ;
        			i = 0;
        	    	plusjeune[i] = j;	
        		}
        		else if (age == ageplusjeune) {
        			i = i + 1 ;
        			plusjeune[i] = j;
        		}
        		
        	}
        	}
        	//On d�termine quel joueur r�el va commencer � jouer. 
        	int n = (int)(Math.random()*i);
        	this.joueurR.get(plusjeune[n]).setEstPremierAJouer(true);

    }
        	//On place les joueurs virtuels et les joueurs r�els dans la collection joueur. 
        	this.joueur.addAll(joueurR);
        	this.joueur.addAll(joueurV);
        	System.out.println("=============================");
        	this.creerCartesdeBase();

    }
    
    /**
     * M�thode pour cr�er toutes les cartes de base au jeu "The Other Hat Trick". Si jamais l'utilisateur a d�cid� de joueur avec des variantes permettant d'ajouter des cartes, les cartes de base vont s'ajouter aux cartes d�j� ajouter pr�alablement. Remarque : la m�thode Collections.shuffle permet de m�langer les props et les tricks. 
     * 
     * @see Jeu#jouerAvecVariantes(int)
     * @see Trick
     * @see Prop
     */
    public void creerCartesdeBase() {
		this.prop.add(new Prop(0));
		this.prop.add(new Prop(1));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(3));
		this.prop.add(new Prop(4));
		//Une fois tous les Props ajout�s, on m�lange la pile de props. 
		Collections.shuffle(this.prop);
		for (int i = 0; i<9; i++) {
		this.trickD.add(new Trick(i));
		}
		//On m�lange le Trick Deck avant d'ajouter le dernier trick : The Other Hat Trick. 
		Collections.shuffle(this.trickD);
		this.trickD.add(new Trick(9));
		this.distribuerProps();
    }
    
    /**
     * M�thode qui cherche qui doit jouer durant ce tour. Elle va ensuite indiquer la personne qui va essayer de r�aliser son tour. Ensuite, elle appelera des m�thodes permettant de mettre en place le d�but du tour du joueur en cours et de s'assurer que les prochains tours s'effectuent correctement.   
     * 
     * @return la position du joueur qui joue. 
     * @see Jeu#piocherUneCarteTrick(boolean)
     * @see Jeu#gererActionsDeJeu(int)
     * @see Jeu#mettreAJourLaPile()
     * @see Joueur
     * @see Joueur#setTrickARealiser(ArrayList)
     */
	public int commencer() {
		//On cherche la position du joueur � qui c'est le tour de jouer. 
		int j=0;
		while (this.joueur.get(j).isEstPremierAJouer()==false && j<this.nbredeJoueurs) {
			j = j+1;
		}
		//Une fois ce joueur trouv�, on donne son nom et on lui envoie l'�tat actuel du jeu si c'est un joueur virtuel.
		//On indique ensuite la prochaine personne qui jouera au prochain appel de la m�thode commencer().
		if (this.joueur.get(j).isEstPremierAJouer()==true) {
			System.out.println("La personne qui joue est :\n "+ this.joueur.get(j).toString());
			this.joueur.get(j).setJeu(this);
			this.joueur.get(j).setEstPremierAJouer(false);
			if (j+1 == this.nbredeJoueurs){
				this.joueur.get(0).setEstPremierAJouer(true);
			   }
			else {
				this.joueur.get(j+1).setEstPremierAJouer(true);
			}
		}
		this.piocherUneCarteTrick(this.joueur.get(j).setTrickARealiser(this.mettreAJourLaPile()));
		this.gererActionsDeJeu(j);
		//On retourne la position du joueur qui est en train de jouer. 
		return j;
    }

	/**
	 * Cette m�thode sert � piloter le tour de jeu du joueur. On va appeler des m�thodes permettant d'afficher les cartes visibles sur le plateau de jeu. A la fin de la m�thode, on va d�terminer si il faut relancer un tour de jeu ou si la partie est termin�e. 
	 * <P>
	 * Mais surtout, cette m�thode va s'assurer que les informations entrer dans le tableau infosSwitch sont correctes et permettent de r�aliser correctement les �changes de Props. 
	 * 
	 * @param j
	 * 		Position du joueur qui joue. 
	 */
	public void gererActionsDeJeu(int j) {
		//On envoie l'�tat du jeu actuel si le joueur qui joue est un joueur virtuel
		this.joueur.get(j).setJeu(this);
		//On affiche l'�tat du plateau. 
		this.afficherPlateau();
		//On cr�e une collection ArrayList (mais on aurait pu cr�er une collection HashSet plut�t) qui va contenir la liste de tous les joueurs sauf celui qui est en train de jouer. 
		ArrayList<String> nomJ = new ArrayList<String> ();
		for (int i =0; i < this.nbredeJoueurs;i++) {
			if (j != i) {
			nomJ.add(this.joueur.get(i).getNom());
			}
		}
		//Si on choisit la variante 2, il est possible de choisir la carte du propsCentre pour effectuer un tour de magie. Par cons�quent, on ajoute PropsCentre dans la collection des noms. 
		if (this.variante==2) {
			nomJ.add("PropsCentre");
		}
		boolean OK = false;
		/*Cr�ation d'un tableau d'objets qui contiendra :
		 * infosSwitch[0] : nom du joueur qui joue.
		 * infosSwitch[1] : position de la carte du joueur qui joue dont il veut se d�barasser. 
		 * infosSwitch[2] : nom du joueur avec qui le joueur qui joue veut �changer un de ses Props. 
		 * infosSwitch[3] : position de la carte que le joueur qui joue veut r�cup�rer chez le joueur avec qui il veut �changer son Prop. 
		*/
		Object[] infosSwitch = new Object[4];
		//On s'assure que le nom entr� pour choisir le joueur avec qui on veut faire l'�change est bien un nom qui existe. 
		while (OK == false) {
			this.joueur.get(j).setVariante(this.variante);
			infosSwitch = this.joueur.get(j).jouer();
			String nomJoueur = (String) infosSwitch[2];
				if (nomJ.contains(nomJoueur)==true) {
					OK = true;
				}
		}
		//Cette m�thode va g�rer l'�change particulier des Props entre les joueurs quand la variante choisie est 2. 
		if (this.variante == 2) {
			this.ajouterProps(infosSwitch);
		}
		//Cette m�thode va r�aliser l'�change des Props entre les joueurs. 
		else {
		this.switcherProps(infosSwitch);
		}
		//Si la partie n'est pas finie, on lance le tour suivant
		if (this.finPartie == false) {
		this.commencer();
		}
		//Si la partie est finie, on lance la phase qui correspond � la fin de partie. 
		else {
			this.gererFinDePartie();
		}
		}
	
	/**
	 * Permet de r�cup�rer le Trick Pile. 
	 * 
	 * @return le Trick Pile
	 */
	public ArrayList<Trick> getTrickP() {
		return trickP;
	}

	/**
	 * M�thode qui va se lancer dans le cas o� la variante choisie est 2. Ce cas est particulier car le joueur n'a qu'une seule carte dans sa main et il va faire une combinaison avec la carte d'un autre joueur choisi pr�alablement. Apr�s le tour, la carte est rendue au joueur. 
	 *
	 * @param infosSwitch
	 * 		Tableau avec les informations sur le nom des joueurs et la position des cartes choisies dans les mains des joueurs (0 dans ce cas).
	 *@see Jeu#gererActionsDeJeu(int)
	 *@see Jeu#testerTrick(int)
	 */
	public void ajouterProps(Object[] infosSwitch) {
		//On r�cup�re le nom des joueurs, le joueur qui joue et le joueur choisi. 
		String joueurActuel = (String) infosSwitch[0];
		String joueurEchange = (String) infosSwitch[2];
		this.joueurEchange = joueurEchange;
		//Variables pour chercher les positions du joueur qui joue et du joueur choisi. 
		int A = 0;
		int E = -1;
		//Dans le cas de la variante 2, les variables posPropJA et posPropJE sont toujours �gales � 0. 
		int posPropJA = (int) infosSwitch[1];
		int posPropJE = (int) infosSwitch[3];
		//On va chercher les positions du joueur qui joue et du joueur choisi.
		for (int j=0; j<this.nbredeJoueurs;j++) { 
			if (joueurActuel.equals(this.joueur.get(j).getNom())) {
				A = j;
			}
			if (joueurEchange.equals(this.joueur.get(j).getNom()) ) {
				E = j;
			}
		}
		//Si le joueur �change n'a pas �t� trouv�, cela veut dire que le joueur a choisi d'�changer sa carte avec le PropsCentre. Op�ration possible dans le cas o� la variante choisie est 2. 
		//On ajoute dans la main du joueur qui joue le prop s�lectionn�. Il a donc maintenant 2 cartes. 
		if (E== -1) {
			this.joueur.get(A).setCarteMain(this.prop.get(0));
		}
		
		else {
		this.joueur.get(A).setCarteMain(this.joueur.get(E).getMain().get(posPropJE));
		}
		System.out.println("==================");
		System.out.println(this.joueur.get(A).afficherMain());
		//On va pouvoir tester si le trick est r�ussi ou pas. 
		this.testerTrick(A);
		
	}
	
	/**
	 * M�thode qui va r�aliser le switch des Props entre les joueurs d�sign�s. 
	 * 
	 * @param infosSwitch
	 * 		Tableau avec les informations sur le nom des joueurs et la position des cartes choisies dans les mains des joueurs.
	 * @see Jeu#gererActionsDeJeu(int)
	 * @see Jeu#testerTrick(int)
	 */
	public void switcherProps(Object[] infosSwitch) {
		//On r�cup�re le nom des joueurs, le joueur qui joue et le joueur choisi. 
		String joueurActuel = (String) infosSwitch[0];
		String joueurEchange = (String) infosSwitch[2];
		this.joueurEchange = joueurEchange;
		//Variables pour chercher les positions du joueur qui joue et du joueur choisi. 
		int A = 0;
		int E = 0;
		//Les variables posPropJA et posPropJE indiquent des positions.  
		int posPropJA = (int) infosSwitch[1];
		int posPropJE = (int) infosSwitch[3];
		//On va chercher les positions du joueur qui joue et du joueur choisi.
		for (int j=0; j<this.nbredeJoueurs;j++) { 
			if (joueurActuel.equals(this.joueur.get(j).getNom())) {
				A = j;
			}
			if (joueurEchange.equals(this.joueur.get(j).getNom())) {
				E = j;
			}
		}
		//R�alisation du switch. Dans l'ordre, on ajoute dans les mains correspondantes, la carte choisie et la carte dont le joueur veut se d�barasser. Puis ensuite, on supprime, dans les mains correspondantes, la carte dont le joueur veut se d�barasser et la carte choisie. 
		this.joueur.get(E).setCarteMain(this.joueur.get(A).getMain().get(posPropJA));
		this.joueur.get(A).setCarteMain(this.joueur.get(E).getMain().get(posPropJE));
		this.joueur.get(E).removeCarteMain(posPropJE);
		this.joueur.get(A).removeCarteMain(posPropJA);
		System.out.println("==================");
		System.out.println(this.joueur.get(A).afficherMain());
		//On va pouvoir tester si le trick est r�ussi ou pas. 
		this.testerTrick(A);
	}
	
	/**
	 * M�thode qui va g�rer le cas o� le bool�en finDePartie est pass� � True. Cette m�thode va indiquer que le jeu est termin� et appeler d'autres m�thodes pour compter les points et afficher le classement. 
	 * 
	 * @see Jeu#afficherClassement()
	 * @see Jeu#compterPoints()
	 */
	public void gererFinDePartie() {
		this.compterPoints();
		System.out.println("Le jeu est termin�, le d�compte �galement.");
		System.out.println("Le classement est : ");
		this.afficherClassement();
		
	}
	
	/**
	 * M�thode qui va afficher le classement du premier au dernier gr�ce au calcul des points effectu� dans la m�thode compterPoints(). 
	 * 
	 * @see Joueur#toString2()
	 * @see Jeu#compterPoints()
	 */
	public void afficherClassement() {
		//On cr�e une liste de joueurs avec tous les joueurs pr�sents dans la partie et on va r�ordonner ensuite les joueurs en fonction de leur nombre de points. 
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		classement.addAll(this.joueur);
		//On cherche d'abord le joueur avec le plus petit nombre de points qui sera donc � la premi�re place quand on aura fini de trier tous les joueurs. 
		int place = this.nbredeJoueurs;
		int points = 4000;
		int permut = 0;
		int k = -1;
		//Bool�en qui permet d'indiquer quand tous les joueurs ont �t� positionn�s correctement � leur place en fonction de leurs points. 
		boolean permutOver = false;
		while ( permutOver == false) {
			points = 4000;
			//On cherche le joueur avec le petit nombre de points parmi tous les joueurs qui n'ont pas encore �t� class�s. 
			for (int i = 0; i < this.nbredeJoueurs-permut; i++) {
				if (classement.get(i).getPoint() <= points) {
					points = classement.get(i).getPoint();
					k = i;
				}
			}
			//Une fois ce joueur trouv�, on indique que le joueur a �t� trouv� en augmentant de un l'incr�ment permut. Ensuite, on copie ce joueur � la fin de la liste classement puis on le supprime de la liste classement � la position k.  
			permut++;
			classement.add(classement.get(k));
			classement.remove(k);
			//Une fois que permut a atteint le nombre de joueurs, cela veut dire qu'on a fini de classer les joueurs. 
			if (permut == this.nbredeJoueurs) {
				permutOver=true;
			}
		}
		//On affiche le classement des joueurs du premier au dernier avec leur nombre de points.  
		int clas = 1;
		for (int j=this.nbredeJoueurs-1; j>=0 ; j--) {
			System.out.println(clas + ". "+classement.get(j).toString2());
			System.out.println(classement.get(j).afficherMain());
			clas = clas + 1;
		}
	}
	
	/**
	 *M�thode qui permet de compter le nombre de points pour chaque joueur � la fin de la partie. Il faut noter que quand un joueur r�ussit un tour, il garde le tour qu'il a r�ussi avec lui. compterPoints() r�cup�re donc les tricks r�ussis par le joueur. 
	 *<P>
	 *Dans cette m�thode, on va �galement regarder si le tour "The Other Hat Trick" a �t� r�ussi. S'il n'a pas �t� fait, on affectera les malus sur les joueurs commme indiqu� dans les r�gles. 
	 */
	public void compterPoints() {
		boolean OK = false ;
		//On regarde si le tour "The Other Hat Trick" a �t� r�ussi ou pas. 
		if (this.trickP.size()!=0) {
		if (this.trickP.get(this.trickP.size()-1).getValeur()==9) {
			OK = true;
		}
		}
		else {
			this.finPartie=true;
		}
		//On r�cup�re les tricks r�ussis des joueurs pour ensuite ajouter le nombre de points correspondant � chaque trick r�ussi. 
		for (int j = 0; j < this.nbredeJoueurs; j++) {
			for (int i = 0; i <this.joueur.get(j).getTricksRealises().size();i++) {
				this.joueur.get(j).addPoint(this.joueur.get(j).getTricksRealises().get(i).getPointstricks());
			}
			//Si le tour "The Other Hat Trick" n'a pas �t� r�alis�, on cherche quels joueurs ont des Props n�cessaires � la combinaison dans leur main et on leur applique ensuite le malus de -3 points. 
			if (OK == true) {
				for (int k = 0; k < this.joueur.get(j).getMain().size(); k++) {
					if (this.joueur.get(j).getMain().get(k).getValeur() == 1 || this.joueur.get(j).getMain().get(k).getValeur() == 4) {
						this.joueur.get(j).addPoint(-3);
					}
				}
			}
		}
		
		
	}
	
	/**
	 * M�thode qui va parcourir la main du joueur en jeu mais �galement parcourir les props n�cessaires pour r�ussir le trick en jeu. Il va pouvoir d�terminer si le trick a �t� r�ussi ou pas. Si il est r�ussi, le trick sera ajout� dans joueur.TrickRealises. 
	 * 
	 * @see Joueur#melangerPropsCentre(ArrayList)
	 * @see Joueur#retournerCarte()
	 * 
	 * @param j
	 * 		Position du joueur en train de jouer. 
	 */
	public void testerTrick (int j) {
		//Indique quel trick le joueur a d�cid� de r�aliser durant le tour. Il a le choix entre la derni�re carte du Trick Pile et la premi�re carte du Trick Deck.  
		int i = this.joueur.get(j).getChoixTrick();
		//On r�cup�re les informations sur le trick choisi par le joueur. 
		Trick trickEnJeu = this.joueur.get(j).getTrickARealiser().get(i);
		//On cr�e une copie de la collection avec la main du joueur qu'on va pouvoir modifier sans changer la vraie main du joueur. 
		ArrayList<Prop> mainJoueur = new ArrayList<Prop>();
		mainJoueur.addAll(this.joueur.get(j).getMain());
		Iterator<Prop> itMain = mainJoueur.iterator();
		//On parcourt dans un premier temps toute la main du joueur pour savoir s'il poss�de des props de Prop1 pour r�aliser le trick en jeu. 
		boolean OK = false;
		while (itMain.hasNext() && OK == false) {
			//S'il poss�de un des props de Prop1 dans trickEnJeu, alors on supprime ce prop de la copie de la collection de sa main. 
			if (trickEnJeu.getProp1().contains(itMain.next())) {
				itMain.remove();
				OK = true;
			}
		}
		//On va faire la m�me chose mais pour Prop2.
		boolean OK2 = false;
		Iterator<Prop> itMain2 =  mainJoueur.iterator();
		if (OK == true) {
			while (itMain2.hasNext() && OK2 == false) {
				if (trickEnJeu.getProp2().contains(itMain2.next())) {
					OK2 = true;
				}
			}
		
		}
		//Si OK2 est �gale � True, cela veut dire le joueur poss�de des props de Prop1 et de Prop2. Par cons�quent, le tour est r�ussi. 
		if (OK2 == true) {
			System.out.println("==================");
			System.out.println("BRAVO, vous avez r�ussi !");
			System.out.println("==================");
			//On ajoute le tour r�ussi dans la liste des tricks r�ussis par le joueur et on supprime ce m�me trick du Trick Pile. 
			this.joueur.get(j).addTrickRealises(trickEnJeu);
			this.trickP.remove(this.trickP.size()-1);
			//On appelle la m�thode m�langerPropsCentre pour mettre � jour le jeu selon les r�gles. 
			this.prop = this.joueur.get(j).melangerPropsCentre(this.prop);

		}
		//Dans ce cas, le tour a �chou�. 
		else {
			//On g�re le cas o� la variante est �gale � 2. 
			this.gererVariante(j);
			System.out.println("==================");
			System.out.println("Vous avez �chou�");
			System.out.println("==================");
			//Si la partie n'est pas termin�e, alors le joueur doit retourner une de ses cartes. 
			if (this.finPartie == false) {
			this.joueur.get(j).retournerCarte();
			}
		}
	
	}
	/**
	 * Si la variante est �gale � 2, alors le joueur qui joue a une carte en trop dans sa main qui correspond � la carte qu'il a choisi pour r�aliser sa combinaison. Dans ce cas, on va aller supprimer cette carte. 

	 * @param j
	 * 	Position du joueur en jeu. 
	 */
	public void gererVariante(int j) {
		if (this.variante==2) {
			this.joueur.get(j).getMain().remove(1);
		}
	}
	
	/**
	 * Cette m�thode permet d'afficher l'�tat du plateau de jeu. Elle va indiquer les valeurs des props visibles parmi les joueurs avant que le joueur qui joue se d�cide � jouer. 
	 * 
	 *@see Jeu#gererActionsDeJeu(int)
	 */
	public void afficherPlateau() {
		//Affiche le nom des joueurs avec l'�tat de leur main. Le nom du prop sera affich� si celui-ci est visible. 
		for (int i = 0; i<this.nbredeJoueurs; i++) {
			System.out.println(this.joueur.get(i).getNom() + " :");
			for (int j = 0; j<this.joueur.get(i).getMain().size();j++) {
				this.joueur.get(i).getMain().get(j).afficherNom(j);
			}
		}
		//Dans le cas de la variante 2, le propCentre est affich� pour indiqu� au joueur qu'il peut choisir de combiner avec le propCentre s'il le souhaite. 
		if (this.variante == 2) {
			for (int k = 0; k<this.prop.size();k++) {
			System.out.println("PropsCentre :");
			this.prop.get(k).afficherNom(k);
			}
		}
	}
	
	/**
	 * M�thode qui permet de mettre � jour le Trick Deck et le Trick Pile en fonction du choix du joueur de soit faire le tour qu'on lui montre ou alors d'en d�couvrir un nouveau. 
	 * @param choix
	 * 		Bool�en qui indique si le joueur veut r�aliser le trick qu'on lui propose ou alors un nouveau tour.  
	 */
	public void piocherUneCarteTrick(boolean choix) {
		//Si on a choisi de faire un nouveau tour, alors le Trick Pile et le Trick Deck sont mis � jour. 
		if (choix == true) {
		this.trickP.add(this.trickD.get(0));
		this.trickD.remove(0);
		}
		//Si le Trick Deck est vide alors cela veut dire que l'on rentre dans le dernier tour de jeu car il ne reste plus que le trick "The Other Hat Trick". 
		if (trickD.size() == 0) {
			System.out.println("Ceci est le dernier tour !!!!!!");
			System.out.println("==================");
			this.finPartie = true;
			
		}
	}
	
	/**
	 * M�thode qui permet de s'assurer que l'on proposera bien deux tricks au joueur qui joue. Le dernier trick sur le Trick Pile et le premier trick sur le Trick Deck. 
	 * @return les deux tricks que le joueur peut au choix r�aliser. 
	 */
	public ArrayList<Trick> mettreAJourLaPile() {
		//Si le Trick Pile est vide, il faut, selon les r�gles, lui ajouter une carte de Trick Deck avant de commencer le tour. 
		if (this.trickP.isEmpty()==true) {
		this.trickP.add(this.trickD.get(0));
		this.trickD.remove(0);
		}
		//Dans la collection trickAFaire, on y ajoute les deux tricks que le joueur peut r�aliser. 
		ArrayList<Trick> trickAFaire = new ArrayList<Trick>();
		trickAFaire.add(this.trickP.get(this.trickP.size()-1));
		if (this.trickD.size()!=0){
		trickAFaire.add(this.trickD.get(0));
		}
		return trickAFaire;
		
	}
	

}
