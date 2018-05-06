package interfaces;
/**
 * Interfaz para dibujar en la partida.
 * 
 * @author Alejandro Díaz
 * @version 1.0
 * @since 1.0
 *
 */
public interface DibujablePartida {
	/**
	 * Enum de los resultados de la partida.
	 * @since 1.0
	 *
	 */
	public enum ResultadoFinal {
		GANADOR, PERDEDOR, EMPATE, GANADORMAQUINA;
	}
	/**
	 * Dibuja los tableros de los jugadores uno al lado del otro.
	 * @param resultado El resultado de la partida.
	 * @since 1.0
	 */
	public void dibujar(ResultadoFinal resultado);
}
