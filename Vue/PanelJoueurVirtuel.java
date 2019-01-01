package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controler.Controler;
import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Modele.Jeu;

public abstract class PanelJoueurVirtuel extends JPanel implements Observer  {
	protected JoueurVirtuel joueurV;
	private Jeu jeu;
	private Controler controler;
	private JoueurVirtuel joueur;
	private JPanel prop1;
	private JPanel prop2;

	public PanelJoueurVirtuel(Jeu jeu, Controler controler, JoueurVirtuel joueur) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		this.joueur= joueur;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel prop1 = new JPanel();
		JPanel prop2 = new JPanel();
		
		 
		

	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
