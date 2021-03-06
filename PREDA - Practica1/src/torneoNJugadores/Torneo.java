/**
 * @ (#) Torneo.java
 *
 * Clase Torneo.
 * Clase principal que inicia el programa. Recibe los datos de entrada,
 * y realiza la llamada a la clase que implementa el algoritmo.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/28
 */
package torneoNJugadores;

public class Torneo {
	
	public static void main(String[] args) {
		
		int indice = 0;
		int n = 0;
		String nombreFichero = "";
		String jugadores[] = null;
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
			n = Integer.valueOf(args[indice]);
			indice = indice + 1;
			
			if(args.length == indice + 1) {
				nombreFichero = args[indice];
				ficheroEntrada = true;
			}
			
			if (n % 2 != 0) {
				n = n + 1;
			}
			if(ficheroEntrada) {
				jugadores = DatosEntrada.leerArchivo(n, nombreFichero);
			} else {
				jugadores = DatosEntrada.introducirJugadores(n);
			}
			int dias = n-1;
			int[][] tabla = new int[n+1][dias+1];
				
			tabla = AlgoritmoDyV.calcularTorneo(n, tabla);
			DatosSalida.imprimirCuadro(jugadores, dias, tabla);
				
			if(traza) {
				DatosSalida.imprimirTraza();
			}
		}
	}	
}