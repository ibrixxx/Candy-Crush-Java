package Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

import Logika.CandyCrush;

public class Okvir extends JFrame{
	CandyCrush cc;
	MojPanel bobe;
	InfoPanel info;
	Dugmad komande;
	public final static int brojRedova = 5;
	public final static int brojKolona = 5;
	public final static int brojPoteza = 10;
	
	
	private void napravi() {
		info = new InfoPanel(cc);
		bobe = new MojPanel(cc, info);
		komande = new Dugmad(cc, bobe, info);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.3;
		c.weightx = 1;
		add(info, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.1;
		add(komande, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 1;
		c.weightx = 1;
		add(bobe, c);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500, 600);
	}
	
	
	public Okvir() {
		super("Candy Crush");
		cc = new CandyCrush(brojRedova, brojKolona, brojPoteza);
		napravi();
	}
	
	public Okvir(int brojRedova, int brojKolona, int brojPoteza) {
		super("Candy Crush");
		cc = new CandyCrush(brojRedova, brojKolona, brojPoteza);
		napravi();
	}
	
	
	public Okvir(int brPoteza) {
		super("Candy Crush");
		int randomNum1 = ThreadLocalRandom.current().nextInt(4, 12 + 1);
		int randomNum2 = ThreadLocalRandom.current().nextInt(4, 12 + 1);
		cc = new CandyCrush(randomNum1, randomNum2, brPoteza);
		napravi();
	}
	
}
