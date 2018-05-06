package utilities;

import java.util.*;

public class Teclado {
	private static Scanner teclado = new Scanner(System.in);

	public static enum Es {
		MAYOR, MENOR, MAYOR_IGUAL, MENOR_IGUAL
	}

	public static enum Rango {
		AMBOS_INCLUIDOS, AMBOS_EXCLUIDOS, MIN_INCLUIDO, MAX_INCLUIDO
	}

	public static enum Tipo {
		BYTE, SHORT, INT, LONG, FLOAT, DOUBLE
	}

	// Cerrar teclado.
	public static void cerrarTeclado() {
		teclado.close();
	}

	// Leer un caracter.
	public static char leerChar() {
		char caracter;
		caracter = teclado.next().charAt(0);
		return caracter;
	}

	public static char leerChar(String mensaje) {
		char caracter;
		System.out.println(mensaje);
		caracter = teclado.next().charAt(0);
		return caracter;
	}

	// Leer una cadena.
	public static String leerCadena() {
		String cadena;
		do {
			cadena = teclado.nextLine();
		} while (cadena.equals(""));
		return cadena;
	}

	public static String leerCadena(String mensaje) {
		String cadena;
		do {
			System.out.println(mensaje);
			cadena = teclado.nextLine();
		} while (cadena.equals(""));
		return cadena;
	}

	// Leer un booleano con opciones.
	public static boolean leerBoolean(String mensaje, String opcionT, String opcionF) {
		byte respuesta;
		// boolean booleano;
		do {
			System.out.printf("%s\n\t1. %s\n\t2. %s\n", mensaje, opcionT, opcionF);
			respuesta = leerNumeros(Tipo.BYTE);
			if (respuesta != 1 && respuesta != 2) {
				System.out.println("Introduce una opcion valida");
			}
		} while (respuesta != 1 && respuesta != 2);
		// booleano = respuesta == 1 ? true : false;
		return respuesta == 1;
	}

	// Leer un boleano con una pregunta si o no.
	public static boolean leerBoolean(String pregunta) {
		String respuesta;
		// boolean booleano;
		do {
			System.out.printf("%s s/n\n", pregunta);
			respuesta = leerCadena().toUpperCase();
		} while (!respuesta.equals("S") && !respuesta.equals("N"));
		// booleano = respuesta.equals("S") ? true : false;
		return respuesta.equals("S");
	}

