package Vue;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.displayComponent();
	}
		private void displayComponent() {
		//JPanel tableTrick = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		//tableTrick.setLayout(new BoxLayout(tableTrick, BoxLayout.X_AXIS));
		
			PanelTrick TrickP = new PanelTrick(this.jeu.mettreAJourLaPile().get(0), this.controler);
			

			PanelTrick TrickD = new PanelTrick(this.jeu.mettreAJourLaPile().get(1), this.controler);
			TrickD.faceDown();
			
		this.add(TrickP);
		//TrickP.setPreferredSize(new Dimension(60, 40));
		this.add(new JLabel(" Trick Pile " ));
		this.add(TrickD);	
		//TrickP.setPreferredSize(new Dimension(100, 40));
		this.add(new JLabel(" Trick Deck " ));
		
		//this.add(tableTrick);
	
		}
}
