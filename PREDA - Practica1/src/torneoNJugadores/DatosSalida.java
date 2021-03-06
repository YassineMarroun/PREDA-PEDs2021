/**
 * @ (#) DatosSalida.java
 *
 * Clase DatosSalida.
 * Clase encargada de dar el formato visual a la solucion obtenida y guardar en el archivo de salida.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/28
 */
package torneoNJugadores;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DatosSalida {
	
	private static String stringCompleto = "";
	private static String traza = "Traza\n";
	private static int numJugadores = 0;
	
	public static void imprimirCuadro(String jugadores[], int dias, int[][]tabla) {
		
		if(Arrays.asList(jugadores).contains("LIBRE")) {
			
			numJugadores = jugadores.length - 1;
		} else {
			numJugadores = jugadores.length;
		}
		imprimirResultado(jugadores, dias, tabla);
	}
		
	
	public static void imprimirResultado(String jugadores[], int dias, int[][]tabla) {
		
		int lineas = 0;
		
		stringCompleto += String.format("%26s", " ");
		for (int i=1; i <= dias; i++) {
			String dia = String.format("Dia: " + "%-11s", i);
			stringCompleto += dia;
			lineas = lineas + dia.length();
		}
		stringCompleto += String.format("\n%26s", " ");
		for (int i = 0; i <= lineas; i++) {
			stringCompleto += "-";
		}
		for (int fila = 1; fila <= numJugadores; fila++) {
			String jugador = String.format("\nJugador " + "%-18s", jugadores[fila-1]);
			stringCompleto += jugador;
			for (int columna = 1; columna <= dias; columna++) {
				int op = tabla[fila][columna];
				String oponente = String.format("%-16s", jugadores[op-1]);
				stringCompleto += oponente;
			}
			stringCompleto += String.format("\n%26s", " ");
			for (int i = 0; i <= lineas; i++) {
				stringCompleto += "-";
			}
		}
		System.out.print(stringCompleto);
		imprimirArchivo(stringCompleto);
	}
	
	
	public static void imprimirArchivo(String stringCompleto) {
		
		try {
			FileWriter writer = new FileWriter("Torneo de Tenis " + numJugadores + " Jugadores.txt");
			writer.write(stringCompleto);
			writer.close();
		} catch (IOException e) {
			System.out.print("Fallo creando torneo: " + e);
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
				+ "java -jar torneo.jar [-t] [-h] n [fichero entrada]\n"
				+ "-t	Traza la seleccion de jugadores\n"
				+ "-h	Muestra esta ayuda\n"
				+ "n	Numero de jugadores\n"
				+ "[fichero entrada]	Listado de los nombres de los jugadores del torneo\n");
	}
}