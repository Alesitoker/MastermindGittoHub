package jugadores;

import java.util.*;

import jugadores.Tablero.*;
import mastermind.*;
/**
 * Esta clase es el jugador Maquina de la partida.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Maquina extends Jugador {
	/**
	 * Contruye un objeto Maquina con el modo que se va a jugar.
	 * @param modo Modo de juego que se va a jugar.
	 */
	public Maquina(ModoDeJuego modo) {
		super(modo);
	}
	/**
	 * Elige una combinacion.
	 * @see #eleccion(byte)
	 * @since 1.0
	 */
	public void elegirCombinacion() {
		int i, opcion;
		String color = "";
		Random rnd = new Random();
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo.getNumCasillas());
		
		for (i = 0; i < modo.getNumCasillas(); i++) {
			opcion = rnd.nextInt(modo.getNumColores());
			color = eleccion((byte) opcion);
			combinacion.addFicha(color, i);
		}
		tablero.addCombinacion(combinacion);
	}
	/**
	 * Elige la combinacion oculta.
	 * @return La combinacion oculta elegida.
	 * @see #eleccion(byte)
	 * @since 1.0
	 */
	public Combinacion elegirCombinacionOculta() {
		int i = 0, opcion;
		String color = "";
		Random rnd = new Random();
		HashMap<Integer, String> mapa = new HashMap<>();
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		
		do {
			opcion = rnd.nextInt(modo.getNumColores());
			color = eleccion((byte) opcion);
			
			if (modo != ModoDeJuego.DIFICIL) {
				if (!mapa.containsKey(opcion)) {
					combinacion.addFicha(color, i);
					mapa.put(opcion, color);
					i++;
				} 
			} else {
				combinacion.addFicha(color, i);
				i++;
			}
		} while (i < modo.getNumCasillas());
		combinacionPropia = combinacion;
		return combinacion;
	}
	/**
	 * Indicar las fichas en la posicion correcta y en la posicion incorrecta de la combinacion del adversario con la oculta.
	 * @param combinacionAdversario Ultima combinacion del adversario.
	 * @see #comprobarRespuesta(CombinacionRespuesta)
	 * @see #insertRespuesta(CombinacionRespuesta, int[])
	 * @since 1.0
	 */
	public void indicarRespuesta(CombinacionRespuesta combinacionAdversario) {
		insertRespuesta(combinacionAdversario, comprobarRespuesta(combinacionAdversario));
	}
}
