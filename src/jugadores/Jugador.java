package jugadores;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.*;

public abstract class Jugador {
	protected Tablero tablero;
	protected ModoDeJuego modo;
	protected Combinacion combinacionPropia;
	
	public Jugador(ModoDeJuego modo) {
		this.modo = modo;
		tablero = new Tablero(modo);
	}

	public abstract void elegirCombinacion();

	public abstract Combinacion elegirCombinacionOculta();

	public abstract CombinacionRespuesta indicarRespuesta(Combinacion combinacion);
	
	public Tablero getTablero() {
		return tablero;
	}
	
	protected int[] comprobarRespuesta(Combinacion combinacionAdversario) {
		boolean salir = false, comprobar;
		int i, j, fichasRespuesta[] = new int[modo.getNumCasillas()];
		int respuestaCorrecta[] = new int[3];
		for (i = 0; i < modo.getNumCasillas(); i++) {
			for (j = 0; j < modo.getNumCasillas() && !salir; j++) {
				comprobar = combinacionPropia.oneFicha(i).equals(combinacionAdversario.oneFicha(j));
				if (comprobar && j == i) {
					fichasRespuesta[i] = 1;
					salir = true;
				} else if (comprobar && j != i) {
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

	protected CombinacionRespuesta insertRespuesta(Combinacion combinacionAdversario, int[] RespuestaCorrecta) {
		int contador = 0;
		CombinacionRespuesta respuesta = new CombinacionRespuesta(combinacionAdversario.getCombinacion());
		do {
			if (RespuestaCorrecta[0] > 0) {
				respuesta.addRespuesta(Colores.NEGRO, contador);
				RespuestaCorrecta[0]--;
			} else if (RespuestaCorrecta[1] > 0) {
				respuesta.addRespuesta(Colores.BLANCO, contador);
				RespuestaCorrecta[1]--;
			} else if (RespuestaCorrecta[2] > 0) {
				respuesta.addRespuesta("vacio", contador);
			}
			contador++;
		} while (contador < modo.getNumCasillas());
		return respuesta;
	}
	
	protected String eleccion(byte opcion) {
		String color = "";

		switch (opcion) {
			case 0:
				color = Colores.ROJO;
				break;
			case 1:
				color = Colores.VERDE;
				break;
			case 2:
				color = Colores.AMARILLO;
				break;
			case 3:
				color = Colores.MORADO;
				break;
			case 4:
				color = Colores.AZUL;
				break;
			case 5:
				color = Colores.VIOLET;
				break;
			case 6:
				color = Colores.LIGHT_GREEN;
				break;
			case 7:
				color = Colores.BROWN;
				break;
			case 8:
				color = Colores.NARANJA;
				break;
			case 9:
				color = Colores.CELESTE;
				break;
		}
		return color;
	}
}
