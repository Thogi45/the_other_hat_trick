import java.util.ArrayList;
/**
 * Interface permettant d'impl�menter les deux niveaux de jeu des joueurs virtuels. 
 * 
 * @see Moyen
 * @see Facile
 * @see JoueurVirtuel
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public interface Strategie {
	
	/**
	 * M�thode pour permettre au classe Moyen et Facile de r�cup�rer l'�tat du jeu. 
	 * @param jeuActuel
	 * 		Etat du jeu actuel. 
	 */
	public abstract void setJeu(Jeu jeuActuel);
	
	/**
	 * M�thode pour g�rer la phase de jeu du joueur virtuel. Cette m�thode correspond au moment o� le joueur virtuel choisit un nom de joueur et des positions des cartes des mains pour r�aliser l'�change. 
	 * 
	 * @see JoueurVirtuel#jouer()
	 * @see Joueur#jouer()
	 * @see Jeu#gererActionsDeJeu(int)
	 * @param joueurA
	 * 		On r�cup�re les informations sur le joueur en train de jouer. 
	 * @return Tableau d'objets qui retourne le nom des joueurs et la position des cartes pour l'�change. 
	 */
	public abstract Object[] fairejouerIA(Joueur joueurA);
	
	/**
	 * M�thode permettant de choisir quel trick le joueur virtuel va r�aliser durant son tour parmi les deux possibles. 
	 * 
	 * @see JoueurVirtuel#setTrickARealiser(ArrayList)
	 * @see Joueur#setTrickARealiser(ArrayList)
	 * @param tricksPossibles
	 * 		Collection avec les tricks possibles � r�aliser durant ce tour. 
	 * @param j1
	 * 		On r�cup�re les informations sur le joueur en train de jouer. 
	 * @return Un integer permettant d'indiquer le choix du joueur d'effectuer le tour qu'on lui propose ou pas. 
	 */
	public abstract int choisirTrickIA(ArrayList<Trick> tricksPossibles, Joueur j1);
	
	/**
	 * M�thode permettant au joueur virtuel de retourner une carte de sa main quand il �choue lors de la r�alisation d'un Trick.
	 * 
	 * @see Joueur#retournerCarte()
	 * @see JoueurVirtuel#retournerCarte()
	 * @return La position de la carte � retourner. 
	 */
	public abstract int retournerCarteIA();
	
	/**
	 * M�thode permettant de choisir les props que l'on veut garder quand on a r�ussit un tour de magie. 
	 * 
	 * @see Joueur#melangerPropsCentre(ArrayList)
	 * @see JoueurVirtuel#melangerPropsCentre(ArrayList)
	 * @param props
	 * 		Collection de props contenant les props de la main du joueur et les props situ�s au centre du plateau. 
	 * @param pos
	 * 		Taille de la collection props. 
	 * @return La position de la carte � retourner.
	 */
	public abstract int melangerPropsCentreIA(ArrayList<Prop> props, int pos);
	
}