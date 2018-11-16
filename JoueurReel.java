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

	public ArrayList<String> jouer() {
		System.out.println(this.afficherMain());
		System.out.println("Quel prop voulez-vous échanger ? (Attention à bien écrire le nom du prop)");
		Scanner sc = new Scanner(System.in);
		String reponse = sc.nextLine();
		if (reponse.equals(this.))
		System.out.println("Avec qui voulez-vous échanger votre carte ?");
		
		
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
