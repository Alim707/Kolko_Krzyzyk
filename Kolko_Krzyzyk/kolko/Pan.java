package kolko;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pan extends JPanel {
	
	private Przycisk tab[][];//publiczne pola klasy!!! co to w ogule ma byc? JA ZMIENILEM
	
	//Albo to pole klasy przenies do Action (ono w ogule nie jest wykorzystywane w tym obiekcie)
	//Albo funkcej Action.dzialania() przenies tu
	/**
	 * hghghghg
	 */
	public boolean tura;//publiczne pola klasy!!! co to w ogule ma byc?
	
	private int ile;

	public Pan() {
		boolean przejscie = true;
		while (przejscie) {
			try {
				//xxx=(trzy w rzedzie) lub xxxxx co gdy plansza 4x4???
				ile = Integer.parseInt(JOptionPane.showInputDialog("Podaj dlugosc boku planszy z zakresu 3-50."));
				if (ile >= 3 && ile <= 50) {
					przejscie = false;
				} else {
					JOptionPane.showMessageDialog(null, "ERROR! Zly zakres danych :p");

				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERROR! Zly rodzaj danych :p");
			}
		}
		this.setLayout(new GridLayout(ile, ile));//BARDZO LADNIE DUZY PLUS wykorzystales wiedze z poprzedniej lekcji
		tura = true;
		tab = new Przycisk[ile][ile];
		for (int i = 0; i < ile; i++) {
			for (int j = 0; j < ile; j++) {
				tab[i][j] = new Przycisk();
				tab[i][j].addActionListener(new Action(tab[i][j], this));
				this.add(tab[i][j]);

			}

		}

	}

	public int sprawdz() {
	//TEN KOD DZIALA TYLKO DLA PLANSZY 3x3
	//DLA WIEKSZYCH NIE DZIALA 
	//SPROBUJ TAKIEGO PODEJSCIA:
	Point[] kierunki = {
			new Point(1, 0),
			new Point(0, 1),
			new Point(0, -1), 
			new Point(-1, 0),
			new Point(1, 1), 
			new Point(-1, -1),
			new Point(-1, 1), 
			new Point(1, -1)
	};
//		int licz = 0;
//		for (int i = 0; i < ile; i++) {
//			if (tab[0][i].znak == 0) {
//				licz++;
//				while (licz < ile && tab[licz][i].znak == 0) {
//					licz++;
//
//				}
//				if (licz == ile) {
//					return 0;
//
//				}
//				licz = 0;
//
//			}
//			if (tab[0][i].znak == 1) {
//				licz++;
//				while (licz < ile && tab[licz][i].znak == 1) {
//					licz++;
//
//				}
//				if (licz == ile) {
//					return 1;
//
//				}
//				licz = 0;
//
//			}
//			if (tab[i][0].znak == 0) {
//				licz++;
//				while (licz < ile && tab[i][licz].znak == 0) {
//					licz++;
//
//				}
//				if (licz == ile) {
//					return 0;
//
//				}
//				licz = 0;
//
//			}
//			if (tab[i][0].znak == 1) {
//				licz++;
//				while (licz < ile && tab[i][licz].znak == 1) {
//					licz++;
//
//				}
//				if (licz == ile) {
//					return 1;
//
//				}
//				licz = 0;
//
//			}
//
//		}
//		if (tab[0][0].znak == 0) {
//			licz++;
//			while (licz < ile && tab[licz][licz].znak == 0) {
//				licz++;
//
//			}
//			if (licz == ile) {
//				return 0;
//
//			}
//			licz = 0;
//
//		}
//		if (tab[0][0].znak == 1) {
//			licz++;
//			while (licz < ile && tab[licz][licz].znak == 1) {
//				licz++;
//
//			}
//			if (licz == ile) {
//				return 1;
//
//			}
//			licz = 0;
//
//		}
//		if (tab[ile - 1][0].znak == 0) {
//			licz++;
//			while (licz < ile && tab[ile - (licz + 1)][licz].znak == 0) {
//				licz++;
//
//			}
//			if (licz == ile) {
//				return 0;
//
//			}
//			licz = 0;
//
//		}
//		if (tab[ile - 1][0].znak == 1) {
//			licz++;
//			while (licz < ile && tab[ile - (licz + 1)][licz].znak == 1) {
//				licz++;
//
//			}
//			if (licz == ile) {
//				return 1;
//
//			}
//			licz = 0;
//
//		}
//
//		for (int i = 0; i < ile; i++) {
//			for (int j = 0; j < ile; j++) {
//				if (tab[i][j].znak == 2) {
//					return 3;
//
//				}
//
//			}
//
//		}
//		return 2;
		//zamiana tura z boolean na int
		int tura=-1;
		if (true==this.tura){
			tura=0;
		}else{
			tura=1;
		}
		//dla 3x3
		if (ile == 3){
			//na skos
			if (tab[0][0].znak==tura && tab[1][1].znak==tura && tab[2][2].znak==tura || tab[2][0].znak==tura && tab[1][1].znak==tura && tab[0][2].znak==tura){
				return tura;
			}
			for (int i=0;i<3;i++){
				if (!(tab[i][0].znak==tura && tab[i][1].znak==tura && tab[i][2].znak==tura)){
					return 2;
				}
				if (!(tab[0][i].znak==tura && tab[1][i].znak==tura && tab[2][i].znak==tura)){
					return 2;
				}
			}
			return tura;
		//dla 5x5, 6x6, ...
		}else{
			//gdybysmy mieli wspolrzendne ostatnio postawionego to mozemy zrobic to optymalniej
			for (int i=0;i<ile;i++){
				for (int j=0;j<ile;j++){
					sprawdzPom(i,j);
				}
			}
		}
		return 4;//nie dokonczylem
	}

	private void sprawdzPom(int i, int j) {
		//tab[i][j]
	}

	public void czyscwysztko() {
		for (int i = 0; i < ile; i++) {
			for (int j = 0; j < ile; j++) {
				tab[i][j].czysc();

			}

		}

	}

}
