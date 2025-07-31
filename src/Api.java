import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Api {
    public static void apiResponse() throws IOException, InterruptedException {
        String monedaAConsultar;
        String monedaAConvertir;
        Double valorSolicitado;
        Double valorConvertido = 0.0;

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            try {


                System.out.println("Ingresar tipo de moneda a consultar:");
                // Tipo de moneda indicada por el usuario
                monedaAConsultar = scanner.nextLine().toUpperCase();
                // Validar código de moneda
                if (!monedaAConsultar.matches("[A-Z]{3}")) {
                    System.out.println("Código de moneda inválido. Debe tener 3 letras, por ejemplo USD o CLP.");
                    continue;
                }

                System.out.println("Ingrese tipo de moneda a la cual desea convertir:");

                // Tipo de moneda a la cual quiere convertir
                monedaAConvertir = scanner.nextLine().toUpperCase();
                // Validar código de moneda
                if (!monedaAConvertir.matches("[A-Z]{3}")) {
                    System.out.println("Código de moneda inválido. Debe tener 3 letras, por ejemplo USD o CLP.");
                    System.out.println("Intente nuevamente");
                    continue;
                }


                // Validar que el valor a ingresar sea de tipo Double
                System.out.println("Ingrese el valor que desea convertir:");
                while (true) {
                    if (scanner.hasNextDouble()) {
                        valorSolicitado = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                        scanner.next(); // Limpiar entrada no valida
                    }
                }


                // Ejecucion de la API
                ConversionApi data = ApiCliente.obtenerConversion(monedaAConsultar);

                // Resultado de valor a consultar * tipo de cambio
                valorConvertido = valorSolicitado * data.getMonedaYValor().get(monedaAConvertir);

                //Mensaje de los valores solicitados y convertidos
                System.out.printf("1- Monto consultado: %,.2f %s%n", valorSolicitado, monedaAConsultar);
                System.out.printf("2- Tipo de cambio: 1 %s = %,.2f %s%n", monedaAConsultar,
                        data.getMonedaYValor().get(monedaAConvertir), monedaAConvertir);
                System.out.printf("3- Valor convertido: %,.2f %s%n", valorConvertido, monedaAConvertir);

                RegistroConversion registro = new RegistroConversion(monedaAConsultar, monedaAConvertir, valorSolicitado, valorConvertido);
                HistorialConversiones.agregarRegistro(registro);

            } catch (NullPointerException e) {
                System.out.println("Error de ingreso en tipo de moneda: " + e.getCause());
            }


            int opcion;
            scanner.nextLine();
            boolean opcionValida = true;

            while (opcionValida) {

                System.out.println("""
                        
                        ***************************************
                        ¿Desea realizar otra consulta?
                        
                        1) Sí.
                        2) Volver al menu principal.
                        
                        ***************************************
                        """);

                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            opcionValida = false;
                            break;
                        case 2:
                            continuar = false;
                            opcionValida = false;
                            Menu.mostrarMenu();
                            break;
                        default:
                            System.out.println("Ingresar una opción válida: 1 o 2");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida: " + e.getMessage());
                    scanner.nextLine();
                }

            }
        }
    }
}
