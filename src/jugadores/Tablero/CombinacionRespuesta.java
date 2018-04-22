package jugadores.Tablero;

public class CombinacionRespuesta extends Combinacion {
	private Casilla respuesta[];
	
	public CombinacionRespuesta(int numCasillas) {
		super(numCasillas);
//		respuesta = new Casilla[numCasillas];
	}
	
	public CombinacionRespuesta(Casilla[] combinacion) {
		super();
		this.combinacion=combinacion;
		respuesta = new Casilla[combinacion.length];
	}

	public void addRespuesta(String color, int posicion) {
		respuesta[posicion] = new Casilla(color);
	}
	
	public Casilla[] getRespuesta() {
		return respuesta;
	}
	
	public Casilla oneRespuesta(int posicion) {
		return respuesta[posicion];
	}
	
	public void dibujar() {
		int i;
		System.out.print("|");
		for (i = 0; i < combinacion.length; i++) {
			combinacion[i].dibujar();
			System.out.print("|");
		}
		System.out.print("  ");
		if (respuesta != null) {
			for (i = 0; i < respuesta.length; i++) {
				respuesta[i].Dibujar_respuesta();
				System.out.print(" ");
			}
		}
	}
}
