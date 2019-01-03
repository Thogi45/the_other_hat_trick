import java.util.ArrayList;
/**
 * Interface permettant d'implémenter les deux niveaux de jeu des joueurs virtuels. 
 * 
 * @see Moyen
 * @see Facile
 * @see JoueurVirtuel
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public interface Strategie {
	
	/**
	 * Méthode pour permettre au classe Moyen et Facile de récupérer l'état du jeu. 
	 * @param jeuActuel
	 * 		Etat du jeu actuel. 
	 */
	public abstract void setJeu(Jeu jeuActuel);
	
	/**
	 * Méthode pour gérer la phase de jeu du joueur virtuel. Cette méthode correspond au moment où le joueur virtuel choisit un nom de joueur et des positions des cartes des mains pour réaliser l'échange. 
	 * 
	 * @see JoueurVirtuel#jouer()
	 * @see Joueur#jouer()
	 * @see Jeu#gererActionsDeJeu(int)
	 * @param joueurA
	 * 		On récupère les informations sur le joueur en train de jouer. 
	 * @return Tableau d'objets qui retourne le nom des joueurs et la position des cartes pour l'échange. 
	 */
	public abstract Object[] fairejouerIA(Joueur joueurA);
	
	/**
	 * Méthode permettant de choisir quel trick le joueur virtuel va réaliser durant son tour parmi les deux possibles. 
	 * 
	 * @see JoueurVirtuel#setTrickARealiser(ArrayList)
	 * @see Joueur#setTrickARealiser(ArrayList)
	 * @param tricksPossibles
	 * 		Collection avec les tricks possibles à réaliser durant ce tour. 
	 * @param j1
	 * 		On récupère les informations sur le joueur en train de jouer. 
	 * @return Un integer permettant d'indiquer le choix du joueur d'effectuer le tour qu'on lui propose ou pas. 
	 */
	public abstract int choisirTrickIA(ArrayList<Trick> tricksPossibles, Joueur j1);
	
	/**
	 * Méthode permettant au joueur virtuel de retourner une carte de sa main quand il échoue lors de la réalisation d'un Trick.
	 * 
	 * @see Joueur#retournerCarte()
	 * @see JoueurVirtuel#retournerCarte()
	 * @return La position de la carte à retourner. 
	 */
	public abstract int retournerCarteIA();
	
	/**
	 * Méthode permettant de choisir les props que l'on veut garder quand on a réussit un tour de magie. 
	 * 
	 * @see Joueur#melangerPropsCentre(ArrayList)
	 * @see JoueurVirtuel#melangerPropsCentre(ArrayList)
	 * @param props
	 * 		Collection de props contenant les props de la main du joueur et les props situés au centre du plateau. 
	 * @param pos
	 * 		Taille de la collection props. 
	 * @return La position de la carte à retourner.
	 */
	public abstract int melangerPropsCentreIA(ArrayList<Prop> props, int pos);
	
}