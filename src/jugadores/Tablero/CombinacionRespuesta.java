package jugadores.Tablero;

public class CombinacionRespuesta extends Combinacion {
	private Casillas respuesta[];
	
	public CombinacionRespuesta(int numCasillas) {
		super(numCasillas);
		respuesta = new Casillas[numCasillas];
	}
	
	public void addRespuesta(String color, int posicion) {
		respuesta[posicion] = new Casillas(color);
	}
	
	public void dibujar() {
		
	}
}
