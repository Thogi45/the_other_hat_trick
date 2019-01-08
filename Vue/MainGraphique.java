package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		private PanelJoueurVirtuel panelWest;
		private PanelJoueurVirtuel panelEast;
		private JPanel panelCenter;
		private PanelJoueurReel panelSouth;
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
			//String message;
			// TODO Auto-generated method stub
			if (arg instanceof String) {
			String message = (String) arg; 
			if (message == "FlipTrick") {
				int reponse = JOptionPane.showConfirmDialog(this.frame,"Voulez-vous réaliser ce tour ? (Oui ou Non)","Choisir Trick", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (reponse == JOptionPane.YES_OPTION) {
					//this.jeu.setBChoixtrick(true);
					this.controler.FlipTrick(); 
				}
				if (reponse == JOptionPane.NO_OPTION) {
					//this.jeu.setBChoixtrick(false);
					this.controler.NoFlipTrick();
				}
					
			}else if (message == "update TableTrick") {
				this.panelNorth.getTrickP().update();
				
			
			}else if (message == "ChoisirProp") {
				JOptionPane jOp = new JOptionPane();
				jOp.showMessageDialog(this.frame," Choissisez-vous 1 prop pour échanger", "Changer Props", JOptionPane.INFORMATION_MESSAGE);
				this.panelSouth.getProps()[0].addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//controler.setiropChoisi1(0); 
						jeu.setiPropChoisi1(0);
						jeu.continu();
					}
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {}

					@Override
					public void mouseReleased(MouseEvent e) {}
				});
				this.panelSouth.getProps()[1].addMouseListener(new MouseListener() {
						@Override
					public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							jeu.setiPropChoisi1(1);
							jeu.continu();
						}
						@Override
					public void mouseEntered(MouseEvent e) {}

						@Override
					public void mouseExited(MouseEvent e) {}

						@Override
					public void mousePressed(MouseEvent e) {}

						@Override
					public void mouseReleased(MouseEvent e) {}
				});		
					this.controler.getJeu().continu();
				
			}else if (message == "Choisir Adversaire") {
				JOptionPane jOp = new JOptionPane();
				jOp.showMessageDialog(this.frame," Choissisez-vous un autre prop de votre adversaire pour échanger", "Changer Props", JOptionPane.INFORMATION_MESSAGE);
				// joueur1 carte 0
				this.panelEast.getProps()[0].addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							jeu.setNomAdversaire("ordi 2");
							jeu.setiAdversaire(1);
							jeu.setiPropChoisi2(0);
							jeu.continu();
						}
						@Override
						public void mouseEntered(MouseEvent e) {}
						@Override
						public void mouseExited(MouseEvent e) {}
						@Override
						public void mousePressed(MouseEvent e) {}
						@Override
						public void mouseReleased(MouseEvent e) {}
				});
				//joueurV 1 carte 1
				this.panelEast.getProps()[1].addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						jeu.setNomAdversaire("ordi 2");
						jeu.setiAdversaire(1);
						jeu.setiPropChoisi2(1);
						jeu.continu();
					}
					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {}

					@Override
					public void mouseReleased(MouseEvent e) {}
			});
				// joueurV2 carte 0
				this.panelWest.getProps()[0].addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						jeu.setNomAdversaire("ordi 1");
						jeu.setiAdversaire(0);
						jeu.setiPropChoisi2(0);
						jeu.continu();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				
			});
				//joueurV 2 carte 1
				this.panelWest.getProps()[1].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						jeu.setNomAdversaire("ordi 1");
						jeu.setiAdversaire(0);
						jeu.setiPropChoisi2(1);
						jeu.continu();
					}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				
				
			});
				this.controler.getJeu().continu();
			
				
			
			}
			else if (message == "Update Cartes Prop"){
				System.out.println("dm in carte ra");
				this.panelSouth.getProps()[this.controler.getJeu().getiPropChoisi1()].UpdateTrickV();
				this.panelEast.getProps()[this.controler.getJeu().getiPropChoisi2()].UpdateTrickR();
				this.panelWest.getProps()[this.controler.getJeu().getiPropChoisi2()].UpdateTrickR();
		
				
				
				this.controler.getJeu().continu();
			}
			else if ( message == "Info Changer Cartes")
				if (this.controler.getJeu().getreussi() == true) {
					JOptionPane jOp = new JOptionPane();
					jOp.showMessageDialog(this.frame,"BRAVO! Vous avez réussi! Choissier la prop à changer avec le centre", "Info Changer Cartes", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					JOptionPane jOp = new JOptionPane();
					jOp.showMessageDialog(this.frame,"Vous avez échoué! Choissier la prop à montrer", "Info Changer Cartes", JOptionPane.INFORMATION_MESSAGE);
				}
				
				this.panelSouth.getProps()[0].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						jeu.setiPropFinTour(0);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				
				
			});
				this.panelSouth.getProps()[1].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						jeu.setiPropFinTour(1);
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				
				
			});
				//this.controler.getJeu().continu();
			
			
		} 
			
		}	
		}	


	

	

	
	

