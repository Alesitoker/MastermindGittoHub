package jugadores.Tablero;

import java.util.Arrays;

import interfaces.Dibujable;
import mastermind.ModoDeJuego;

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
	 * Almacena la posicion en la que hay que introducir el color.
	 */
	protected int posicion = 0;
	/**
	 * Contruye un objeto Combinacion con el modo de juego para asignarle el tamaño a la combinacion.
	 * @param modo Modo de juego de la partida que se va a jugar.
	 */
	public Combinacion(ModoDeJuego modo) {
		combinacion = new Casilla[modo.getNumCasillas()];
	}
	/**
	 * Modifica el atributo combinacion.
	 * @param combinacion La combinacion por la que se va a modificar.
	 * @since 1.0
	 */
	// Se utiliza solo en las pruebas.
	public void setCombinacion(Casilla[] combinacion) {
		this.combinacion = combinacion;
	}
	/**
	 * Añade un color en la posicion indicada.
	 * @param posicion Posicion del color de la ficha.
	 * @since 1.0
	 */
	public void addFicha(int posicion) {
		if (this.posicion < combinacion.length) {
			combinacion[this.posicion] = new Casilla(posicion);
			this.posicion++;
		}
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
	 * Compara este número con el objeto especificado
	 * @param obj	El objeto a comparar. Puede ser null
	 * @return 		true: si son iguales. 
	 * 				false: si son diferentes. 
	 * @since 		1.0
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if(obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion)obj).combinacion) && posicion == ((Combinacion) obj).posicion) {
			resultado=true;
		}
		return resultado;
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
