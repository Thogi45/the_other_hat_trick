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
	private PanelTrick TrickP;
	private PanelTrick TrickD;
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
		
			this.TrickP = new PanelTrick(this.jeu.mettreAJourLaPile().get(0), this.controler);

			this.TrickD = new PanelTrick(this.jeu.mettreAJourLaPile().get(1), this.controler);
			this.TrickD.faceDown();
			
		this.add(TrickP);
		//TrickP.setPreferredSize(new Dimension(60, 40));
		this.add(new JLabel(" Trick Pile " ));
		this.add(TrickD);	
		//TrickP.setPreferredSize(new Dimension(100, 40));
		this.add(new JLabel(" Trick Deck " ));
		
	
		}
		
		public PanelTrick getTrickP () {
			
			return this.TrickP;
		}
		
	/*	public PanelTrick repainTP() {
			/*this.TrickP.setUpdateTrickP(this.TrickP);
			this.validate();
			this.repaint();
			return this.TrickP;
			this.TrickP.removeAll();
			try {
				Thread.sleep(50);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				this.TrickP = new PanelTrick;
				this.TrickP.background = 
				
				
				
		}*/
		
		
		
}
