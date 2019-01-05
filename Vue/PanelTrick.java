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

import Carte.Trick;
import Controler.Controler;


public class PanelTrick extends JPanel {
private Controler controler;
private Trick carte;
private String pathFaceUp;
private String pathFaceDown; 
private Image background; 
private Image FaceUp; 
private Image FaceDown; 

public PanelTrick (Trick t,Controler ctrl) {
this.controler =ctrl;
this.carte = t;

pathFaceUp = this.carte.getsimage(t.getValeur());
pathFaceDown = "image/TrickVerso.PNG";

BufferedImage img = null;
try {
img = ImageIO.read(new File(pathFaceUp));

} catch (IOException e) {
e.printStackTrace();
}
Image FaceUp = img.getScaledInstance(200, 120, Image.SCALE_SMOOTH);

BufferedImage imgDown = null;
try {
imgDown = ImageIO.read(new File(pathFaceDown));

} catch (IOException e) {
e.printStackTrace();
}
Image FaceDown = imgDown.getScaledInstance(200, 120, Image.SCALE_SMOOTH);

Dimension cardDimension = new Dimension(136, 80);
this.setMinimumSize(cardDimension);
this.setMaximumSize(cardDimension);
this.setPreferredSize(cardDimension);
this.background = FaceUp; 
this.addMouseListener(new MouseListener() {

@Override
public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mousePressed(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseClicked(MouseEvent e) {
}
});

}

protected void paintComponent(Graphics g) {
super.paintComponent(g); 
g.drawImage(this.background, 0, 0,getWidth(),getHeight(), null);
}

public void faceDown() {
this.background = this.FaceDown;
this.repaint();
}

}