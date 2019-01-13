package Joueur;
import java.util.ArrayList;
import java.util.Iterator;


import Carte.Prop;
import Carte.Trick;
import Modele.Jeu;


import java.util.Random;
/**
 * Classe qui impl�mente l'interface Strat�gie. Permet de d�finir les comp�tences du joueur virtuel moyen.
 * 
 * @author Thomas Girerd et Thuy Tien Nguyen
 * @see Strategie
 * @see JoueurVirtuel
 *
 */
public class Moyen implements Strategie {
	/**
	 * Attribut pour enregistrer l'�tat du jeu actuel. 
	 */
	private Jeu jeuActuel;

	/**
	 * M�thode pour r�cup�rer l'�tat du jeu actuel. 
	 */
	public void setJeu(Jeu jeuActuel) {
		this.jeuActuel = jeuActuel;
	}

	/**
	 * M�thode pour r�cup�rer l'�tat du jeu actuel. 
	 * @return L'objet jeu actuel. 
	 */
	public Jeu getJeu() {
		return this.jeuActuel;
	}

	@Override
	public Object[] fairejouerIA(Joueur joueurA) {
		/*On cr�e un tableau d'objet qui va contenir les informations n�cessaires pour le switch. 
		Cr�ation d'un tableau d'objets qui contiendra :
		 * valeurs[0] : nom du joueur qui joue.
		 * valeurs[1] : position de la carte du joueur qui joue dont il veut se d�barasser. 
		 * valeurs[2] : nom du joueur avec qui le joueur qui joue veut �changer un de ses Props. 
		 * valeurs[3] : position de la carte que le joueur qui joue veut r�cup�rer chez le joueur avec qui il veut �changer son Prop. 
		*/
		Object[] valeurs; 
		valeurs = new Object[4];
		valeurs[0] = (String) joueurA.getNom();
		boolean OK = false;
		int pos = -1;
		//Le joueur moyen va regarder quel est le trick en jeu et les props possibles pour ce trick. 
		Trick trickEnJeu = this.jeuActuel.getTrickP().get(jeuActuel.getTrickP().size()-1);
		ArrayList<Prop> propsPossibles = new ArrayList<Prop>();
		propsPossibles.addAll(trickEnJeu.getProp1());
		propsPossibles.addAll(trickEnJeu.getProp2());
		//Il va ensuite regarder si dans sa main, il poss�de des props possibles pour r�aliser le trick. 
		for (int i = 0; i<joueurA.getMain().size();i++) {
			//Il cherche un prop de sa main qui n'est pas n�cessaire pour r�ussir le trick.
			if (propsPossibles.contains(joueurA.getMain().get(i))==false) {
				pos = i;
			}
		}
		
		int posA = -1;
		//Si dans sa main, il ne contient que des props possibles pour r�aliser le trick, il tire au hasard un prop dont il veut se d�barasser. 
		if (pos == -1) {
			posA = (int) Math.round(Math.random()*(joueurA.getMain().size()-1));
		}
		else {
		//Sinon, il choisit un prop qui n'est pas dans la liste des props pour r�aliser le trick. 
			posA = pos;
		}
		//On entre la position dans le tableau pour le switch.
		valeurs[1] = (int) posA;
		//Maintenant, on va chercher des props qui pourraient permettre de r�aliser le trick. 
		//On cherche donc parmi les props visibles si des props peuvent permettre de r�aliser le trick.
		//Si oui, alors on s�lectionne le dernier prop que l'on a trouv� qui permet de r�aliser le trick. 
		for (int j = 0; j<this.jeuActuel.getNbredeJoueurs();j++) {
			//Permet de ne pas s'int�resser aux props du joueur qui joue. 
			if (this.jeuActuel.getJoueur().get(j).getNom().equals(joueurA.getNom())==false) {
				for (int l = 0; l <this.jeuActuel.getJoueur().get(j).getMain().size();l++) {
					if (this.jeuActuel.getJoueur().get(j).getMain().get(l).getIsFaceUp()==true) {
						//Si on trouve un prop qui nous int�resse, on remplit le tableau valeurs. 
						if (propsPossibles.contains(this.jeuActuel.getJoueur().get(j).getMain().get(l))) {
						valeurs[2] = (String) this.jeuActuel.getJoueur().get(j).getNom();
						valeurs[3] = (int) l;
						}
					}
				}
			}
		}
		int k=-1;
		//Si on voit que le tableau valeurs n'a pas �t� rempli car on n'a trouv� de props int�ressants par ceux visibles sur le plateau alors on le remplit al�atoirement. 
		if (valeurs[2]==null) {
			boolean OK1 = false;
			while (OK1 == false) {
				k = (int) Math.round(Math.random()*(jeuActuel.getNbredeJoueurs()-1));
				if ((jeuActuel.getJoueur().get(k).getNom().equals(joueurA.getNom()))==false) {
					OK1 = true;
				}
				
				}
				valeurs[2] = (String) jeuActuel.getJoueur().get(k).getNom();
				Random rand = new Random();
				int posB = rand.nextInt(joueurA.getMain().size()-1-0+1)+0;
				valeurs[3] = (int) posB;
		}
		
		return valeurs;
	}

