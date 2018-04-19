package jugadores;

import jugadores.Tablero.*;
import mastermind.*;
import utilities.*;
import utilities.Teclado.*;

public abstract class Jugador {
	protected Tablero tablero;
	protected ModoDeJuego modo;

	public Jugador(ModoDeJuego modo) {
		this.modo = modo;
		tablero = new Tablero(modo);
	}

	public abstract void elegirCombinacion();
	public abstract void elegirCombinacionOculta();
	public abstract CombinacionRespuesta indicarRespuesta(Combinacion combinacion);
	public void addCombinacion(CombinacionRespuesta combinacion) {
		tablero.addCombinacion(combinacion);
	}
	protected String eleccion() {
		byte opcion;
		final byte MINNUM = 1;
		String color = "";
		
		opcion = Teclado.rango(MINNUM,(byte) modo.getNumColores(), Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
		switch (opcion) {
			case 1:
				color = Colores.ROJO;
				break;
			case 2:
				color = Colores.VERDE;
				break;
			case 3:
				color = Colores.AMARILLO;
				break;
			case 4:
				color = Colores.MORADO;
				break;
			case 5:
				color = Colores.AZUL;
				break;
			case 6:
				color = Colores.VIOLET;
				break;
			case 7:
				color = Colores.LIGHT_GREEN;
				break;
			case 8:
				color = Colores.BROWN;
				break;
			case 9:
				color = Colores.NARANJA;
				break;
			case 10:
				color = Colores.CELESTE;
				break;
			}
		return color;
	}
}
