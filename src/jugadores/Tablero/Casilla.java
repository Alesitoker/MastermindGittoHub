package jugadores.Tablero;

import static utilities.Constantes.*;

import interfaces.DibujableFichaRespuesta;

/**
 * Esta clase almacena un color.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Casilla implements DibujableFichaRespuesta {
	/**
	 * Almacena los colores posibles de las casillas.
	 */
	private static String colores[] = {ROJO, CELESTE, AMARILLO, ROJOPERONO, AZUL, VIOLET, LIGHT_GREEN, BROWN, NARANJA, VERDE};
	/**
	 * Almacena los colores de las respuestas.
	 */
	private static String coloresRespuesta[] = {NEGRO, GRIS, VACIO};
	/**
	 * Almacena un color.
	 */
	private String color;
	/**
	 * Contruye una Casilla con un color.
	 * @param color El número que sera el color de la casilla.
	 */
	public Casilla(int color) {
		addColor(color);
	}
	/**
	 * Construye una casilla con el color de una respuesta.
	 * @param respuesta El número que sera el color de la casilla.
	 */
	public Casilla(byte respuesta) {
		addColorRespuesta(respuesta);
	}
	/**
	 * Compara este número con el objeto especificado
	 * @param obj	El objeto a comparar. Puede ser null
	 * @return 		true: si son iguales.
	 * 				false: si son diferentes.
	 * @since 		1.0
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if(obj instanceof Casilla && color.equals(((Casilla)obj).color)) {
			resultado=true;
		}
		return resultado;
	}
	/**
	 * Devuelve el color de colores de la posición dada.
	 * @param posicion La posición para obtener el color.
	 * @return El color de la posición dada.
	 * @since 1.0
	 */
	public static String darColor(int posicion) {
		return colores[posicion];
	}
	/**
	 * Asigna en el atributo color el color del array indicado por la posición del parametro.
	 * @param posicion La posición del array que contiene el color.
	 * @since 1.0
	 */
	private void addColor(int posicion) {
		final int MAXCOLORES = 10;
		if (posicion < MAXCOLORES)
			this.color = colores[posicion];
		else {
			throw new IllegalArgumentException("La posición no puede ser mayor al numero de colores maximos");
		}
	}
	/**
	 * Asigna en el atributo color el color de la respuesta indicado por la posición del parametro.
	 * @param posicion La posición que indica el color.
	 * @since 1.0
	 */
	private void addColorRespuesta(int posicion) {
		final int MAXRESPUESTA = 3;
		if (posicion < MAXRESPUESTA)
			color = coloresRespuesta[posicion];
		else {
			throw new IllegalArgumentException("La posición no puede ser mayor al numero de respuestas posibles");
		}
	}
	/**
	 * Dibuja una casilla
	 * @since 1.0
	 */
	public void dibujar() {
		System.out.printf("%s%s%s", color, FIGURA, RESET);
	}
	/**
	 * Dibuja una casilla de respuesta.
	 * @since 1.0
	 */
	public void DibujarRespuesta() {
		
		if (!color.equals("vacio")) {
			System.out.printf("%s%s%s", color, FIGURARESPUESTA, RESET);
		} else {
			System.out.printf("%s%s%s", GRIS, FIGURARESPUESTAVACIA, RESET);
		}
	}
}
