package Gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Okvir extends JFrame {
	Panel1 info;
	public Panel2 igra;
	Gui gui;
	
	public Okvir(Gui gui1) {
		gui = gui1;
		setSize(690, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(2,1));
		info = new Panel1(gui);
		igra = new Panel2(gui);
		add(info);
		add(igra);
	}
}