	@Override
	public int choisirTrickIA(ArrayList<Trick> tricksPossibles, Joueur j1) {
		//Le joueur moyen cherche � d�terminer si il veut r�aliser le tour qu'on lui propose. 
		int choix = 0;
		Trick trickPile = tricksPossibles.get(0);
		//On cr�e une collection avec le contenu de la main du joueur. 
		ArrayList<Prop> mainJoueur = new ArrayList<Prop>();
		mainJoueur.addAll(j1.getMain());
		int p1 = 0;
		int p2 = 0;
		Iterator<Prop> itMain = mainJoueur.iterator();
		boolean OK = false;
		//Notre it�rateur va parcourir la main du joueur et voir s'il ne trouve pas des props qui concordent avec les props possibles pour r�aliser le tour. 
		while (itMain.hasNext() && OK == false) {
			//Si on trouve des trucs props qui co�ncident parmi prop1, alors on incr�mente p1
			Prop ptest = itMain.next();
			if (trickPile.getProp1().contains(ptest)) {
				p1 = p1 + 1 ;
				//Si on en a plus de 2, p1 retourne � z�ro car on pourra toujours r�aliser le tour en se d�barassant d'un des 3 props. 
				if (p1 > 2) {
					p1 = 0;
				}
			}
			//Si on trouve des trucs props qui co�ncident parmi prop2, alors on incr�mente p2
			if (trickPile.getProp2().contains(ptest)) {
				p2 = p2 + 1;
				//Si on en a plus de 2, p2 retourne � z�ro car on pourra toujours r�aliser le tour en se d�barassant d'un des 3 props. 
				if (p2 > 2) {
					p2 = 0;
				}
			}
		}
		int somme = p2 + p1;
		//On d�termine le choix du joueur moyen en fonction du nombre de prop1 et de prop2 qu'il a dans sa main et du nombre de cartes total que le joueur a dans sa main. 
		//S'il choisit 0 alors le joueur garde le trick qu'on lui propose mais s'il choisit 1, alors il choisit de d�couvrir le nouveau tour. 
		if (somme  == 2) {
			if (j1.getMain().size() <= 2) {
			choix = 1;
			}
			else {
			choix = 0;
			}	
		}
		else if (somme == 1) {
			choix = 0;
		}
		else if (somme == 0) {
			choix = 1;
		}
		else {
			choix = 0;
		}
 		return choix;
	}

	@Override
	public int retournerCarteIA() {
		//On tire al�atoirement une position pour retourner les cartes. 
		return (int) Math.round(Math.random()*(jeuActuel.getJoueur().get(0).getMain().size()-1));
	}

	@Override
	public int melangerPropsCentreIA(ArrayList<Prop> props, int pos) {
		//On tire al�atoirement une position pour garder les props que l'on veut parmi les props centre. 
		int k = (int) Math.round(Math.random()*(props.size()-1));
		return k;
	}

}