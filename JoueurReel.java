import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe permettant de g�rer les joueurs r�els du jeu.
 * @author Thomas Girerd et Thuy Tien Nguyen
 *
 */
public class JoueurReel extends Joueur {
	/**
	 * Attribut indiquant l'�ge du joueur r�el.
	 */
    private double age;
    
    /**
     * Permet � l'objet joueur r�el de conna�tre la variante sur lequel on joue.
     */
    private int variante;

	/**
	 * Ajouter une nouvelle carte dans la main du joueur. 
	 * 
	 * @param carteMain
	 * 		Carte � ajouter dans la main du joueur. 
	 */
	public void setCarteMain(Prop carteMain) {
		this.getMain().add(carteMain);
	}

	/**
	 * Constructeur pour le joueur r�el.
	 * 
	 * @param age
	 * 		Age du joueur.
	 * @param nom
	 * 		Nom du joueur.
	 */
	public JoueurReel(double age, String nom) {
		super();
		this.age = age;
		super.setNom(nom);
		
	}
	
	/**
	 * M�thode permettant, lorsque l'on a r�ussi son tour, de choisir les nouveaux props que l'on veut dans sa main. 
	 * 
	 * @param propCentre
	 * 		On r�cup�re la collection des props au centre. 
	 * @return les nouveaux props au centre. 
	 */
	public ArrayList<Prop> melangerPropsCentre(ArrayList<Prop> propCentre) {
		//Si jamais la variante est celle o� on combine avec une seule carte dans sa main, alors on supprime la carte que le joueur a en trop en d�marrant la m�thode. 
		if (this.getVariante()==2) {
			this.removeCarteMain(1);
		System.out.println("=====================");
		System.out.println("La carte pris au joueur pour la r�alisation du trick a ete remise au joueur choisi pour l'�change");
		System.out.println("=====================");
		}
		//On place dans une collection de props toutes les cartes dans la main du joueur et celles dans le prop centre et on les retourne toutes face down.
		int k = this.getMain().size();
		ArrayList<Prop> props = propCentre;
		boolean OK = false;
		for (int i = 0; i<this.getMain().size(); i++) {
			this.getMain().get(i).setIsFaceUp(false);
		}
		props.addAll(getMain());
		for (int i =0; i<props.size();i++) {
			System.out.println((i+1) + ". " + props.get(i).getNomP());
		}
		//On va demander au joueur r�el de choisir les cartes qu'il veut dans sa main. 
		//On lui indique le nombre de cartes qu'il doit choisir
		//Il doit entrer les positions des cartes qu'il veut
		int k1 = props.size();
		int p = 0;
		System.out.println("==================");
		System.out.println("Vous devez choisir " + k + " cartes parmi toutes ces cartes.");
		while (OK ==false) {
			this.supprimerMain();
			for (int j=1;j<=k;j++) {
				System.out.println("==================");
				System.out.println("S�lectionnez la position de la carte n�"+j+" � ajouter dans votre jeu.");
				Scanner sc = new Scanner(System.in);
				//Ce pos permet de mettre � jour la position des cartes dans la collection props apr�s que l'on ait commencer � choisir des cartes. 
				int pos = sc.nextInt()-1-p;
				if (pos>=0 && pos <k1) {
					p++;
					this.setCarteMain(props.get(pos));
					props.remove(pos);
				}
			}
			if (p == k) {
				OK = true;
			}
			else {
				//On s'assure que les positions entr�es sont correctes. 
				p=0;
				props.addAll(getMain());
				for (int i =0; i<props.size();i++) {
					System.out.println((i+1) + ". " + props.get(i).getNomP());
				}
				System.out.println("Vous avez fait une erreur, veuillez recommencer");
			}
		}
		return props;
		
	}
	
	/**
	 * M�thode permettant au joueur de retourner une carte de sa main quand il �choue lors de la r�alisation d'un Trick. 
	 */
	public void retournerCarte() {
		int j = 0;
		int pos = 0;
		boolean OK=false;
		//On regarde qu'elles sont les cartes d�j� retourn�es et on compte le nombre de cartes.
		for (int i = 0; i<this.getMain().size();i++) {
			if (this.getMain().get(i).getIsFaceUp()) {
				j=j+1;
			}
			else if (this.getMain().get(i).getIsFaceUp()== false) {
				pos = i;
			}
		//Si il y a n-1 cartes retourn�es alors que le joueur a n cartes dans sa main alors on retourne la derni�re carte.
		}
		if (j==(this.getMain().size()-1)) {
			this.getMain().get(pos).setIsFaceUp(true);
		}
		//Sinon on indique que toutes les cartes sont d�j� retourn�es. 
		else if (j == this.getMain().size()) {
			System.out.println("Vos cartes sont d�j� retourn�es.");
		}
		else {
			while (OK == false) {
				//On demande au joueur de choisir la carte qu'il d�cide retourner. 
				System.out.println("Choisissez une carte � montrer (entrer une position)");
				Scanner sc = new Scanner(System.in);
				int choixProp = sc.nextInt() - 1;
				System.out.println("==================");
				if (this.getMain().get(choixProp).getIsFaceUp()==false) {
					this.getMain().get(choixProp).setIsFaceUp(true);
					OK = true;
				}
				else {
					System.out.println("Vous avez choisi une carte d�j� retourn�e ou une position qui n'existe pas");
				}
		}
	}
	}
	
