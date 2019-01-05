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
import javafx.scene.chart.Chart;
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
		public JFrame frame;
		private String niveau;
		private String nomJR;
		private Double ageJR;
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
						InfoJoueurReel frame= new InfoJoueurReel();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public  InfoJoueurReel() {this.setTitle("The Other Hat Trick");
		this.setLocationRelativeTo(null);
		this.setResizable(false); 
		this.setBounds(100, 100, 450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		
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
			
			container = new JPanel(new GridLayout(5, 1, 5, 5));
			
			container.add(new JLabel("Veuillez entrer le nom de joueur " ));
			container.add(nomField);
			container.add(new JLabel("Veuillez entrer ton age"));
			container.add(spAgeJoueur);
			container.add(new JLabel("Veuillez choisir ton vineau"));
			container.add(tempPanel);
			
							
			Ensuite = new JButton("Ensuite");
			Ensuite.setFont(new Font("Arial", Font.PLAIN, 14));
			//this.Ensuite.setBounds(84, 211, 99, 27);
			
			Ensuite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				
					
							if (facile.isSelected()) {
								niveau = "f";
							} else if (moyen.isSelected()) {
								niveau = "m";
							}
							else {
								niveau = "d";
							}				
						
					
					//creerJeu();		
					//this.setVisible(false);
					//Controller ctrl = new Controler(jeu);
					//MainGraphique fenetre = new MainGraphique(ctrl);
					
				}
				
				
			});
			
			Ensuite.setBounds(178, 293, 97, 25);
			
			container.add(Ensuite);
			this.setContentPane(container);
			this.pack();
			this.setVisible(true);}

			/*public void creerJeu() {
				
				Jeu jeu = new Jeu(nbrJ, nbrJR, nbrJV,  nomJR, ageJR,niveau);
				
				
			}*/
			
			
			
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
			
			public String getnomJR() {
				return this.nomField.getText();
			}
			
			public String getNiveau() {

				if (this.facile.isSelected()) {
					this.niveau = "f";
				} else if (this.moyen.isSelected()) {
					this.niveau = "m";
				}
				else {
					this.niveau = "d";
				}				
				return this.niveau;
			}
			public Double getageJR() {
				Double dAge = 0.0; 
				if (this.spAgeJoueur.getValue() instanceof Double) {
					dAge = (Double) this.spAgeJoueur.getValue();
				}
				return dAge;
			}
			
			public Jeu getJeu() {
				return this.jeu;
			}
			
	
			public void setCtrl(Jeu jeu) {}
			
			
			
			public void closeWindow() {
				this.frame.dispose();
			}
			
		}