package Vue;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import Carte.Trick;
import Controler.Controler;
import Controler.Controler;




public class PanelTrick  extends JButton{
	private Controler controler;
	private Trick carte;
	//private String pathFond;
	
	public PanelTrick (Trick t,Controler ctrl) {
	this.controler =ctrl;
	this.carte = t;
	
		
}
	

}
