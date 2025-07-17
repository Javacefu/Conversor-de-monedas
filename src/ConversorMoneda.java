import java.util.Scanner;

public class ConversorMoneda {
    public static void main(String[] args) {
        String monedaOrigen;
        String monedaDestino;
        double valorIngresado = 0.0;
        System.out.println("Bienvenido al conversor de monedas");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese el tipo de moneda de origen:");
        monedaOrigen = scanner.nextLine();

//      Validacion de ingreso de numero
        while (true) {
            System.out.println("Ingrese el valor a convertir:");
            if (scanner.hasNextDouble()) {
                valorIngresado = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer
                break;
            } else {
                System.out.println("Error: debe ingresar un numero valido.");
                scanner.nextLine(); // Descartar entrada invalida
            }
        }


        System.out.println("Ingrese el tipo de moneda de destino:");
        monedaDestino = scanner.nextLine();

        //      simulacion de tasa de cambio (Provisional)
        double tasaDeCambio = 900;
        double valorConvertido = valorIngresado * tasaDeCambio;

        System.out.printf("Resultado: %s %.2f%n", monedaDestino.toUpperCase(), valorConvertido);

        scanner.close();
    }
}