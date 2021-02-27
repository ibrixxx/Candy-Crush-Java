package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Logika.CandyCrush;

public class Dugmad extends JPanel{
	CandyCrush igra;
	JButton restart;
	JButton refresh;
	MojPanel polje;
	InfoPanel info;
	final static int maxBrojRefreshanja = 3;
	int brojRefreshanja;
	
	public Dugmad(CandyCrush cc, MojPanel mp, InfoPanel ip) {
		brojRefreshanja = 0;
		igra = cc;
		polje = mp;
		info = ip;
		refresh = new JButton("refresh");
		restart = new JButton("restart");
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(igra.kraj())
					brojRefreshanja = maxBrojRefreshanja;
				if(brojRefreshanja < maxBrojRefreshanja) {
					igra.randomTabela();
					polje.osvjeziStanje();
				}
				brojRefreshanja++;
			}
		});
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = igra.tabelaStanja().length;
				int kolona = igra.tabelaStanja()[0].length;
				int potezi = igra.dajPotezeUkupno();
				igra = new CandyCrush(red, kolona, potezi);
				info = new InfoPanel(igra);
				polje = new MojPanel(igra, info);
				polje.osvjeziStanje();
				brojRefreshanja = 0;
			}
		});
		setLayout(new GridLayout(1,2));
		setVisible(true);
		add(refresh);
		add(restart);
	}
}
