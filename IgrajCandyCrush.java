package Konzola;

import java.util.Scanner;

import Logika.CandyCrush;

public class IgrajCandyCrush {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/*int redovi, kolone, potezi;
		System.out.println("Unesite dimenzije poligona: ");
		
		redovi = s.nextInt();
		kolone = s.nextInt();
		System.out.println("Unesite broj poteza: ");
		potezi = s.nextInt();*/
		CandyCrush cc = new CandyCrush(6, 6, 10);
		cc.prikaziStanje();
		while(!cc.kraj()) {
			int[] potez = new int[4];
			System.out.println("prva boba: ");
			potez[0] = s.nextInt();
			potez[1] = s.nextInt();
			System.out.println("druga boba: ");
			potez[2] = s.nextInt();
			potez[3] = s.nextInt();
			cc.igrajPotez(potez);
			System.out.println();
			cc.prikaziStanje();
		}
	}

}
