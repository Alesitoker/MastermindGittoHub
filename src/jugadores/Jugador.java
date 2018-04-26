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

	public abstract void indicarRespuesta(CombinacionRespuesta combinacion);
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public int[] comprobarRespuesta(CombinacionRespuesta combinacionAdversario) {
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
