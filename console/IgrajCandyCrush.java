package Konzola;

import java.util.Scanner;

import Logika.CandyCrush;

public class IgrajCandyCrush {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		CandyCrush cc = new CandyCrush(6, 6, 10);
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

	private static void prikaziStanje(CandyCrush cc) {
		int[][] mat = cc.tabelaStanja();
		for(int i = 0; i <mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}
