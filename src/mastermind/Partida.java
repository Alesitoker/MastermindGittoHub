package mastermind;

import utilities.*;
import utilities.Teclado.*;
import jugadores.*;
import interfaces.DibujablePartida;

import static mastermind.ModoDeJuego.*;
import static utilities.Constantes.*;

/**
 * Esta clase es donde se juega la partida.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Partida implements DibujablePartida{
	/**
	 * Los jugadores que van a jugar.
	 */
	private Jugador jugadores[] = new Jugador[2];
	/**
	 * El modo de la partida que se va a jugar.
	 */
	private ModoDeJuego modo;
	/**
	 * Los turnos de la partida.
	 */
	private int turno;
	/**
	 * Construye un nuevo objeto Partida con el modo de juego y los jugadores.
	 * @param modo El modo de juego.
	 * @param jugador1 El jugador 1 de la partida.
	 * @param jugador2 El jugador 2 de la partida.
	 */
	Partida(ModoDeJuego modo, Jugador jugador1, Jugador jugador2) {
		this.modo = modo;
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
	}
	/**
	 * Comienza una partida.
	 * @since 1.0
	 */
	public void empezarPartida() {
		ResultadoFinal resultado;

		if (modo == FACIL) {
			jugadores[0].getTablero().setCombinacionOculta(jugadores[1].elegirCombinacionOculta());
		} else {
			for (int i = 0, j = jugadores.length-1; i < jugadores.length && j >= 0; i++, j--)
				jugadores[i].getTablero().setCombinacionOculta(jugadores[j].elegirCombinacionOculta());
		}

		if (modo == FACIL)
			resultado = jugarFacil();
		else if (modo == MEDIO)
			resultado = jugarMedio();
		else
			resultado = jugarDificil();

		finPartida(resultado);
	}
	/**
	 * Juega una partida en modo facil.
	 * @return El resultado de la partida.
	 * @since 1.0
	 */
	private ResultadoFinal jugarFacil() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, elegido = false, mostrado = false;
		int respondido[] = new int[3];
		ResultadoFinal resultado = null;

		do {
			if (jugadores[0] instanceof Usuario) {
				System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tablero\n\t3. Rendirse");
				opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
				switch (opcion) {
					case 1:
						jugadores[0].elegirCombinacion();
						elegido = true;
						break;
					case 2:
						if (!jugadores[0].getTablero().noCombinaciones() && !mostrado) {
							jugadores[0].getTablero().dibujar_noOculta();;
							System.out.printf("Nº Intentos: %d/%d\n\n", turno, modo.getNumIntentos());
							mostrado = true;
						} else if (mostrado) {
							System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Constantes.ROJO,
									Constantes.RESET);
						} else {
							System.out.printf("%sDebes elegir colores primero%s\n", Constantes.ROJO, Constantes.RESET);
						}
						break;
					case 3:
						resultado = ResultadoFinal.PERDEDOR;
						salir = true;
						break;
				}
			} else {
				jugadores[0].elegirCombinacion();
				jugadores[0].getTablero().dibujar();
				System.out.printf("Nº Intentos: %d/%d\n", turno + 1, modo.getNumIntentos());
				elegido = true;
			}
			if (elegido) {
				jugadores[1].indicarRespuesta(jugadores[0].getTablero().lastCombinacion());
				turno++;
				elegido = false;
				mostrado = false;
				respondido = jugadores[1].comprobarRespuesta(jugadores[0].getTablero().lastCombinacion());
				if (jugadores[0] instanceof Usuario && (respondido[1] == 0 && respondido[2] == 0)) {
					resultado = ResultadoFinal.GANADOR;
					salir = true;
				} else if (respondido[1] == 0 && respondido[2] == 0) {
					resultado = ResultadoFinal.PERDEDOR;
					salir = true;
				}
			}

		} while (!salir && turno < modo.getNumIntentos());
		if (jugadores[0] instanceof Usuario && (resultado == null || turno == modo.getNumIntentos())) {
			resultado = ResultadoFinal.PERDEDOR;
		} else {
			resultado = ResultadoFinal.GANADOR;
		}
		return resultado;
	}
	/**
	 * Juega una partida en modo medio.
	 * @return El resultado de la partida.
	 * @since 1.0
	 */
	private ResultadoFinal jugarMedio() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, mostrado = false, elegido = false;
		int i, j, respondido[][] = new int[2][];
		ResultadoFinal resultado = null;

		do {
			System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tableros\n\t3. Rendirse");
			opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			switch (opcion) {
				case 1:
					for (i = 0; i < jugadores.length; i++) {
						jugadores[i].elegirCombinacion();
					}
					jugadores[1].getTablero().dibujar();
					for (i = 0, j = jugadores.length - 1; i < jugadores.length && j >= 0; i++, j--) {
						jugadores[j].indicarRespuesta(jugadores[i].getTablero().lastCombinacion());
					}
					turno++;
					elegido = true;
					break;
				case 2:
					if (!jugadores[0].getTablero().noCombinaciones() && !mostrado) {
						dibujar(resultado);
						mostrado = true;
					} else if (mostrado) {
						System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Constantes.ROJO,
								Constantes.RESET);
					} else {
						System.out.printf("%sDebes elegir colores primero%s\n", Constantes.ROJO, Constantes.RESET);
					}
					break;
				case 3:
					resultado = ResultadoFinal.PERDEDOR;
					salir = true;
					break;
			}
			if (elegido) {
				for (i = 0, j = jugadores.length - 1; i < respondido.length && j >= 0; i++, j--) {
					respondido[i] = jugadores[j].comprobarRespuesta(jugadores[i].getTablero().lastCombinacion());
				}
				if ((respondido[0][1] == 0 && respondido[0][2] == 0)
						&& (respondido[1][1] == 0 && respondido[1][2] == 0)) {
					resultado = ResultadoFinal.EMPATE;
					salir = true;
				} else if (respondido[0][1] == 0 && respondido[0][2] == 0) {
					resultado = ResultadoFinal.GANADOR;
					salir = true;
				} else if (respondido[1][1] == 0 && respondido[1][2] == 0) {
					resultado = ResultadoFinal.PERDEDOR;
					salir = true;
				}
				elegido = false;
				mostrado = false;
			}
		} while (!salir && turno < modo.getNumIntentos());
		if (resultado == null && turno == modo.getNumIntentos()) {
			if (respondido[0][0] > respondido[1][0])
				resultado = ResultadoFinal.GANADOR;
			else if (respondido[0][0] < respondido[1][0])
				resultado = ResultadoFinal.PERDEDOR;
			else if (respondido[0][0] == respondido[1][0]) {
				if (respondido[0][1] > respondido[1][1])
					resultado = ResultadoFinal.GANADOR;
				else if (respondido[0][1] < respondido[1][1])
					resultado = ResultadoFinal.PERDEDOR;
				else if (respondido[1][1] == respondido[1][1])
					resultado = ResultadoFinal.EMPATE;
			}	
		}
		return resultado;
	}
	/**
	 * Juega una partida en modo dificil.
	 * @return El resultado de la partida. 
	 * @since 1.0
	 */
	private ResultadoFinal jugarDificil() {
		boolean salir = false;
		int i, j, respondido[][] = new int[2][];
		ResultadoFinal resultado = null;

		do {
			for (i = 0; i < jugadores.length; i++) {
				jugadores[i].elegirCombinacion();
			}
			for (i = 0, j = jugadores.length - 1; i < jugadores.length && j >= 0; i++, j--) {
				jugadores[j].indicarRespuesta(jugadores[i].getTablero().lastCombinacion());
			}
			turno++;
			dibujar(resultado);
			for (i = 0, j = jugadores.length - 1; i < respondido.length && j >= 0; i++, j--) {
				respondido[i] = jugadores[j].comprobarRespuesta(jugadores[i].getTablero().lastCombinacion());
			}
			if ((respondido[0][1] == 0 && respondido[0][2] == 0) && (respondido[1][1] == 0 && respondido[1][2] == 0)) {
				resultado = ResultadoFinal.EMPATE;
				salir = true;
			} else if ((respondido[0][1] == 0 && respondido[0][2] == 0)
					|| (respondido[1][1] == 0 && respondido[1][2] == 0)) {
				resultado = ResultadoFinal.GANADORMAQUINA;
				salir = true;
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!salir || turno == 10);
		return resultado;
	}
	/**
	 * Muesta el resultado final de la partida con su informacion.
	 * @param resultado El resultado de la partida.
	 * @since 1.0
	 */
	private void finPartida(ResultadoFinal resultado) {
		switch (resultado) {
			case GANADOR:
				System.out.println(AMARILLO
						+ "      :::    :::     :::      ::::::::           ::::::::      :::     ::::    :::     :::     :::::::::   :::::::: \r\n"
						+ "     :+:    :+:   :+: :+:   :+:    :+:         :+:    :+:   :+: :+:   :+:+:   :+:   :+: :+:   :+:    :+: :+:    :+: \r\n"
						+ "    +:+    +:+  +:+   +:+  +:+                +:+         +:+   +:+  :+:+:+  +:+  +:+   +:+  +:+    +:+ +:+    +:+  \r\n"
						+ "   +#++:++#++ +#++:++#++: +#++:++#++         :#:        +#++:++#++: +#+ +:+ +#+ +#++:++#++: +#+    +:+ +#+    +:+   \r\n"
						+ "  +#+    +#+ +#+     +#+        +#+         +#+   +#+# +#+     +#+ +#+  +#+#+# +#+     +#+ +#+    +#+ +#+    +#+    \r\n"
						+ " #+#    #+# #+#     #+# #+#    #+#         #+#    #+# #+#     #+# #+#   #+#+# #+#     #+# #+#    #+# #+#    #+#     \r\n"
						+ "###    ### ###     ###  ########           ########  ###     ### ###    #### ###     ### #########   ########       \r\n"
						+ "" + RESET);
				break;
			case PERDEDOR:
				System.out.println(AZUL
						+ "     .'(    /`-.    )\\.--.         /`-.  )\\.---.   /`-.    )\\.-. .'(    )\\.-.   .-./(  \r\n"
						+ " ,') \\  ) ,' _  \\  (   ._.'      ,' _  \\(   ,-._(,' _  \\ ,'     )\\  ) ,'     ),'     ) \r\n"
						+ "(  '-' ( (  '-' (   `-.`.       (  '-' ( \\  '-, (  '-' ((  .-, ( ) ( (  .-, ((  .-, (  \r\n"
						+ " ) .-.  ) )   _  ) ,_ (  \\       ) ,._.'  ) ,-`  ) ,_ .' ) '._\\ )\\  ) ) '._\\ )) '._\\ ) \r\n"
						+ "(  ,  ) \\(  ,' ) \\(  '.)  )     (  '     (  ``-.(  ' ) \\(  ,   (  ) \\(  ,   ((  ,   (  \r\n"
						+ " )/    )/ )/    )/ '._,_.'       )/       )..-.( )/   )/ )/ ._.'   )/ )/ ._.' )/ ._.'  \r\n"
						+ "                                                                                       \r\n"
						+ "" + RESET);
				break;
			case EMPATE:
				System.out.println(
						NARANJA + "   ▄████████   ▄▄▄▄███▄▄▄▄      ▄███████▄    ▄████████     ███        ▄████████ \r\n"
								+ "  ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███   ███    ███ ▀█████████▄   ███    ███ \r\n"
								+ "  ███    █▀  ███   ███   ███   ███    ███   ███    ███    ▀███▀▀██   ███    █▀  \r\n"
								+ " ▄███▄▄▄     ███   ███   ███   ███    ███   ███    ███     ███   ▀  ▄███▄▄▄     \r\n"
								+ "▀▀███▀▀▀     ███   ███   ███ ▀█████████▀  ▀███████████     ███     ▀▀███▀▀▀     \r\n"
								+ "  ███    █▄  ███   ███   ███   ███          ███    ███     ███       ███    █▄  \r\n"
								+ "  ███    ███ ███   ███   ███   ███          ███    ███     ███       ███    ███ \r\n"
								+ "  ██████████  ▀█   ███   █▀   ▄████▀        ███    █▀     ▄████▀     ██████████ \r\n"
								+ "                                                                                \r\n"
								+ "" + RESET);
				break;
			default:
				break;
		}
		System.out.println("Informacion de la partida:");
		if (modo == FACIL) {
			jugadores[0].getTablero().dibujar();
		} else {
			dibujar(resultado);
		}
	}
	/**
	 * Dibuja los tableros de los jugadores uno al lado del otro.
	 * @param resultado El resultado de la partida.
	 * @since 1.0
	 */
	public void dibujar(ResultadoFinal resultado) {
		int i, j;
		String espacios;

		if (modo == DIFICIL) {
			System.out.print("     ");
			jugadores[0].getTablero().dibujar_oculta();
			System.out.println("\n               ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		} else if (resultado != null) {
			System.out.print("     ");
			jugadores[0].getTablero().dibujar_oculta();
			System.out.println("\n               ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		}
		for (i = 0, j = jugadores[1].getTablero().combinacionesSize() - 1; 
				i < jugadores[0].getTablero().combinacionesSize() && j >= 0; i++, j--) {
			if (i < 9)
				espacios = "    ";
			else if (i < 99)
				espacios = "   ";
			else
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			jugadores[0].getTablero().dibujar_linea(i);
			System.out.print("\t\t");
			if (j < 9)
				espacios = "    ";
			else if (j < 99)
				espacios = "   ";
			else
				espacios = "  ";
			System.out.printf("%d%s", jugadores[1].getTablero().combinacionesSize() - i, espacios);
			jugadores[1].getTablero().dibujar_linea(j);
			System.out.println();
			if (modo == DIFICIL) {
				try {
					Thread.sleep(2700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if (modo == DIFICIL) {
			System.out.print("\t\t\t\t\t\t\t               ");
			System.out.print("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.print("\n\t\t\t\t\t\t\t     ");
			jugadores[1].getTablero().dibujar_oculta();
		} else {
			System.out.print("\t\t\t\t\t               ");
			System.out.print("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.print("\n\t\t\t\t\t     ");
			jugadores[1].getTablero().dibujar_oculta();
		}
		System.out.printf("\nNº Intentos: %d/%s\n", turno, modo == MEDIO ? modo.getNumIntentos() : "∞");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
	}

}
