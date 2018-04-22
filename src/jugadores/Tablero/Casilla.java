package jugadores.Tablero;

import interfaces.Dibujable;
import utilities.Colores;

public class Casilla implements Dibujable {
	private String color;
	
	public Casilla(String color) {
		this.color = color;
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if(obj instanceof Casilla && color.equals(((Casilla)obj).color)) {
			resultado=true;
		}
		return resultado;
	}

	public String getColor() {
		return color;
	}

	public void dibujar() {
		String figura = "⬤";
		
		System.out.printf("%s%s%s", color, figura, Colores.RESET);
	}
	
	public void Dibujar_respuesta() {
		String figura = "⬟";
		String figuraVacia = "⬠";
		
		if (!color.equals("vacio")) {
			System.out.printf("%s%s%s", color, figura, Colores.RESET);
		} else {
			System.out.printf("%s ", figuraVacia);
		}
	}
}
