package Vue;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.server.Container;

import Controler.Controler;
import Modele.Jeu;


public class TableTrick extends JPanel {
	private Jeu jeu;
	private Controler controler;
	private PanelTrick TrickP;
	private PanelTrick TrickD;
	private JPanel container; 
	private JPanel tricklabel;
	public TableTrick(Jeu jeu, Controler controler) {
		//super();
		this.jeu = jeu;
		this.controler = controler;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}
		private void displayComponent() {
		//JPanel tableTrick = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		//tableTrick.setLayout(new BoxLayout(tableTrick, BoxLayout.X_AXIS));
			container  = new JPanel(); 
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			
			this.TrickP = new PanelTrick(this.jeu.mettreAJourLaPile().get(this.jeu.mettreAJourLaPile().size() - 2),this.controler);
			
			this.TrickD = new PanelTrick(this.jeu.mettreAJourLaPile().get(1), this.controler);
			
			this.TrickD.faceDown();
			Dimension carteDimension = new Dimension(300,135); 
			this.TrickP.setMinimumSize(carteDimension);
			this.TrickP.setMaximumSize(carteDimension);
			this.TrickD.setMinimumSize(carteDimension);
			this.TrickD.setMaximumSize(carteDimension);
			
			
			container.add(this.TrickP);
			container.add(new JLabel(" Trick Pile " ));
			container.add(this.TrickD);	
			container.add(new JLabel(" Trick Deck " ));
			this.add(container); 
	
		}
		
		public PanelTrick getTrickP () {
			return this.TrickP;
		}
		
	
		public void update() {
			
			this.removeAll();
			
			this.displayComponent();
			
		}
		
		
}
