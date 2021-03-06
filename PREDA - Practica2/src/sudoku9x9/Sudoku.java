/**
 * @ (#) Sudoku.java
 *
 * Clase Sudoku.
 * Clase que contiene el metodo principal que inicia el programa.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/29
 */
package sudoku9x9;

public class Sudoku {

	public static void main(String[] args) {
		
		int indice = 0;
		String nombreFichero = "";
		int[][] tablero = new int[9][9];
		boolean help = false;
		boolean traza = false;
		boolean ficheroEntrada = false;
		
		switch(args[indice]) {
		
			case "-h":
				help = true;
				DatosSalida.imprimirAyuda();
				break;
			case "-t":
				traza = true;
				indice = indice + 1;
		}
		if(!help) {
			nombreFichero = args[indice];
			ficheroEntrada = true;
			
			if(ficheroEntrada) {
				tablero = DatosEntrada.leerArchivo(nombreFichero);
			}
			
			AlgoritmoVueltaAtras algoritmoVA = new AlgoritmoVueltaAtras(tablero);
			algoritmoVA.resolverSudoku();
			
			DatosSalida datosS = new DatosSalida(tablero);
			datosS.imprimirResultado();
			
			if(traza) {
				DatosSalida.imprimirTraza();
			}
		}
	}
}