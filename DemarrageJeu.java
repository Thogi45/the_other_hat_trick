import java.util.ArrayList;
import java.util.AbstractSet;
import java.util.Scanner;
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

	public List<Carte> getCarte() {
		return carte;
	}

	public void setCarte(List<Carte> carte) {
		this.carte = carte;
	}

	public List<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
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

    public List<Carte> carte = new ArrayList<Carte> ();

    public List<Joueur> joueur = new ArrayList<Joueur> ();

    public Jeu jeu;

    public void creerCarte( int nbreCartesCrees) {
    	this.nbreCartesCreees = nbreCartesCrees;
    	boolean p1 = false;
    	ArrayList<Prop> aProp = new ArrayList<Prop>();
    	ArrayList<Trick> aTrick = new ArrayList<Trick> ();
     	if (nbreCartesCrees == 0) {
    		aProp.add(new Prop(0));
    		aProp.add(new Prop(1));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(3));
    		aProp.add(new Prop(4));
    		Collections.shuffle(aProp);
    		aTrick.add(new Trick(0));
    		aTrick.add(new Trick(1));
    		aTrick.add(new Trick(2));
    		aTrick.add(new Trick(3));
    		aTrick.add(new Trick(4));
    		aTrick.add(new Trick(5));
    		aTrick.add(new Trick(6));
    		aTrick.add(new Trick(7));
    		aTrick.add(new Trick(8));
    		Collections.shuffle(aTrick);
    		aTrick.add(new Trick(9));
    	}
     	else {
    		aProp.add(new Prop(0));
    		aProp.add(new Prop(1));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(2));
    		aProp.add(new Prop(3));
    		aProp.add(new Prop(4));
    		Collections.shuffle(aProp);
    		aTrick.add(new Trick(0));
    		aTrick.add(new Trick(1));
    		aTrick.add(new Trick(2));
    		aTrick.add(new Trick(3));
    		aTrick.add(new Trick(4));
    		aTrick.add(new Trick(5));
    		aTrick.add(new Trick(6));
    		aTrick.add(new Trick(7));
    		aTrick.add(new Trick(8));
    		Collections.shuffle(aTrick);
    		aTrick.add(new Trick(9));
     	}
     	Trick t1 = aTrick.get(9);
     	System.out.println(aTrick.get(9).getNomtrick());
     	Trick t2 = aTrick.get(0);
     	System.out.println(aTrick.get(0).getNomtrick());
     	
    }
     	
  
    	
    	

    
    public void creerJoueurs() {
    	for (int i=0; i < this.nbreJoueursV ; i++ ) {
    	JoueurVirtuel[] jvirtuel;
		jvirtuel = new JoueurVirtuel[this.nbreJoueursV];
		System.out.println("Quel est le niveau des joueurs\nFacile Moyen Difficile");
		Scanner niveau = new Scanner(System.in);
		String niv = niveau.nextLine();
		char carac = niv.charAt(0);
		if (this.nbreJoueursV !=0) {
		
		if (carac == 'F' || carac == 'f') {
			jvirtuel[i] = new JoueurVirtuel(new Facile());
		}
		else if (carac == 'M' || carac == 'm') {
			jvirtuel[i] = new JoueurVirtuel( new Moyen());
		}
		else if (carac == 'D' || carac == 'd') {
			jvirtuel[i] = new JoueurVirtuel( new Difficile());
		}
		jvirtuel[i].setNom("ordi "+ (i+1));
	}}
    	double ageplusjeune = 200 ;
		JoueurReel[] jreel;
    	jreel = new JoueurReel[this.getNbreJoueursR()];
    	System.out.println("Vous allez entrer le nom des Joueurs et leur âge");
    	int i = 0;
    	int plusjeune[];
    	plusjeune = new int[this.getNbreJoueursR()];
    	for (int j=0; j<this.nbreJoueursR ; j++) {
    		System.out.println("Quel est le nom de joueur " + (j+1) + " ?");
    		Scanner nomJ = new Scanner(System.in);
    		String nom = nomJ.nextLine();
    		System.out.println("Quel est son âge ?");
    		Scanner ageJ = new Scanner(System.in);
    		double age = ageJ.nextDouble();
    		jreel[j] = new JoueurReel(age, nom);
    		jreel[j].setEstPremierAJouer(false);
    		
    		
    		if (age < ageplusjeune) {
    			ageplusjeune = age ;
    			i = 0;
    	    	plusjeune[i] = j;	
    		}
    		else if (age == ageplusjeune) {
    			i = i + 1 ;
    			plusjeune[i] = j;
    		}
    		
    	}
    	System.out.println(i);
    	System.out.println(plusjeune.length);
    	int n = (int)(Math.random()*i);
    	jreel[plusjeune[n]].setEstPremierAJouer(true);
 
    }
    
  
    public void lancerLeJeu() {
    boolean OK = false;
    int cartesAjoutees = 0;
    System.out.println("Bonjour, Nous allons jouer à The Other Hat Trick");
    System.out.println("Voulez-vous jouer aux règles normales ?\nY or N");
    Scanner sc2 = new Scanner(System.in);
    String str = sc2.nextLine();
    char reponse = str.charAt(0);
    while (OK == false) {
    switch (reponse) {
    case 'Y' :
    this.setNbreJoueurs(3);
    System.out.println("\nAvant de commencer, nous avons des détails à mettre en place\nCombien il y a-t-il de joueurs réels et virtuels ? Attention, il ne peut y avoir que 3 joueurs maximum");
    System.out.println("\nNombre de Joueurs Reels ?");
    Scanner sc = new Scanner(System.in);
    this.setNbreJoueursR(sc.nextInt());
    System.out.println("\nNombre de Joueurs Virtuels ?");
    Scanner sc1 = new Scanner(System.in);
    this.setNbreJoueursV(sc1.nextInt());
    if ((this.getNbreJoueursR()+this.getNbreJoueursV())==3) {
    OK = true;
    }
    else {
    System.out.println("Vous n'avez pas entré le bon nombre de joueurs.\nVeuillez recommencer");
    
    }
    case 'N' :
    OK = true;
    }    
    }
   
    this.creerJoueurs();
    this.creerCarte(cartesAjoutees);
    Jeu Jeu1 = new Jeu(17+cartesAjoutees, this.getNbreJoueursR(), this.getNbreJoueursV());
    Jeu1.commencer();
    
    
   }

}
