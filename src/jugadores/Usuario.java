package jugadores;

import static utilities.Colores.*;

import java.util.HashMap;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.*;
import utilities.Teclado.*;

public class Usuario extends Jugador {

	public Usuario(ModoDeJuego modo) {
		super(modo);
	}
	
	public void elegirCombinacion() {
		int i;
		String color = "";
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo.getNumCasillas());

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		System.out.printf("1. %s⬤%9$s  2. %s⬤%9$s  3. %s⬤%9$s  4. %s⬤%9$s\n5. %s⬤%9$s  6. %s⬤%9$s  7. %s⬤%9$s  8. %s⬤%9$s\n", ROJO, VERDE, AMARILLO, MORADO, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET);

		for (i = 0; i < modo.getNumCasillas(); i++) {
			byte opcion;
			final byte MINNUM = 1;
			opcion = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			color = eleccion((byte) (opcion - 1));
			combinacion.addFicha(color, i);
		}
		tablero.addCombinacion(combinacion);
	}

	public Combinacion elegirCombinacionOculta() {
		int i = 0;
		byte opcion;
		final byte MINNUM = 1;
		String color = "";
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		HashMap<String, Integer> mapa = new HashMap<>();

		System.out.printf("Elige %d colores:\n", modo.getNumCasillas());
		System.out.printf("1. %s⬤%9$s  2. %s⬤%9$s  3. %s⬤%9$s  4. %s⬤%9$s\n5. %s⬤%9$s  6. %s⬤%9$s  7. %s⬤%9$s  8. %s⬤%9$s\n", ROJO, VERDE, AMARILLO, MORADO, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET);

		do {
			opcion = Teclado.rango(MINNUM, (byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			color = eleccion((byte) (opcion - 1));
			if (!mapa.containsKey(color)) {
				combinacion.addFicha(color, i);
				mapa.put(color, i);
				i++;
			}
		} while (i < modo.getNumCasillas());
		combinacionPropia = combinacion;
		return combinacion;
	}

	public CombinacionRespuesta indicarRespuesta(Combinacion combinacionAdversario) {
		byte numPosicionCorrecta, numPosicionIncorrecta;
		int respuestaCorrecta[] = null;
		
		respuestaCorrecta = comprobarRespuesta(combinacionAdversario);
		do {
			System.out.println("Introduce el numero de fichas colocadas en posicion correcta:");
			numPosicionCorrecta = Teclado.leerNumeros(Tipo.BYTE);
			if (numPosicionCorrecta != respuestaCorrecta[0])
				System.out.printf("%sEl numero de fichas no es correcto%s", Colores.ROJO, Colores.RESET);
		} while (numPosicionCorrecta != respuestaCorrecta[0]);
		do {
			System.out.println("Introduce el numero de fichas colocadas en posicion incorrecta:");
			numPosicionIncorrecta = Teclado.leerNumeros(Tipo.BYTE);
			if (numPosicionIncorrecta != respuestaCorrecta[1])
				System.out.printf("%sEl numero de fichas no es correcto%s", Colores.ROJO, Colores.RESET);
		} while (numPosicionIncorrecta != respuestaCorrecta[1]);
		return insertRespuesta(combinacionAdversario, respuestaCorrecta);
	}
}
