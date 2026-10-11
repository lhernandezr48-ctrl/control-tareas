import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Locale;

public class MainControlCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        HashSet<String> categorias = new HashSet<>();
        HashMap<String, Double> totalPorCategoria = new HashMap<>();

        int cantidadProductos;

        System.out.println("===== CONTROL DE COMPRAS DEL HOGAR =====");

        System.out.print("Cantidad de productos que desea registrar (mínimo 5): ");
        cantidadProductos = Integer.parseInt(scanner.nextLine().trim());

        while (cantidadProductos < 5) {
            System.out.println("Debe registrar al menos 5 productos.");
            System.out.print("Ingrese nuevamente la cantidad: ");
            cantidadProductos = Integer.parseInt(scanner.nextLine().trim());
        }

        while (productos.size() < cantidadProductos) {
            System.out.println("\nProducto " + (productos.size() + 1));

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: Q");
            double precio = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Cantidad comprada: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());

            if (nombre.isEmpty()) {
                System.out.println(
                        "Producto no registrado: el nombre no puede estar vacío."
                );
            } else if (categoria.isEmpty()) {
                System.out.println(
                        "Producto no registrado: la categoría no puede estar vacía."
                );
            } else if (precio <= 0) {
                System.out.println(
                        "Producto no registrado: el precio debe ser mayor que cero."
                );
            } else if (cantidad <= 0) {
                System.out.println(
                        "Producto no registrado: la cantidad debe ser mayor que cero."
                );
            } else {
                Producto producto = new Producto(
                        nombre, categoria, precio, cantidad
                );

                productos.add(producto);
                categorias.add(categoria);

                double subtotal = producto.calcularSubtotal();

                totalPorCategoria.put(
                        categoria,
                        totalPorCategoria.getOrDefault(categoria, 0.0) + subtotal
                );

                System.out.println("Producto registrado correctamente.");
            }
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====");

        double totalGeneral = 0;
        Producto mayorGasto = productos.get(0);
        Producto menorGasto = productos.get(0);

        for (Producto producto : productos) {
            double subtotal = producto.calcularSubtotal();
            totalGeneral += subtotal;

            System.out.printf(
                    Locale.US,
                    "%s | %s | Q%.2f x %d | Subtotal: Q%.2f%n",
                    producto.getNombre(),
                    producto.getCategoria(),
                    producto.getPrecioUnitario(),
                    producto.getCantidad(),
                    subtotal
            );

            if (subtotal > mayorGasto.calcularSubtotal()) {
                mayorGasto = producto;
            }

            if (subtotal < menorGasto.calcularSubtotal()) {
                menorGasto = producto;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categorias);

        System.out.println("\nTotal por categoría:");

        String categoriaMayorGasto = "";
        double mayorTotalCategoria = -1;

        for (String categoria : categorias) {
            double total = totalPorCategoria.get(categoria);

            System.out.printf(
                    Locale.US, "%s: Q%.2f%n", categoria, total
            );

            if (total > mayorTotalCategoria) {
                mayorTotalCategoria = total;
                categoriaMayorGasto = categoria;
            }
        }

        System.out.println("\nProductos registrados: " + productos.size());

        System.out.printf(
                Locale.US, "Total general: Q%.2f%n", totalGeneral
        );

        System.out.println("\nProducto con mayor gasto:");
        System.out.printf(
                Locale.US, "%s - Q%.2f%n",
                mayorGasto.getNombre(),
                mayorGasto.calcularSubtotal()
        );

        System.out.println("\nProducto con menor gasto:");
        System.out.printf(
                Locale.US, "%s - Q%.2f%n",
                menorGasto.getNombre(),
                menorGasto.calcularSubtotal()
        );

        System.out.println("\nCategoría con mayor gasto:");
        System.out.printf(
                Locale.US, "%s - Q%.2f%n",
                categoriaMayorGasto,
                mayorTotalCategoria
        );

        System.out.print("\nIngrese una categoría para consultar: ");
        String consulta = scanner.nextLine().trim();

        if (totalPorCategoria.containsKey(consulta)) {
            System.out.printf(
                    Locale.US,
                    "Total gastado en %s: Q%.2f%n",
                    consulta,
                    totalPorCategoria.get(consulta)
            );
        } else {
            System.out.println(
                    "La categoría ingresada no se encuentra registrada."
            );
        }

        scanner.close();
    }
}
