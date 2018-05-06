package test;

import static mastermind.ModoDeJuego.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import jugadores.*;
import jugadores.Tablero.*;

class Junittest {
	@Test
	void testFacil() {
		int i;
		final int cantPruebas = 13;
		final int ROJO = 0, CELESTE = 1, AMARILLO = 2, AZUL = 4, VIOLETA = 5, MARRON = 7, NARANJA = 8, VERDE = 9;
		final byte FICHAPOSICIONCORRECTA = 0, FICHAPOSICIONINCORRECTA = 1, NOHAYFICHA = 2;
		Jugador maquina = new Maquina(FACIL);
		Combinacion combinacionOculta = new Combinacion(FACIL);
		CombinacionRespuesta combinacion[] = new CombinacionRespuesta[cantPruebas];
		CombinacionRespuesta combinacionPrueba[] = new CombinacionRespuesta[cantPruebas];
		Casilla fichaPequeña[] = new Casilla[3];
		Casilla fichaRespuestaPequeña[] = new Casilla[3];

		for (i = 0; i < combinacion.length && i < combinacionPrueba.length; i++) {
			if (i < 12) {
				combinacion[i] = new CombinacionRespuesta(FACIL);
				combinacionPrueba[i] = new CombinacionRespuesta(FACIL);
			}
		}
		combinacion[11].setCombinacion(fichaPequeña);
		combinacion[11].setRespuesta(fichaRespuestaPequeña);
		combinacion[12] = new CombinacionRespuesta(DIFICIL);
		combinacion[12] = new CombinacionRespuesta(DIFICIL);
//		// Rellenar combinacion oculta.
		combinacionOculta.addFicha(ROJO);
		combinacionOculta.addFicha(VERDE);
		combinacionOculta.addFicha(AMARILLO);
		combinacionOculta.addFicha(NARANJA);
		
		maquina.setCombinacionPropia(combinacionOculta);
		// Fichas en la posicion correcta.
		// Ningun color acertado.
		combinacion[0].addFicha(AZUL);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(VIOLETA);
		combinacion[0].addFicha(MARRON);
		
		combinacionPrueba[0].addFicha(AZUL);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(VIOLETA);
		combinacionPrueba[0].addFicha(MARRON);
		
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[0]);
		
		assertEquals(combinacionPrueba[0], combinacion[0]);
		// Una ficha en posicion correcta.
		combinacion[1].addFicha(ROJO);
		combinacion[1].addFicha(AZUL);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(VIOLETA);
		
		combinacionPrueba[1].addFicha(ROJO);
		combinacionPrueba[1].addFicha(AZUL);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(VIOLETA);
		
