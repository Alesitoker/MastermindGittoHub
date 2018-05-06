package mastermind;

import utilities.Teclado;
import utilities.Teclado.*;

import static utilities.Constantes.*;

import jugadores.*;

import static mastermind.ModoDeJuego.*;
/**
 * Esta clase permite configurar la partida, mostrando menus.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class Menu {
	/**
	 * Configura una partida.
	 * @return Una partida configurada.
	 * @since 1.0
	 */
	public Partida configurarPartida() {
		final byte MINNUM = 1, MAXNUM = 3, JUGADORESMAX = 2;
		byte opcion, ju = 0, jm = 1;
		ModoDeJuego dificultad = null;
		boolean juega = true;
		Jugador jugador[] = new Jugador[2];
		int i;
		
		
		System.out.println("Elige el modo de juego:");
		System.out.printf("\t%s1. Facil%s\n\t%s2. Medio%2$s\n\t%s3. Dificil%2$s\n", LIGHT_GREEN, RESET, AMARILLO, ROJO);
		opcion = Teclado.rango(MINNUM, MAXNUM, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
		
		switch(opcion) {
			case 1:
				dificultad = FACIL;
				juega = Teclado.leerBoolean("¿Jugar o elegir combinacion oculta?", "Jugar", "Elegir Combinacion");
				if (!juega) {
					ju++;
					jm--;
				}
				break;
			case 2:
				dificultad = MEDIO;
				break;
			case 3:
				dificultad = DIFICIL;
				for (i = 0; i < JUGADORESMAX; i++) {
					jugador[i] = new Maquina(dificultad);
				}
				break;
		}
		if (dificultad == FACIL || dificultad == MEDIO) {
			jugador[ju] = new Usuario(dificultad);
			jugador[jm] = new Maquina(dificultad);
		}
		return new Partida(dificultad, jugador[0], jugador[1]);
	}
}
