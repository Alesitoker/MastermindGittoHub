package jugadores.Tablero;

import java.util.LinkedList;

import interfaces.*;
import mastermind.*;
import static mastermind.ModoDeJuego.*;
/**
 * Esta clase contiene las combinaciones del jugador.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Tablero implements Dibujable, Dibujable_Tablero {
	/**
	 * Combinacion oculta del jugador contrario.
	 */
	private Combinacion combinacionOculta;
	/**
	 * Combinaciones para adivinar la combinacion oculta con su respectiva respuesta.
	 */
	private LinkedList<CombinacionRespuesta> combinaciones = new LinkedList<>();
	/**
	 * Modo que se va a jugar.
	 */
	private ModoDeJuego modo;
	/**
	 * Contruye un Tablero con el modo que se va a jugar.
	 * @param modo Modo que se va a jugar.
	 */
	public Tablero(ModoDeJuego modo) {
		this.modo = modo;
	}
	/**
	 * Modifica la combinacion oculta.
	 * @param combinacionOculta Combinacion oculta elegida.
	 * @since 1.0
	 */
	public void setCombinacionOculta(Combinacion combinacionOculta) {
		this.combinacionOculta = combinacionOculta;
	}
	/**
	 * Devuelve la combinacion oculta.
	 * @return La combinacion oculta.
	 * @since 1.0
	 */
	public Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}
	/**
	 * Devuelve las combinaciones con su respuesta.
	 * @return Las combinaciones con su respuesta
	 * @since 1.0
	 */
	public LinkedList<CombinacionRespuesta> getCombinaciones() {
		return combinaciones;
	}
	/**
	 * Añade una combinacion con respuesta al tablero.
	 * @param combinacion Combinacion que se va a introducir al tablero.
	 * @since 1.0
	 */
	public void addCombinacion(CombinacionRespuesta combinacion) { 
		combinaciones.addLast(combinacion);
	}
	/**
	 * Devuelve la ultima combinacion introducida.
	 * @return La ultima combinacion con su respuesta.
	 * @since 1.0
	 */
	public CombinacionRespuesta lastCombinacion() {
		return combinaciones.getLast();
	}
	/**
	 * Dibuja el tablero.
	 * @since 1.0
	 */
	public void dibujar() {
		int i;
		String espacios = "   ";
		
		System.out.print("    ");
		combinacionOculta.dibujar();
		if (modo == MEDIO) {
			System.out.println("\n            ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		} else {
			System.out.println("\n            ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		}
		for (i = 0; i < combinaciones.size(); i++) {
			if (i >= 9)
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	/**
	 * Dibuja la combinacion oculta.
	 * @since 1.0
	 */
	public void dibujar_oculta() {
		combinacionOculta.dibujar();
	}
	/**
	 * Dibuja el tablero sin su combinacion oculta.
	 * @since 1.0
	 */
	public void dibujar_noOculta() {
		int i;
		String espacios = "   ";
		
		for (i = 0; i < combinaciones.size(); i++) {
			if (i >= 9)
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	/**
	 * Dibuja una linea del tablero.
	 * @param linea La linea que se va a dibujar.
	 * @since 1.0
	 */
	public void dibujar_linea(int linea) {
		combinaciones.get(linea).dibujar();
	}
}
