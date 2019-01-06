package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Controler.Controler;
import Modele.Jeu;

import Joueur.JoueurReel;


public class MainGraphique implements Observer {

		private Jeu jeu;
		private JoueurReel JoueurReel;
		private Controler controler;
		private JFrame frame;
		private TableTrick panelNorth;
		private JPanel panelWest;
		private JPanel panelEast;
		private JPanel panelCenter;
		private JPanel panelSouth;
		private PanelJoueurVirtuel panelLeft;
		

		public MainGraphique(Controler ctrl) {
			//System.out.println("show graphique");
			this.controler = ctrl;
			this.jeu = this.controler.getJeu();
			/*match.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			this.initialize();
		}

		private void initialize() {
			frame = new JFrame("HatTrick");
			frame.setBounds(0, 0, 1240, 800);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//	frame.setBackground(new Color(0, 100, 0));
			frame.getContentPane().setLayout(new BorderLayout());

			
			panelNorth = new TableTrick(this.jeu, this.controler);
			TitledBorder borderTop = new TitledBorder("Center Game");
			borderTop.setTitleJustification(TitledBorder.CENTER);
			borderTop.setTitlePosition(TitledBorder.TOP);
			panelNorth.setBorder(borderTop);
			panelNorth.setPreferredSize(new Dimension(1220, 180));
			frame.add(panelNorth,BorderLayout.PAGE_START);


			panelWest = new PanelJoueurVirtuel(this.jeu, this.controler,this.jeu.getJoueurV().get(0));
			TitledBorder borderWest = new TitledBorder("Player 1");
			borderWest.setTitleJustification(TitledBorder.CENTER);
			borderWest.setTitlePosition(TitledBorder.TOP);
			panelWest.setBorder(borderWest);
			panelWest.setPreferredSize(new Dimension(300, 200));
			frame.add(panelWest,BorderLayout.LINE_START);
			
			
			
			panelEast = new PanelJoueurVirtuel(this.jeu, this.controler,this.jeu.getJoueurV().get(1));
			TitledBorder borderEast = new TitledBorder("Player 2");
			borderEast.setTitleJustification(TitledBorder.CENTER);
			borderEast.setTitlePosition(TitledBorder.TOP);
			panelEast.setBorder(borderEast);
			panelEast.setPreferredSize(new Dimension(400, 400));
			frame.add(panelEast,BorderLayout.LINE_END);
			
			
			
			panelSouth = new PanelJoueurReel(this.jeu,this.controler,this.jeu.getJoueurR().get(0));
			TitledBorder borderBottom = new TitledBorder("JoueurReel");
			borderBottom.setTitleJustification(TitledBorder.CENTER);
			borderBottom.setTitlePosition(TitledBorder.TOP);
			panelSouth.setBorder(borderBottom);
			panelSouth.setPreferredSize(new Dimension(1220, 180));
			frame.add(panelSouth,BorderLayout.PAGE_END);
			

			panelCenter = new PanelPropCentre(this.jeu, this.controler);
			TitledBorder borderCenter = new TitledBorder("The 7th Prop");
			borderCenter.setTitleJustification(TitledBorder.CENTER);
			borderCenter.setTitlePosition(TitledBorder.TOP);
			panelCenter.setBorder(borderCenter);
			panelCenter.setPreferredSize(new Dimension(300, 200));
			frame.add(panelCenter,BorderLayout.CENTER);
			
			frame.setVisible(true);
			
		}

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			String message = (String) arg; 
			if (message == "FlipTrick") {
				int reponse = JOptionPane.showConfirmDialog(this.frame,"Voulez-vous réaliser ce tour ? (Oui ou Non)","Choisir Trick", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				System.out.println(reponse);
				if (reponse == JOptionPane.YES_OPTION) {
					this.jeu.setBChoixtrick(true);
					
				}
				if (reponse == JOptionPane.NO_OPTION) {
					this.jeu.setBChoixtrick(false);
					
				}
				
				}
			else if (message == "Change the TrickPile") {
				System.out.println(this.controler.getJeu().mettreAJourLaPile().get(1).getNomtrick());
				System.out.println("ready to repain");
				this.panelNorth.getTrickP().UpdateTrickP();
				
				System.out.println("repained");
				try {
					Thread.sleep(200);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
			else if (message == "ChooseProp") {
				JOptionPane jOp = new JOptionPane();
				jOp.showConfirmDialog(this.frame," Quel prop voulez-vous échanger ?", "Changer Props", JOptionPane.INFORMATION_MESSAGE);
				
			}
			}
			
		}
		
		


	

	

	
	

