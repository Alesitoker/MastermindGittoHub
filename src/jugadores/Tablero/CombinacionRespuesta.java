package jugadores.Tablero;

import java.util.Arrays;
import mastermind.ModoDeJuego;

/**
 * Esta clase almacena una combinacion con su respuesta.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class CombinacionRespuesta extends Combinacion {
	/**
	 * Almacena la respuesta de la combinacion.
	 */
	private Casilla respuesta[];
	/**
	 * Almacena la posicion en la que hay que introducir el color de la respuesta.
	 */
	private int posicionRespuesta = 0;
	/**
	 * Contruye un objeto CombinacionRespuesta con el modo de juego para asignarle tamaño a la combinacion y la respuesta.
	 * @param modo Modo de juego de la partida que se va a jugar.
	 */
	public CombinacionRespuesta(ModoDeJuego modo) {
		super(modo);
		respuesta = new Casilla[modo.getNumCasillas()];
	}
	/**
	 * Modifica el atributo respuesta.
	 * @param respuesta La respuesta por la que se va a modificar.
	 * @since 1.0
	 */
	// se utiliza solo en las pruebas.
	public void setRespuesta(Casilla[] respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Añade la respuesta en la posicion indicada.
	 * @param posicion Posicion del color de la respuesta.
	 * @since 1.0
	 */
	public void addRespuesta(byte posicion) {
		if (posicionRespuesta < respuesta.length) {
			respuesta[posicionRespuesta] = new Casilla(posicion);
			posicionRespuesta++;
		}
		
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
		
		if(obj instanceof CombinacionRespuesta && super.equals(obj) && Arrays.equals(respuesta, ((CombinacionRespuesta) obj).respuesta) && posicionRespuesta == ((CombinacionRespuesta) obj).posicionRespuesta) {
			resultado=true;
		}
		return resultado;
	}	
	/**
	 * Dibuja la combinacion junto a su respuesta.
	 * @since 1.0
	 */
	public void dibujar() {
		int i;
		System.out.print("|");
		for (i = 0; i < combinacion.length; i++) {
			combinacion[i].dibujar();
			System.out.print("|");
		}
		System.out.print("  ");
		for (i = 0; i < respuesta.length; i++) {
			if (respuesta[i] != null) {
				respuesta[i].Dibujar_respuesta();
				System.out.print(" ");
			}
		}
	}
}

