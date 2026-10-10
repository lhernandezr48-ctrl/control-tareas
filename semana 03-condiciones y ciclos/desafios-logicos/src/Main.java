import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Datos del estudiante
        System.out.println("Lilian Gabriela Hernández Rodríguez");
        System.out.println("Carné: 9941-25-27807");
        System.out.println("Semana 3 — Condiciones y ciclos");

        // Menú principal
        do {
            System.out.println();
            System.out.println("========= DESAFÍOS LÓGICOS =========");
            System.out.println();
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.println();
            System.out.print("Seleccione una opción: ");

            // Validar que se ingrese un número
            if (!sc.hasNextInt()) {
                sc.next(); // descarta el texto inválido
                opcion = 0;
            } else {
                opcion = sc.nextInt();
            }
            sc.nextLine(); // limpia el salto de línea

            switch (opcion) {
                case 1:
                    // OPCIÓN 1: Generar una secuencia
                    break;
                case 2:
                    // OPCIÓN 2: Conteo regresivo
                    break;
                case 3:
                    // OPCIÓN 3: Analizar números
                    break;
                case 4:
                    // OPCIÓN 4: Pirámide
                    break;
                case 5:
                    // OPCIÓN 5: Palabra secreta
                    break;
                case 6:
                    System.out.println("Programa finalizado correctamente.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
