package Vue;

import java.util.ArrayList;

import javax.swing.JPanel;

import Vue.Controler;
import Vue.Trick;
import Carte.PropCentre;;
import Modele.Jeu;

public class PanelPropCentre {
	private Jeu jeu;
	private Controler controler;
	private PropCentre propcentre;
	private JPanel prop1;
	
	public PanelPropCentre(Jeu jeu, Controler controler, ArrayList<Carte.Trick> arrayList) {
		this.controler = controler;
		
	}
 
}
