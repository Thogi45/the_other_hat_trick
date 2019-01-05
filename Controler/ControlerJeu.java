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
				
				final InfoJoueurReel infoJR = new InfoJoueurReel();
				infoJR.setnbrJ(fnV.getnbrJ());
				infoJR.setnbrJR(fnV.getnbrJR());

				fnV.closeWindow();
				
				infoJR.Ensuite.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					
						String niveau ="";
						
								if (infoJR.facile.isSelected()) {
									niveau = "f";
								} else if (infoJR.moyen.isSelected()) {
									niveau = "m";
								}
								else {
									niveau = "d";
								}				
							
						{
							String nomJR =infoJR.nomField.getText();
							int iNbJ = infoJR.getnbrJ();
							int nbrJR = infoJR.getnbrJR();
							int nbrJV = iNbJ-nbrJR;
							int iAge = (int) infoJR.spAgeJoueur.getValue();
							double ageJR =(double) iAge;
							
				Jeu jeu = Jeu.creerNouveauJeu( iNbJ, nbrJR, nbrJV, nomJR , ageJR , niveau);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Controler controlerJeu = new Controler(jeu);
				MainGraphique mainGraphique = new MainGraphique(controlerJeu);
				
				jeu.addObserver(mainGraphique);
				infoJR.dispose();
				
				jeu.start();
				
				};
				}
			});
			}		
						
			});
		
			
	}
}

	
