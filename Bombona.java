package Gui;

import java.awt.Color;

import javax.swing.JButton;

public class Bombona extends JButton{
	public int red;
	public int kolona;
	private int vrsta;
	
	public Bombona(int boja, int i, int j) {
		//setVisible(true);
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
	
	public void promjeniBoju(int boja, int i, int j) {
		red = i;
		kolona = j;
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
}
