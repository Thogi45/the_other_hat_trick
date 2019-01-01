package Controler;

import Modele.Jeu;

public class Controler {		
		private Jeu jeu;

		public Controler (Jeu recentJeu) {
			this.jeu = recentJeu;
				}

		public Jeu getJeu() {
			return jeu;
		}
}
