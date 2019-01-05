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
			
			
			public void actionPerformed(ActionEvent e) {
				final InfoJoueurReel infoJR = new InfoJoueurReel();
				infoJR.setnbrJR(fnV.getnbrJR());
				infoJR.setnbrJV(fnV.getnbrJ()-fnV.getnbrJR());
				infoJR.setnbrJ(fnV.getnbrJ());
				fnV.closeWindow();
				
					infoJR.Ensuite.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						   
							/*int nbrJ = infoJR.getnbrJ();
							int nbrJR = infoJR.getnbrJR();
							int nbrJV = infoJR.getnbrJV();
							String nomJR = infoJR.getnomJR();
							Double ageJR = infoJR.getageJR();
							String niveau = infoJR.getNiveau();*/
				System.out.println(infoJR.getnbrJ());	
				Jeu jeu = new Jeu( infoJR.getnbrJ(), infoJR.getnbrJR(),infoJR.getnbrJV(),infoJR.getnomJR(),infoJR.getageJR(),infoJR.getNiveau());
				//jeu.start();
				/*try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				Controler controlerJeu = new Controler(jeu);
				MainGraphique mainGraphique = new MainGraphique(controlerJeu);
	
				jeu.addObserver(mainGraphique);
	
				infoJR.dispose();
				
				jeu.start();
				
				};
				
			});
			
						
			}
		
		
	});
}
}