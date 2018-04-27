package jugadores.Tablero;

import interfaces.Dibujable;
import static utilities.Constantes.*;
/**
 * Esta clase almacena un color.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Casilla implements Dibujable {
	/**
	 * Almacena un color.
	 */
	private String color;
	/**
	 * Contruye una Casilla con un color.
	 * @param color Color con el que se va a crear el objeto.
	 */
	public Casilla(String color) {
		this.color = color;
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
	 * Dibuja una casilla
	 */
	public void dibujar() {
		System.out.printf("%s%s%s", color, figura, RESET);
	}
	/**
	 * Dibuja una casilla de respuesta.
	 */
	public void Dibujar_respuesta() {
		
		if (!color.equals("vacio")) {
			System.out.printf("%s%s%s", color, figuraRespuesta, RESET);
		} else {
			System.out.printf("%s%s%s", GRIS, figuraRespuestaVacia, RESET);
		}
	}
}
