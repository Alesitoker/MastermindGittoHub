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
	 * @since 1.0
	 */
	public void elegirCombinacion() {
		int i, color;
		Random rnd = new Random();
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo);
		
		for (i = 0; i < modo.getNumCasillas(); i++) {
			color = rnd.nextInt(modo.getNumColores());
			combinacion.addFicha(color);
		}
		tablero.addCombinacion(combinacion);
	}
	/**
	 * Elige la combinacion oculta.
	 * @return La combinacion oculta elegida.
	 * @since 1.0
	 */
	public Combinacion elegirCombinacionOculta() {
		int contador = 0, color;
		Random rnd = new Random();
		HashMap<Integer, Boolean> mapa = new HashMap<>();
		Combinacion combinacion = new Combinacion(modo);
		
		do {
			color = rnd.nextInt(modo.getNumColores());
			
			if (modo != ModoDeJuego.DIFICIL) {
				if (!mapa.containsKey(color)) {
					combinacion.addFicha(color);
					mapa.put(color, true);
					contador++;
				} 
			} else {
				combinacion.addFicha(color);
				contador++;
			}
		} while (contador < modo.getNumCasillas());
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
