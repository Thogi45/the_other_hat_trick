package Vue;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Modele.Jeu;

public class PanelMainJeu  extends JPanel implements Observer {
	private InfoJoueurReel infoJR;
	private Controler ctrl;
	private PanelJoueurReel PanelJR;
	private PanelJoueurVirtuel PanelJV;
	private JPanel PanelFace;
	private JPanel PanelDroit;
	private JPanel PanelGauche;
	private Jeu jeu;
	private JoueurReel joueurR;
	private MainGraphique MainGraphique;
	private Integer i;
	
	public PanelMainJeu (Jeu jeu,JoueurReel joueurR) {
		this.jeu = jeu;
		this.ctrl = ctrl;
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
