
public class JoueurReel extends Joueur {
    private double age;
    
    private boolean estPremierAJouer;

    private String nom;

	public JoueurReel(double age, String nom) {
		super();
		this.age = age;
		this.nom = nom;
	}

	public boolean isEstPremierAJouer() {
		return estPremierAJouer;
	}

	public void setEstPremierAJouer(boolean estPremierAJouer) {
		this.estPremierAJouer = estPremierAJouer;
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
