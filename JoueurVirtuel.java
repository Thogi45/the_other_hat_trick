import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe permettant de gérer les joueurs virtuels du jeu. 
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class JoueurVirtuel extends Joueur {
    
	/**
	 * Attribut du type Strategie permettant de définir le niveau du joueur. 
	 */
    private Strategie S1;
    
    /**
     * Setter permettant d'envoyer l'état du jeu actuel au joueur virtuel et à la Strategie.$
     * 
     * @see JoueurVirtuel#setJeu1(Jeu)
     * @param jeu
     * 		L'état du jeu actuel. 
     */
    public void setJeu(Jeu jeu) {
    	S1.setJeu(jeu);
    	//On appelle la méthode setJeu1() car on envoie le jeu qu'au joueur virtuel. 
    	this.setJeu1(jeu);
    }

	/**
	 * Ajouter une nouvelle carte dans la main du joueur. 
	 * 
	 * @param carteMain
	 * 		Carte à ajouter dans la main du joueur. 
	 */
	public void setCarteMain(Prop carteMain) {
		this.getMain().add(carteMain);
	}

	/**
	 * Constructeur du joueur virtuel. 
	 * @param s1
	 * 		Permet d'indiquer le niveau du joueur.
	 */
	public JoueurVirtuel(Strategie s1) {
		super();
		S1 = s1;
	}

	/**
	 * Le joueur récupère tous les tricks qu'il peut réaliser pendant le tour soit deux tricks possibles. Il en connait un, il choisit s'il veut le faire ou pas. 
	 * 
	 * @see Joueur#setTrickARealiser(ArrayList)
	 * @see Jeu#commencer()
	 * @see JoueurReel#setTrickARealiser(ArrayList)
	 * @see Moyen#choisirTrickIA(ArrayList, Joueur)
	 * @see Facile#choisirTrickIA(ArrayList, Joueur)
	 * @param trickARealiser
	 * 		Collection avec les deux tricks que le joueur peut réaliser. 
	 * @return Choix du joueur de faire le trick qu'on lui montrer ou alors de découvrir l'autre trick. 
	 */
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		//On appelle la méthode dans Joueur.
		super.setTrickARealiser(trickARealiser);
		boolean trickChoix = false;
		System.out.println("Le tour à réaliser est : " + this.getTrickARealiser().get(0).toString());
		//Dans le cas où tous les tours de magie sont réussis, il se peut que la taille de la collection des tricks possibles à réaliser soit 1. 
		if (trickARealiser.size()!=1) {
		//On demande, en fonction du niveau de difficultés, au joueur virtuel s'il veut réaliser le tour qu'on lui montre. 
		this.setChoixTrick(S1.choisirTrickIA(trickARealiser, this));
		if (this.getChoixTrick()==0) {
			System.out.println("=====================");
			System.out.println("L'ordi a choisi de garder ce tour.");
			System.out.println("Le tour à réaliser est donc ");
			System.out.println(this.getTrickARealiser().get(0).toString());
			trickChoix = false;
		}
		else {
			System.out.println("=====================");
			System.out.println("L'ordi a choisi de faire un nouveau tour");
			System.out.println("Le nouveau tour est donc :");
			System.out.println(this.getTrickARealiser().get(1).toString());
			this.setChoixTrick(1);
			trickChoix = true;
		}
		}
		else {
			trickChoix = false;
		}
		//On indique en retour qu'elle a été le choix du joueur concernant les deux tricks qu'on lui propose. 
		System.out.println("=====================");
		return trickChoix;
	}
	
	/**
	 * Constructeur du joueur virtuel. 
	 */
	public JoueurVirtuel() {
		super();
	}
	
	/**
	 * Getter permettant de récupérer la stratégie. 
	 * @return La stratégie.
	 */
	public Strategie getS1() {
		return S1;
	}

	/**
	 * Setter permettant de mettre en place la stratégie.
	 * @param s1
	 * 		Stratégie du joueur virtuel.
	 */
	public void setS1(Strategie s1) {
		S1 = s1;
	}

	/**
	 * Méthode permettant de choisir quels props on veut échanger et avec quel joueur. 
	 * 
	 * @return Tableau d'objets qui retourne le nom des joueurs pour l'échange et la position des cartes pour l'échange. 
	 */
	public Object[] jouer() {
		return S1.fairejouerIA(this);
	}

	/**
	 * Méthode permettant, lorsque l'on a réussi son tour, de choisir les nouveaux props que l'on veut dans sa main. 
	 * 
	 * @see Jeu#testerTrick(int)
	 * @see Jeu#ajouterProps(Object[])
	 * @see Moyen#melangerPropsCentreIA(ArrayList, int)
	 * @see Facile#melangerPropsCentreIA(ArrayList, int)
	 * 
	 * @param propCentre
	 * 		On récupère la collection des props au centre. 
	 * @return les nouveaux props au centre. 
	 */
	public ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre) {
		//Si jamais la variante est celle où on combine avec une seule carte dans sa main, alors on supprime la carte que l'on a en trop en démarrant la méthode. 
		if (this.getJeu().getVariante()==2) {
			this.removeCarteMain(1);
		}
		//On place dans une collection de props toutes les cartes dans la main du joueur et celles dans le prop centre et on les retourne toutes face down.
		int k = this.getMain().size();
		ArrayList<Prop> props = propCentre;
		boolean OK = false;
		for (int i = 0; i<this.getMain().size(); i++) {
			this.getMain().get(i).setIsFaceUp(false);
		}
		props.addAll(getMain());
		int k1 = props.size();
		int p=0;
		//On va demander au joueur virtuel de choisir les props qu'il veut garder dans sa main parmi ceux qu'on lui propose.
		while (OK ==false) {
			//On supprime les cartes de sa main.
			this.supprimerMain();
			for (int j=1;j<=k;j++) {
				//On appelle la méthode dans S1 pour savoir quelle carte il décide de choisir parmi celles contenus dans la collection props.
				//La collection props contient tous les props du propCentre et de la main du joueur. 
				int pos = S1.melangerPropsCentreIA(props, k);
				//Si la position est correcte alors on ajoute la carte dans la main du joueur et on supprime la carte sélectionnée de la collection props.
				if (pos>=0 && pos <k1) {
					p++;
					this.setCarteMain(props.get(pos));
					props.remove(pos);
				}
				//Si la position n'est pas bonne, on indique qu'il y a un problème. 
				else {
					System.out.println("Problem");
				}
			}
			if (p == k) {
				OK = true;
			}
			else {
				//Si la position n'est pas bonne, on indique qu'il y a un problème.
				p=0;
				props.addAll(getMain());
				System.out.println("Vous avez fait une erreur, veuillez recommencer");
			}
		}
		return props;
		
	}

	/**
	 * Méthode permettant au joueur de retourner une carte de sa main quand il échoue lors de la réalisation d'un Trick. 
	 */
	public void retournerCarte() {
		int j = 0;
		int pos = 0;
		boolean OK=false;
		//On regarde qu'elles sont les cartes déjà retournées et on compte le nombre de cartes.
		for (int i = 0; i<this.getMain().size();i++) {
			if (this.getMain().get(i).getIsFaceUp()) {
				j=j+1;
			}
			else if (this.getMain().get(i).getIsFaceUp()== false) {
				pos = i;
			}
			
		}
		//Si il y a n-1 cartes retournées alors que le joueur a n cartes dans sa main alors on retourne la dernière carte.
		if (j==(this.getMain().size()-1)) {
			this.getMain().get(pos).setIsFaceUp(true);
		}
		//Sinon on indique que toutes les cartes sont déjà retournées. 
		else if (j == this.getMain().size()) {
			System.out.println("Les cartes sont déjà retournées.");
		}
		else {
			//L'ordinateur va déterminer quelle carte il doit retourner.
			while (OK == false) {
				System.out.println("L'ordi va choisir une carte à montrer ");
				//Il appelle une méthode qui va tirer aléatoirement une carte à retourner. 
				int choixProp = S1.retournerCarteIA();
				System.out.println("==================");
				//On s'assure que la position choisie correspond bien a une carte qui est face cachée. 
				if (this.getMain().get(choixProp).getIsFaceUp()==false) {
					this.getMain().get(choixProp).setIsFaceUp(true);
					OK = true;
				}
				else {
					System.out.println("L'ordi a choisi une carte déjà retournée ou une position qui n'existe pas");
				}
		}
	}
		
	}


	}


