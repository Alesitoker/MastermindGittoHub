package jugadores.Tablero;

import java.util.Arrays;

import interfaces.Dibujable;
/**
 * Esta clase almacena una combinacion.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Combinacion implements Dibujable {
	/**
	 * Almacena una combinacion.
	 */
	protected Casilla combinacion[];
	/**
	 * Contruye un objeto Combinacion con la cantidad de casillas.
	 * @param numCasillas Cantidad de casillas para la combinacion.
	 */
	public Combinacion(int numCasillas) {
		combinacion = new Casilla[numCasillas];
	}
	/**
	 * Añade un color en la posicion indicada.
	 * @param color Color de la ficha.
	 * @param posicion La posicion del color.
	 * @since 1.0
	 */
	public void addFicha(String color, int posicion) {
		combinacion[posicion] = new Casilla(color);
	}
	/**
	 * Devuelve una ficha de la posicion indicada.
	 * @param posicion La posicion de la ficha en la combinacion.
	 * @return La ficha de la posicion pasada.
	 * @since 1.0
	 */
	public Casilla oneFicha(int posicion) {
		return combinacion[posicion];
	}
	/**
	 * Dibuja la combinacion.
	 * @since 1.0
	 */
	public void dibujar() {
		int i;
		
		System.out.print("|");
		for (i = 0; i < combinacion.length; i++) {
			combinacion[i].dibujar();
			System.out.print("|");
		}
	}
}
