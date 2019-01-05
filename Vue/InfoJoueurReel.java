package Vue;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;

import javax.swing.JTextField;

import Controler.Controler;
import Joueur.Difficile;
import Joueur.Facile;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Joueur.Moyen;
import Modele.Jeu;
import Modele.DemarrageJeu;

public class InfoJoueurReel extends JFrame {
		private JFrame principalFrame;
		private JPanel container;
		private JSpinner spAgeJoueur;
		private NumberEditor iAgeJoueur;
		private ButtonGroup buttonGroup;
		private JRadioButton facile;
		private JRadioButton moyen;
		private JRadioButton difficile;
		private JTextField nomField;
		public JButton Ensuite;
		public JFrame frame1;
		private String niveau;
		private String nomJR;
		private Integer ageJR;
		private Integer nbrJR;
		private Integer nbrJV;
		private Integer nbrJ;
		private Jeu jeu;
		private int index;
		private DemarrageJeu DemarrageJeu;
		private JoueurReel joueurR;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InfoJoueurReel frame1= new InfoJoueurReel();
						frame1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public void InfoJoueurReel() {
			index = 1;
			principalFrame = new JFrame("Parametrage");
			container = new JPanel(new GridLayout(2, 40, 500, 500));
			
			
			
			
			spAgeJoueur = new JSpinner();
			iAgeJoueur = new JSpinner.NumberEditor(spAgeJoueur);
			spAgeJoueur.setEditor(iAgeJoueur);
				// Définition des limites du spinner
			iAgeJoueur.getModel().setMinimum(5);
			iAgeJoueur.getModel().setMaximum(80);
			iAgeJoueur.getModel().setStepSize(1);
			iAgeJoueur.getModel().setValue(5);
			iAgeJoueur.getTextField().setEditable(true);


			
				buttonGroup = new ButtonGroup();
				facile = new JRadioButton("Facile");
				moyen = new JRadioButton("Moyen");
				difficile = new JRadioButton("Difficile");
				JPanel tempPanel = new JPanel();
				tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
				tempPanel.add(facile);
				tempPanel.add(moyen);
				tempPanel.add(difficile);

				// ajoute des boutons radio dans le groupe
				buttonGroup.add(facile);
				buttonGroup.add(moyen);
				buttonGroup.add(difficile);
				buttonGroup.setSelected(facile.getModel(), true);

				nomField = new JTextField("");
				
			
				final JLabel Lbnom = new JLabel("Veuillez entrer le nom de joueur "+ index );
				nomField.setText("");
				container.add(Lbnom);
				container.add(nomField);
				container.add(new JLabel("Veuillez entrer ton age"));
				container.add(spAgeJoueur);
<<<<<<< HEAD
				container.add(new JLabel("Veuillez choisir ton niveau"));
				 container.add(tempPanel);
=======
				container.add(new JLabel("Veuillez choisir ton vineau"));
				container.add(tempPanel);
>>>>>>> cdd44802b5a231e1eadc7fdf72f7860d16239cf7
				
				container.add(new JLabel());
				
				this.frame1=principalFrame;
				principalFrame.setContentPane(container);
				principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				principalFrame.pack();
				this.frame1.setVisible(true);
				
				final JButton Ensuite = new JButton("Ensuite");
				Ensuite.setFont(new Font("Arial", Font.PLAIN, 14));
				Ensuite.setBounds(84, 211, 99, 27);
				Ensuite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						nomJR = nomField.getText();
						ageJR = (int) spAgeJoueur.getValue();
						
						System.out.println(nomJR);
						System.out.println(ageJR);
						System.out.println(niveau);
						
						JoueurReel joueurR = new JoueurReel(ageJR,nomJR);
							
					/*	if (index < nbrJR - 2) {
							index = index + 1;
							Lbnom.setText("Veuillez entrer le nom de joueur "+ index );
							nomField.setText("");
							spAgeJoueur.setValue(5);				
						}
						
						else if (index == nbrJR - 2){
							
							try {*/
						
								if (facile.isSelected()) {
									niveau = "f";
								} else if (moyen.isSelected()) {
									niveau = "m";
								}
								else {
									niveau = "d";
								}				
							/*}		
							catch (Exception e) {
								e.printStackTrace();
							}
							
						}
						*/
						
						creerJeu();
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						frame1.setVisible(false);
						Controler ctrl = new Controler(jeu);
						MainGraphique fenetre = new MainGraphique(ctrl);
						
					}
					
					
				});
				
				container.add(Ensuite);

				
				// frame.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
				
				
				
			}

			public void creerJeu() {	
				
				final Jeu jeu = new Jeu();
				this.jeu.setNbredeJoueurs(this.nbrJ);
				this.jeu.setNbredeJoueursR(this.nbrJR);
				this.jeu.setNbredeJoueursV(this.nbrJV);
				
				this.jeu.getJoueurR().add(joueurR);						
				if (niveau == "f") {
					for (int i = 1; i < 2; i++ ) {
					jeu.getJoueurV().add(new JoueurVirtuel(new Facile()));
					}
				} else if (niveau == "m") {
					for (int i = 1; i < 2; i++ ) {
					jeu.getJoueurV().add(new JoueurVirtuel(new Moyen()));
					}
				}
				else {
					for (int i = 1; i < 2; i++ ) {
					jeu.getJoueurV().add(new JoueurVirtuel(new Difficile()));
				}	
				}
				
				for (int i = 0; i < 2; i++) {
					this.jeu.getJoueur().add(jeu.getJoueurV().get(i));
				}
				
					this.jeu.getJoueur().add(jeu.getJoueurR().get(0));
				
					this.setCtrl(this.jeu);

				// Commencer le jeu
				this.jeu.commencer();
				
			}
			
			
			
			public void setnomField(String nom) {
				this.nomField.setText(nom); 
			}
			
			public void setageJoueur(Integer age) {
				this.spAgeJoueur.setValue(age);
			}
			
		
			public void setnbrJR(Integer nbrJR) {
				this.nbrJR = nbrJR;
			}
			public void setnbrJ(Integer nbrJ) {
				this.nbrJ = nbrJ;
			}
			public void setnbrJV(Integer nbrJV) {
				this.nbrJV = nbrJV;
			}
			public Integer getnbrJR() {
				return this.nbrJR;
			}
			
			public Integer getnbrJ() {
				return this.nbrJ;
			}
			public Integer getnbrJV() {
				return this.nbrJV;
			}
			public Jeu getJeu() {
				return this.jeu;
			}
			
	
			public void setCtrl(Jeu jeu) {}
			
			
			
			public void closeWindow() {
				this.frame1.dispose();
			}
			
		}
		
		



