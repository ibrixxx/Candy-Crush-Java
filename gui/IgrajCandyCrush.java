package Gui;

import javax.swing.JFrame;

public class IgrajCandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame okvir = new JFrame("Candy Crush");
		MojPanel mp = new MojPanel(5, 5, 10);
		okvir.setContentPane(mp);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setVisible(true);
		okvir.setSize(500, 600);
	}

}
