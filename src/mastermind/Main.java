package mastermind;

import utilities.Teclado;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		do {
			menu.configurarPartida().empezarPartida();
		} while(Teclado.leerBoolean("¿Desea reiniciar?"));
		Teclado.cerrarTeclado();
	}

}
