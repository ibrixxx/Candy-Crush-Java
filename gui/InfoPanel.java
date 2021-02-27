package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.CandyCrush;

public class InfoPanel extends JPanel{
	CandyCrush igra;
	JLabel bodovi;
	JLabel potezi;
	JTextField bod;
	JTextField potez;
	
	public InfoPanel(CandyCrush cc) {
		super();
		igra = cc;
		setLayout(new GridLayout(2,2));
		setVisible(true);
		bodovi = new JLabel();
		bodovi.setText("Broj bodova:");
		potezi = new JLabel();
		potezi.setText("Preostalo poteza:");
		bod = new JTextField();
		potez = new JTextField();
		bod.setText(String.valueOf(igra.dajBodove()));
		bod.setEditable(false);
		potez.setText(String.valueOf(igra.dajPoteze()));
		potez.setEditable(false);
		add(bodovi);
		add(bod);
		add(potezi);
		add(potez);
	}
	
	
	public void azuriraj() {
		bod.setText(String.valueOf(igra.dajBodove()));
		potez.setText(String.valueOf(igra.dajPoteze()));
	}
}
