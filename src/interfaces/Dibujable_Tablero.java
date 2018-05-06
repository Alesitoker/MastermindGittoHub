package interfaces;
/**
 * Interfaz de dibujar para tablero.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public interface Dibujable_Tablero extends Dibujable {
	/**
	 * Dibuja la combinacion oculta.
	 * @since 1.0
	 */
	public void dibujar_oculta();
	/**
	 * Dibuja el tablero sin su combinacion oculta.
	 * @since 1.0
	 */
	public void dibujar_noOculta();
	/**
	 * Dibuja una linea del tablero.
	 * @param linea La linea que se va a dibujar.
	 * @since 1.0
	 */
	public void dibujar_linea(int linea); // Esto dibuja una linea del tablero.
}
