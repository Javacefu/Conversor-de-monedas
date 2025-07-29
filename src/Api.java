import java.io.IOException;
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

                //Mensaje de los valores solicitados y convertidos
                data.resultados(monedaAConsultar,
                        monedaAConvertir,
                        valorSolicitado,
                        valorConvertido);


                HistorialConversiones.agregarRegistro(monedaAConsultar,
                        valorSolicitado,
                        monedaAConvertir,
                        valorConvertido);

                //HistorialConversiones.agregarRegistro(monedaAConsultar, valorSolicitado, monedaAConvertir, valorConvertido);


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
