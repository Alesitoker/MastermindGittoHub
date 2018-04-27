package jugadores;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.*;
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
	 * combinacion oculta que introduce el jugador.
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
	 * Compara la combinacion del adversario con la oculta para dar el numero de fichas en posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @param combinacionAdversario Ultima combinacion del adversario.
	 * @return El numero de fichas en la posicion correcta, en posicion incorrecta y si no hay ninguna.
	 * @since 1.0
	 */
	public int[] comprobarRespuesta(CombinacionRespuesta combinacionAdversario) {
		boolean salir = false, comprobar;
		int i, j, fichasRespuesta[] = new int[modo.getNumCasillas()];
		int respuestaCorrecta[] = new int[3];
		for (i = 0; i < modo.getNumCasillas(); i++) {
			for (j = 0; j < modo.getNumCasillas() && !salir; j++) {
				comprobar = combinacionPropia.oneFicha(i).equals(combinacionAdversario.oneFicha(j));
				if (comprobar && j == i) {
					// 1 == ficha colocada en posicion correcta.
					fichasRespuesta[i] = 1;
					salir = true;
				} else if (comprobar && j != i) {
					// 2 == ficha colocada en posicion incorrecta
					fichasRespuesta[i] = 2;
				}
			}
			comprobar = false;
			salir = false;
		}
		for (int c: fichasRespuesta) {
			if (c == 1)
				respuestaCorrecta[0]++;
			else if (c == 2)
				respuestaCorrecta[1]++;
			else
				respuestaCorrecta[2]++;
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
		
		do {
			if (RespuestaCorrecta[0] > 0) {
				combinacionAdversario.addRespuesta(Constantes.NEGRO, contador);
				RespuestaCorrecta[0]--;
			} else if (RespuestaCorrecta[1] > 0) {
				combinacionAdversario.addRespuesta(Constantes.GRIS, contador);
				RespuestaCorrecta[1]--;
			} else if (RespuestaCorrecta[2] > 0) {
				combinacionAdversario.addRespuesta("vacio", contador);
			}
			contador++;
		} while (contador < modo.getNumCasillas());
	}
	/**
	 * Cambia la opcion del jugador por un color.
	 * @param opcion Color elegido.
	 * @return El color elegido.
	 * @since 1.0
	 */
	protected String eleccion(byte opcion) {
		String color = "";

		switch (opcion) {
			case 0:
				color = Constantes.ROJO;
				break;
			case 1:
				color = Constantes.CELESTE;
				break;
			case 2:
				color = Constantes.AMARILLO;
				break;
			case 3:
				color = Constantes.COLORCARNE;
				break;
			case 4:
				color = Constantes.AZUL;
				break;
			case 5:
				color = Constantes.VIOLET;
				break;
			case 6:
				color = Constantes.LIGHT_GREEN;
				break;
			case 7:
				color = Constantes.BROWN;
				break;
			case 8:
				color = Constantes.NARANJA;
				break;
			case 9:
				color = Constantes.VERDE;
				break;
		}
		return color;
	}
}