	// Leer numeros.
	@SuppressWarnings("unchecked")
	public static <Y> Y leerNumeros(Tipo tipo) {
		Y numero = null;
		boolean noValido;

		do {
			noValido = false;
			try {
				switch (tipo) {
					case BYTE:
						numero = (Y) Byte.valueOf(teclado.nextByte());
						break;
					case SHORT:
						numero = (Y) Short.valueOf(teclado.nextShort());
						break;
					case INT:
						numero = (Y) Integer.valueOf(teclado.nextInt());
						break;
					case LONG:
						numero = (Y) Long.valueOf(teclado.nextLong());
						break;
					case FLOAT:
						numero = (Y) Float.valueOf(teclado.nextFloat());
						break;
					case DOUBLE:
						numero = (Y) Double.valueOf(teclado.nextDouble());
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error, el valor introducido no es valido");
				noValido = true;
			} finally {
				teclado.nextLine();
			}
		} while (noValido);
		return numero;
	}

	// Numero menor/mayor
	public static <Y> Y mayor_menor(Y numero, Es es, Tipo tipo) {
		Y numero2 = null;
		int comparacion = 0;
		boolean noValido;
		
		do {
			noValido = true;
			numero2 = leerNumeros(tipo);
			switch(es) {
				case MENOR:
				switch (tipo) {
					case BYTE:
						comparacion = ((Byte)numero2).compareTo((Byte) numero);
						break;
					case SHORT:
						comparacion = ((Short)numero2).compareTo((Short) numero);
						break;
					case INT:
						comparacion = ((Integer)numero2).compareTo((Integer) numero);
						break;
					case LONG:
						comparacion = ((Long)numero2).compareTo((Long) numero);
						break;
					case FLOAT:
						comparacion = ((Float)numero2).compareTo((Float) numero);
						break;
					case DOUBLE:
						comparacion = ((Double)numero2).compareTo((Double) numero);
						break;
				}
				if(comparacion < 0) 
					noValido = false;
				else 
					System.out.printf("El numero debe ser menor que %d\n", numero);
				break;
				case MENOR_IGUAL:
					switch (tipo) {
						case BYTE:
							comparacion = ((Byte)numero2).compareTo((Byte) numero);
							break;
						case SHORT:
							comparacion = ((Short)numero2).compareTo((Short) numero);
							break;
						case INT:
							comparacion = ((Integer)numero2).compareTo((Integer) numero);
							break;
						case LONG:
							comparacion = ((Long)numero2).compareTo((Long) numero);
							break;
						case FLOAT:
							comparacion = ((Float)numero2).compareTo((Float) numero);
							break;
						case DOUBLE:
							comparacion = ((Double)numero2).compareTo((Double) numero);
							break;
					}
					if(comparacion <= 0) 
						noValido = false;
					else
						System.out.printf("El numero debe ser menor igual que %d\n", numero);
					break;
				case MAYOR:
					switch (tipo) {
						case BYTE:
							comparacion = ((Byte)numero2).compareTo((Byte) numero);
							break;
						case SHORT:
							comparacion = ((Short)numero2).compareTo((Short) numero);
							break;
						case INT:
							comparacion = ((Integer)numero2).compareTo((Integer) numero);
							break;
						case LONG:
							comparacion = ((Long)numero2).compareTo((Long) numero);
							break;
						case FLOAT:
							comparacion = ((Float)numero2).compareTo((Float) numero);
							break;
						case DOUBLE:
							comparacion = ((Double)numero2).compareTo((Double) numero);
							break;
					}
					if(comparacion <= 0) 
						noValido = false;
					else
						System.out.printf("El numero debe ser mayor que %d\n", numero);
					break;
				case MAYOR_IGUAL:
					switch (tipo) {
						case BYTE:
							comparacion = ((Byte)numero2).compareTo((Byte) numero);
							break;
						case SHORT:
							comparacion = ((Short)numero2).compareTo((Short) numero);
							break;
						case INT:
							comparacion = ((Integer)numero2).compareTo((Integer) numero);
							break;
						case LONG:
							comparacion = ((Long)numero2).compareTo((Long) numero);
							break;
						case FLOAT:
							comparacion = ((Float)numero2).compareTo((Float) numero);
							break;
						case DOUBLE:
							comparacion = ((Double)numero2).compareTo((Double) numero);
							break;
					}
					if(comparacion <= 0)
						noValido = false;
					else
						System.out.printf("El numero debe ser mayor igual igual que %d\n", numero);
					break;
			}
		} while(noValido);
		return numero2;
	}
	
	// rango
	public static <Y> Y rango(Y numeroInferior, Y numeroSuperior, Rango rango, Tipo tipo) {
		Y numero;
		boolean noValido, comparacion = false;
		do {
			numero = leerNumeros(tipo);
			noValido = true;
			switch (rango) {
				case AMBOS_INCLUIDOS:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero >= (Byte)numeroInferior && (Byte)numeroSuperior >= (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero >= (Short)numeroInferior && (Short)numeroSuperior >= (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero >= (Integer)numeroInferior && (Integer)numeroSuperior >= (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero >= (Long)numeroInferior && (Long)numeroSuperior >= (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero >= (Float)numeroInferior && (Float)numeroSuperior >= (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero >= (Double)numeroInferior && (Double)numeroSuperior >= (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("El numero debe de ser mayor que %d y menor que %d\n", numeroInferior, numeroSuperior);
					break;
				case AMBOS_EXCLUIDOS:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero > (Byte)numeroInferior && (Byte)numeroSuperior > (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero > (Short)numeroInferior && (Short)numeroSuperior > (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero > (Integer)numeroInferior && (Integer)numeroSuperior > (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero > (Long)numeroInferior && (Long)numeroSuperior > (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero > (Float)numeroInferior && (Float)numeroSuperior > (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero > (Double)numeroInferior && (Double)numeroSuperior > (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("El numero debe de ser mayor que %d y menor que %d (ambos excluidos)\n", numeroInferior, numeroSuperior);
					break;
				case MIN_INCLUIDO:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero >= (Byte)numeroInferior && (Byte)numeroSuperior > (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero >= (Short)numeroInferior && (Short)numeroSuperior > (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero >= (Integer)numeroInferior && (Integer)numeroSuperior > (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero >= (Long)numeroInferior && (Long)numeroSuperior > (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero >= (Float)numeroInferior && (Float)numeroSuperior > (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero >= (Double)numeroInferior && (Double)numeroSuperior > (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("El numero debe de ser mayor que %d y menor que %d (no incluido)\n", numeroInferior, numeroSuperior);
					break;
				case MAX_INCLUIDO:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero > (Byte)numeroInferior && (Byte)numeroSuperior >= (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero > (Short)numeroInferior && (Short)numeroSuperior >= (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero > (Integer)numeroInferior && (Integer)numeroSuperior >= (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero > (Long)numeroInferior && (Long)numeroSuperior >= (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero > (Float)numeroInferior && (Float)numeroSuperior >= (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero > (Double)numeroInferior && (Double)numeroSuperior >= (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("El numero debe de ser mayor que %d (no incluido) y menor que %d\n", numeroInferior, numeroSuperior);
					break;
			}
		} while(noValido);
		return numero;
	}
	// Rango con mensaje.
	public static <Y> Y rango(Y numeroInferior, Y numeroSuperior, Rango rango, Tipo tipo, String mensaje) {
		Y numero;
		boolean noValido, comparacion = false;
		do {
			numero = leerNumeros(tipo);
			noValido = true;
			switch (rango) {
				case AMBOS_INCLUIDOS:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero >= (Byte)numeroInferior && (Byte)numeroSuperior >= (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero >= (Short)numeroInferior && (Short)numeroSuperior >= (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero >= (Integer)numeroInferior && (Integer)numeroSuperior >= (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero >= (Long)numeroInferior && (Long)numeroSuperior >= (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero >= (Float)numeroInferior && (Float)numeroSuperior >= (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero >= (Double)numeroInferior && (Double)numeroSuperior >= (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("%s\n", mensaje);
					break;
				case AMBOS_EXCLUIDOS:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero > (Byte)numeroInferior && (Byte)numeroSuperior > (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero > (Short)numeroInferior && (Short)numeroSuperior > (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero > (Integer)numeroInferior && (Integer)numeroSuperior > (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero > (Long)numeroInferior && (Long)numeroSuperior > (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero > (Float)numeroInferior && (Float)numeroSuperior > (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero > (Double)numeroInferior && (Double)numeroSuperior > (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("%s\n", mensaje);
					break;
				case MIN_INCLUIDO:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero >= (Byte)numeroInferior && (Byte)numeroSuperior > (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero >= (Short)numeroInferior && (Short)numeroSuperior > (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero >= (Integer)numeroInferior && (Integer)numeroSuperior > (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero >= (Long)numeroInferior && (Long)numeroSuperior > (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero >= (Float)numeroInferior && (Float)numeroSuperior > (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero >= (Double)numeroInferior && (Double)numeroSuperior > (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("%s\n", mensaje);
					break;
				case MAX_INCLUIDO:
					switch (tipo) {
						case BYTE:
							if ((Byte)numeroInferior >= (Byte)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Byte)numero > (Byte)numeroInferior && (Byte)numeroSuperior >= (Byte)numero;
							break;
						case SHORT:
							if ((Short)numeroInferior >= (Short)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Short)numero > (Short)numeroInferior && (Short)numeroSuperior >= (Short)numero;
							break;
						case INT:
							if ((Integer)numeroInferior >= (Integer)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Integer)numero > (Integer)numeroInferior && (Integer)numeroSuperior >= (Integer)numero;
							break;
						case LONG:
							if ((Long)numeroInferior >= (Long)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Long)numero > (Long)numeroInferior && (Long)numeroSuperior >= (Long)numero;
							break;
						case FLOAT:
							if ((Float)numeroInferior >= (Float)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Float)numero > (Float)numeroInferior && (Float)numeroSuperior >= (Float)numero;
							break;
						case DOUBLE:
							if ((Double)numeroInferior >= (Double)numeroSuperior) {
								throw new IllegalArgumentException("Error, el numero inferior no puede ser mayor o igual al superior");
							}
							comparacion = (Double)numero > (Double)numeroInferior && (Double)numeroSuperior >= (Double)numero;
							break;
					}
					if (comparacion)
						noValido = false;
					else
						System.out.printf("%s\n", mensaje);
					break;
			}
		} while(noValido);
		return numero;
	}
}
