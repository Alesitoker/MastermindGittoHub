package mastermind;
/**
 * Esta clase permite configurar la partida, mostrando menus.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public enum ModoDeJuego {
	FACIL(4, 8, 10, false), MEDIO(5, 8, 15, false), DIFICIL(8, 10, 0, true);
	/**
	 * Almacena el numero de casillas.
	 */
	private int numCasillas;
	/**
	 * Almacena el numero de colores.
	 */
	private int numColores;
	/**
	 * Almacena el numero de intentos.
	 */
	private int numIntentos;
	/**
	 * Almacena si hay repeticion de colores.
	 */
	private boolean repeticion;
	/**
	 * Configura el modoDeJuego.
	 * @param numCasillas El numero de casillas del modo que se va a jugar.
	 * @param numColores El numero de colores del modo que se va a jugar.
	 * @param numIntentos El numero de intentos del modo que se va a jugar.
	 * @param repeticion Si hay repeticion de colores en el modo que se va a jugar.
	 * @since 1.0
	 */
	ModoDeJuego(int numCasillas, int numColores, int numIntentos, boolean repeticion) {
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.numIntentos = numIntentos;
		this.repeticion = repeticion;
	}
	/**
	 * Devuelve el numero de casillas del modo que se va a jugar.
	 * @return El numero de casillas.
	 * @since 1.0
	 */
	public int getNumCasillas() {
		return numCasillas;
	}
	/**
	 * Devuelve el numero de colores del modo que se va a jugar.
	 * @return El numero de colores.
	 * @since 1.0
	 */
	public int getNumColores() {
		return numColores;
	}
	/**
	 * Devuelve el numero de intentos que tiene en la partida.
	 * @return El numero de intentos.
	 * @since 1.0
	 */
	public int getNumIntentos() {
		return numIntentos;
	}
	/**
	 * Devuelve si hay repeticion de colores en el modo que se va a jugar.
	 * @return Si hay repeticion de colores.
	 * @since 1.0
	 */
	public boolean isRepeticion() {
		return repeticion;
	}
}
