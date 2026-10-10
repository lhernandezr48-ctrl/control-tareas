import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Figura[] figuras = {
                new Circulo(5),
                new Rectangulo(4, 6),
                new Triangulo(3, 8)
        };

        System.out.println("===== ÁREAS DE FIGURAS GEOMÉTRICAS =====");

        for (Figura figura : figuras) {
            figura.mostrarInformacion();

            System.out.printf(
                    Locale.US,
                    "Área: %.2f%n%n",
                    figura.calcularArea()
            );
        }
    }
}