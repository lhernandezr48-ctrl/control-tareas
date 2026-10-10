import java.util.Scanner;

public class DesafiosLogicos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Lilian Gabriela Hernández Rodríguez");
        System.out.println("Carne: 9941-25-27807");
        System.out.println("Semana 3 - Condiciones y ciclos");

        do {
            System.out.println("\n========= DESAFÍOS LÓGICOS =========");
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que la opción sea un número entero
            while (true) {
                try {
                    opcion = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Ingrese un número: ");
                }
            }

            switch (opcion) {
                case 1:
                    // Opción 1: Generar una secuencia
                    int inicial;
                    int fin;
                    int incremento;
                    boolean datosValidos = true;

                    try {
                        System.out.print("Número inicial: ");
                        inicial = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Número final: ");
                        fin = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Incremento: ");
                        incremento = Integer.parseInt(scanner.nextLine().trim());

                        if (incremento <= 0) {
                            System.out.println("Error: el incremento debe ser mayor que cero.");
                            datosValidos = false;
                        } else if (fin <= inicial) {
                            System.out.println("Error: el número final debe ser mayor que el inicial.");
                            datosValidos = false;
                        } else {
                            System.out.println("Secuencia generada:");

                            for (int i = inicial; i <= fin; ) {
                                System.out.print(i + " ");

                                // Evitar que la suma exceda el límite de un entero
                                if (i > Integer.MAX_VALUE - incremento) {
                                    break;
                                }

                                i += incremento;
                            }
                            System.out.println();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar números enteros.");
                        datosValidos = false;
                    }
                    break;

                case 2:
                    // Opción 2: Realizar un conteo regresivo
                    int numero = 0;
                    boolean numeroValido = false;

                    while (!numeroValido) {
                        System.out.print("Ingrese el número inicial (10 a 50): ");

                        try {
                            numero = Integer.parseInt(scanner.nextLine().trim());

                            if (numero >= 10 && numero <= 50) {
                                numeroValido = true;
                            } else {
                                System.out.println("Número fuera de rango. Intente nuevamente.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Debe ingresar un número entero.");
                        }
                    }

                    while (numero >= 0) {
                        System.out.print(numero + " ");
                        numero--;
                    }

                    System.out.println("\n¡Despegue!");
                    break;

                case 3:
                    // Opción 3: Analizar números
                    int positivo = 0;
                    int negativo = 0;
                    int ignorados = 0;
                    long suma = 0;

                    while (true) {
                        int valor;

                        System.out.print("Ingrese un número entero (0 para finalizar): ");

                        try {
                            valor = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Ingrese un número entero.");
                            continue;
                        }

                        if (valor == 0) {
                            break;
                        }

                        if (valor > 0) {
                            positivo++;
                        } else if (valor < 0) {
                            negativo++;
                        } else {
                            continue;
                        }

                        if (valor % 5 == 0) {
                            System.out.println("El número " + valor + " fue ignorado.");
                            ignorados++;
                            continue;
                        }

                        suma += valor;
                    }

                    System.out.println("\n========= RESUMEN =========");
                    System.out.println("Positivos: " + positivo);
                    System.out.println("Negativos: " + negativo);
                    System.out.println("Suma válida: " + suma);
                    System.out.println("Números ignorados: " + ignorados);
                    break;

                case 4:
                    // Opción 4: Dibujar una pirámide
                    int altura = 0;
                    boolean alturaValida = false;

                    while (!alturaValida) {
                        System.out.print("Ingrese la altura (3 a 10): ");

                        try {
                            altura = Integer.parseInt(scanner.nextLine().trim());

                            if (altura >= 3 && altura <= 10) {
                                alturaValida = true;
                            } else {
                                System.out.println("La altura debe estar entre 3 y 10.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Ingrese un número entero.");
                        }
                    }

                    for (int fila = 1; fila <= altura; fila++) {
                        for (int espacio = 1; espacio <= altura - fila; espacio++) {
                            System.out.print(" ");
                        }

                        for (int estrella = 1; estrella <= (2 * fila - 1); estrella++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    break;

                case 5:
                    // Opción 5: Validar palabra secreta
                    String palabra;

                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        palabra = scanner.nextLine().trim();

                        if (!palabra.equalsIgnoreCase("Guatemala")) {
                            System.out.println("Palabra incorrecta. Intente nuevamente.");
                        }
                    } while (!palabra.equalsIgnoreCase("Guatemala"));

                    System.out.println("Palabra correcta.");
                    break;

                case 6:
                    // Opción 6: Salir del programa
                    System.out.println("Programa finalizado correctamente.");
                    break;

                default:
                    System.out.println("Opción inexistente. Seleccione una opción del 1 al 6.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }
}
