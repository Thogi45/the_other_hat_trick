package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.scene.control.Spinner;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;

import Joueur.JoueurReel;
import Modele.Jeu;

import java.awt.Font;
import Vue.InfoJoueurReel;
public class FenetreVariant extends JFrame {

	private JFrame frame;
	private String valeur;
	private Integer nbrJR;
	private Integer nbrJ;
	private JTextField regle;
	private JSpinner nbrJoueurReel;
	private JSpinner nbrJoueur;
	private NumberEditor inbrJR;
	private NumberEditor inbrJ;
	protected Integer nbrJV;
	private Jeu jeu;
	
	public JButton btOK;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreVariant window = new FenetreVariant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	//Initialize the contents of the frame.

	public FenetreVariant() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("           Bonjour, Nous allons jouer The Other Hat Trick");
		lblNewLabel.setBounds(42, 28, 432, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		 final JTextField regle = new JTextField();
		regle.setBounds(178, 105, 97, 22);
		frame.getContentPane().add(regle);
		regle.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Voulez-vous jouer aux r\u00E8gles normales ?");
		lblNewLabel_1.setBounds(108, 67, 260, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel nbrJoueurR = new JLabel("Combien de Joueurs Reel?");
		nbrJoueurR.setBounds(146, 140, 163, 16);
		frame.getContentPane().add(nbrJoueurR);
		
		final JSpinner nbrJoueurReel = new JSpinner();
		inbrJR = new JSpinner.NumberEditor(nbrJoueurReel);
		nbrJoueurReel.setBounds(218, 169, 30, 22);
		nbrJoueurReel.setEditor(inbrJR);
		frame.getContentPane().add(nbrJoueurReel);
		inbrJR.getModel().setMinimum(0);
		inbrJR.getModel().setMaximum(5);
		inbrJR.getModel().setStepSize(1);
		inbrJR.getModel().setValue(0); 
		inbrJR.getTextField().setEditable(true);
		
		JLabel label = new JLabel("Combien de Joueurs?");
		label.setBounds(146, 219, 163, 16);
		frame.getContentPane().add(label);
		
		final JSpinner nbrJoueur = new JSpinner();
		inbrJ = new JSpinner.NumberEditor(nbrJoueur);
		nbrJoueur.setBounds(218, 248, 30, 22);
		nbrJoueur.setEditor(inbrJ);
		frame.getContentPane().add(nbrJoueur);
		inbrJ.getModel().setMinimum(0);
		inbrJ.getModel().setMaximum(5);
		inbrJ.getModel().setStepSize(1);
		inbrJ.getModel().setValue(0); 
		inbrJ.getTextField().setEditable(true);
		
		frame.getContentPane().add(nbrJoueur);
		this.frame.setVisible(true);
		
		
		this.btOK = new JButton("OK");
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get valeur entree
				valeur=regle.getText();
				
				nbrJR= (Integer) nbrJoueurReel.getValue(); 
					
				nbrJ=(Integer) nbrJoueur.getValue();
				
				nbrJV = nbrJ - nbrJR;
		
				final InfoJoueurReel frame1 = new InfoJoueurReel();
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame1.setnbrJR(nbrJR);
				frame1.setnbrJV(nbrJV);
				frame1.setnbrJ(nbrJ);
				
				frame1.setVisible(true);
				
				
				frame.setVisible(false);
			
					
				}
		});
		btOK.setBounds(178, 293, 97, 25);
		frame.getContentPane().add(btOK);		
		
		
		
	}
	
	
}
