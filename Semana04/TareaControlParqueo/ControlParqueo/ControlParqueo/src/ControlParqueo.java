import java.util.Scanner;

public class ControlParqueo {

    static final double RECARGO_TICKET = 50.00;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String nombre = "Lilian Gabriela Hernandez Rodriguez";
        String carne = "9941-25-27807";

        System.out.println("---");
        System.out.println("SISTEMA DE CONTROL DE PARQUEO");
        System.out.println("---");
        System.out.println("Estudiante: " + nombre);
        System.out.println("Carné: " + carne);
        System.out.println();

        int cantidadVehiculos;

        do {
            System.out.print("Ingrese la cantidad de vehículos a registrar: ");
            cantidadVehiculos = entrada.nextInt();

            if (cantidadVehiculos <= 0) {
                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }

        } while (cantidadVehiculos <= 0);

        int cantidadMotocicletas = 0;
        int cantidadAutomoviles = 0;
        int cantidadPickups = 0;
        int cantidadTicketsPerdidos = 0;

        double totalRecaudado = 0;
        double pagoMasAlto = 0;
        String placaPagoMasAlto = "";

        for (int i = 1; i <= cantidadVehiculos; i++) {

            System.out.println();
            System.out.println("---");
            System.out.println("REGISTRO DEL VEHÍCULO " + i);
            System.out.println("---");

            entrada.nextLine();

            System.out.print("Número de placa: ");
            String placa = entrada.nextLine();

            int tipoVehiculo;

            do {
                System.out.println();
                System.out.println("1. Motocicleta");
                System.out.println("2. Automóvil");
                System.out.println("3. Pickup o camioneta");
                System.out.print("Seleccione el tipo de vehículo: ");

                tipoVehiculo = entrada.nextInt();

                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println("Error: debe seleccionar 1, 2 o 3.");
                }

            } while (tipoVehiculo < 1 || tipoVehiculo > 3);

            int horaEntrada;
            int minutoEntrada;
            int horaSalida;
            int minutoSalida;

            do {
                System.out.print("Hora de entrada (0-23): ");
                horaEntrada = entrada.nextInt();

                if (horaEntrada < 0 || horaEntrada > 23) {
                    System.out.println("Error: la hora debe estar entre 0 y 23.");
                }

            } while (horaEntrada < 0 || horaEntrada > 23);

            do {
                System.out.print("Minuto de entrada (0-59): ");
                minutoEntrada = entrada.nextInt();

                if (minutoEntrada < 0 || minutoEntrada > 59) {
                    System.out.println("Error: los minutos deben estar entre 0 y 59.");
                }

            } while (minutoEntrada < 0 || minutoEntrada > 59);

            do {
                System.out.print("Hora de salida (0-23): ");
                horaSalida = entrada.nextInt();

                if (horaSalida < 0 || horaSalida > 23) {
                    System.out.println("Error: la hora debe estar entre 0 y 23.");
                }

            } while (horaSalida < 0 || horaSalida > 23);

            do {
                System.out.print("Minuto de salida (0-59): ");
                minutoSalida = entrada.nextInt();

                if (minutoSalida < 0 || minutoSalida > 59) {
                    System.out.println("Error: los minutos deben estar entre 0 y 59.");
                }

            } while (minutoSalida < 0 || minutoSalida > 59);

            int minutosEntrada = horaEntrada * 60 + minutoEntrada;
            int minutosSalida = horaSalida * 60 + minutoSalida;

            int minutosEstacionado;

            if (minutosSalida < minutosEntrada) {
                minutosEstacionado = (1440 - minutosEntrada) + minutosSalida;
            } else {
                minutosEstacionado = minutosSalida - minutosEntrada;
            }

            if (minutosEstacionado == 0) {
                System.out.println("Error: la salida debe ser diferente a la entrada.");
                i--;
                continue;
            }

            int horasCobradas = (minutosEstacionado + 59) / 60;

            char ticket;

            do {
                System.out.print("¿Perdió el ticket? (S/N): ");
                ticket = entrada.next().toUpperCase().charAt(0);

                if (ticket != 'S' && ticket != 'N') {
                    System.out.println("Error: solamente puede ingresar S o N.");
                }

            } while (ticket != 'S' && ticket != 'N');

