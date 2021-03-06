/**
 * @ (#) DatosSalida.java
 *
 * Clase DatosSalida.
 * Clase encargada de dar el formato visual a la solucion obtenida y guardar en un archivo de texto el resultado.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/29
 */
package sudoku9x9;
import java.io.FileWriter;
import java.io.IOException;

public class DatosSalida {
	
	private int[][] tablero;
	private String stringCompleto = "";
	private static String traza = "Traza\n";
	
	public DatosSalida(int tablero[][]) {
		
		this.tablero = tablero;
	}
	
	public void imprimirResultado() {
		
		for(int i = 0; i < 9; i++) {
			
			if(i % 3 == 0 && i != 0) {
				stringCompleto = stringCompleto + "---------------------------------\n";
			}
			for(int j = 0; j < 9; j++) {
				
				if(j % 3 == 0 && j != 0) {
					stringCompleto = stringCompleto + " | ";
				}
				stringCompleto = stringCompleto + " " + tablero[i][j] + " ";
			}
			stringCompleto = stringCompleto + "\n";
		}
		stringCompleto = stringCompleto + "---------------------------------";
		
		System.out.print(stringCompleto);
		imprimirArchivo(stringCompleto);
	}
	
	public static void imprimirArchivo(String stringCompleto) {
		
		try {
			FileWriter writer = new FileWriter("tableroSolucionado.txt");
			writer.write(stringCompleto);
			writer.close();
		} catch (IOException e) {
			System.out.print("Fallo en imprimir traza: " + e);
		}
	}
	
	
	
	public static void unirTraza(String pTraza) {
		traza += pTraza;
	}
	
	
	public static void imprimirTraza() {
		
		try {
			FileWriter writer = new FileWriter("Traza.txt");
			writer.write(traza);
			writer.close();
		} catch (IOException e) {
			System.out.print("Fallo en imprimir traza: " + e);
		}		
	}
	
	
	public static void imprimirAyuda() {
		
		System.out.println("Sintaxis para introducir correctamente los argumentos de entrada:\n"
				+ "java -jar sudoku.jar [-t] [-h] [fichero entrada]\n"
				+ "-t	Traza cada llamada recursiva y sus parametros.\n"
				+ "-h	Muestra esta ayuda\n"
				+ "[fichero entrada]	Tabla inicial del Sudoku\n");
	}
}