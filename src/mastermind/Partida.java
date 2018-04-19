package mastermind;

import utilities.Teclado;
import utilities.Teclado.*;
import static mastermind.ModoDeJuego.*;

import jugadores.*;

public class Partida {
	Jugador jugador[] = new Jugador[2];
	private ModoDeJuego modo;
	
	Partida(ModoDeJuego modo, Jugador jugador[]) {
		this.modo = modo;
		this.jugador = jugador;
	}
	public void empezarPartida() {
		byte opcion;
		final byte MINNUM = 1, MAXNUM = 3;
		boolean salir = false;
		
		if (modo == FACIL) {
			jugador[1].elegirCombinacionOculta();
		} else {
			jugador[0].elegirCombinacionOculta();
			jugador[1].elegirCombinacionOculta();
		}
		
		do {
			if (jugador[0] instanceof Usuario) {
				System.out.println("Selecciona una opcion:\n\t1. Elegir colores\n\t2. Mostrar tablero\n\t3. Rendirse");
				opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
				switch (opcion) {
					case 1:
						jugador[0].elegirCombinacion();
						break;
					case 2:
						break;
					case 3:
						salir = true;
						break;
				}
				if (modo == MEDIO) {
					jugador[1].elegirCombinacion();
				}
			} else {
				if (modo == FACIL) {
					jugador[0].elegirCombinacion();
//					System.out.print("Combinacion oculta: ");
//					jugador[1].tablero.combinacionOculta.dibujar();
//					System.out.println();
//					jugador[0].tablero.combinaciones.getLast().dibujar();
//					System.out.println();
//					jugador[1].indicarRespuesta(modo.isRepeticion(), modo.getNumCasillas());
				} else {
					jugador[0].elegirCombinacion();
					jugador[1].elegirCombinacion();
				}
			}
//			if (modo == DIFICIL) {
//				System.out.println("Tablero jugador 1:\t\tTablero jugador 2:");
//				jugador[0].tablero.dibujar();
//				jugador[1].tablero.dibujar();
//				if (modo == MEDIO) {
//					
//				}
//			}
			
		} while (!salir);
	}
}