            double tarifa = obtenerTarifa(tipoVehiculo);
            double subtotal = horasCobradas * tarifa;
            double descuento = calcularDescuento(subtotal, horasCobradas);

            double total;

            if (ticket == 'S') {
                total = calcularPago(horasCobradas, tarifa, RECARGO_TICKET);
                total = total - descuento;
                cantidadTicketsPerdidos++;
            } else {
                total = calcularPago(horasCobradas, tarifa);
                total = total - descuento;
            }

            switch (tipoVehiculo) {
                case 1:
                    cantidadMotocicletas++;
                    break;
                case 2:
                    cantidadAutomoviles++;
                    break;
                case 3:
                    cantidadPickups++;
                    break;
            }

            totalRecaudado += total;

            if (total > pagoMasAlto) {
                pagoMasAlto = total;
                placaPagoMasAlto = placa;
            }

            mostrarComprobante(
                    placa,
                    tipoVehiculo,
                    minutosEstacionado,
                    horasCobradas,
                    tarifa,
                    subtotal,
                    descuento,
                    ticket,
                    total
            );
        }

        System.out.println();
        System.out.println("---");
        System.out.println("RESUMEN DE LA JORNADA");
        System.out.println("---");

        System.out.println("Motocicletas: " + cantidadMotocicletas);
        System.out.println("Automóviles: " + cantidadAutomoviles);
        System.out.println("Pickups o camionetas: " + cantidadPickups);
        System.out.println("Tickets perdidos: " + cantidadTicketsPerdidos);
        System.out.printf("Total recaudado: Q%.2f%n", totalRecaudado);
        System.out.printf("Pago más alto: Q%.2f%n", pagoMasAlto);
        System.out.println("Placa del pago más alto: " + placaPagoMasAlto);

        System.out.println("---");
        System.out.println("FIN DEL PROGRAMA");
        System.out.println("---");

        entrada.close();
    }

    public static double obtenerTarifa(int tipoVehiculo) {

        switch (tipoVehiculo) {
            case 1:
                return 5.00;
            case 2:
                return 8.00;
            case 3:
                return 12.00;
            default:
                return 0;
        }
    }

    public static String obtenerNombreVehiculo(int tipoVehiculo) {

        switch (tipoVehiculo) {
            case 1:
                return "Motocicleta";
            case 2:
                return "Automóvil";
            case 3:
                return "Pickup o camioneta";
            default:
                return "Desconocido";
        }
    }

    public static double calcularDescuento(double subtotal, int horas) {

        if (horas > 8) {
            return subtotal * 0.15;
        } else {
            return 0;
        }
    }

    public static double calcularPago(int horas, double tarifa) {

        return horas * tarifa;
    }

    public static double calcularPago(int horas, double tarifa, double recargo) {

        return (horas * tarifa) + recargo;
    }

    public static void mostrarComprobante(
            String placa,
            int tipoVehiculo,
            int minutosEstacionado,
            int horasCobradas,
            double tarifa,
            double subtotal,
            double descuento,
            char ticket,
            double total) {

        double recargo = 0;

        if (ticket == 'S') {
            recargo = RECARGO_TICKET;
        }

        int horas = minutosEstacionado / 60;
        int minutos = minutosEstacionado % 60;

        System.out.println();
        System.out.println("---COMPROBANTE---");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + obtenerNombreVehiculo(tipoVehiculo));
        System.out.println("Tiempo estacionado: " + horas + " horas y " + minutos + " minutos");
        System.out.println("Horas cobradas: " + horasCobradas);
        System.out.printf("Tarifa por hora: Q%.2f%n", tarifa);
        System.out.printf("Subtotal: Q%.2f%n", subtotal);
        System.out.printf("Descuento: Q%.2f%n", descuento);
        System.out.printf("Recargo por ticket perdido: Q%.2f%n", recargo);
        System.out.printf("TOTAL: Q%.2f%n", total);
        System.out.println("---");
    }
}
