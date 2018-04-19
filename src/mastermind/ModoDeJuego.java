package mastermind;

public enum ModoDeJuego {
	FACIL(4, 8, 10, false), MEDIO(5, 8, 15, false), DIFICIL(8, 10, 0, true);
	
	private int numCasillas, numColores, numIntentos;
	private boolean repeticion;
	
	ModoDeJuego(int numCasillas, int numColores, int numIntentos, boolean repeticion) {
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.numIntentos = numIntentos;
		this.repeticion = repeticion;
	}

	public int getNumCasillas() {
		return numCasillas;
	}

	public int getNumColores() {
		return numColores;
	}

	public int getNumIntentos() {
		return numIntentos;
	}

	public boolean isRepeticion() {
		return repeticion;
	}
}
