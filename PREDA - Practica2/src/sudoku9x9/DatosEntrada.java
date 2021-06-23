/**
 * @ (#) DatosEntrada.java
 *
 * Clase DatosEntrada.
 * Clase encargada de leer los datos de un archivo para formar el tablero inicial.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/29
 */
package sudoku9x9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatosEntrada {
	
	public static int[][] leerArchivo(String nombreFichero) {
		
		try {
		Scanner scanner = new Scanner(new File(nombreFichero));
		String[][] datos = new String[9][9];
		int[][] tableroEntrada = new int[9][9];
		
		for(int i = 0; i < datos.length; i++) {
			for(int j = 0; j < datos[i].length; j++) {
				datos[i][j] = scanner.next();
			}
		}
		
		for(int i = 0; i < tableroEntrada.length; i++) {
			for(int j = 0; j < tableroEntrada[i].length; j++) {
				if(datos[i][j].equals("-")) {
					tableroEntrada[i][j] = 0;
				} else {
					tableroEntrada[i][j] = Integer.parseInt(datos[i][j]);
				}
			}			
		}
		scanner.close();
		
		return tableroEntrada;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}