	/**
	 * Le joueur r�cup�re tous les tricks qu'il peut r�aliser pendant le tour soit deux tricks possibles. Il en connait un, il choisit s'il veut le faire ou pas. 
	 * 
	 * @see Jeu#commencer()
	 * @see Joueur#setTrickARealiser(ArrayList)
	 * 
	 * @param trickARealiser
	 * 		Collection avec les deux tricks que le joueur peut r�aliser. 
	 * @return Choix du joueur de faire le trick qu'on lui montrer ou alors de d�couvrir l'autre trick. 
	 */
	public boolean setTrickARealiser(ArrayList<Trick> trickARealiser) {
		//On appelle la m�thode dans Joueur.
		super.setTrickARealiser(trickARealiser);
		boolean OK = false;
		boolean trickChoix =false;
		//Dans le cas o� tous les tours de magie sont r�ussis, il se peut que la taille de la collection des tricks possibles � r�aliser soit 1.
		if (trickARealiser.size()!=1) {
		//On demande au joueur de choisir s'il d�cide de r�aliser le tour qu'on lui propose ou de voir le prochain.
		while (OK == false) {
		System.out.println(this.getTrickARealiser().get(0).toString());
		System.out.println("Voulez-vous r�aliser ce tour ? (Oui ou Non)");	
		Scanner sc = new Scanner(System.in);
		String reponse = sc.nextLine();
		char rep = reponse.charAt(0);
		if (rep=='N'||rep=='n') {
			System.out.println("=====================");
			System.out.println("Le nouveau tour est donc :");
			System.out.println(this.getTrickARealiser().get(1).toString());
			this.setChoixTrick(1);
			trickChoix = true;
			OK = true;
		}
		else if (rep=='o'||rep=='O') {
			System.out.println("=====================");
			System.out.println("Le tour � r�aliser est donc ");
			System.out.println(this.getTrickARealiser().get(0).toString());
			this.setChoixTrick(0);
			trickChoix = false;
			OK = true;
		}
		else {
			//On s'assure que le joueur a bien r�pondu.
			System.out.println("Vous avez mal r�pondu.");
			OK = false;
		}
		}
		}
		else {
			System.out.println("=====================");
			System.out.println("Le tour � r�aliser est donc ");
			System.out.println(this.getTrickARealiser().get(0).toString());
			this.setChoixTrick(0);
			trickChoix = false;
			OK = true;	
		}
		System.out.println("=====================");
		//On retourne le choix du joueur. 
		return trickChoix;
		
	}

	/**
	 * M�thode permettant de choisir quels props on veut �changer et avec quel joueur. 
	 * 
	 * @return Tableau d'objets qui retourne le nom des joueurs pour l'�change et la position des cartes pour l'�change. 
	 */
	public Object[] jouer() {
		/*On cr�e un tableau d'objet qui va contenir les informations n�cessaires pour le switch. 
		Cr�ation d'un tableau d'objets qui contiendra :
		 * valeurs[0] : nom du joueur qui joue.
		 * valeurs[1] : position de la carte du joueur qui joue dont il veut se d�barrasser . 
		 * valeurs[2] : nom du joueur avec qui le joueur qui joue veut �changer un de ses Props. 
		 * valeurs[3] : position de la carte que le joueur qui joue veut r�cup�rer chez le joueur avec qui il veut �changer son Prop. 
		*/
		Object[] valeurs;
		valeurs = new Object[4];
		valeurs[0] = this.getNom();
		System.out.println(this.afficherMain());
		boolean OK = false;
		while (OK==false) {
			/*On demande au joueur d'entrer dans l'ordre :
			* - La position de la carte dont il veut se d�barrasser dans sa main.  
			* - Le joueur avec qui il d�sire faire l'�change
			* - La position de la carte qu'il veut et qui appartient au joueur choisi. 
			* Tout au long de la boucle while, on s'assure que le joueur a bien entr� des champs acceptables pour terminer la boucle.
			*/
			if (this.getVariante() != 2) {
			System.out.println("Quel prop voulez-vous �changer ?");
			System.out.println("\nEntrer la position de la carte � �changer avec un notre joueur");
			Scanner sc = new Scanner(System.in);
			int rep = sc.nextInt()-1;
			if (rep < this.getMain().size() && rep >= 0) {
			valeurs[1] = rep;
			}
			}
			else {
				valeurs[1] =0;
			}
			System.out.println("Choisissez l'adversaire avec qui �changer votre prop");
			Scanner sc1 = new Scanner(System.in);
			String rep1 = sc1.nextLine();
			
			valeurs[2] = (String) rep1;
			if (this.getVariante() != 2) {
			System.out.println("\nEntrer la position de la carte � choisir chez le joueur s�lectionn�");
			Scanner sc2 = new Scanner(System.in);
			int rep2 = sc2.nextInt()-1;
			if (rep2 < this.getMain().size() && rep2 >= 0) {
				valeurs[3] = rep2;
				OK = true;
				}
			}
			else {
				valeurs[3] = 0;
				OK = true;
			}
			
		}
		
		return valeurs;
		}

	/**
	 * Permet d'envoyer l'�tat du jeu actuel. 
	 * @param jeu
	 * 		Etat du jeu actuel.
	 */
	public void setJeu(Jeu jeu) {
		variante = jeu.getVariante();
		return;
	}
	
	/**
	 * M�thode pour obtenir l'age du joueur. 
	 * 
	 * @return Un double indiquant l'age du joueur.
	 */
	public double getAge() {
		return age;
	}

	/**
	 * Setter pour indiquer l'�ge du joueur.
	 * 
	 * @param age
	 * 		Double pour indiquer l'�ge du joueur.
	 */
	public void setAge(double age) {
		this.age = age;
	}


    

}
