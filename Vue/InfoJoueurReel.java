package Vue;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import Joueur.Difficile;
import Joueur.Facile;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;
import Joueur.Moyen;
import Modele.Jeu;

public class InfoJoueurReel extends JFrame {
		private JFrame pricipalFrame;
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
		private int index;
	

		public InfoJoueurReel() {
			index = 1;
			pricipalFrame = new JFrame("Parametrage");
			container = new JPanel(new GridLayout(2, 4, 5, 5));
			
			
			
			
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
				container.add(new JLabel("Veuillez choisir ton vineau"));
				 container.add(tempPanel);
				
				container.add(new JLabel());
				// creer nouveau jeu
				
				final Jeu jeu = new Jeu();
				/*jeu.setNbredeJoueurs(nbrJ);
				jeu.setNbredeJoueursR(nbrJR);
				jeu.setNbredeJoueursV(nbrJV);*/
				final JButton Ensuite = new JButton("Ensuite");
				Ensuite.setFont(new Font("Arial", Font.PLAIN, 14));
				Ensuite.setBounds(84, 211, 99, 27);
				Ensuite.addActionListener(new ActionListener() {
					//private Integer nbrJ;

					public void actionPerformed(ActionEvent arg0) {
						nomJR = nomField.getText();
						ageJR = (int) spAgeJoueur.getValue();
						if (facile.isSelected()) {
							niveau = "f";
						} else if (moyen.isSelected()) {
							niveau ="m";
						}
						else {
							niveau = "d";				
						}				
						System.out.println(nomJR);
						System.out.println(ageJR);
						System.out.println(niveau);
						
						JoueurReel joueurR = new JoueurReel(ageJR,nomJR);
						jeu.getJoueurR().add(joueurR);
						
						if (index < nbrJR - 2) {
							index = index + 1;
							Lbnom.setText("Veuillez entrer le nom de joueur "+ index );
							nomField.setText("");
							spAgeJoueur.setValue(5);
							
							
						}
						else if (index == nbrJR - 2){
							try {
								if (facile.isSelected()) {
									for (int i = 1; i <= nbrJV; i++ ) {
									jeu.getJoueurV().add(new JoueurVirtuel(new Facile()));
									}
								} else if (moyen.isSelected()) {
									for (int i = 1; i <= nbrJV; i++ ) {
									jeu.getJoueurV().add(new JoueurVirtuel(new Moyen()));
									}
								}
								else {
									for (int i = 1; i <= nbrJV; i++ ) {
									jeu.getJoueurV().add(new JoueurVirtuel(new Difficile()));
								}
								}
							}
							
							catch (Exception e) {
								e.printStackTrace();
							}
						frame1.setVisible(false);
						MainGraphique frame = new MainGraphique();
						}
						
					}
					
					
				});
				container.add(Ensuite);

				pricipalFrame.setContentPane(container);
				pricipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pricipalFrame.pack();
				// frame.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
				this.frame1=pricipalFrame;
				this.frame1.setVisible(true);
				
				
			}

			public static void main(String[] args) {
				InfoJoueurReel view = new InfoJoueurReel();
				
			}
			
			public void setnomField(String nom) {
				this.nomField.setText(nom); 
			}
			
			public void setageJoueur(Integer age) {
				this.spAgeJoueur.setValue(age);
			}
			
			/*public JoueurReel  getJoueurReel() {
				
				JoueurReel joueurR = new JoueurReel(ageJR,nomJR);
				JoueurVirtuel joueurV = new JoueurVirtuel();
				
				return joueurR;
				
				
			}*/
			/*public Integer getageJR() {
				return ageJR;
			}
			
			public String getnomJR( ) {
				return nomJR;
			}
			*/
			public void setnbrJR(Integer nbrJR) {
				this.nbrJR = nbrJR;
			}
			public void setnbrJ(Integer nbrJ) {
				this.nbrJR = nbrJ;
			}
			public void setnbrJV(Integer nbrJV) {
				this.nbrJV = nbrJV;
			}

			public void closeWindow() {
				this.frame1.dispose();
			}
			
		}
		
		



