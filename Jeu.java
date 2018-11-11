import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private String etat;

    private String joueurEnCours;

    private int nbredecartes;
    
    private int nbredeJoueursR;
    
    private int nbredeJoueursV;
    
    private int nbredeJoueurs;
    
    private int variante;
    
    public ArrayList<Trick> trick = new ArrayList<Trick> ();
    
    public ArrayList<Prop> prop = new ArrayList<Prop> ();

    public ArrayList<Joueur> joueur = new ArrayList<Joueur> ();
    
    public ArrayList<JoueurVirtuel> joueurV = new ArrayList<JoueurVirtuel> ();
    
    public ArrayList<JoueurReel> joueurR = new ArrayList<JoueurReel>();

	public int getNbredeJoueurs() {
		return nbredeJoueurs;
	}

	public void setNbredeJoueurs(int nbredeJoueurs) {
		this.nbredeJoueurs = nbredeJoueurs;
	}

	public ArrayList<Trick> getTrick() {
		return trick;
	}

	public void setTrick(ArrayList<Trick> trick) {
		this.trick = trick;
	}

	public ArrayList<Prop> getProp() {
		return prop;
	}

	public void setProp(ArrayList<Prop> prop) {
		this.prop = prop;
	}

	public ArrayList<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(ArrayList<Joueur> joueur) {
		this.joueur = joueur;
	}

	public ArrayList<JoueurVirtuel> getJoueurV() {
		return joueurV;
	}

	public void setJoueurV(ArrayList<JoueurVirtuel> joueurV) {
		this.joueurV = joueurV;
	}

	public ArrayList<JoueurReel> getJoueurR() {
		return joueurR;
	}

	public void setJoueurR(ArrayList<JoueurReel> joueurR) {
		this.joueurR = joueurR;
	}

	public Jeu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNbredeJoueursV() {
		return nbredeJoueursV;
	}

	public void setNbredeJoueursV(int nbredeJoueursV) {
		this.nbredeJoueursV = nbredeJoueursV;
	}

	public int getNbredeJoueursR() {
		return nbredeJoueursR;
	}

	public void setNbredeJoueursR(int nbredeJoueursR) {
		this.nbredeJoueursR = nbredeJoueursR;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(String joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public int getNbredecartes() {
		return nbredecartes;
	}

	public void setNbredecartes(int nbredecartes) {
		this.nbredecartes = nbredecartes;
	}
	
	public void jouerAvecVariantes( int variante) {
		this.variante = variante;
		if (variante == 1) {
			System.out.println("Packs disponibles (Vous pouvez ajouter tous les packs) :\n");
			System.out.println("Pack 1 (Props et Tricks de base x2");
			System.out.println("\nPack 2 (Nouveaux Tricks et Props)");
			System.out.println("\nQuels packs d'extension voulez-vous ajouter ? (1, 2, 12, 122)");
			Scanner sc1 = new Scanner(System.in);
			int extension = sc1.nextInt();
			if (extension == 1 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(0));
				this.prop.add(new Prop(1));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(2));
				this.prop.add(new Prop(3));
				this.prop.add(new Prop(4));
				this.trick.add(new Trick(0));
				this.trick.add(new Trick(1));
				this.trick.add(new Trick(2));
				this.trick.add(new Trick(3));
				this.trick.add(new Trick(4));
				this.trick.add(new Trick(5));
				this.trick.add(new Trick(6));
				this.trick.add(new Trick(7));
				this.trick.add(new Trick(8));	
			}
			if (extension == 2 || extension == 12 || extension == 122) {
				this.prop.add(new Prop(5));
				this.prop.add(new Prop(6));
				this.prop.add(new Prop(7));
				this.trick.add(new Trick(10));
				this.trick.add(new Trick(11));
				if (extension == 122) {
					this.prop.add(new Prop(5));
					this.prop.add(new Prop(6));
					this.prop.add(new Prop(7));
					this.trick.add(new Trick(10));
					this.trick.add(new Trick(11));
				}
			}
		}
		if (variante == 2) {
			
		}
		
	}

	public Jeu(int nbredecartes, int nbredeJoueursR, int nbredeJoueursV) {
		super();
		this.nbredeJoueursV = nbredeJoueursV;
		this.nbredeJoueursR = nbredeJoueursR;
		this.nbredecartes = nbredecartes;
	}

    public void finir() {
    }

    public void classer() {
    }

    public void compterlesScores() {
    }
    
    public void creerJoueurs() {
    	if (this.nbredeJoueursV !=0) {
       	for (int i=0; i < this.nbredeJoueursV ; i++ ) {
    		System.out.println("Quel est le niveau des joueurs\nFacile Moyen Difficile");
    		Scanner niveau = new Scanner(System.in);
    		String niv = niveau.nextLine();
    		char carac = niv.charAt(0);
    		if (carac == 'F' || carac == 'f') {
    			this.joueurV.add(new JoueurVirtuel(new Facile()));
    		}
    		else if (carac == 'M' || carac == 'm') {
    			this.joueurV.add(new JoueurVirtuel(new Moyen()));
    		}
    		else if (carac == 'D' || carac == 'd') {
    			this.joueurV.add(new JoueurVirtuel( new Difficile()));
    		}
    		this.joueurV.get(i).setNom("ordi "+ (i+1));
    	}}

        	if (this.nbredeJoueursR !=0) {
            	double ageplusjeune = 200 ;
            	System.out.println("Vous allez entrer le nom des Joueurs et leur âge");
            	int i = 0;
            	int plusjeune[];
            	plusjeune = new int[this.getNbredeJoueursR()];
        	for (int j=this.nbredeJoueursV; j<(this.nbredeJoueursR+this.nbredeJoueursV); j++) {
        		System.out.println("Quel est le nom de joueur " + (j+1) + " ?");
        		Scanner nomJ = new Scanner(System.in);
        		String nom = nomJ.nextLine();
        		System.out.println("Quel est son âge ?");
        		Scanner ageJ = new Scanner(System.in);
        		double age = ageJ.nextDouble();
        		this.joueurR.add(new JoueurReel(age, nom));
        		this.joueurR.get(j).setEstPremierAJouer(false);
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
        	this.joueurR.get(plusjeune[n]).setEstPremierAJouer(true);
    }
    }
    
    public void creerCartesdeBase() {
		this.prop.add(new Prop(0));
		this.prop.add(new Prop(1));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(2));
		this.prop.add(new Prop(3));
		this.prop.add(new Prop(4));
		Collections.shuffle(this.prop);
		this.trick.add(new Trick(0));
		this.trick.add(new Trick(1));
		this.trick.add(new Trick(2));
		this.trick.add(new Trick(3));
		this.trick.add(new Trick(4));
		this.trick.add(new Trick(5));
		this.trick.add(new Trick(6));
		this.trick.add(new Trick(7));
		this.trick.add(new Trick(8));
		Collections.shuffle(this.trick);
		this.trick.add(new Trick(9));
    	
    }
	public void commencer() {


    }

}
