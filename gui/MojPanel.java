package Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Logika.CandyCrush;

public class MojPanel extends JPanel{
	CandyCrush igra;
	JPanel prikazTabele;
	Bombona[][] dugmad;
	int brojKlikova;
	int[] potez;
	InfoPanel info;
	
	public MojPanel(CandyCrush cc, InfoPanel ip) {
		super();
		brojKlikova = 0;
		potez = new int[4];
		info = ip;
		igra = cc;
		int dimX = igra.tabelaStanja().length;
		int dimY = igra.tabelaStanja()[0].length;
		setLayout(new BorderLayout());
		setVisible(true);
		prikazTabele = new JPanel();
		add(prikazTabele, BorderLayout.CENTER);
		prikazTabele.setLayout(new GridLayout(dimX, dimY));
		dugmad = new Bombona[dimX][dimY];
		for(int i = 0; i<dimX; i++) {
			for(int j = 0; j<dimY; j++) {
				dugmad[i][j] = new Bombona(igra.tabelaStanja()[i][j], i, j);
				prikazTabele.add(dugmad[i][j]);
				int red = i;
				int kolona = j;
				dugmad[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!igra.kraj()) {
							brojKlikova++;
							if(brojKlikova == 1) {
								potez[0] = red;
								potez[1] = kolona;
							}
							if(brojKlikova == 2) {
								potez[2] = red;
								potez[3] = kolona;
								brojKlikova = 0;
								igra.igrajPotez(potez);
								osvjeziStanje();
							}
						}
						
					}
				});
			}
		}
	}
	
	public void osvjeziStanje() {
		for(int i = 0; i<dugmad.length; i++) {
			for(int j = 0; j<dugmad[i].length; j++) {
				dugmad[i][j].promjeniBoju(igra.tabelaStanja()[i][j]);
			}
		}
		info.azuriraj();
	}

}
