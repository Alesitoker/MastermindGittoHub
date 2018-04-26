package jugadores.Tablero;

import java.util.LinkedList;

import interfaces.*;
import mastermind.*;
import static mastermind.ModoDeJuego.*;


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

	public CombinacionRespuesta lastCombinacion() {
		return combinaciones.getLast();
	}
	
	public void dibujar() {
		int i;
		String espacios = "   ";
		
		System.out.print("    ");
		combinacionOculta.dibujar();
		if (modo == MEDIO) {
			System.out.println("\n            ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		} else {
			System.out.println("\n            ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		}
		for (i = 0; i < combinaciones.size(); i++) {
			if (i >= 9)
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	
	public void dibujar_oculta() {
		combinacionOculta.dibujar();
	}
	
	public void dibujar_noOculta() {
		int i;
		String espacios = "   ";
		
		for (i = 0; i < combinaciones.size(); i++) {
			if (i >= 9)
				espacios = "  ";
			System.out.printf("%d%s", i+1, espacios);
			combinaciones.get(i).dibujar();
			System.out.println();
		}
	}
	
	public void dibujar_linea(int linea) {
		combinaciones.get(linea).dibujar();
	}
}
