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
	
	public Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}

	public void addCombinacion(CombinacionRespuesta combinacion) { 
		combinaciones.addLast(combinacion);
	}
	
	public LinkedList<CombinacionRespuesta> getCombinaciones() {
		return combinaciones;
	}

	public Combinacion lastCombinacion() {
		return combinaciones.getLast();
	}
	
	public void addLastRespuesta(CombinacionRespuesta combinacion) {
		combinaciones.removeLast();
		addCombinacion(combinacion);		
	}
	
	public void dibujar() {
		int i;
		System.out.print("   ");
		combinacionOculta.dibujar();
		System.out.println();
		for (i = 0; i < combinaciones.size(); i++) {
			System.out.printf("%d  ", i+1);
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	
	public void dibujar_noOculta() {
		int i;
		
		for (i = 0; i < combinaciones.size(); i++) {
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	
	public void dibujar_linea(int linea) {
		combinaciones.get(linea).dibujar();
	}
}