		combinacionPrueba[1].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[1]);
		
		assertEquals(combinacionPrueba[1], combinacion[1]);
		// Mas de una ficha en la posicion correcta.
		combinacion[2].addFicha(AZUL);
		combinacion[2].addFicha(VERDE);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(NARANJA);
		
		combinacionPrueba[2].addFicha(AZUL);
		combinacionPrueba[2].addFicha(VERDE);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(NARANJA);
		
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[2]);
		
		assertEquals(combinacionPrueba[2], combinacion[2]);
		// 4 fichas en posicion correcta.
		combinacion[3].addFicha(ROJO);
		combinacion[3].addFicha(VERDE);
		combinacion[3].addFicha(AMARILLO);
		combinacion[3].addFicha(NARANJA);
		
		combinacionPrueba[3].addFicha(ROJO);
		combinacionPrueba[3].addFicha(VERDE);
		combinacionPrueba[3].addFicha(AMARILLO);
		combinacionPrueba[3].addFicha(NARANJA);
		
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		
		maquina.indicarRespuesta(combinacion[3]);
		
		assertEquals(combinacionPrueba[3], combinacion[3]);
		// Fichas en posicion correcta e incorrecta	.
		// Una ficha en posicion incorrecta.
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO);
		combinacion[4].addFicha(AZUL);
		combinacion[4].addFicha(VIOLETA);
		
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO);
		combinacionPrueba[4].addFicha(AZUL);
		combinacionPrueba[4].addFicha(VIOLETA);
		
		combinacionPrueba[4].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[4]);
		
		assertEquals(combinacionPrueba[4], combinacion[4]);
		// Mas de una ficha en la posicion incorrecta.
		combinacion[5].addFicha(VERDE);
		combinacion[5].addFicha(ROJO);
		combinacion[5].addFicha(CELESTE);
		combinacion[5].addFicha(VIOLETA);
		
		combinacionPrueba[5].addFicha(VERDE);
		combinacionPrueba[5].addFicha(ROJO);
		combinacionPrueba[5].addFicha(CELESTE);
		combinacionPrueba[5].addFicha(VIOLETA);
		
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[5]);
		
		assertEquals(combinacionPrueba[5], combinacion[5]);
		// 4 fichas en posicion incorrecta.
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(ROJO);
		combinacion[6].addFicha(NARANJA);
		combinacion[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(ROJO);
		combinacionPrueba[6].addFicha(NARANJA);
		combinacionPrueba[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[6]);
		
		assertEquals(combinacionPrueba[6], combinacion[6]);
		// Fichas en posicion correcta e incorrecta.
		// Una ficha en posicion correcta y una incorrecta.
		combinacion[7].addFicha(AMARILLO);
		combinacion[7].addFicha(VERDE);
		combinacion[7].addFicha(VIOLETA);
		combinacion[7].addFicha(AZUL);
		
		combinacionPrueba[7].addFicha(AMARILLO);
		combinacionPrueba[7].addFicha(VERDE);
		combinacionPrueba[7].addFicha(VIOLETA);
		combinacionPrueba[7].addFicha(AZUL);
		
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[7]);
		
		assertEquals(combinacionPrueba[7], combinacion[7]);
		// Mas de una ficha en posicion correcta y Mas de una en incorrecta.
		combinacion[8].addFicha(AMARILLO);
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(ROJO);
		combinacion[8].addFicha(NARANJA);
		
		combinacionPrueba[8].addFicha(AMARILLO);
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(ROJO);
		combinacionPrueba[8].addFicha(NARANJA);
		
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[8]);
		
		assertEquals(combinacionPrueba[8], combinacion[8]);
		// Mismo color en posicion incorrecta y posicion correcta.
		combinacion[9].addFicha(VIOLETA);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(NARANJA);
		
		combinacionPrueba[9].addFicha(VIOLETA);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(NARANJA);
		
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[9]);
		
		assertEquals(combinacionPrueba[9], combinacion[9]);
		// Mismo color en posicion incorrecta mas de una vez.
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(NARANJA);
		
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(NARANJA);
		
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[10]);
		
		assertEquals(combinacionPrueba[10], combinacion[10]);
		// Pasar una combinacion con menor tamaño.
		combinacion[11].addFicha(NARANJA);
		combinacion[11].addFicha(VERDE);
		combinacion[11].addFicha(NARANJA);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			maquina.indicarRespuesta(combinacion[11]);
		});	
		
		// Pasar una combinacion con mayor tamaño
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(VERDE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(CELESTE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(AMARILLO);
		combinacion[12].addFicha(NARANJA);
		
		maquina.indicarRespuesta(combinacion[12]);
		
	}
	@Test
	void testMedio() {
		int i;
		final int cantPruebas = 13;
		final int ROJO = 0, CELESTE = 1, AMARILLO = 2, AZUL = 4, VIOLETA = 5, VERDE_CLARO = 6, MARRON = 7, NARANJA = 8, VERDE = 9;
		final byte FICHAPOSICIONCORRECTA = 0, FICHAPOSICIONINCORRECTA = 1, NOHAYFICHA = 2;
		Jugador maquina = new Maquina(MEDIO);
		Combinacion combinacionOculta = new Combinacion(MEDIO);
		CombinacionRespuesta combinacion[] = new CombinacionRespuesta[cantPruebas];
		CombinacionRespuesta combinacionPrueba[] = new CombinacionRespuesta[cantPruebas];
		
		for (i = 0; i < combinacion.length && i < combinacionPrueba.length; i++) {
			if (i < 11) {
				combinacion[i] = new CombinacionRespuesta(MEDIO);
				combinacionPrueba[i] = new CombinacionRespuesta(MEDIO);
			}
		}
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[12] = new CombinacionRespuesta(DIFICIL);
		combinacion[12] = new CombinacionRespuesta(DIFICIL);
//		// Rellenar combinacion oculta.
		combinacionOculta.addFicha(ROJO);
		combinacionOculta.addFicha(VERDE);
		combinacionOculta.addFicha(AMARILLO);
		combinacionOculta.addFicha(NARANJA);
		combinacionOculta.addFicha(VERDE_CLARO);
		
		maquina.setCombinacionPropia(combinacionOculta);
		// Fichas en la posicion correcta.
		// Ningun color acertado.
		combinacion[0].addFicha(AZUL);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(VIOLETA);
		combinacion[0].addFicha(MARRON);
		combinacion[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addFicha(AZUL);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(VIOLETA);
		combinacionPrueba[0].addFicha(MARRON);
		combinacionPrueba[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[0]);
		
		assertEquals(combinacionPrueba[0], combinacion[0]);
		// Una ficha en posicion correcta.
		combinacion[1].addFicha(ROJO);
		combinacion[1].addFicha(AZUL);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(VIOLETA);
		combinacion[1].addFicha(AZUL);
		
		combinacionPrueba[1].addFicha(ROJO);
		combinacionPrueba[1].addFicha(AZUL);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(VIOLETA);
		combinacionPrueba[1].addFicha(AZUL);
		
		combinacionPrueba[1].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[1]);
		
		assertEquals(combinacionPrueba[1], combinacion[1]);
		// Mas de una ficha en la posicion correcta.
		combinacion[2].addFicha(AZUL);
		combinacion[2].addFicha(VERDE);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(NARANJA);
		combinacion[2].addFicha(AZUL);
		
		combinacionPrueba[2].addFicha(AZUL);
		combinacionPrueba[2].addFicha(VERDE);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(NARANJA);
		combinacionPrueba[2].addFicha(AZUL);
		
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[2]);
		
		assertEquals(combinacionPrueba[2], combinacion[2]);
		// 5 fichas en posicion correcta.
		combinacion[3].addFicha(ROJO);
		combinacion[3].addFicha(VERDE);
		combinacion[3].addFicha(AMARILLO);
		combinacion[3].addFicha(NARANJA);
		combinacion[3].addFicha(VERDE_CLARO);
		
		combinacionPrueba[3].addFicha(ROJO);
		combinacionPrueba[3].addFicha(VERDE);
		combinacionPrueba[3].addFicha(AMARILLO);
		combinacionPrueba[3].addFicha(NARANJA);
		combinacionPrueba[3].addFicha(VERDE_CLARO);
		
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		
		maquina.indicarRespuesta(combinacion[3]);
		
		assertEquals(combinacionPrueba[3], combinacion[3]);
		// Fichas en posicion correcta e incorrecta	.
		// Una ficha en posicion incorrecta.
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO);
		combinacion[4].addFicha(AZUL);
		combinacion[4].addFicha(VIOLETA);
		combinacion[4].addFicha(VIOLETA);
		
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO);
		combinacionPrueba[4].addFicha(AZUL);
		combinacionPrueba[4].addFicha(VIOLETA);
		combinacionPrueba[4].addFicha(VIOLETA);
		
		combinacionPrueba[4].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[4]);
		
		assertEquals(combinacionPrueba[4], combinacion[4]);
		// Mas de una ficha en la posicion incorrecta.
		combinacion[5].addFicha(VERDE);
		combinacion[5].addFicha(ROJO);
		combinacion[5].addFicha(CELESTE);
		combinacion[5].addFicha(VIOLETA);
		combinacion[5].addFicha(AMARILLO);
		
		combinacionPrueba[5].addFicha(VERDE);
		combinacionPrueba[5].addFicha(ROJO);
		combinacionPrueba[5].addFicha(CELESTE);
		combinacionPrueba[5].addFicha(VIOLETA);
		combinacionPrueba[5].addFicha(AMARILLO);
		
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[5]);
		
		assertEquals(combinacionPrueba[5], combinacion[5]);
		// 5 fichas en posicion incorrecta.
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(ROJO);
		combinacion[6].addFicha(NARANJA);
		combinacion[6].addFicha(VERDE_CLARO);
		combinacion[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(ROJO);
		combinacionPrueba[6].addFicha(NARANJA);
		combinacionPrueba[6].addFicha(VERDE_CLARO);
		combinacionPrueba[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[6]);
		
		assertEquals(combinacionPrueba[6], combinacion[6]);
		// Fichas en posicion correcta e incorrecta.
		// Una ficha en posicion correcta y una incorrecta.
		combinacion[7].addFicha(AMARILLO);
		combinacion[7].addFicha(VERDE);
		combinacion[7].addFicha(VIOLETA);
		combinacion[7].addFicha(AZUL);
		combinacion[7].addFicha(MARRON);
		
		combinacionPrueba[7].addFicha(AMARILLO);
		combinacionPrueba[7].addFicha(VERDE);
		combinacionPrueba[7].addFicha(VIOLETA);
		combinacionPrueba[7].addFicha(AZUL);
		combinacionPrueba[7].addFicha(MARRON);
		
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[7]);
		
		assertEquals(combinacionPrueba[7], combinacion[7]);
		// Mas de una ficha en posicion correcta y Mas de una en incorrecta.
		combinacion[8].addFicha(AMARILLO);
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(ROJO);
		combinacion[8].addFicha(NARANJA);
		combinacion[8].addFicha(VERDE_CLARO);
		
		combinacionPrueba[8].addFicha(AMARILLO);
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(ROJO);
		combinacionPrueba[8].addFicha(NARANJA);
		combinacionPrueba[8].addFicha(VERDE_CLARO);
		
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[8]);
		
		assertEquals(combinacionPrueba[8], combinacion[8]);
		// Mismo color en posicion incorrecta y posicion correcta.
		combinacion[9].addFicha(VIOLETA);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(NARANJA);
		
		combinacionPrueba[9].addFicha(VIOLETA);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(NARANJA);
		
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[9]);
		
		assertEquals(combinacionPrueba[9], combinacion[9]);
		// Mismo color en posicion incorrecta mas de una vez.
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(AMARILLO);
		combinacion[10].addFicha(NARANJA);
		
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(AMARILLO);
		combinacionPrueba[10].addFicha(NARANJA);
		
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[10]);
		
		assertEquals(combinacionPrueba[10], combinacion[10]);
		// Pasar una combinacion con menor tamaño.
		combinacion[11].addFicha(NARANJA);
		combinacion[11].addFicha(VERDE);
		combinacion[11].addFicha(NARANJA);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			maquina.indicarRespuesta(combinacion[11]);
		});	
		
		// Pasar una combinacion con mayor tamaño
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(VERDE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(CELESTE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(AMARILLO);
		combinacion[12].addFicha(NARANJA);
		
		maquina.indicarRespuesta(combinacion[12]);
		
	}
	@Test
	void testDificilSinRepeticion() {
		int i;
		final int cantPruebas = 13;
		final int ROJO = 0, CELESTE = 1, AMARILLO = 2, ROJO_OSCURO = 3, AZUL = 4, VIOLETA = 5, VERDE_CLARO = 6, MARRON = 7, NARANJA = 8, VERDE = 9;
		final byte FICHAPOSICIONCORRECTA = 0, FICHAPOSICIONINCORRECTA = 1, NOHAYFICHA = 2;
		Jugador maquina = new Maquina(DIFICIL);
		Combinacion combinacionOculta = new Combinacion(DIFICIL);
		CombinacionRespuesta combinacion[] = new CombinacionRespuesta[cantPruebas];
		CombinacionRespuesta combinacionPrueba[] = new CombinacionRespuesta[cantPruebas];
		Casilla fichaGigante[] = new Casilla[10];
		Casilla fichaRespuestaGigante[] = new Casilla[10];
		
		for (i = 0; i < combinacion.length && i < combinacionPrueba.length; i++) {
			if (i < 11 || i == 12) {
				combinacion[i] = new CombinacionRespuesta(DIFICIL);
				combinacionPrueba[i] = new CombinacionRespuesta(DIFICIL);
			}
		}
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[12].setCombinacion(fichaGigante);
		combinacion[12].setRespuesta(fichaRespuestaGigante);
//		// Rellenar combinacion oculta.
		combinacionOculta.addFicha(ROJO);
		combinacionOculta.addFicha(VERDE);
		combinacionOculta.addFicha(AMARILLO);
		combinacionOculta.addFicha(NARANJA);
		combinacionOculta.addFicha(VERDE_CLARO);
		combinacionOculta.addFicha(MARRON);
		combinacionOculta.addFicha(AZUL);
		combinacionOculta.addFicha(VIOLETA);
		
		maquina.setCombinacionPropia(combinacionOculta);
		// Fichas en la posicion correcta.
		// Ningun color acertado.
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(ROJO_OSCURO);
		combinacion[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(ROJO_OSCURO);
		combinacionPrueba[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[0]);
		
		assertEquals(combinacionPrueba[0], combinacion[0]);
		// Una ficha en posicion correcta.
		combinacion[1].addFicha(ROJO);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(ROJO_OSCURO);
		combinacion[1].addFicha(CELESTE);
		
		combinacionPrueba[1].addFicha(ROJO);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(ROJO_OSCURO);
		combinacionPrueba[1].addFicha(CELESTE);
		
		combinacionPrueba[1].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[1]);
		
		assertEquals(combinacionPrueba[1], combinacion[1]);
		// Mas de una ficha en la posicion correcta.
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(VERDE);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(NARANJA);
		combinacion[2].addFicha(VERDE_CLARO);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(AZUL);
		combinacion[2].addFicha(VIOLETA);
		
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(VERDE);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(NARANJA);
		combinacionPrueba[2].addFicha(VERDE_CLARO);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(AZUL);
		combinacionPrueba[2].addFicha(VIOLETA);
		
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[2]);
		
		assertEquals(combinacionPrueba[2], combinacion[2]);
		// 8 fichas en posicion correcta.
		combinacion[3].addFicha(ROJO);
		combinacion[3].addFicha(VERDE);
		combinacion[3].addFicha(AMARILLO);
		combinacion[3].addFicha(NARANJA);
		combinacion[3].addFicha(VERDE_CLARO);
		combinacion[3].addFicha(MARRON);
		combinacion[3].addFicha(AZUL);
		combinacion[3].addFicha(VIOLETA);
		
		combinacionPrueba[3].addFicha(ROJO);
		combinacionPrueba[3].addFicha(VERDE);
		combinacionPrueba[3].addFicha(AMARILLO);
		combinacionPrueba[3].addFicha(NARANJA);
		combinacionPrueba[3].addFicha(VERDE_CLARO);
		combinacionPrueba[3].addFicha(MARRON);
		combinacionPrueba[3].addFicha(AZUL);
		combinacionPrueba[3].addFicha(VIOLETA);
		
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		
		maquina.indicarRespuesta(combinacion[3]);
		
		assertEquals(combinacionPrueba[3], combinacion[3]);
		// Fichas en posicion correcta e incorrecta	.
		// Una ficha en posicion incorrecta.
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO_OSCURO);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO_OSCURO);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[4].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[4]);
		
		assertEquals(combinacionPrueba[4], combinacion[4]);
		// Mas de una ficha en la posicion incorrecta.
		combinacion[5].addFicha(VERDE);
		combinacion[5].addFicha(ROJO);
		combinacion[5].addFicha(CELESTE);
		combinacion[5].addFicha(VIOLETA);
		combinacion[5].addFicha(AMARILLO);
		combinacion[5].addFicha(CELESTE);
		combinacion[5].addFicha(MARRON);
		combinacion[5].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[5].addFicha(VERDE);
		combinacionPrueba[5].addFicha(ROJO);
		combinacionPrueba[5].addFicha(CELESTE);
		combinacionPrueba[5].addFicha(VIOLETA);
		combinacionPrueba[5].addFicha(AMARILLO);
		combinacionPrueba[5].addFicha(CELESTE);
		combinacionPrueba[5].addFicha(MARRON);
		combinacionPrueba[5].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[5]);
		
		assertEquals(combinacionPrueba[5], combinacion[5]);
		// 8 fichas en posicion incorrecta.
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(ROJO);
		combinacion[6].addFicha(NARANJA);
		combinacion[6].addFicha(VERDE_CLARO);
		combinacion[6].addFicha(AMARILLO);
		combinacion[6].addFicha(VIOLETA);
		combinacion[6].addFicha(MARRON);
		combinacion[6].addFicha(AZUL);
		
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(ROJO);
		combinacionPrueba[6].addFicha(NARANJA);
		combinacionPrueba[6].addFicha(VERDE_CLARO);
		combinacionPrueba[6].addFicha(AMARILLO);
		combinacionPrueba[6].addFicha(VIOLETA);
		combinacionPrueba[6].addFicha(MARRON);
		combinacionPrueba[6].addFicha(AZUL);
		
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[6]);
		
		assertEquals(combinacionPrueba[6], combinacion[6]);
		// Fichas en posicion correcta e incorrecta.
		// Una ficha en posicion correcta y una incorrecta.
		combinacion[7].addFicha(AMARILLO);
		combinacion[7].addFicha(VERDE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(ROJO_OSCURO);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[7].addFicha(AMARILLO);
		combinacionPrueba[7].addFicha(VERDE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(ROJO_OSCURO);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[7]);
		
		assertEquals(combinacionPrueba[7], combinacion[7]);
		// Mas de una ficha en posicion correcta y Mas de una en incorrecta.
		combinacion[8].addFicha(AMARILLO);
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(ROJO);
		combinacion[8].addFicha(NARANJA);
		combinacion[8].addFicha(VERDE_CLARO);
		combinacion[8].addFicha(AZUL);
		combinacion[8].addFicha(MARRON);
		combinacion[8].addFicha(VIOLETA);
		
		combinacionPrueba[8].addFicha(AMARILLO);
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(ROJO);
		combinacionPrueba[8].addFicha(NARANJA);
		combinacionPrueba[8].addFicha(VERDE_CLARO);
		combinacionPrueba[8].addFicha(AZUL);
		combinacionPrueba[8].addFicha(MARRON);
		combinacionPrueba[8].addFicha(VIOLETA);
		
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[8]);
		
		assertEquals(combinacionPrueba[8], combinacion[8]);
		// Mismo color en posicion incorrecta y posicion correcta.
		combinacion[9].addFicha(AZUL);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(NARANJA);
		combinacion[9].addFicha(CELESTE);
		combinacion[9].addFicha(AZUL);
		combinacion[9].addFicha(AZUL);
		
		combinacionPrueba[9].addFicha(AZUL);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(NARANJA);
		combinacionPrueba[9].addFicha(CELESTE);
		combinacionPrueba[9].addFicha(AZUL);
		combinacionPrueba[9].addFicha(AZUL);
		
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[9]);
		
		assertEquals(combinacionPrueba[9], combinacion[9]);
		// Mismo color en posicion incorrecta mas de una vez.
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(AMARILLO);
		combinacion[10].addFicha(NARANJA);
		combinacion[10].addFicha(AZUL);
		combinacion[10].addFicha(CELESTE);
		combinacion[10].addFicha(AZUL);
		
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(AMARILLO);
		combinacionPrueba[10].addFicha(NARANJA);
		combinacionPrueba[10].addFicha(AZUL);
		combinacionPrueba[10].addFicha(CELESTE);
		combinacionPrueba[10].addFicha(AZUL);
		
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[10]);
		
		assertEquals(combinacionPrueba[10], combinacion[10]);
		// Pasar una combinacion con menor tamaño.
		combinacion[11].addFicha(NARANJA);
		combinacion[11].addFicha(VERDE);
		combinacion[11].addFicha(NARANJA);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			maquina.indicarRespuesta(combinacion[11]);
		});	
		
		// Pasar una combinacion con mayor tamaño
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(VERDE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(CELESTE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(AMARILLO);
		combinacion[12].addFicha(NARANJA);
		
		maquina.indicarRespuesta(combinacion[12]);
	}
	
	@Test
	void testDificilConRepeticion() {
		int i;
		final int cantPruebas = 13;
		final int ROJO = 0, CELESTE = 1, AMARILLO = 2, ROJO_OSCURO = 3, AZUL = 4, VIOLETA = 5, VERDE_CLARO = 6, MARRON = 7, NARANJA = 8, VERDE = 9;
		final byte FICHAPOSICIONCORRECTA = 0, FICHAPOSICIONINCORRECTA = 1, NOHAYFICHA = 2;
		Jugador maquina = new Maquina(DIFICIL);
		Combinacion combinacionOculta = new Combinacion(DIFICIL);
		CombinacionRespuesta combinacion[] = new CombinacionRespuesta[cantPruebas];
		CombinacionRespuesta combinacionPrueba[] = new CombinacionRespuesta[cantPruebas];
		Casilla fichaGigante[] = new Casilla[10];
		Casilla fichaRespuestaGigante[] = new Casilla[10];
		
		for (i = 0; i < combinacion.length && i < combinacionPrueba.length; i++) {
			if (i < 11 || i == 12) {
				combinacion[i] = new CombinacionRespuesta(DIFICIL);
				combinacionPrueba[i] = new CombinacionRespuesta(DIFICIL);
			}
		}
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[11] = new CombinacionRespuesta(FACIL);
		combinacion[12].setCombinacion(fichaGigante);
		combinacion[12].setRespuesta(fichaRespuestaGigante);
//		// Rellenar combinacion oculta.
		combinacionOculta.addFicha(VERDE);
		combinacionOculta.addFicha(AZUL);
		combinacionOculta.addFicha(VIOLETA);
		combinacionOculta.addFicha(VERDE);
		combinacionOculta.addFicha(ROJO);
		combinacionOculta.addFicha(AMARILLO);
		combinacionOculta.addFicha(AMARILLO);
		combinacionOculta.addFicha(VERDE);
		
		maquina.setCombinacionPropia(combinacionOculta);
		// Fichas en la posicion correcta.
		// Ningun color acertado.
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(CELESTE);
		combinacion[0].addFicha(ROJO_OSCURO);
		combinacion[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(CELESTE);
		combinacionPrueba[0].addFicha(ROJO_OSCURO);
		combinacionPrueba[0].addFicha(CELESTE);
		
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		combinacionPrueba[0].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[0]);
		
		assertEquals(combinacionPrueba[0], combinacion[0]);
		// Una ficha en posicion correcta.
		combinacion[1].addFicha(VERDE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(CELESTE);
		combinacion[1].addFicha(ROJO_OSCURO);
		combinacion[1].addFicha(CELESTE);
		
		combinacionPrueba[1].addFicha(VERDE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(CELESTE);
		combinacionPrueba[1].addFicha(ROJO_OSCURO);
		combinacionPrueba[1].addFicha(CELESTE);
		
		combinacionPrueba[1].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		combinacionPrueba[1].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[1]);
		
		assertEquals(combinacionPrueba[1], combinacion[1]);
		// Mas de una ficha en la posicion correcta.
		combinacion[2].addFicha(VERDE);
		combinacion[2].addFicha(AZUL);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(VERDE);
		combinacion[2].addFicha(VERDE_CLARO);
		combinacion[2].addFicha(CELESTE);
		combinacion[2].addFicha(AMARILLO);
		combinacion[2].addFicha(VERDE);
		
		combinacionPrueba[2].addFicha(VERDE);
		combinacionPrueba[2].addFicha(AZUL);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(VERDE);
		combinacionPrueba[2].addFicha(VERDE_CLARO);
		combinacionPrueba[2].addFicha(CELESTE);
		combinacionPrueba[2].addFicha(AMARILLO);
		combinacionPrueba[2].addFicha(VERDE);
		
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		combinacionPrueba[2].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[2]);
		
		assertEquals(combinacionPrueba[2], combinacion[2]);
		// 8 fichas en posicion correcta.
		combinacion[3].addFicha(VERDE);
		combinacion[3].addFicha(AZUL);
		combinacion[3].addFicha(VIOLETA);
		combinacion[3].addFicha(VERDE);
		combinacion[3].addFicha(ROJO);
		combinacion[3].addFicha(AMARILLO);
		combinacion[3].addFicha(AMARILLO);
		combinacion[3].addFicha(VERDE);
		
		combinacionPrueba[3].addFicha(VERDE);
		combinacionPrueba[3].addFicha(AZUL);
		combinacionPrueba[3].addFicha(VIOLETA);
		combinacionPrueba[3].addFicha(VERDE);
		combinacionPrueba[3].addFicha(ROJO);
		combinacionPrueba[3].addFicha(AMARILLO);
		combinacionPrueba[3].addFicha(AMARILLO);
		combinacionPrueba[3].addFicha(VERDE);
		
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[3].addRespuesta(FICHAPOSICIONCORRECTA);
		
		maquina.indicarRespuesta(combinacion[3]);
		
		assertEquals(combinacionPrueba[3], combinacion[3]);
		// Fichas en posicion correcta e incorrecta	.
		// Una ficha en posicion incorrecta.
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(VERDE);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO_OSCURO);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(CELESTE);
		combinacion[4].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(VERDE);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO_OSCURO);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(CELESTE);
		combinacionPrueba[4].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[4].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		combinacionPrueba[4].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[4]);
		
		assertEquals(combinacionPrueba[4], combinacion[4]);
		// Mas de una ficha en la posicion incorrecta.
		combinacion[5].addFicha(ROJO);
		combinacion[5].addFicha(VERDE);
		combinacion[5].addFicha(VERDE);
		combinacion[5].addFicha(VIOLETA);
		combinacion[5].addFicha(AMARILLO);
		combinacion[5].addFicha(CELESTE);
		combinacion[5].addFicha(MARRON);
		combinacion[5].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[5].addFicha(ROJO);
		combinacionPrueba[5].addFicha(VERDE);
		combinacionPrueba[5].addFicha(VERDE);
		combinacionPrueba[5].addFicha(VIOLETA);
		combinacionPrueba[5].addFicha(AMARILLO);
		combinacionPrueba[5].addFicha(CELESTE);
		combinacionPrueba[5].addFicha(MARRON);
		combinacionPrueba[5].addFicha(ROJO_OSCURO);
		
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		combinacionPrueba[5].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[5]);
		
		assertEquals(combinacionPrueba[5], combinacion[5]);
		// 8 fichas en posicion incorrecta.
		combinacion[6].addFicha(ROJO);
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(VIOLETA);
		combinacion[6].addFicha(AMARILLO);
		combinacion[6].addFicha(AZUL);
		combinacion[6].addFicha(VERDE);
		combinacion[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addFicha(ROJO);
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(VIOLETA);
		combinacionPrueba[6].addFicha(AMARILLO);
		combinacionPrueba[6].addFicha(AZUL);
		combinacionPrueba[6].addFicha(VERDE);
		combinacionPrueba[6].addFicha(AMARILLO);
		
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[6].addRespuesta(FICHAPOSICIONINCORRECTA);
		
		maquina.indicarRespuesta(combinacion[6]);
		
		assertEquals(combinacionPrueba[6], combinacion[6]);
		// Fichas en posicion correcta e incorrecta.
		// Una ficha en posicion correcta y una incorrecta.
		combinacion[7].addFicha(AMARILLO);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(ROJO_OSCURO);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(CELESTE);
		combinacion[7].addFicha(VERDE);
		
		combinacionPrueba[7].addFicha(AMARILLO);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(ROJO_OSCURO);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(CELESTE);
		combinacionPrueba[7].addFicha(VERDE);
		
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[7].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		combinacionPrueba[7].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[7]);
		
		assertEquals(combinacionPrueba[7], combinacion[7]);
		// Mas de una ficha en posicion correcta y Mas de una en incorrecta.
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(VERDE);
		combinacion[8].addFicha(AMARILLO);
		combinacion[8].addFicha(ROJO);
		combinacion[8].addFicha(AZUL);
		combinacion[8].addFicha(AMARILLO);
		combinacion[8].addFicha(VERDE);
		
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(VERDE);
		combinacionPrueba[8].addFicha(AMARILLO);
		combinacionPrueba[8].addFicha(ROJO);
		combinacionPrueba[8].addFicha(AZUL);
		combinacionPrueba[8].addFicha(AMARILLO);
		combinacionPrueba[8].addFicha(VERDE);
		
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[8].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[8]);
		
		assertEquals(combinacionPrueba[8], combinacion[8]);
		// Mismo color en posicion incorrecta y posicion correcta.
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(CELESTE);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(VERDE);
		combinacion[9].addFicha(AMARILLO);
		combinacion[9].addFicha(AMARILLO);
		
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(CELESTE);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(VERDE);
		combinacionPrueba[9].addFicha(AMARILLO);
		combinacionPrueba[9].addFicha(AMARILLO);
		
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		combinacionPrueba[9].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[9]);
		
		assertEquals(combinacionPrueba[9], combinacion[9]);
		// Mismo color en posicion incorrecta mas de una vez.
		combinacion[10].addFicha(AMARILLO);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(AMARILLO);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(VERDE);
		combinacion[10].addFicha(AMARILLO);
		
		combinacionPrueba[10].addFicha(AMARILLO);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(AMARILLO);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(VERDE);
		combinacionPrueba[10].addFicha(AMARILLO);
		
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(FICHAPOSICIONINCORRECTA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		combinacionPrueba[10].addRespuesta(NOHAYFICHA);
		
		maquina.indicarRespuesta(combinacion[10]);
		
		assertEquals(combinacionPrueba[10], combinacion[10]);
		// Pasar una combinacion con menor tamaño.
		combinacion[11].addFicha(NARANJA);
		combinacion[11].addFicha(VERDE);
		combinacion[11].addFicha(NARANJA);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			maquina.indicarRespuesta(combinacion[11]);
		});	
		
		// Pasar una combinacion con mayor tamaño
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(VERDE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(CELESTE);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(NARANJA);
		combinacion[12].addFicha(AMARILLO);
		combinacion[12].addFicha(NARANJA);
		
		maquina.indicarRespuesta(combinacion[12]);
	}
	

}
