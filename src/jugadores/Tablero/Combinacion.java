package jugadores.Tablero;

import java.util.Arrays;

import interfaces.Dibujable;

public class Combinacion implements Dibujable {
	protected Casilla combinacion[];

	public Combinacion() {
		
	}
	public Combinacion(int numCasillas) {
		combinacion = new Casilla[numCasillas];
	}
	
	public void addFicha(String color, int posicion) {
		combinacion[posicion] = new Casilla(color);
	}
	
	public Casilla[] getCombinacion() {
		return combinacion;
	}
	
	public Casilla oneFicha(int posicion) {
		return combinacion[posicion];
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if(obj instanceof Combinacion && Arrays.equals(combinacion, (Casilla[]) obj)) {
			resultado=true;
		}
		return resultado;
	}
	
	public void dibujar() {
		int i;
		
		System.out.print("|");
		for (i = 0; i < combinacion.length; i++) {
			combinacion[i].dibujar();
			System.out.print("|");
		}
	}
}
