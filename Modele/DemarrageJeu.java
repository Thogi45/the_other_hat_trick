package Modele;
import java.util.ArrayList;
import java.util.AbstractSet;
import java.util.Scanner;

import Carte.Trick;

import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collections;


public class DemarrageJeu {
	
    public DemarrageJeu() {
		super();
	}

    public int getNbreJoueurs() {
		return nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs) {
		this.nbreJoueurs = nbreJoueurs;
	}


	public int getNbreJoueursR() {
		return nbreJoueursR;
	}

	public void setNbreJoueursR(int nbreJoueursR) {
		this.nbreJoueursR = nbreJoueursR;
	}

	public int getNbreJoueursV() {
		return nbreJoueursV;
	}

	public void setNbreJoueursV(int nbreJoueursV) {
		this.nbreJoueursV = nbreJoueursV;
	}

	public double getAgeJoueurR() {
		return ageJoueurR;
	}

	public void setAgeJoueurR(double ageJoueurR) {
		this.ageJoueurR = ageJoueurR;
	}

	public int getRegleChoisie() {
		return regleChoisie;
	}

	public void setRegleChoisie(int regleChoisie) {
		this.regleChoisie = regleChoisie;
	}

	public Trick getTricksSupp() {
		return tricksSupp;
	}

	public void setTricksSupp(Trick tricksSupp) {
		this.tricksSupp = tricksSupp;
	}

	public String getNomDesJoueurs() {
		return nomDesJoueurs;
	}

	public void setNomDesJoueurs(String nomDesJoueurs) {
		
		this.nomDesJoueurs = nomDesJoueurs;
	}

	public boolean isCreationCarte() {
		return creationCarte;
	}

	public void setCreationCarte(boolean creationCarte) {
		this.creationCarte = creationCarte;
	}

	public int getNbreCartesCreees() {
		return nbreCartesCreees;
	}

	public void setNbreCartesCreees(int nbreCartesCreees) {
		this.nbreCartesCreees = nbreCartesCreees;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	
	private int nbreJoueurs;
	
	private int nbreJoueursR;
	
	private int nbreJoueursV;

    private double ageJoueurR;

    private int regleChoisie;

    private Trick tricksSupp;

    private String nomDesJoueurs;

    private boolean creationCarte;

    private int nbreCartesCreees;
    
    public Jeu jeu;
      
    public void lancerLeJeu() {
    boolean OK = false;
    this.jeu = new Jeu();
    int cartesAjoutees = 0;
    System.out.println("Bonjour, Nous allons jouer à The Other Hat Trick");
    System.out.println("Voulez-vous jouer aux règles normales ?\nY or N");
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
    System.out.println("Il existe plusieurs variantes du jeu\nVoici les variantes possibles :\n1. Jouer encore à 3 joueurs mais augmenter le nombre de cartes par joueurs");
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
