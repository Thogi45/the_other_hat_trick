package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controler.Controler;
import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Modele.Jeu;

public class PanelJoueurVirtuel extends JPanel implements Observer  {
	
	private Jeu jeu;
	private Controler controler;
	private JoueurVirtuel joueurV;
	private PanelProp[] props=new PanelProp[2];

	public PanelJoueurVirtuel(Jeu jeu, Controler controler, JoueurVirtuel joueurV) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		this.joueurV= joueurV;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}

	private void displayComponent() {
		JPanel infoJoueur = new JPanel();
		infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.X_AXIS));
		JLabel nameBox = new JLabel("Name: " + this.joueurV.getNom());
		nameBox.setSize(100, 25);
		infoJoueur.add(nameBox);
		
		JLabel pointBox = new JLabel("Point: " + this.joueurV.getPoint());
		pointBox.setSize(100, 25);
		infoJoueur.add(pointBox);
		this.add(infoJoueur);
		
		JPanel listProp = new JPanel();
		infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.X_AXIS));
		for (int i=0;i<2;i++) {
			this.props[i] = new PanelProp(this.joueurV.getMain().get(i),this.joueurV.getMain().get(i).getIsFaceUp(), this.controler);
			listProp.add(this.props[i]);
			//carteProp.faceUp();		
		}
		this.add(listProp);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
