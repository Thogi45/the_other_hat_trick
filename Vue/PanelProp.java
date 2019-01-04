package Vue;



import Controler.Controler;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Carte.Prop;
import Controler.Controler;


public class PanelProp  extends JButton{
	private Controler controler;
	private Prop card;
	private String pathFond;
	private Image background;
	private Image backgroundUp;
	private Image backgroundDown;
	private String pathFondDown;
	
	public PanelProp (Prop p,Controler ctrl) {
		this.controler =ctrl;
		this.card = p;
}
}
