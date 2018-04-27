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
	 * @see #eleccion(byte)
	 * @since 1.0
	 */
	public void elegirCombinacion() {
		int i;
		String color = "";
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo.getNumCasillas());

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		System.out.printf("1. %s%10$s%9$s  2. %s%10$s%9$s  3. %s%10$s%9$s  4. %s%10$s%9$s\n5. %s%10$s%9$s  6. %s%10$s%9$s  7. %s%10$s%9$s  8. %s%10$s%9$s\n", 
				ROJO, CELESTE, AMARILLO, COLORCARNE, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET, figura);

		for (i = 0; i < modo.getNumCasillas(); i++) {
			byte opcion;
			final byte MINNUM = 1;
			opcion = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			color = eleccion((byte) (opcion - 1));
			combinacion.addFicha(color, i);
		}
		tablero.addCombinacion(combinacion);
	}
	/**
	 * Se le muestra un menu al usuario, teniendo que elegir entre una de las opciones hasta formar la combinacion oculta.
	 * @return La combinacion oculta elegida.
	 * @see #eleccion(byte)
	 * @since 1.0
	 */
	public Combinacion elegirCombinacionOculta() {
		int i = 0;
		byte opcion;
		final byte MINNUM = 1;
		String color = "";
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		HashMap<String, Integer> mapa = new HashMap<>();

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		System.out.printf("1. %s%10$s%9$s  2. %s%10$s%9$s  3. %s%10$s%9$s  4. %s%10$s%9$s\n5. %s%10$s%9$s  6. %s%10$s%9$s  7. %s%10$s%9$s  8. %s%10$s%9$s\n", 
				ROJO, CELESTE, AMARILLO, COLORCARNE, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET, figura);

		do {
			opcion = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			color = eleccion((byte) (opcion - 1));
			if (!mapa.containsKey(color)) {
				combinacion.addFicha(color, i);
				mapa.put(color, i);
				i++;
			} else {
				System.out.println("No puedes repetir colores.");
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
		byte numPosicionCorrecta, numPosicionIncorrecta;
		int respuestaCorrecta[] = null;
		
		respuestaCorrecta = comprobarRespuesta(combinacionAdversario);
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
