package mastermind;

import utilities.*;
import utilities.Teclado.*;
import jugadores.*;

import static mastermind.ModoDeJuego.*;
import static utilities.Constantes.*;
import static mastermind.Partida.ResultadoFinal.*;

public class Partida {
	private Jugador jugador[];
	private ModoDeJuego modo;
	private int turno;
	
	Partida(ModoDeJuego modo, Jugador jugador[]) {
		this.modo = modo;
		this.jugador = jugador;
	}
	
	public enum ResultadoFinal {
		GANADOR, PERDEDOR, EMPATE, GANADORMAQUINA;
	}
	
	public void empezarPartida() {
		ResultadoFinal resultado;
		
		if (modo == FACIL) {
			jugador[0].getTablero().setCombinacionOculta(jugador[1].elegirCombinacionOculta());
		} else {
			jugador[1].getTablero().setCombinacionOculta(jugador[0].elegirCombinacionOculta());
			jugador[0].getTablero().setCombinacionOculta(jugador[1].elegirCombinacionOculta());
		}
		
		if (modo == FACIL)
			resultado =	jugarFacil();
		else if (modo == MEDIO)
			resultado =	jugarMedio();
		else
			resultado = jugarDificil();
		
			finPartida(resultado);
	}

	private ResultadoFinal jugarFacil() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, elegido = false, mostrado = false;
		int respondido[] = new int[3];
		ResultadoFinal resultado = null;
		
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
							jugador[0].getTablero().dibujar_noOculta();
							System.out.printf("Nº Intentos: %d/%d\n\n", turno+1, modo.getNumIntentos());
						} else if (mostrado) {
							System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Constantes.ROJO, Constantes.RESET);
						} else {
							System.out.printf("%sDebes elegir colores primero%s\n", Constantes.ROJO, Constantes.RESET);
						}
						break;
					case 3:
						salir = true;
						break;
				}
			} else {
				jugador[0].elegirCombinacion();
				jugador[0].getTablero().dibujar();
				System.out.printf("Nº Intentos: %d/%d\n", turno+1, modo.getNumIntentos());
				elegido = true;
			}
			if (elegido) {
				jugador[1].indicarRespuesta(jugador[0].getTablero().lastCombinacion());
				turno++;
				elegido = false;
				mostrado = false;
				respondido = jugador[1].comprobarRespuesta(jugador[0].getTablero().lastCombinacion());
				if (jugador[0] instanceof Usuario && (respondido[1] == 0 && respondido[2] == 0)) {
					resultado = GANADOR;
					salir = true;
				} else if (respondido[1] == 0 && respondido[2] == 0) {
					resultado = PERDEDOR;
					salir = true;
				}
			}
			
		} while (!salir && turno < modo.getNumIntentos());
		if (jugador[0] instanceof Usuario && (resultado == null || turno == modo.getNumIntentos())) {
			resultado = PERDEDOR;
		} else {
			resultado = GANADOR;
		}
		return resultado;
	}
	private ResultadoFinal jugarMedio() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false, mostrado = false, elegido = false;
		int i, j, respondido[][] = new int[2][3];
		ResultadoFinal resultado = null;
		
		do {
			System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tablero\n\t3. Rendirse");
			opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
			switch (opcion) {
				case 1:
					for (i = 0; i < jugador.length; i++) {
						jugador[i].elegirCombinacion();
					}
					jugador[1].getTablero().dibujar();
					for (i = 0, j = jugador.length-1; i < jugador.length && j >= 0; i++, j--) {
						jugador[j].indicarRespuesta(jugador[i].getTablero().lastCombinacion());
					}
					turno++;
					elegido = true;
					break;
				case 2:
					if (!jugador[0].getTablero().getCombinaciones().isEmpty() && !mostrado) {
						dibujar();
						mostrado = true;
					} else if (mostrado) {
						System.out.printf("%sSolo puedes mostrar el tablero una vez por turno%s\n", Constantes.ROJO, Constantes.RESET);
					} else {
						System.out.printf("%sDebes elegir colores primero%s\n", Constantes.ROJO, Constantes.RESET);
					}
					break;
				case 3:
					salir = true;
					break;
			}
			if (elegido) {
				for (i = 0, j = jugador.length-1; i < respondido.length && j >= 0; i++, j--) {
					respondido[i] = jugador[i].comprobarRespuesta(jugador[j].getTablero().lastCombinacion());
				}
				if ((respondido[0][1] == 0 && respondido[0][2] == 0) && (respondido[1][1] == 0 && respondido[1][2] == 0)) {
					resultado = EMPATE;
					salir = true;
				} else if (respondido[0][1] == 0 && respondido[0][2] == 0) {
					resultado = GANADOR;
					salir = true;
				} else if (respondido[1][1] == 0 && respondido[1][2] == 0) {
					resultado = PERDEDOR;
					salir = true;
				}
				elegido = false;
				mostrado = false;
			}
		} while (!salir && turno < modo.getNumIntentos());
		if (resultado == null) {
			if (respondido[0][0] > respondido[1][0]) {
				resultado = GANADOR;
			} else if (respondido[0][0] < respondido[1][0]) {
				resultado = PERDEDOR;
			}
		}
		return resultado;
	}
	
	private ResultadoFinal jugarDificil() {
		boolean salir = false;
		int i, j, respondido[][] = new int[2][3];
		ResultadoFinal resultado = null;
		
		do {
			for (i = 0; i < jugador.length; i++) {
				jugador[i].elegirCombinacion();
			}
			for (i = 0, j = jugador.length-1; i < jugador.length && j >= 0; i++, j--) {
				jugador[j].indicarRespuesta(jugador[i].getTablero().lastCombinacion());
			}
			turno++;
			dibujar();
			for (i = 0, j = jugador.length-1; i < respondido.length && j >= 0; i++, j--) {
				respondido[i] = jugador[i].comprobarRespuesta(jugador[j].getTablero().lastCombinacion());
			}
			if ((respondido[0][1] == 0 && respondido[0][2] == 0) && (respondido[1][1] == 0 && respondido[1][2] == 0)) {
				resultado = EMPATE;
				salir = true;
			} else if ((respondido[0][1] == 0 && respondido[0][2] == 0)  || (respondido[1][1] == 0 && respondido[1][2] == 0)) {
				resultado = GANADORMAQUINA;
				salir = true;
			}
		} while (!salir);
		return resultado;
	}
	
	private void finPartida(ResultadoFinal resultado) {
		switch (resultado) {
			case GANADOR:
				System.out.println(AMARILLO +
						"      :::    :::     :::      ::::::::           ::::::::      :::     ::::    :::     :::     :::::::::   :::::::: \r\n" + 
						"     :+:    :+:   :+: :+:   :+:    :+:         :+:    :+:   :+: :+:   :+:+:   :+:   :+: :+:   :+:    :+: :+:    :+: \r\n" + 
						"    +:+    +:+  +:+   +:+  +:+                +:+         +:+   +:+  :+:+:+  +:+  +:+   +:+  +:+    +:+ +:+    +:+  \r\n" + 
						"   +#++:++#++ +#++:++#++: +#++:++#++         :#:        +#++:++#++: +#+ +:+ +#+ +#++:++#++: +#+    +:+ +#+    +:+   \r\n" + 
						"  +#+    +#+ +#+     +#+        +#+         +#+   +#+# +#+     +#+ +#+  +#+#+# +#+     +#+ +#+    +#+ +#+    +#+    \r\n" + 
						" #+#    #+# #+#     #+# #+#    #+#         #+#    #+# #+#     #+# #+#   #+#+# #+#     #+# #+#    #+# #+#    #+#     \r\n" + 
						"###    ### ###     ###  ########           ########  ###     ### ###    #### ###     ### #########   ########       \r\n" + 
						""+ RESET);
				break;
			case PERDEDOR:
				System.out.println(AZUL + 
						"     .'(    /`-.    )\\.--.         /`-.  )\\.---.   /`-.    )\\.-. .'(    )\\.-.   .-./(  \r\n" + 
						" ,') \\  ) ,' _  \\  (   ._.'      ,' _  \\(   ,-._(,' _  \\ ,'     )\\  ) ,'     ),'     ) \r\n" + 
						"(  '-' ( (  '-' (   `-.`.       (  '-' ( \\  '-, (  '-' ((  .-, ( ) ( (  .-, ((  .-, (  \r\n" + 
						" ) .-.  ) )   _  ) ,_ (  \\       ) ,._.'  ) ,-`  ) ,_ .' ) '._\\ )\\  ) ) '._\\ )) '._\\ ) \r\n" + 
						"(  ,  ) \\(  ,' ) \\(  '.)  )     (  '     (  ``-.(  ' ) \\(  ,   (  ) \\(  ,   ((  ,   (  \r\n" + 
						" )/    )/ )/    )/ '._,_.'       )/       )..-.( )/   )/ )/ ._.'   )/ )/ ._.' )/ ._.'  \r\n" + 
						"                                                                                       \r\n" + 
						""+ RESET);
				break;
			case EMPATE:
				System.out.println(NARANJA  + 
						"   ▄████████   ▄▄▄▄███▄▄▄▄      ▄███████▄    ▄████████     ███        ▄████████ \r\n" + 
						"  ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███   ███    ███ ▀█████████▄   ███    ███ \r\n" + 
						"  ███    █▀  ███   ███   ███   ███    ███   ███    ███    ▀███▀▀██   ███    █▀  \r\n" + 
						" ▄███▄▄▄     ███   ███   ███   ███    ███   ███    ███     ███   ▀  ▄███▄▄▄     \r\n" + 
						"▀▀███▀▀▀     ███   ███   ███ ▀█████████▀  ▀███████████     ███     ▀▀███▀▀▀     \r\n" + 
						"  ███    █▄  ███   ███   ███   ███          ███    ███     ███       ███    █▄  \r\n" + 
						"  ███    ███ ███   ███   ███   ███          ███    ███     ███       ███    ███ \r\n" + 
						"  ██████████  ▀█   ███   █▀   ▄████▀        ███    █▀     ▄████▀     ██████████ \r\n" + 
						"                                                                                \r\n" + 
						"" + RESET);
				break;
			default:
				break;
		}
		System.out.println("Informacion de la partida:");
		if (modo == FACIL) {
			jugador[0].getTablero().dibujar();
		} else {
			dibujar();
		}
	}
	
	public void dibujar() {
		int i, j;
		String espacios;
		
		if (modo == DIFICIL) {
			System.out.print("     ");
			jugador[0].getTablero().dibujar_oculta();
			System.out.println("\n               ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		}
		for (i = 0, j = jugador[1].getTablero().getCombinaciones().size()-1; i < jugador[0].getTablero().getCombinaciones().size() && j >= 0; i++, j--) {
			if (i < 9)
				espacios = "    ";
			else if (i < 100)
				espacios = "   ";
			else
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			jugador[0].getTablero().dibujar_linea(i);
			System.out.print("\t\t");
				if (j < 9)
					espacios = "    ";
				else if (j < 99)
					espacios = "   ";
				else
					espacios = "  ";
				System.out.printf("%d%s", jugador[1].getTablero().getCombinaciones().size()-i, espacios);
				jugador[1].getTablero().dibujar_linea(j);
				System.out.println();
		}
		if (modo == DIFICIL) {
			System.out.print("\t\t\t\t\t\t\t               ");
			System.out.print("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.print("\n\t\t\t\t\t\t\t     ");
			jugador[1].getTablero().dibujar_oculta();
		} else {
			System.out.print("\t\t\t\t\t               ");
			System.out.print("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.print("\n\t\t\t\t\t     ");
			jugador[1].getTablero().dibujar_oculta();
		}
		System.out.printf("\nNº Intentos: %d/%s\n", turno, modo == MEDIO ? modo.getNumIntentos() : "∞");
	}
	
}
