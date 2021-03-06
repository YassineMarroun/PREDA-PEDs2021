/**
 * @ (#) AlgoritmoVueltaAtras.java
 *
 * Clase AlgoritmoVueltaAtras.
 * Clase que implementa el algoritmo que da solucion al sudoku.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/29
 */
package sudoku9x9;

public class AlgoritmoVueltaAtras {
	
	private int[][] tablero;
	private static final int LIBRE = 0;
	private static int llamada = 0;
	
	public AlgoritmoVueltaAtras(int tablero[][]) {
		
		this.tablero = tablero;
	}
	
	
	public boolean resolverSudoku() {
		
		llamada++;
		DatosSalida.unirTraza("Llamada recursiva numero: " + llamada);
		
		for(int fila = 0; fila < 9; fila ++) {
			for(int columna = 0; columna < 9; columna++) {
				
				if(tablero[fila][columna] == LIBRE) {
					for(int numero = 1; numero <= 9; numero++) {
						if(esValido(fila, columna, numero)) {
							tablero[fila][columna] = numero;
							if(resolverSudoku()) {
								return true;
							} else {
								tablero[fila][columna] = LIBRE;
							}
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	private boolean esValido(int fila, int columna, int numero) {
		
		return !(contieneEnFila(fila, numero) || contieneEnColumna(columna, numero) || contieneEnCaja(fila, columna, numero));
	}
	
	
	private boolean contieneEnFila(int fila, int numero) {
		
		for(int i = 0; i < 9; i++) {
			if (tablero[fila][i] == numero) {
				
				return true;
			}
		}
		return false;
	}

	
	private boolean contieneEnColumna(int columna, int numero) {
		
		for(int i = 0; i < 9; i++) {
			if (tablero[i][columna] == numero) {
				
				return true;
			}
		}
		return false;
	}
	
	
	private boolean contieneEnCaja(int fila, int columna, int numero) {
		
		int f = fila - fila % 3;
		int c = columna - columna % 3;
		
		for(int i = f; i < f+3; i++) {
			for(int j = c; j < c+3; j++) {
			
				if (tablero[i][j] == numero) {
					
					return true;
				}
			}
		}
		return false;
	}
}