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

public class PanelProp extends JPanel {
private Controler controler;
private Prop carte;
private String pathFaceUp;
private Image background;
private Image backgroundUp;
private Image backgroundDown;
private String pathFaceDown;

public PanelProp (Prop p,Controler ctrl) {
this.controler =ctrl;
this.carte = p;

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
}