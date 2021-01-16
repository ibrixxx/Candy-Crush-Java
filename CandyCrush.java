package Logika;

import java.util.concurrent.ThreadLocalRandom;

public class CandyCrush {
	private int brojFigura;
	private int dimenzijaX, dimenzijaY;
	private int[][] matrica;
	private int brojPoteza; 
	private int bodovi;
	
	public CandyCrush(int dimX, int dimY, int potezi) {
		brojFigura = 5;
		brojPoteza = potezi;
		bodovi = 0;
		if(dimX > 12 || dimX < 6)
			dimX = 8;
		if(dimY < 6 || dimY > 12)
			dimY = 8;
		dimenzijaX = dimX;
		dimenzijaY = dimY;
		matrica = new int[dimenzijaX][dimenzijaY];
		for(int i = 0; i<dimenzijaX; i++) {
			for(int j = 0; j<dimenzijaY; j++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, brojFigura + 1);
				matrica[i][j] = randomNum;
			}	
		}
		while(provjeriStanje())
			spustiBombone();
	}
	
	
	
	public void prikaziStanje() {
		System.out.println("Broj bodova: " + bodovi + " Preostalo poteza: " + brojPoteza);
		for(int i = 0; i<dimenzijaX; i++) {
			for(int j = 0; j<dimenzijaY; j++) {
				System.out.print(matrica[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean kraj() {
		if(brojPoteza > 0)
			return false;
		return true;
	}
	
	
	public void igrajPotez(int[] potez) {
		int temp = matrica[potez[0]][potez[1]];
		matrica[potez[0]][potez[1]] = matrica[potez[2]][potez[3]];
		matrica[potez[2]][potez[3]] = temp;
		System.out.println();
		boolean validan = false;
		prikaziStanje();
		while(provjeriStanje()) {
			spustiBombone();
			validan = true;
		}
		if(!validan) {
			temp = matrica[potez[0]][potez[1]];
			matrica[potez[0]][potez[1]] = matrica[potez[2]][potez[3]];
			matrica[potez[2]][potez[3]] = temp;
		}
		brojPoteza--;
	}
	
	
	public void spustiBombone() {
		for(int i = 0; i<dimenzijaY; i++) {
			int granica = 0;
			for(int j = 0; j<dimenzijaX-1; j++) {
				if(matrica[0][i] == 0) {
					int pom = 0;
					matrica[0][i] = ThreadLocalRandom.current().nextInt(1, brojFigura + 1);
					while((pom+1 < dimenzijaX) && (matrica[pom][i] == matrica[pom+1][i])) {
						matrica[pom+1][i] = ThreadLocalRandom.current().nextInt(1, brojFigura + 1);
						pom++;
					}
					j = pom;
				}
				if(matrica[j][i] != 0 && matrica[j+1][i] == 0) {
					int pom1 = j;
					int pom2 = j+1;
					while(pom2+1 < dimenzijaX && matrica[pom2+1][i] == 0)
						pom2++;
					while(pom1 >= 0) {
						matrica[pom2][i] = matrica[pom1][i];
						matrica[pom1][i] = 0;
						pom1--; pom2--;
					}
				}
			}
		}
		ubaciNoveBombone();
	}
	
	
	public void ubaciNoveBombone() {
		for(int i = 0; i<dimenzijaX; i++) {
			for(int j = 0; j<dimenzijaY; j++) {
				if(matrica[i][j] == 0) {
					int randomNum = ThreadLocalRandom.current().nextInt(1, brojFigura + 1);
					matrica[i][j] = randomNum;
					bodovi++;
				}
			}	
		}
	}
	
	
	public boolean provjeriStanje() {
		boolean zaBrisanje = false;
		for(int i = 0; i<dimenzijaX; i++) {
			int brojac = 1;
			for(int j = 1; j<dimenzijaY; j++) {
				if(matrica[i][j] == matrica[i][j-1]) {
					brojac++;
					if(brojac >= 3 && j == dimenzijaY-1) {
						matrica[i][j] = 0;
						while(brojac >= 1) {
							matrica[i][j-brojac] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}
				else {
					if(brojac >= 3) {
						matrica[i][j-1] = 0;
						while(brojac > 1) {
							matrica[i][j-brojac] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}				
			}
		}
		for(int i = 0; i<dimenzijaY; i++) {
			int brojac = 1;
			for(int j = 1; j<dimenzijaX; j++) {
				if(matrica[j][i] == matrica[j-1][i]) {
					brojac++;
					if(brojac >= 3 && j == dimenzijaX-1) {
						matrica[j][i] = 0;
						while(brojac >= 1) {
							matrica[j-brojac][i] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}
				else {
					if(brojac >= 3) {
						matrica[j-1][i] = 0;
						while(brojac > 1) {
							matrica[j-brojac][i] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}
			}
		}
		return zaBrisanje;
	}
}
