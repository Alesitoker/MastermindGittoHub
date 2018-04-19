package jugadores.Tablero;

public class Casillas {
	private String color;
	
	public Casillas(String color) {
		this.color = color;
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		if(obj instanceof Casillas && color.equals(((Casillas)obj).color)) {
			resultado=true;
		}
		return resultado;
	}

	public String getColor() {
		return color;
	}
	
}
