package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controler.Controler;
import Modele.Jeu;
import Vue.FenetreVariant;
import Vue.InfoJoueurReel;
import Vue.MainGraphique;

public class ControlerJeu {
	
	public static void main(String[] args) {
		final FenetreVariant fnV = new FenetreVariant();
		
		fnV.btOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			final InfoJoueurReel infoR = new InfoJoueurReel();
			fnV.setVisible(false);
			
			
			infoR.Ensuite.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
						
						
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						Jeu jeu = infoR.getJeu();
						Controler controlerJeu = new Controler(jeu);
						MainGraphique mainGraphique = new MainGraphique(controlerJeu);
						jeu.addObserver(mainGraphique);
						infoR.closeWindow();
							
					}
					});		
			}
			});
		
			
	}
}

	
	/*
	 Ensuite.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			final Jeu jeu = new Jeu();
			nomJR = nomField.getText();
			ageJR = (int) spAgeJoueur.getValue();
			
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
						niveau = "f";
					} else if (moyen.isSelected()) {
						niveau ="m";
					}
					else {
						niveau = "d";	
					}				
				}		
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
			//creerJeu();
			frame1.setVisible(false);
			//MainGraphique fenetre = new MainGraphique(jeu, jeu.getJoueurR());
			Thread t = new Thread() {
				@Override
				public void run() {		
					jeu.jouerAvecVariantes(1);
					jeu.creerCartesdeBase();
					jeu.gererActionsDeJeu(jeu.commencer());
					
					
				}
			};
			t.start();
			
		}
		
		
	});
}*/
