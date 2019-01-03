import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe permettant de g�rer les joueurs virtuels du jeu. 
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class JoueurVirtuel extends Joueur {
    
	/**
	 * Attribut du type Strategie permettant de d�finir le niveau du joueur. 
	 */
    private Strategie S1;
    
    /**
     * Setter permettant d'envoyer l'�tat du jeu actuel au joueur virtuel et � la Strategie.$
     * 
     * @see JoueurVirtuel#setJeu1(Jeu)
     * @param jeu
     * 		L'�tat du jeu actuel. 
     */
    public void setJeu(Jeu jeu) {
    	S1.setJeu(jeu);
    	//On appelle la m�thode setJeu1() car on envoie le jeu qu'au joueur virtuel. 
    	this.setJeu1(jeu);
    }

	/**
	 * Ajouter une nouvelle carte dans la main du joueur. 
	 * 
	 * @param carteMain
	 * 		Carte � ajouter dans la main du joueur. 
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
	 * Le joueur r�cup�re tous les tricks qu'il peut r�aliser pendant le tour soit deux tricks possibles. Il en connait un, il choisit s'il veut le faire ou pas. 
	 * 
	 * @see Joueur#setTrickARealiser(ArrayList)
	 * @see Jeu#commencer()
	 * @see JoueurReel#setTrickARealiser(ArrayList)
	 * @see Moyen#choisirTrickIA(ArrayList, Joueur)
	 * @see Facile#choisirTrickIA(ArrayList, Joueur)
	 * @param trickARealiser
	 * 		Collection avec les deux tricks que le joueur peut r�aliser. 
	 * @return Choix du joueur de faire le trick qu'on lui montrer ou alors de d�couvrir l'autre trick. 
	 */
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		//On appelle la m�thode dans Joueur.
		super.setTrickARealiser(trickARealiser);
		boolean trickChoix = false;
		System.out.println("Le tour � r�aliser est : " + this.getTrickARealiser().get(0).toString());
		//Dans le cas o� tous les tours de magie sont r�ussis, il se peut que la taille de la collection des tricks possibles � r�aliser soit 1. 
		if (trickARealiser.size()!=1) {
		//On demande, en fonction du niveau de difficult�s, au joueur virtuel s'il veut r�aliser le tour qu'on lui montre. 
		this.setChoixTrick(S1.choisirTrickIA(trickARealiser, this));
		if (this.getChoixTrick()==0) {
			System.out.println("=====================");
			System.out.println("L'ordi a choisi de garder ce tour.");
			System.out.println("Le tour � r�aliser est donc ");
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
		//On indique en retour qu'elle a �t� le choix du joueur concernant les deux tricks qu'on lui propose. 
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
	 * Getter permettant de r�cup�rer la strat�gie. 
	 * @return La strat�gie.
	 */
	public Strategie getS1() {
		return S1;
	}

	/**
	 * Setter permettant de mettre en place la strat�gie.
	 * @param s1
	 * 		Strat�gie du joueur virtuel.
	 */
	public void setS1(Strategie s1) {
		S1 = s1;
	}

	/**
	 * M�thode permettant de choisir quels props on veut �changer et avec quel joueur. 
	 * 
	 * @return Tableau d'objets qui retourne le nom des joueurs pour l'�change et la position des cartes pour l'�change. 
	 */
	public Object[] jouer() {
		return S1.fairejouerIA(this);
	}

	/**
	 * M�thode permettant, lorsque l'on a r�ussi son tour, de choisir les nouveaux props que l'on veut dans sa main. 
	 * 
	 * @see Jeu#testerTrick(int)
	 * @see Jeu#ajouterProps(Object[])
	 * @see Moyen#melangerPropsCentreIA(ArrayList, int)
	 * @see Facile#melangerPropsCentreIA(ArrayList, int)
	 * 
	 * @param propCentre
	 * 		On r�cup�re la collection des props au centre. 
	 * @return les nouveaux props au centre. 
	 */
	public ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre) {
		//Si jamais la variante est celle o� on combine avec une seule carte dans sa main, alors on supprime la carte que l'on a en trop en d�marrant la m�thode. 
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
				//On appelle la m�thode dans S1 pour savoir quelle carte il d�cide de choisir parmi celles contenus dans la collection props.
				//La collection props contient tous les props du propCentre et de la main du joueur. 
				int pos = S1.melangerPropsCentreIA(props, k);
				//Si la position est correcte alors on ajoute la carte dans la main du joueur et on supprime la carte s�lectionn�e de la collection props.
				if (pos>=0 && pos <k1) {
					p++;
					this.setCarteMain(props.get(pos));
					props.remove(pos);
				}
				//Si la position n'est pas bonne, on indique qu'il y a un probl�me. 
				else {
					System.out.println("Problem");
				}
			}
			if (p == k) {
				OK = true;
			}
			else {
				//Si la position n'est pas bonne, on indique qu'il y a un probl�me.
				p=0;
				props.addAll(getMain());
				System.out.println("Vous avez fait une erreur, veuillez recommencer");
			}
		}
		return props;
		
	}

	/**
	 * M�thode permettant au joueur de retourner une carte de sa main quand il �choue lors de la r�alisation d'un Trick. 
	 */
	public void retournerCarte() {
		int j = 0;
		int pos = 0;
		boolean OK=false;
		//On regarde qu'elles sont les cartes d�j� retourn�es et on compte le nombre de cartes.
		for (int i = 0; i<this.getMain().size();i++) {
			if (this.getMain().get(i).getIsFaceUp()) {
				j=j+1;
			}
			else if (this.getMain().get(i).getIsFaceUp()== false) {
				pos = i;
			}
			
		}
		//Si il y a n-1 cartes retourn�es alors que le joueur a n cartes dans sa main alors on retourne la derni�re carte.
		if (j==(this.getMain().size()-1)) {
			this.getMain().get(pos).setIsFaceUp(true);
		}
		//Sinon on indique que toutes les cartes sont d�j� retourn�es. 
		else if (j == this.getMain().size()) {
			System.out.println("Les cartes sont d�j� retourn�es.");
		}
		else {
			//L'ordinateur va d�terminer quelle carte il doit retourner.
			while (OK == false) {
				System.out.println("L'ordi va choisir une carte � montrer ");
				//Il appelle une m�thode qui va tirer al�atoirement une carte � retourner. 
				int choixProp = S1.retournerCarteIA();
				System.out.println("==================");
				//On s'assure que la position choisie correspond bien a une carte qui est face cach�e. 
				if (this.getMain().get(choixProp).getIsFaceUp()==false) {
					this.getMain().get(choixProp).setIsFaceUp(true);
					OK = true;
				}
				else {
					System.out.println("L'ordi a choisi une carte d�j� retourn�e ou une position qui n'existe pas");
				}
		}
	}
		
	}


	}


