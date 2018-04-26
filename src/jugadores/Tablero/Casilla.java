package jugadores.Tablero;

import interfaces.Dibujable;
import static utilities.Constantes.*;

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
		System.out.printf("%s%s%s", color, figura, RESET);
	}
	
	public void Dibujar_respuesta() {
		
		if (!color.equals("vacio")) {
			System.out.printf("%s%s%s", color, figuraRespuesta, RESET);
		} else {
			System.out.printf("%s%s%s", GRIS, figuraRespuestaVacia, RESET);
		}
	}
}
