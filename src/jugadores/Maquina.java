package jugadores;

import java.util.*;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.Colores;

public class Maquina extends Jugador {
	
	public Maquina(ModoDeJuego modo) {
		super(modo);
	}

	public void elegirCombinacion() {
		Random rnd = new Random();
		HashMap<String, Integer> mapa = new HashMap<>();
		
		
	}

	public void elegirCombinacionOculta() {
		
	}

	public CombinacionRespuesta indicarRespuesta(Combinacion combinacion) {
		boolean salir = false, comprobar;
		int i, j, contador = 0, negras = 0, blancas = 0, negrasBlancas[] = new int[modo.getNumCasillas()];
		CombinacionRespuesta respuesta = new CombinacionRespuesta(modo.getNumCasillas());
		Casillas combiAdversario[] = combinacion.getCombinacion();
		Casillas combiMia[] = tablero.lastCombinacion().getCombinacion();
		
		if (modo == ModoDeJuego.FACIL && modo == ModoDeJuego.MEDIO) {
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
		}
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
