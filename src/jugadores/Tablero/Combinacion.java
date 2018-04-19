package jugadores.Tablero;

import interfaces.Dibujable;

public class Combinacion implements Dibujable {
	private Casillas combinacion[];

	public Combinacion(int numCasillas) {
		combinacion = new Casillas[numCasillas];
	}
	
	public void addFicha(String color, int posicion) {
		combinacion[posicion] = new Casillas(color);
	}
	
	public Casillas[] getCombinacion() {
		return combinacion;
	}
	
	public void dibujar() {
		
	}
}
