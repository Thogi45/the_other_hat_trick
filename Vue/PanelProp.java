package Vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Carte.Prop;
import Controler.Controler;
import Joueur.JoueurReel;
import Joueur.JoueurVirtuel;

public class PanelProp extends JPanel {
private Controler controler;
private Prop carte;
private String pathFaceUp;
private Image background;
private Image backgroundUp;
private Image backgroundDown;
private String pathFaceDown;
private String nomProp;
private Boolean isFaceUp;
private Boolean PpChoisi = false;

public PanelProp (Prop p, Boolean isFaceUp, Controler ctrl) {
this.controler =ctrl;
this.carte = p;
this.isFaceUp = isFaceUp;

pathFaceUp = this.carte.getsimage(p.getValeur());
pathFaceDown = "image/CarteVerso.PNG";

BufferedImage imgUp = null;
try {
imgUp = ImageIO.read(new File(this.pathFaceUp));

} catch (IOException e) {
e.printStackTrace();
}
this.backgroundUp = imgUp.getScaledInstance(120, 200, Image.SCALE_SMOOTH);


BufferedImage imgDown = null;
try {
imgDown = ImageIO.read(new File(this.pathFaceDown));

} catch (IOException e) {
e.printStackTrace();
}
this.backgroundDown = imgDown.getScaledInstance(120, 200, Image.SCALE_SMOOTH);

Dimension cardDimension = new Dimension(80, 136);
this.setMinimumSize(cardDimension);
this.setMaximumSize(cardDimension);
this.setPreferredSize(cardDimension);

this.background = this.backgroundDown;

}


public String getNomProp() {
	return this.carte.getNomP();
}
@Override
protected void paintComponent(Graphics g) {
// TODO Auto-generated method stub
super.paintComponent(g); 
g.drawImage(this.background, 0, 0,getWidth(),getHeight(), null);
}
public void faceDown() {
this.background = this.backgroundDown;
this.repaint();
}
public void faceUp() {
this.background = this.backgroundUp;
this.repaint();
}

	public Boolean getPpropChoisi() {
		return this.PpChoisi;
	}
	
	public void UpdateTrickR() {
		this.removeAll();
			try {
			
			int iPropChoisi1 = this.controler.getJeu().getiPropChoisi1();
			System.out.println("gia tri "+ iPropChoisi1);
			
			JoueurReel joueurR = this.controler.getJeu().getJoueurR().get(0);
			Prop prop =  joueurR.getMain().get(iPropChoisi1);
			
			String path = prop.getsimage(prop.getValeur());
			
			this.background = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.validate();
		this.repaint();
}
	public void UpdateTrickV() {
		this.removeAll();
			try {
			
			int iPropChoisi2 = this.controler.getJeu().getiPropChoisi2();
			int iAdversaireChoisi = this.controler.getJeu().getiAdversaire();		
			JoueurVirtuel joueurV = this.controler.getJeu().getJoueurV().get(iAdversaireChoisi);
			Prop prop =  joueurV.getMain().get(iPropChoisi2);
			String path = prop.getsimage(prop.getValeur());
			
			this.background = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.validate();
		this.repaint();
}
	
 
}