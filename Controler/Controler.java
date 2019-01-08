package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Modele.Jeu;
import Vue.MainGraphique;

public class Controler {		
	private Jeu jeu;
	private int iPopChoisi1;
	public Controler (Jeu jeu) {
		this.jeu = jeu;
		
		
		
		
	}

	public Jeu getJeu() {
		return jeu;
	}
	/*public void setiPropChoisi1(int iPropChoisi1) {
		this.iPopChoisi1 = iPropChoisi1;
	}
	public int getiPropChoisi1() {
		return this.iPopChoisi1;
	}*/

	public void NoFlipTrick() {
		this.jeu.setbChoixTrick(true); 
		
	}
	public void FlipTrick() {
		this.jeu.setbChoixTrick(false);
	}
	
	public void setiropChoisi1(int i) {
		this.jeu.setiPropChoisi1(i);
		this.jeu.continu();
	}
}
	

