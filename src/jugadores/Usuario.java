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
		Combinacion combinacion = new CombinacionRespuesta(modo.getNumCasillas());
		
		System.out.printf("Elige %d colores:\n", modo.getNumColores());
		System.out.printf("1. %s●%9$s  2. %s●%9$s  3. %s●%9$s  4. %s●%9$s\n5. %s●%9$s  6. %s●%9$s  7. %s●%9$s  8. %s●%9$s\n", ROJO, VERDE, AMARILLO, MORADO, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET);

		for (i = 0; i < modo.getNumCasillas(); i++) {
			color = eleccion();
			combinacion.addFicha(color, i);
		}
		tablero.addCombinacion(combinacion);
	}
	public void elegirCombinacionOculta() {
		int i = 0;
		String color = "";
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		HashMap<String, Integer> mapa = new HashMap<>();
		
		System.out.printf("Elige %d colores:\n", modo.getNumColores());
		System.out.printf("1. %s●%9$s  2. %s●%9$s  3. %s●%9$s  4. %s●%9$s\n5. %s●%9$s  6. %s●%9$s  7. %s●%9$s  8. %s●%9$s\n", ROJO, VERDE, AMARILLO, MORADO, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET);

		do {
			color = eleccion();
			if (!mapa.containsKey(color)) {
				combinacion.addFicha(color, i);
				mapa.put(color, i);
				i++;
			}
		} while (i < modo.getNumCasillas());
		tablero.setCombinacionOculta(combinacion);
	}
	public CombinacionRespuesta indicarRespuesta(Combinacion combinacion) {
		byte numNegras, numBlancas;
		int i, j, contador = 0, negras = 0, blancas = 0, negrasBlancas[] = new int[modo.getNumCasillas()];
		boolean salir = false, comprobar;
		CombinacionRespuesta respuesta = new CombinacionRespuesta(modo.getNumCasillas());
		Casillas combiAdversario[] = combinacion.getCombinacion();
		Casillas combiMia[] = tablero.lastCombinacion().getCombinacion();
		
		do {
			System.out.println("Introduce el numero de fichas negras:");
			numNegras = Teclado.leerNumeros(Tipo.BYTE);
			System.out.println("Introduce el numero de fichas blancas:");
			numBlancas = Teclado.leerNumeros(Tipo.BYTE);
			
			if ((numNegras + numBlancas) < modo.getNumCasillas()) {
				for (i = 0; i < modo.getNumCasillas(); i++) {
					for (j = 0; j < modo.getNumCasillas() && !salir; j++) {
						comprobar = combiMia[j].equals(combiAdversario[i]);
						if (comprobar && j == i) {
							negrasBlancas[i] = 1;
							salir = true;
						} else if (comprobar && j != i) {
							negrasBlancas[i] = 2;
						}
					}
					comprobar = false;
					salir = false;
				}
				for (int c : negrasBlancas) {
					if (c == 1)
						negras++;
					else if (c == 2)
						blancas++;
				}
				if (numNegras != negras || numBlancas != blancas)
					salir = false;
				else
					salir = true;
			}
		} while (!salir);
		salir = false;
		do {
			if (negras > 0) {
				respuesta.addRespuesta(Colores.NEGRO, contador);
				negras--;
			} else if (blancas > 0) {
				respuesta.addRespuesta(Colores.BLANCO, contador);
				blancas--;
			}
			if (blancas == 0 && negras == 0)
				salir = true;
			contador++;
		} while (!salir);
		
		return respuesta;
	}
}
