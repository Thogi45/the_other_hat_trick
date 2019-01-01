package Carte;

public abstract class Carte {
    private String nom;
    // Tets

    public abstract void melanger();
    
    public abstract void ajouterCartes(int cartesAjoutees, int index);

    public void retourner() {
    }

}
