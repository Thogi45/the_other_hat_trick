package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Modele.Jeu;

public class PanelJoueurReel extends JPanel implements Observer {

	private Jeu jeu;
	private Controler controler;
	private JoueurReel joueur;
	private JPanel prop1;
	private JPanel prop2;
	

	public PanelJoueurReel(Jeu jeu, Controler controler, JoueurReel joueur) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		this.joueur= joueur;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel prop1 = new JPanel();
		JPanel prop2 = new JPanel();

	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}