import java.util.ArrayList;
import java.util.Scanner;


public class JoueurReel extends Joueur {
    private double age;
    

    private String nom;

	public JoueurReel(double age, String nom) {
		super();
		this.age = age;
		this.nom = nom;
	}
	
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		super.setTrickARealiser(trickARealiser);
		boolean OK = false;
		boolean trickChoix =false;
		while (OK == false) {
		System.out.println("Voulez-vous réaliser le tour " + this.getTrickARealiser().get(0).getNomtrick());	
		Scanner sc = new Scanner(System.in);
		String reponse = sc.nextLine();
		char rep = reponse.charAt(0);
		if (rep=='N'||rep=='n') {
			System.out.println("Le nouveau tour est "+this.getTrickARealiser().get(1).getNomtrick());
			this.setChoixTrick(1);
			trickChoix = true;
			OK = true;
		}
		else if (rep=='o'||rep=='O') {
			System.out.println("Le tour à réaliser est donc "+ this.getTrickARealiser().get(0).getNomtrick());
			this.setChoixTrick(0);
			trickChoix = false;
			OK = true;
		}
		else {
			System.out.println("Vous avez mal répondu.");
			OK = false;
		}
		}
		return trickChoix;
		
	}

	public Object[] jouer() {
		Object[] valeurs;
		valeurs = new Object[4];
		valeurs[0] = this.getNom();
		System.out.println(this.afficherMain());
		boolean OK = false;
		while (OK==false) {
			System.out.println("Quel prop voulez-vous échanger ?");
			System.out.println("\nEntrer la position de la carte à échanger avec un notre joueur");
			Scanner sc = new Scanner(System.in);
			int rep = sc.nextInt()-1;
			if (rep < this.getMain().size() && rep >= 0) {
			valeurs[1] = rep;
			}
			System.out.println("Choisissez l'adversaire avec qui échanger votre prop");
			Scanner sc1 = new Scanner(System.in);
			String rep1 = sc1.nextLine();
			
			valeurs[2] = (String) rep1;
			
			System.out.println("\nEntrer la position de la carte à choisir chez le joueur sélectionné");
			Scanner sc2 = new Scanner(System.in);
			int rep2 = sc.nextInt()-1;
			if (rep2 < this.getMain().size() && rep2 >= 0) {
				valeurs[3] = rep2;
				OK = true;
				}
		}
		return valeurs;
		}

		
		
		
	
	


	public void setJeu(Jeu jeu) {
		return;
	}
	
	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    

}
