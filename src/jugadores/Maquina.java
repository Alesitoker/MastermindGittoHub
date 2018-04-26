package jugadores;

import java.util.*;

import jugadores.Tablero.*;
import mastermind.*;

public class Maquina extends Jugador {
	
	public Maquina(ModoDeJuego modo) {
		super(modo);
	}

	public void elegirCombinacion() {
		int i, opcion;
		String color = "";
		Random rnd = new Random();
		CombinacionRespuesta combinacion = new CombinacionRespuesta(modo.getNumCasillas());
		
		for (i = 0; i < modo.getNumCasillas(); i++) {
			opcion = rnd.nextInt(modo.getNumColores());
				color = eleccion((byte) opcion);
				combinacion.addFicha(color, i);
		}
		tablero.addCombinacion(combinacion);
	}

	public Combinacion elegirCombinacionOculta() {
		int i = 0, opcion;
		String color = "";
		Random rnd = new Random();
		HashMap<Integer, String> mapa = new HashMap<>();
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		
		do {
			opcion = rnd.nextInt(modo.getNumColores());
			color = eleccion((byte) opcion);
			
			if (modo != ModoDeJuego.DIFICIL) {
				if (!mapa.containsKey(opcion)) {
					combinacion.addFicha(color, i);
					mapa.put(opcion, color);
					i++;
				} 
			} else {
				combinacion.addFicha(color, i);
				i++;
			}
		} while (i < modo.getNumCasillas());
		combinacionPropia = combinacion;
		return combinacion;
	}

	public void indicarRespuesta(CombinacionRespuesta combinacionAdversario) {
		insertRespuesta(combinacionAdversario, comprobarRespuesta(combinacionAdversario));
	}
}
