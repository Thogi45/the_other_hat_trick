package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Modele.Jeu;

public class PanelJoueurReel extends JPanel implements Observer {
	
	private Jeu jeu;
	private Controler controler;
	private JoueurReel joueurR;

	public PanelJoueurReel(Jeu jeu, Controler controler, JoueurReel joueurR) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		this.joueurR= joueurR;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}

	private void displayComponent() {
		JPanel infoJoueur = new JPanel();
		infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.X_AXIS));
		JLabel nameBox = new JLabel("Name: " + this.joueurR.getNom());
		nameBox.setSize(100, 25);
		infoJoueur.add(nameBox);
		
		JLabel pointBox = new JLabel("Point: " + this.joueurR.getPoint());
		pointBox.setSize(100, 25);
		infoJoueur.add(pointBox);
		this.add(infoJoueur);
		
		JPanel listProp = new JPanel();
		infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.X_AXIS));
		for (int i=0;i<2;i++) {
			PanelProp carteProp = new PanelProp(this.joueurR.getMain().get(i), this.controler);
			listProp.add(carteProp);
			carteProp.faceUp();		
		}
		this.add(listProp);		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}