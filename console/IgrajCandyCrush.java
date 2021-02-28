package Konzola;

import java.util.Scanner;

import Logika.CandyCrush;

/**
 * 
 * @author ibrahim
 *
 */

public class IgrajCandyCrush {

	/**
	 * Main za konzolu.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int a, b, c;
		System.out.println("Unesite broj redova: ");
		a = s.nextInt();
		System.out.println("Unesite broj kolona: ");
		b = s.nextInt();
		System.out.println("Unesite broj poteza: ");
		c = s.nextInt();
		
		CandyCrush cc = new CandyCrush(a, b, c);
		prikaziStanje(cc);
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
			prikaziStanje(cc);
		}
	}
	
	/**
	 * Metoda za prikaz trenutnog stanja
	 * tabele igrice u konzulu.
	 * @param cc CandyCrush instanca logike igrice.
	 */
	private static void prikaziStanje(CandyCrush cc) {
		int[][] mat = cc.tabelaStanja();
		System.out.println("Broj bodova: " + cc.dajBodove());
		System.out.println("Preostalo poteza: " + cc.dajPoteze());
		for(int i = 0; i <mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}
