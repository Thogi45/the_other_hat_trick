package Modele;
import java.util.ArrayList;
import java.util.AbstractSet;
import java.util.Scanner;

import Carte.Trick;

import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collections;

/**
 * Classe pour initialiser les donn�es du jeu.
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class DemarrageJeu {
	
	/**
	 * Constructeur de DemarrageJeu.
	 */
    public DemarrageJeu() {
		super();
	}
    
    /**
     * Attribut contenant le jeu. 
     */
    public Jeu jeu;
    
     /**
      * Cette m�thode demande � l'utilisateur de choisir la version du jeu � laquelle il d�sire jouer. En fonction de son choix, un objet de la classe Jeu est cr�� avec la variante choisie par l'utilisateur.
      * Si on d�cide de jouer avec les r�gles de base, on appelera la m�thode CreerJoueurs() de jeu. Sinon, la m�thode jouerAvecVariantes() de jeu sera appel�e. 
      */
    public void lancerLeJeu() {
    boolean OK = false;
    this.jeu = new Jeu();
    int cartesAjoutees = 0;
    System.out.println("Bonjour, Nous allons jouer � The Other Hat Trick");
    System.out.println("Voulez-vous jouer aux r�gles normales ?\nY or N");
    Scanner sc2 = new Scanner(System.in);
    String str = sc2.nextLine();
    char reponse = str.charAt(0);
    while (OK == false) {
    if (reponse == 'Y' || reponse == 'y') {
    	jeu.setNbredeJoueurs(3);
    	jeu.creerJoueurs();
    	OK = true;
    	}
    else if (reponse =='N'||reponse =='n') {
    int variante = 0;
    while (variante <= 0 || variante >= 4) {
    System.out.println("Il existe plusieurs variantes du jeu\nVoici les variantes possibles :\n1. Jouer encore � 3 joueurs mais augmenter le nombre de cartes par joueurs");
    System.out.println("\n2. Ajouter des joueurs mais pas de cartes");
    System.out.println("\n3. Ajouter des joueurs et le nombre de cartes par joueur");
    System.out.println("\n1 2 3 ?");
    Scanner sc3 = new Scanner(System.in);
    variante = sc3.nextInt();
    jeu.jouerAvecVariantes(variante);
    }
    OK = true;
    }
    }
   
   }

}
