import java.util.ArrayList;

public interface Strategie {
	
	
	public abstract void setJeu(Jeu jeuActuel);
	public abstract Object[] fairejouerIA(Joueur joueurA);
	public abstract int choisirTrickIA(ArrayList<Trick> tricksPossibles, Joueur j1);
	public abstract int retournerCarteIA();
	public abstract int melangerPropsCentreIA(ArrayList<Prop> props, int pos);
	
}