import java.util.ArrayList;

import java.util.Random;


public class Facile implements Strategie {

private JoueurVirtuel joueur;

private Jeu jeuActuel;

public void jouerStra(JoueurVirtuel joueur, Jeu jeuActuel) {

this.joueur = joueur;

this.jeuActuel = jeuActuel;


this.choisirTrickStra(joueur, jeuActuel);

this.preparePropStra(joueur, jeuActuel );

}

private void preparePropStra(JoueurVirtuel joueur, Jeu jeuActuel) {


public void choisirTrickStra (JoueurVirtuel joueur, Jeu jeuActuel) {

int iTrickChoisi ;

Random rd = new Random();

iTrickChoisi = rd.nextInt(1);

joueur.setChoixTrick(iTrickChoisi);

System.out.println( joueur.getNom()+ " have choose Trick to perform : " + joueur.getTrickARealiser().get(iTrickChoisi).getNomtrick());

//set la position de cartemain choisi

Random rd1 = new Random();

int iPropChoisi =  rd1.nextInt(jeuActuel.getProp().size()%jeuActuel.getJoueur().size());

Prop pPropChoisi = joueur.getMain().get(iPropChoisi);

System.out.println( joueur.getNom()+ "a choisi Propmain à changer:" + joueur.getMain().get(iPropChoisi).getNomP());


//choisir la joueur a changer la carte

//ajouter ID joueur!!!

int iIdJoueurChoisi  =0 ;

while ((iIdJoueurChoisi == 0)|(iIdJoueurChoisi == joueur.getIdJoueur()) ) {

iIdJoueurChoisi = rd1.nextInt(jeuActuel.getJoueur().size());

System.out.println(iIdJoueurChoisi);

}

//choisir la carte de joueur choisi

Joueur p = jeuActuel.TrouverJoueurParId(iIdJoueurChoisi);

jeuActuel.setJoueurChoisi(p);

int iAutrePropChoisi =  rd.nextInt(jeuActuel.getProp().size()%jeuActuel.getJoueur().size());

Prop pAutrePropChoisi = jeuActuel.getJoueurChoisi().getMain().get(iAutrePropChoisi);


jeuActuel.getJoueur().setMain(iPropChoisi, pAutrePropChoisi);

jeuActuel.getJoueurChoisi().setMain(iAutrePropChoisi, pPropChoisi);

jeuActuel.setMain(joueur.getMain());

System.out.println(joueur.getNom() + " has exchanged the props of " + p.getNom());








}

