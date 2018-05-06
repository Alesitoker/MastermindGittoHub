package jugadores;

import static utilities.Constantes.*;

import java.util.HashMap;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.*;
import utilities.Teclado.*;
/**
 * Esta clase es el jugador Humano de la partida.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Usuario extends Jugador {
	/**
	 * Contruye un objeto Usuario con el modo que se va a jugar.
	 * @param modo Modo de juego que se va a jugar.
	 */
	public Usuario(ModoDeJuego modo) {
		super(modo);
	}
	/**
	 * Se le muestra un menu al usuario, teniendo que elegir entre una de las opciones hasta formar la combinacion.
	 * @since 1.0
	 */
	public void elegirCombinacion() {
		int i, color;
		final byte MINNUM = 1;
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo);

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		for (i = 0; i < modo.getNumColores(); i++) {
			System.out.printf("%d. %s%s%s ", i+1, Casilla.darColor(i), FIGURA, RESET);
			if (i == (modo.getNumColores()/2)-1)
				System.out.println();
		}
		System.out.println();

		for (i = 0; i < modo.getNumCasillas(); i++) {
			color = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			combinacion.addFicha(color - 1);
		}
		tablero.addCombinacion(combinacion);
	}
	/**
	 * Se le muestra un menu al usuario, teniendo que elegir entre una de las opciones hasta formar la combinacion oculta.
	 * @return La combinacion oculta elegida.
	 * @since 1.0
	 */
	public Combinacion elegirCombinacionOculta() {
		int i = 0, contador = 0, color;
		final byte MINNUM = 1;
		Combinacion combinacion = new Combinacion(modo);
		HashMap<Integer, Boolean> mapa = new HashMap<>();

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		for (i = 0; i < modo.getNumColores(); i++) {
			System.out.printf("%d. %s%s%s  ", i+1, Casilla.darColor(i), FIGURA, RESET);
			if (i == (modo.getNumColores()/2)-1)
				System.out.println();
		}
		System.out.println();

		do {
			color = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			color -= 1;
			if (!mapa.containsKey(color)) {
				combinacion.addFicha(color);
				mapa.put(color, true);
				contador++;
			} else {
				System.out.println("No puedes repetir colores.");
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
		byte numPosicionCorrecta, numPosicionIncorrecta;
		int respuestaCorrecta[] = comprobarRespuesta(combinacionAdversario);
		
		do {
			System.out.println("Introduce el numero de fichas colocadas en posicion correcta:");
			numPosicionCorrecta = Teclado.leerNumeros(Tipo.BYTE);
			if (numPosicionCorrecta != respuestaCorrecta[0])
				System.out.printf("%sEl numero de fichas no es correcto%s\n", Constantes.ROJO, Constantes.RESET);
		} while (numPosicionCorrecta != respuestaCorrecta[0]);
		do {
			System.out.println("Introduce el numero de fichas colocadas en posicion incorrecta:");
			numPosicionIncorrecta = Teclado.leerNumeros(Tipo.BYTE);
			if (numPosicionIncorrecta != respuestaCorrecta[1])
				System.out.printf("%sEl numero de fichas no es correcto%s\n", Constantes.ROJO, Constantes.RESET);
		} while (numPosicionIncorrecta != respuestaCorrecta[1]);
		insertRespuesta(combinacionAdversario, respuestaCorrecta);
	}
}
