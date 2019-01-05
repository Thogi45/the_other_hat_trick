package Vue;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controler.Controler;
import Carte.Trick;
import Carte.PropCentre;
import Modele.Jeu;

public class PanelPropCentre extends JPanel {
	private Jeu jeu;
	private Controler controler;

	public PanelPropCentre(Jeu jeu, Controler controler) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}
		private void displayComponent() {
		JPanel PropC = new JPanel();
		PropC.setLayout(new BoxLayout(PropC, BoxLayout.X_AXIS));
		
			PanelProp PnPropC = new PanelProp(this.jeu.getProp().get(0), this.controler);
			PropC.add(PnPropC);
			//PnPropC.faceUp();		
		
		this.add(PropC);	
	}
	
 
}
