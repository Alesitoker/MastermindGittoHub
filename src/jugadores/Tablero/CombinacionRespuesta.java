package jugadores.Tablero;
/**
 * Esta clase almacena una combinacion con su respuesta.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public class CombinacionRespuesta extends Combinacion {
	/**
	 * Almacena la respuesta de la combinacion.
	 */
	private Casilla respuesta[];
	/**
	 * Contruye un objeto CombinacionRespuesta con la cantidad de casillas.
	 * @param numCasillas Cantidad de casillas para la combinacion y la respuesta.
	 */
	public CombinacionRespuesta(int numCasillas) {
		super(numCasillas);
		respuesta = new Casilla[numCasillas];
	}
	/**
	 * Añade la respuesta en la posicion indicada.
	 * @param color Color de la respuesta.
	 * @param posicion Posicion de la respuesta.
	 * @since 1.0
	 */
	public void addRespuesta(String color, int posicion) {
		respuesta[posicion] = new Casilla(color);
	}
	/**
	 * Dibuja la combinacion junto a su respuesta.
	 * @since 1.0
	 */
	public void dibujar() {
		int i;
		System.out.print("|");
		for (i = 0; i < combinacion.length; i++) {
			combinacion[i].dibujar();
			System.out.print("|");
		}
		System.out.print("  ");
		for (i = 0; i < respuesta.length; i++) {
			if (respuesta[i] != null) {
				respuesta[i].Dibujar_respuesta();
				System.out.print(" ");
			}
		}
	}
}

