package jugadores.Tablero;

import java.util.LinkedList;

import interfaces.*;
import mastermind.*;

public class Tablero implements Dibujable, Dibujable_Tablero {
	private Combinacion combinacionOculta;
	private LinkedList<CombinacionRespuesta> combinaciones = new LinkedList<>();
	private ModoDeJuego modo;
	
	public Tablero(ModoDeJuego modo) {
		this.modo = modo;
	}

	public void setCombinacionOculta(Combinacion combinacionOculta) {
		this.combinacionOculta = combinacionOculta;
	}

	public void addCombinacion(CombinacionRespuesta combinacion) { 
		combinaciones.addLast(combinacion);
	}
	
	public Combinacion lastCombinacion() {
		return combinaciones.getLast();
	}
	
	public void dibujar() {
		
	}

	public void dibujar_linea(int linea) {
		
	}
}
