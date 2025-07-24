import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Api {
    public static void apiResponse() throws IOException, InterruptedException {
        String monedaAConsultar;
        String monedaAConvertir;
        Double valorSolicitado;
        Double valorConvertido;
        String apiKey = "d52d1ef4880319015feb94f9"; // Clave API

        Scanner scanner = new Scanner(System.in);

//        PARA EL INGRESO DE MONEDAS A CONSULTAR Y CONVERTIR SE DEBE VER LA OPCION DE INGRESAR EXCEPCIONES
//        PARA VALORES QUE NO SEAN LOS QUE ESTAN CONTENIDOS EN LA TABLA O SEAN DE OTRO FORMATO COMO NUMERO
//        LINEAS 24:30

        System.out.println("Ingresar tipo de moneda a consultar:");
        // Tipo de moneda indicada por el usuario
        monedaAConsultar = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese tipo de moneda a la cual desea convertir:");
        // Tipo de moneda a la cual quiere convertir
        monedaAConvertir = scanner.nextLine().toUpperCase();


        // Validar que el valor a ingresar sea de tipo Double
        while (true) {
            System.out.println("Ingrese el valor que desea convertir:");
            if (scanner.hasNextDouble()) {
                valorSolicitado = scanner.nextDouble();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next(); // Limpiar entrada no valida
            }
        }

        // Enlace concatenado con la clave y respuesta de usuario
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaAConsultar;

        // Conexion con el servidor de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Crear variable json con la informacion solicitada
        String json = response.body();

        // Creacion de objeto gson
        Gson gson = new Gson();

        // transformar datos de la solicitud
        ConversionApi data = gson.fromJson(json, ConversionApi.class);
        System.out.println("1- Resultado de consulta: " + data.getRespuesta());
        System.out.println("2- Moneda consultada: " + data.getTipoMoneda());
        System.out.println("3- Tipo de cambio: " + monedaAConvertir + " " + data
                .getMonedaYValor().get(monedaAConvertir));
        valorConvertido = data.getMonedaYValor().get(monedaAConvertir) * valorSolicitado;
        System.out.println("4- El valor convertido es: " + monedaAConvertir + " " + valorConvertido);

        int opcion;
        boolean continuar = true;
        scanner.nextLine();

        System.out.println("""
                ***************************************
                ¿Desea realizar otra consulta?
                
                1) Sí.
                2) Volver al menu principal.
                
                ***************************************                
                """);

        while (continuar) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        Api.apiResponse();
                        break;
                    case 2:
                        Menu.mostrarMenu();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Ingresar una opción valida 1 o 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar una opcion (1 o 2).");
            }


        }
    }
}
