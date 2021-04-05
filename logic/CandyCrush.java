package Logika;

import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author ibrahim
 *
 */

public class CandyCrush {
	private final static int brojFigura = 5;
	private int dimenzijaX, dimenzijaY;
	private int[][] matrica;
	private int brojPoteza;
	private int brojPotezaUkupno;
	private int bodovi;
	private final static int gornjaGranica = 12;
	private final static int donjaGranica = 4;
	
	
	/**
	 * Konstruktor sa tri parametra koji postavlja
	 * odgovarajuće dimenzije igrice i broj poteza.
	 * @param dimX int broj redova.
	 * @param dimY int broj kolona.
	 * @param potezi int ukupan broj poteza za igranje.
	 */
	public CandyCrush(int dimX, int dimY, int potezi) {
		brojPoteza = potezi;
		brojPotezaUkupno = brojPoteza;
		bodovi = 0;
		if(dimX > gornjaGranica || dimX < donjaGranica)
			dimX = 8;
		if(dimY < donjaGranica || dimY > gornjaGranica)
			dimY = 8;
		dimenzijaX = dimX;
		dimenzijaY = dimY;
		matrica = new int[dimenzijaX][dimenzijaY];
		randomTabela();
	}
	
	/**
	 * Pomoćna metoda za generisanje random bomobona za igru.
	 * Poziva metodu za provjeru stanja nad generisanim poljem, 
	 * te spušta bombone ukoliko dođe do brisanja bobmbona.
	 */
	public void randomTabela() {
		for(int i = 0; i<dimenzijaX; i++) {
			for(int j = 0; j<dimenzijaY; j++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, brojFigura + 1);
				matrica[i][j] = randomNum;
			}	
		}
		while(provjeriStanje())
			spustiBombone();
	}
	
	/**
	 * Metoda za ponovno pokretanje trenutne igrice.
	 */
	public void restart() {
		brojPoteza = brojPotezaUkupno;
		bodovi = 0;
		randomTabela();
	}
	
	/**
	 * Postavlja bodove na vrijednost parametra.
	 * @param bod int novi broj bodova.
	 */
	public void postaviBodove(int bod) {
		bodovi = bod;
	}
	
	/**
	 * Metoda koja vraća trenutni broj bodova.
	 * @return int broj bodova.
	 */
	public int dajBodove() {
		return bodovi;
	}
	
	/**
	 * Metoda koja vraća preostali broj poteza.
	 * @return int preostali broj poteza.
	 */
	public int dajPoteze() {
		return brojPoteza;
	}
	
	/**
	 * Metoda koja vraća maksimalan broj poteza koji
	 * se mogu odigrati u jednoj partij.
	 * @return int ukupan broj poteza
	 */
	public int dajPotezeUkupno() {
		return brojPotezaUkupno;
	}
	
	/**
	 * Metoda koja daje trenutno stanje polja u igrici.
	 * @return int[][] matrica trenutnog stanja
	 */
	public int[][] tabelaStanja() {
		return matrica;
	}
	
	/**
	 * Metoda koja provjerava da li je kraj igrice.
	 * @return boolean da li je kraj.
	 */
	public boolean kraj() {
		if(brojPoteza > 0)
			return false;
		return true;
	}
	
	/**
	 * Metoda za provjeru validnosti trenutnog poteza.
	 * @param potez int[] niz od četiri elementa gjde prva dva su indeksi prve, 
	 * a druga dva indeksi druge bombone za zamjenu, gjde prvo ide indeks reda pa indeks kolone.
	 * @return booelan da li je validan potez.
	 */
	public boolean provjeriPotez(int[] potez) {
		int x1, y1, x2, y2;
		x1 = potez[0]; y1 = potez[1]; x2 = potez[2]; y2 = potez[3];
		if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0)
			return false;
		else if(x1 >= dimenzijaX || y1 >= dimenzijaY || x2 >= dimenzijaX || y2 >= dimenzijaY)
			return false;
		else if(x1 == x2 && Math.abs(y1 - y2) > 1)
			return false;
		else if(y1 == y2 && Math.abs(x1 - x2) > 1)
			return false;
		else if(x1 != x2 && y1 != y2)
			return false;
		else
			return true;
	}
	
	/**
	 * Metoda koja vrši zamjenu izabranih polja.
	 * Uništava polja ako treba ili vraća na prijašnju poziciju.
	 * Ukoliko uništi polja, spušta gornja polja na mjesta uništenih polja.
	 * @param potez int[] niz od četiri elementa gjde prva dva su indeksi prve, 
	 * a druga dva indeksi druge bombone za zamjenu, gjde prvo ide indeks reda pa indeks kolone.
	 */
	public void igrajPotez(int[] potez) {
		if(provjeriPotez(potez)) {
			int temp = matrica[potez[0]][potez[1]];
			matrica[potez[0]][potez[1]] = matrica[potez[2]][potez[3]];
			matrica[potez[2]][potez[3]] = temp;
			System.out.println();
			boolean validan = false;
			while(provjeriStanje()) {
				spustiBombone();
				validan = true;
			}
			if(!validan) {
				temp = matrica[potez[0]][potez[1]];
				matrica[potez[0]][potez[1]] = matrica[potez[2]][potez[3]];
				matrica[potez[2]][potez[3]] = temp;
			}
		}
		brojPoteza--;
	}
	
	/**
	 * Metoda za spuštanje polja iznad uništenih polja na njihovo mjesto.
	 */
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
	
	/**
	 * Metoda koja na prazna mjesta nastala nakon 
	 * uništavanja i spuštanja generiše nove bombone. 
	 */
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
	
	private boolean provjeriRedove(boolean zaBrisanje, int[][] mat) {
		for(int i = 0; i<dimenzijaX; i++) {
			int brojac = 1;
			for(int j = 1; j<dimenzijaY; j++) {
				if(mat[i][j] == mat[i][j-1]) {
					brojac++;
					if(brojac >= 3 && j == dimenzijaY-1) {
						bodovi += brojac;
						matrica[i][j] = 0;
						while(brojac >= 1) {
							matrica[i][j-brojac+1] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}
				else {
					if(brojac >= 3) {
						bodovi += brojac;
						matrica[i][j-1] = 0;
						while(brojac > 1) {
							matrica[i][j-brojac] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
					brojac = 1;
				}				
			}
		}
		return zaBrisanje;
	}
	
	
	private boolean provjeriKolone(boolean zaBrisanje, int[][] mat) {
		for(int i = 0; i<dimenzijaY; i++) {
			int brojac = 1;
			for(int j = 1; j<dimenzijaX; j++) {
				if(mat[j][i] == mat[j-1][i]) {
					brojac++;
					if(brojac >= 3 && j == dimenzijaX-1) {
						bodovi += brojac;
						matrica[j][i] = 0;
						while(brojac >= 1) {
							matrica[j-brojac+1][i] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
				}
				else {
					if(brojac >= 3) {
						bodovi += brojac;
						matrica[j-1][i] = 0;
						while(brojac > 1) {
							matrica[j-brojac][i] = 0;
							brojac--;
						}
						brojac = 1;
						zaBrisanje = true;
					}
					brojac = 1;
				}
			}
		}
		return zaBrisanje;
	}
	
	
	/**
	 * Metoda koja gleda postoje li polja za uništavanje vertikalno i horizontalno.
	 * Ukoliko postoje, označava ih.
	 * @return boolean da li postoje polja za uništavanje.
	 */
	public boolean provjeriStanje() {
		boolean zaBrisanje = false;
		
		int[][] pom = new int[dimenzijaX][dimenzijaY];
		//int [][]pom = matrica.clone();
		for(int i = 0; i<dimenzijaX; i++)
			for(int j = 0; j<dimenzijaY; j++)
				pom[i][j] = matrica[i][j];
		
		zaBrisanje = provjeriRedove(zaBrisanje, pom);
		
		zaBrisanje = provjeriKolone(zaBrisanje, pom);
		
		return zaBrisanje;
	}
}
