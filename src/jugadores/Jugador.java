package jugadores;

import java.util.HashMap;

import jugadores.Tablero.*;
import mastermind.*;

/**
 * Esta clase es el jugador de la partida.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public abstract class Jugador {
	/**
	 * El tablero del jugador.
	 */
	protected Tablero tablero;
	/**
	 * Modo que se va a jugar.
	 */
	protected ModoDeJuego modo;
	/**
	 * combinacion oculta que es introducida por el propio jugador.
	 */
	protected Combinacion combinacionPropia;
	/**
	 * Construye un Jugador con el modo que se va a jugar.
	 * @param modo Modo de juego que se va a jugar.
	 */
	public Jugador(ModoDeJuego modo) {
		this.modo = modo;
		tablero = new Tablero(modo);
	}
	/**
	 * Elige una combinacion.
	 * @since 1.0
	 */
	public abstract void elegirCombinacion();
	/**
	 * Elige la combinacion oculta.
	 * @return La combinacion oculta elegida.
	 * @see Combinacion
	 * @since 1.0
	 */
	public abstract Combinacion elegirCombinacionOculta();
	/**
	 * Indicar las fichas en la posicion correcta y en la posicion incorrecta de la combinacion del adversario con la oculta.
	 * @param combinacionAdversario Ultima combinacion del adversario.
	 * @since 1.0
	 */
	public abstract void indicarRespuesta(CombinacionRespuesta combinacionAdversario);
	/**
	 * Devuelve el tablero del jugador.
	 * @return El tablero del jugador.
	 * @see Tablero
	 * @since 1.0
	 */
	public Tablero getTablero() {
		return tablero;
	}
	/**
	 * Modifica la combinacion oculta propia del jugador.
	 * @param combinacionPropia La nueva combinacion oculta propia.
	 * @since 1.0
	 */
	// se utiliza solo en las pruebas.
	public void setCombinacionPropia(Combinacion combinacionPropia) {
		this.combinacionPropia = combinacionPropia;
	}
	/**
	 * Compara la combinacion del adversario con la oculta para dar el numero de fichas en posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @param combinacionAdversario Ultima combinacion del adversario.
	 * @return El numero de fichas en la posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @since 1.0
	 */
	public int[] comprobarRespuesta(CombinacionRespuesta combinacionAdversario) {
		boolean salir = false;
		int i, j;
		int respuestaCorrecta[] = new int[3];
		HashMap<Integer, Casilla> mapaOculta = new HashMap<>();
		HashMap<Integer, Casilla> mapaAdversario = new HashMap<>();
		
		for (i = 0; i < modo.getNumCasillas(); i++) {
			mapaOculta.put(i, combinacionPropia.oneFicha(i));
			mapaAdversario.put(i, combinacionAdversario.oneFicha(i));
		}
		
		for (i = 0; i < modo.getNumCasillas(); i++) {
			if (mapaOculta.get(i).equals(mapaAdversario.get(i))) {
				respuestaCorrecta[0]++;
				mapaOculta.remove(i);
				mapaAdversario.remove(i);
			}
		}
		if (!mapaOculta.isEmpty() && !mapaAdversario.isEmpty()) {
			for (i = 0; i < modo.getNumCasillas(); i++) {
				if (mapaOculta.containsKey(i)) {
					for (j = 0; j < modo.getNumCasillas() && !salir; j++) {
						if (mapaAdversario.containsKey(j)) {
							if (mapaOculta.get(i).equals(mapaAdversario.get(j))) {
								respuestaCorrecta[1]++;
								mapaOculta.remove(i);
								mapaAdversario.remove(j);
								salir = true;
							}
						}
					}
					salir = false;
				}
			}
		}
		
		if (respuestaCorrecta[0] + respuestaCorrecta[1] < modo.getNumCasillas()) {
			respuestaCorrecta[2] = modo.getNumCasillas() - (respuestaCorrecta[0] + respuestaCorrecta[1]);
		}
		
		return respuestaCorrecta;
	}
	/**
	 * Introduce en la respuesta el numero de fichas en posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @param combinacionAdversario Ultima combinacion del adversario.
	 * @param RespuestaCorrecta	El numero de fichas en la posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @since 1.0
	 */
	protected void insertRespuesta(CombinacionRespuesta combinacionAdversario, int[] RespuestaCorrecta) {
		int contador = 0;
		final byte FICHAPOSICIONCORRECTA = 0, FICHAPOSICIONINCORRECTA = 1, NOHAYFICHA = 2;
		
		do {
			if (RespuestaCorrecta[0] > 0) {
				combinacionAdversario.addRespuesta(FICHAPOSICIONCORRECTA);
				RespuestaCorrecta[0]--;
			} else if (RespuestaCorrecta[1] > 0) {
				combinacionAdversario.addRespuesta(FICHAPOSICIONINCORRECTA);
				RespuestaCorrecta[1]--;
			} else {
				combinacionAdversario.addRespuesta(NOHAYFICHA);
			}
			contador++;
		} while (contador < modo.getNumCasillas());
	}
}
