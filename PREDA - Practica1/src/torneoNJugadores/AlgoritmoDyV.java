/**
 * @ (#) AlgoritmoDyV.java
 *
 * Clase AlgoritmoDyV.
 * Clase que implementa el algoritmo que resuelve el problema planteado por el enunciado de la Practica,
 * basandose en el esquema Divide y Venceras.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/11/28
 */
package torneoNJugadores;

public class AlgoritmoDyV {
	
	private static int llamada = 0;
	
	public static int[][] calcularTorneo(int n, int[][]tabla) {	
		
		
		if (n == 2) {													//caso base, 2 jugadores
			
			llamada++;
			DatosSalida.unirTraza("Llamada recursiva numero: " + llamada + ". Caso base: 2 jugadores\n");
			
			tabla[1][1] = 2;
			tabla[2][1] = 1;
		}
		else if (n % 2 != 0) {											//para numero impar de jugadores:
			calcularTorneo(n+1, tabla);									//llamada recursiva
			
			llamada++;
			DatosSalida.unirTraza("Llamada recursiva numero: " + llamada + ". Numero de jugadores en bucle:" + n + ".\n"
					+ "Se realiza la llamada a calcularTorneo sumandole 1\n");
			
			for(int jug = 1; jug <= n; jug++) {							//eliminamos el jugador n+1
				for(int dia = 1; dia <= n; dia++) {
					if (tabla[jug][dia] == n+1) {
						tabla[jug][dia] = 0;
					}
				}
			}
		} else {														//si numero par de jugadores:
			int m = n/2;
			calcularTorneo(m, tabla);									//1' cuadrante superior izquierdo
			
			llamada++;
			DatosSalida.unirTraza("Llamada recursiva numero: " + llamada + ". Numero de jugadores en bucle: " + m + ".\n"
					+ "Primero: Rellena el cuadrante superior izquierdo\n");
			
			if (m % 2 == 0) {
				
				DatosSalida.unirTraza("Segundo: Rellena el cuadrante inferior izquierdo\n");
				
				for(int jug = m+1; jug <= n; jug++) {					//2' cuadrante inferior izquierdo
					for(int dia = 1; dia <= m-1; dia++) {
						tabla[jug][dia] = tabla[jug-m][dia] + m;
					}
				}
				
				DatosSalida.unirTraza("Tercero: Rellena el cuadrante superior derecho\n");
				
				for(int jug = 1; jug <= m; jug++) {						//3' cuadrante superior derecho
					for(int dia = m; dia <= n-1; dia++) {
						if (jug + dia <= n) {
							tabla[jug][dia] = jug + dia;
						} else {
							tabla[jug][dia] = jug + dia - m;
						}
					}
				}
				
				DatosSalida.unirTraza("Cuarto:  Rellena el cuadrante inferior derecho\n");
				
				for(int jug = m+1; jug <= n; jug++) {					//4' cuadrante inferior derecho
					for(int dia = m; dia <= n-1; dia++) {
						if (jug > dia) {
							tabla[jug][dia] = jug - dia;
						} else {
							tabla[jug][dia] = (jug + m) - dia;
						}
					}
				}
			} else {													//si numero impar de jugadores:
				
				DatosSalida.unirTraza("Rellena el cuadrante inferior izquierdo. Jugador o Cero(descanso)\n");
				
				for(int jug = m+1; jug <= n; jug++) {					//1' cuadrante inferior izquierdo
					for(int dia = 1; dia <= m; dia++) {
						if (tabla[jug-m][dia] == 0) {
							tabla[jug][dia] = 0;
						} else {
							tabla[jug][dia] = tabla[jug-m][dia] + m;
						}
					}
				}
				
				DatosSalida.unirTraza("Jugadores que les corresponde Cero(descanso) en los cuadrantes izquierdos\n");
				
				for(int jug = 1; jug <= m; jug++) {						//2' ceros de los cuadrantes izquierdos
					for(int dia = 1; dia <= m; dia++) {
						if (tabla[jug][dia] == 0) {
							tabla[jug][dia] = jug + m;
							tabla[jug+m][dia] = jug;
						}
					}
				}
				
				DatosSalida.unirTraza("Rellena el cuadrante superior derecho\n");
				
				for(int jug = 1; jug <= m; jug++) {						//3' cuadrante superior derecho
					for(int dia = m+1; dia <= n-1; dia++) {
						if (jug + dia <= n) {
							tabla[jug][dia] = jug + dia;
						} else {
							tabla[jug][dia] = jug + dia - m;
						}
					}
				}
				
				DatosSalida.unirTraza("Rellena el cuadrante inferior derecho\n");
				
				for(int jug = m+1; jug <= n; jug++) {					//4' cuadrante inferior derecho
					for (int dia = m+1; dia <= n-1; dia++) {
						if (jug > dia) {
							tabla[jug][dia] = jug - dia;
						} else {
							tabla[jug][dia] = (jug + m) - dia;
						}
					}
				}
			}
		}
		return tabla;
	}
}