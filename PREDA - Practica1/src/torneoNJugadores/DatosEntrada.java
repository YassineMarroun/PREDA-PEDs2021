/**
 * @ (#) DatosEntrada.java
 *
 * Clase DatosEntrada.
 * Clase encargada de leer los datos de un archivo, o recoger los datos introducidos por consola,
 * para proceder a encuadrar el torneo.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/28
 */
package torneoNJugadores;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosEntrada {
	
	public static String[] leerArchivo(int n, String nombreFichero) {
		
		try {
			Scanner scanner = new Scanner(new File(nombreFichero));
			ArrayList<String> listaJugadores = new ArrayList<String>();
			while (scanner.hasNext()){
				listaJugadores.add(scanner.next());
			}
			if (listaJugadores.size() % 2 != 0) {
				listaJugadores.add("LIBRE");
			}
			String[] arrayJugadores = new String[n];
			listaJugadores.toArray(arrayJugadores);
			scanner.close();
		
			return arrayJugadores;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String[] introducirJugadores(int n) {
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduzca el nombre de cada jugador separado por espacio: ");
	        String jugadores = scanner.nextLine();
			ArrayList<String> listaJugadores = new ArrayList<String>(Arrays.asList(jugadores.split(" ")));
			
			if (listaJugadores.size() % 2 != 0) {
				listaJugadores.add("LIBRE");
			}
			String[] arrayJugadores = new String[n];
			listaJugadores.toArray(arrayJugadores);
			scanner.close();
			
	        return arrayJugadores;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}