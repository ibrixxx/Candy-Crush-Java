package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Logika.CandyCrush;

/**
 * 
 * @author ibrahim
 *
 */
public class Dugmad extends JPanel{
	CandyCrush igra;
	JButton restartuj;
	JButton refreshaj;
	MojPanel polje;
	InfoPanel info;
	final static int maxBrojRefreshanja = 3;
	int brojRefreshanja;
	
	/**
	 * Konstruktor sa četiri parametra koji postavlja
	 * dugmad za kontrolu igrice.
	 * @param cc CandyCrush instanca logike.
	 * @param mp MojPanel panel za prikaz stanja tabele.
	 * @param ip InfoPanle panel za prikaz informacija o igrici.
	 * @param o Okvir prozor igrice.
	 */
	public Dugmad(CandyCrush cc, MojPanel mp, InfoPanel ip, Okvir o) {
		brojRefreshanja = 0;
		igra = cc;
		polje = mp;
		info = ip;
		refreshaj = new JButton("Osvježi  (" + maxBrojRefreshanja + ")");
		restartuj = new JButton("Igraj ponovo");
		refreshaj.addActionListener(new ActionListener() {
			@Override
			/**
			 * Mijenja raspored bombona na polju bez dodavanja bodova i oduzimanja broja poteza.
			 */
			public void actionPerformed(ActionEvent arg0) {
				if(igra.kraj())
					brojRefreshanja = maxBrojRefreshanja;
				if(brojRefreshanja < maxBrojRefreshanja) {
					brojRefreshanja++;
					int pom = igra.dajBodove();
					igra.randomTabela();
					igra.postaviBodove(pom);
					polje.osvjeziStanje();
					refreshaj.setText("Osvježi  (" + (maxBrojRefreshanja-brojRefreshanja) + ")");
				}
			}
		});
		restartuj.addActionListener(new ActionListener() {
			@Override
			/**
			 * Vraća igricu na početak.
			 */
			public void actionPerformed(ActionEvent arg0) {
				brojRefreshanja = 0;
				refreshaj.setText("Osvježi  (" + (maxBrojRefreshanja-brojRefreshanja) + ")");
				igra.restart();
				polje.osvjeziStanje();
			}
		});
		setLayout(new GridLayout(1,2));
		setVisible(true);
		add(refreshaj);
		add(restartuj);
	}
}
