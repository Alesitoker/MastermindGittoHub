package mastermind;

import utilities.*;
import utilities.Teclado.*;
import static mastermind.ModoDeJuego.*;

import jugadores.*;

public class Partida {
	Jugador jugador[];
	private ModoDeJuego modo;

	Partida(ModoDeJuego modo, Jugador jugador[]) {
		this.modo = modo;
		this.jugador = jugador;
	}

	public void empezarPartida() {

		if (modo == FACIL) {
			jugador[0].getTablero().setCombinacionOculta(jugador[1].elegirCombinacionOculta());
		} else {
			jugador[1].getTablero().setCombinacionOculta(jugador[0].elegirCombinacionOculta());
			jugador[0].getTablero().setCombinacionOculta(jugador[1].elegirCombinacionOculta());
		}
		
		if (modo == FACIL)
			jugarFacil();
		else
			jugarMedio();
		
		finPartida();
	}

	private void jugarFacil() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, elegido = false, mostrado = false;
		int contador = 1;
		
		do {
			if (jugador[0] instanceof Usuario) {
				System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tablero\n\t3. Rendirse");
				opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
				switch (opcion) {
					case 1:
						jugador[0].elegirCombinacion();
						elegido = true;
						break;
					case 2:
						if (!jugador[0].getTablero().getCombinaciones().isEmpty() && !mostrado) {
							jugador[0].getTablero().dibujar();
							System.out.printf("Nº Intentos: %d/%d", contador+1, modo.getNumIntentos());
						} else if (mostrado) {
							System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Colores.ROJO, Colores.RESET);
						} else {
							System.out.printf("%sDebes elegir  colores primero%s\n", Colores.ROJO, Colores.RESET);
						}
						break;
					case 3:
						salir = true;
						break;
				}
			} else {
				jugador[0].elegirCombinacion();
				jugador[0].getTablero().dibujar();
				elegido = true;
			}
			if (elegido) {
				jugador[0].getTablero().addLastRespuesta(jugador[1].indicarRespuesta(jugador[0].getTablero().lastCombinacion()));
				contador++;
				elegido = false;
				mostrado = false;
//				if () {
//					salir = true;
//				}
			}
			
		} while (!salir && contador < modo.getNumIntentos());
	}
	private void jugarMedio() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, elegido = false, mostrado = false;
		int contador = 1, i, j;
		
		do {
			System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tablero\n\t3. Rendirse");
			opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			switch (opcion) {
				case 1:
					for (i = 0; i < jugador.length; i++) {
						jugador[j].elegirCombinacion();
					}
					for (i = 0, j = 1; i < jugador.length && j > jugador.length; i++, j--) {
						jugador[i].getTablero().addLastRespuesta(jugador[j].indicarRespuesta(jugador[i].getTablero().lastCombinacion()));
					}
					contador++;
					mostrado = false;
					break;
				case 2:
					if (!jugador[0].getTablero().getCombinaciones().isEmpty() && !mostrado) {
						System.out.println(jugador[1].getTablero().getCombinacionOculta());
						for (i = 0; i < jugador[0].getTablero().getCombinaciones().size(); i++) {
							for (j = 0; j < jugador.length; j++) {
								jugador[j].getTablero().dibujar_linea(i);
								System.out.print("\t\t");
							}
							System.out.printf("Nº Intentos: %d/%d", contador+1, modo.getNumIntentos());
							mostrado = true;
						}
					} else if (mostrado) {
						System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Colores.ROJO, Colores.RESET);
					} else {
						System.out.printf("%sDebes elegir  colores primero%s\n", Colores.ROJO, Colores.RESET);
					}
					break;
				case 3:
					salir = true;
					break;
			}
//			if () {
//				
//			}
		} while (!salir && contador < modo.getNumIntentos());
	}
	
	private void finPartida() {
		
	}
	
}
