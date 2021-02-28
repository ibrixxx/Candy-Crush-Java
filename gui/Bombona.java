package Gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * 
 * @author ibrahim
 *
 */

public class Bombona extends JButton{
	public int red;
	public int kolona;
	private int vrsta;
	
	/**
	 * Konstruktor sa tri parametra koji određuje boju i poziciju
	 * bombone u igrici.
	 * @param boja int 1-crvena, 2-zelena, 3-plava, 4-žuta, 5-ljubičasta.
	 * @param i int indeks reda.
	 * @param j int indeks kolone.
	 */
	public Bombona(int boja, int i, int j) {
		vrsta = boja;
		red = i;
		kolona = j;
		setVisible(true);
		switch (vrsta) {
		case 1:
			setBackground(Color.red);
			break;
		case 2:
			setBackground(Color.green);
			break;
		case 3:
			setBackground(Color.blue);
			break;
		case 4:
			setBackground(Color.yellow);
			break;
		case 5:
			setBackground(Color.magenta);
			break;
		default:
			setBackground(Color.white);
		}
	}
	
	/**
	 * Metoda za promjenu boje bombone na određenoj pozicij.
	 * @param boja int Broj koji pretstavlja neku boju.
	 */
	public void promjeniBoju(int boja) {
		vrsta = boja;
		switch (boja) {
		case 1:
			setBackground(Color.red);
			break;
		case 2:
			setBackground(Color.green);
			break;
		case 3:
			setBackground(Color.blue);
			break;
		case 4:
			setBackground(Color.yellow);
			break;
		case 5:
			setBackground(Color.magenta);
			break;
		default:
			setBackground(Color.white);
		}
	}
	
	/**
	 * Metoda koja dobavlja u kojem se redu nalazi bombona.
	 * @return red int.
	 */
	public int getRed() {
		return red;
	}
	
	/**
	 * Metoda koja dobavlja u kojoj se koloni nalazi bombona.
	 * @return kolona int.
	 */
	public int getKolona() {
		return kolona;
	}
}
