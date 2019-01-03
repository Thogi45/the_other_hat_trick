import java.util.ArrayList;
/**
 * Classe qui impl�mente l'interface Strat�gie. Permet de d�finir les comp�tences du joueur virtuel facile.
 * 
 * @author Thomas Girerd et Thuy Tien Nguyen
 * @see Strategie
 * @see JoueurVirtuel
 *
 */
public class Facile implements Strategie {
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
	//On r�cup�re le nom du joueur actuel et ensuite, on va tirer al�atoirement les positions des cartes que l'on veut �changer ainsi que le nom du joueur avec qui on veut faire l'�change. 
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
	//On tire al�atoirement un nombre entier entre 0 et 1 pour savoir si le joueur veut r�aliser le tour qu'on lui montre ou un autre tour. 
	int k = (int) Math.round(Math.random());
	return k;

}

@Override
public int retournerCarteIA() {
	//On tire al�atoirement la position de la carte que l'on veut retourner.
	return (int) Math.round(Math.random()*(jeuActuel.getJoueur().get(0).getMain().size()-1));
}

public int melangerPropsCentreIA(ArrayList<Prop> props, int pos) {
	//On tire al�atoirement la position de la carte que l'on veut garder parmi les propsCentre. 
	int k = (int) Math.round(Math.random()*(props.size()-1));
	return k;
}







}

