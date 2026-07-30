import java.util.Scanner;

public class CalculadoraEdad {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicita la información necesaria para calcular la edad aproximada
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su carné: ");
        String carne = scanner.nextLine();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        System.out.print("Ingrese el año actual: ");
        int anioActual = scanner.nextInt();

        // Calcula la edad aproximada y determina si es mayor de edad
        int edad = anioActual - anioNacimiento;
        int meses = edad * 12;
        boolean mayorEdad = edad >= 18;

        System.out.println("\n----- RESULTADO -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Carné: " + carne);
        System.out.println("Edad aproximada: " + edad + " años");
        System.out.println("Edad aproximada en meses: " + meses + " meses");
        System.out.println("¿Es mayor de edad?: " + mayorEdad);

        scanner.close();
    }
}
