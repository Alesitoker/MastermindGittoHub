package utilities;

import static utilities.Colores.*;

import java.util.*;

import jugadores.Tablero.*;
//import utilities.Teclado.*;


public class Pruebas {

	public static void main(String[] args) {
//		String color = "";
//		byte opcion;
		int i = 0, j, numero = 4, numCasillas = 9, numColores = 10;
		boolean bebe = false;
		String colors[] = {"R", "V", "A", "N", CELESTE, AZUL, VIOLET, MORADO} ;
		Combinacion ocultacion = new Combinacion(4);
		Combinacion bien = new Combinacion(4);
		Casillas[] ocu, bi;
		boolean salir = false;
		int array[] = new int[4];
		int negra = 0, blanca = 0;
		HashMap<String,Integer> mapa = new HashMap<>();
		int negras = 2, blancas = 1, contador = 0;
		CombinacionRespuesta respuesta = new CombinacionRespuesta(4);
				
		for (i = 0; i < bien.getCombinacion().length; i++) {
			ocultacion.addFicha(colors[i], i);
			if (i == 0)
			bien.addFicha("N", i);
			if (i == 1) 
			bien.addFicha("R", i);
			if (i == 2)
				bien.addFicha("N", i);
			else if (i == 3)
				bien.addFicha("N", i);
		}
		
		ocu = ocultacion.getCombinacion();
		bi = bien.getCombinacion();
		for (i = 0; i < ocu.length; i++) {
			for (j = 0; j < bi.length && !salir; j++) {
				System.out.printf("bi:%s ocu:%s\t", bi[j].getColor(), ocu[i].getColor());
				bebe = bi[j].equals(ocu[i]);
				if (bebe && j==i) {
					array[i] = 1;
					salir = true;
				} else if (bebe && j!=i){
					array[i] = 2;
				}
				System.out.printf("%d, %d:%b\n", j, i, bebe);
			}
			bebe = false;
			salir = false;
		}
		for (int c: array) {
			if (c == 1)
				negra++;
			else if (c == 2)
				blanca++;
		}
		System.out.printf("Negra:%d\nBlanca:%d", negra, blanca);
//		System.out.println("Tablero jugador 1:\t\tTablero jugador 2:");
//		System.out.println("Elige un color para la posicion:");
//		System.out.printf("1. %s●%9$s  2. %s●%9$s  3. %s●%9$s  4. %s●%9$s\n5. %s●%9$s  6. %s●%9$s  7. %s●%9$s  8. %s●%9$s\n", ROJO, VERDE, AMARILLO, MORADO, AZUL, VIOLET, LIGHT_GREEN, BROWN, RESET);
//		if (numColores == 10) {
//			System.out.printf("9. %s●%3$s 10. %s●%s\n", NARANJA, CELESTE, RESET);
//		}
//		for (i = 0; i < numCasillas; i++) {
//			
//			opcion = Teclado.rango((byte)1,(byte) numColores, Rango.AMBOS_INCLUIDOS, Tipo.BYTE);
//			switch (opcion) {
//				case 1:
//					color = Colores.ROJO;
//					break;
//				case 2:
//					color = Colores.VERDE;
//					break;
//				case 3:
//					color = Colores.AMARILLO;
//					break;
//				case 4:
//					color = Colores.MORADO;
//					break;
//				case 5:
//					color = Colores.AZUL;
//					break;
//				case 6:
//					color = Colores.VIOLET;
//					break;
//				case 7:
//					color = Colores.LIGHT_GREEN;
//					break;
//				case 8:
//					color = Colores.BROWN;
//					break;
//				case 9:
//					color = Colores.NARANJA;
//					break;
//				case 10:
//					color = Colores.CELESTE;
//					break;
//			}
//			System.out.printf("%s●%s\n", color, RESET);
//		}
		
//		System.out.println(VIOLET+ "\r\n" + 
//				" __  __              _               __  __  _             _ \r\n" + 
//				"|  \\/  |            | |             |  \\/  |(_)           | |\r\n" + 
//				"| \\  / |  __ _  ___ | |_  ___  _ __ | \\  / | _  _ __    __| |\r\n" + 
//				"| |\\/| | / _` |/ __|| __|/ _ \\| '__|| |\\/| || || '_ \\  / _` |\r\n" + 
//				"| |  | || (_| |\\__ \\| |_|  __/| |   | |  | || || | | || (_| |\r\n" + 
//				"|_|  |_| \\__,_||___/ \\__|\\___||_|   |_|  |_||_||_| |_| \\__,_|\r\n" + RESET);
//		System.out.println(VIOLET +
//				"• ▌ ▄ ·.  ▄▄▄· .▄▄ ·▄▄▄▄▄▄▄▄ .▄▄▄  • ▌ ▄ ·. ▪   ▐ ▄ ·▄▄▄▄  \r\n" + 
//				"·██ ▐███▪▐█ ▀█ ▐█ ▀.•██  ▀▄.▀·▀▄ █··██ ▐███▪██ •█▌▐███▪ ██ \r\n" + 
//				"▐█ ▌▐▌▐█·▄█▀▀█ ▄▀▀▀█▄▐█.▪▐▀▀▪▄▐▀▀▄ ▐█ ▌▐▌▐█·▐█·▐█▐▐▌▐█· ▐█▌\r\n" + 
//				"██ ██▌▐█▌▐█ ▪▐▌▐█▄▪▐█▐█▌·▐█▄▄▌▐█•█▌██ ██▌▐█▌▐█▌██▐█▌██. ██ \r\n" + 
//				"▀▀  █▪▀▀▀ ▀  ▀  ▀▀▀▀ ▀▀▀  ▀▀▀ .▀  ▀▀▀  █▪▀▀▀▀▀▀▀▀ █▪▀▀▀▀▀• \r\n" + 
//				"" + RESET);
//		System.out.println(AMARILLO +
//				"      :::    :::     :::      ::::::::           ::::::::      :::     ::::    :::     :::     :::::::::   :::::::: \r\n" + 
//				"     :+:    :+:   :+: :+:   :+:    :+:         :+:    :+:   :+: :+:   :+:+:   :+:   :+: :+:   :+:    :+: :+:    :+: \r\n" + 
//				"    +:+    +:+  +:+   +:+  +:+                +:+         +:+   +:+  :+:+:+  +:+  +:+   +:+  +:+    +:+ +:+    +:+  \r\n" + 
//				"   +#++:++#++ +#++:++#++: +#++:++#++         :#:        +#++:++#++: +#+ +:+ +#+ +#++:++#++: +#+    +:+ +#+    +:+   \r\n" + 
//				"  +#+    +#+ +#+     +#+        +#+         +#+   +#+# +#+     +#+ +#+  +#+#+# +#+     +#+ +#+    +#+ +#+    +#+    \r\n" + 
//				" #+#    #+# #+#     #+# #+#    #+#         #+#    #+# #+#     #+# #+#   #+#+# #+#     #+# #+#    #+# #+#    #+#     \r\n" + 
//				"###    ### ###     ###  ########           ########  ###     ### ###    #### ###     ### #########   ########       \r\n" + 
//				""+ RESET);
//		System.out.println(AZUL + 
//				"     .'(    /`-.    )\\.--.         /`-.  )\\.---.   /`-.    )\\.-. .'(    )\\.-.   .-./(  \r\n" + 
//				" ,') \\  ) ,' _  \\  (   ._.'      ,' _  \\(   ,-._(,' _  \\ ,'     )\\  ) ,'     ),'     ) \r\n" + 
//				"(  '-' ( (  '-' (   `-.`.       (  '-' ( \\  '-, (  '-' ((  .-, ( ) ( (  .-, ((  .-, (  \r\n" + 
//				" ) .-.  ) )   _  ) ,_ (  \\       ) ,._.'  ) ,-`  ) ,_ .' ) '._\\ )\\  ) ) '._\\ )) '._\\ ) \r\n" + 
//				"(  ,  ) \\(  ,' ) \\(  '.)  )     (  '     (  ``-.(  ' ) \\(  ,   (  ) \\(  ,   ((  ,   (  \r\n" + 
//				" )/    )/ )/    )/ '._,_.'       )/       )..-.( )/   )/ )/ ._.'   )/ )/ ._.' )/ ._.'  \r\n" + 
//				"                                                                                       \r\n" + 
//				""+ RESET);
//		for (i = 0; i <= 10; i++) {
//			for (j = 0; j <= 2; j++) {
//				if (j == 0) {
//					color = ROJO;
//				}else if (j == 1) {
//					color = AMARILLO;
//				}else if (j == 2) {
//					color = VERDE;
//				}	
//				System.out.print(color + "#" + RESET);
//			}
//		}
//		System.out.println("▬▬▬▬▬▬▬▬▬");
		/*System.out.println("\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		for (i = 0; i < numero; i++) {
			for(j = 0; j < numero; j++) {
				if (j == 0) 
					System.out.print(VERDE + "|"+ RESET);
				System.out.printf("%s⯂%s%s|%2$s", ROJO, RESET, VERDE);
			}*/
//			System.out.println("\n▬▬▬▬▬▬▬▬▬");
			/*System.out.println("\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			if (i == numero-1) 
				System.out.println("Nº Intentos: ??/??\n");
		
		}
		System.out.println();
		for (i = 0; i < numero; i++) {
			for(j = 0; j < numero; j++) {
				System.out.printf("%s  %s ", FONDO_ROJO, RESET);
			}
			System.out.println("\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		}
		System.out.println(BROWN + "\u25A0" + RESET);
		System.out.println(FONDO_ROJO + "  "+ RESET);*/
	}
		
}
