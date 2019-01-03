import java.util.ArrayList;
/**
 * Classe qui implémente l'interface Stratégie. Permet de définir les compétences du joueur virtuel facile.
 * 
 * @author Thomas Girerd et Thuy Tien Nguyen
 * @see Strategie
 * @see JoueurVirtuel
 *
 */
public class Facile implements Strategie {
	/**
	 * Attribut pour enregistrer l'état du jeu actuel. 
	 */
	private Jeu jeuActuel;

	/**
	 * Méthode pour récupérer l'état du jeu actuel. 
	 */
	public void setJeu(Jeu jeuActuel) {
		this.jeuActuel = jeuActuel;
	}

	/**
	 * Méthode pour récupérer l'état du jeu actuel. 
	 * @return L'objet jeu actuel. 
	 */
	public Jeu getJeu() {
		return this.jeuActuel;
	}

@Override
public Object[] fairejouerIA(Joueur joueurA) {
	/*On crée un tableau d'objet qui va contenir les informations nécessaires pour le switch. 
	Création d'un tableau d'objets qui contiendra :
	 * valeurs[0] : nom du joueur qui joue.
	 * valeurs[1] : position de la carte du joueur qui joue dont il veut se débarasser. 
	 * valeurs[2] : nom du joueur avec qui le joueur qui joue veut échanger un de ses Props. 
	 * valeurs[3] : position de la carte que le joueur qui joue veut récupérer chez le joueur avec qui il veut échanger son Prop. 
	*/
	//On récupère le nom du joueur actuel et ensuite, on va tirer aléatoirement les positions des cartes que l'on veut échanger ainsi que le nom du joueur avec qui on veut faire l'échange. 
	Object[] valeurs; 
	valeurs = new Object[4];
	valeurs[0] = (String) joueurA.getNom();
	boolean OK = false;
	int k=-1;
	int posA = (int) Math.round(Math.random()*(joueurA.getMain().size()-1));
	valeurs[1] = (int) posA;
	while (OK == false) {
	k = (int) Math.round(Math.random()*(jeuActuel.getNbredeJoueurs()-1));
	if ((jeuActuel.getJoueur().get(k).getNom().equals(joueurA.getNom()))==false) {
		OK = true;
	}
	
	}
	valeurs[2] = (String) jeuActuel.getJoueur().get(k).getNom();
	int posB =(int) Math.round(Math.random());
	valeurs[3] = (int) posB;
	return valeurs;
}

@Override
public int choisirTrickIA(ArrayList<Trick> trickPossible, Joueur j1) {
	//On tire aléatoirement un nombre entier entre 0 et 1 pour savoir si le joueur veut réaliser le tour qu'on lui montre ou un autre tour. 
	int k = (int) Math.round(Math.random());
	return k;

}

@Override
public int retournerCarteIA() {
	//On tire aléatoirement la position de la carte que l'on veut retourner.
	return (int) Math.round(Math.random()*(jeuActuel.getJoueur().get(0).getMain().size()-1));
}

public int melangerPropsCentreIA(ArrayList<Prop> props, int pos) {
	//On tire aléatoirement la position de la carte que l'on veut garder parmi les propsCentre. 
	int k = (int) Math.round(Math.random()*(props.size()-1));
	return k;
}







}

