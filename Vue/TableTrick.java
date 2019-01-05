package Vue;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controler.Controler;
import Modele.Jeu;


public class TableTrick extends JPanel {
	private Jeu jeu;
	private Controler controler;
	public TableTrick(Jeu jeu, Controler controler) {
		super();
		this.jeu = jeu;
		this.controler = controler;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}
		private void displayComponent() {
		JPanel tableTrick = new JPanel();
		tableTrick.setLayout(new BoxLayout(tableTrick, BoxLayout.X_AXIS));
		
		PanelTrick TrickP = new PanelTrick(this.jeu.mettreAJourLaPile().get(0), this.controler);
		
		
		PanelTrick TrickD = new PanelTrick(this.jeu.mettreAJourLaPile().get(1), this.controler);
		TrickD.faceDown();
		
		tableTrick.add(TrickP);
		tableTrick.add(TrickD);		
		
		this.add(tableTrick);
	
		}
}
