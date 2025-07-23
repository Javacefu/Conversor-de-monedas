import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Api {
    public static void main() throws IOException, InterruptedException {
        String monedaConsultada;
        String monedaAConvertir;
        Double valor;
        Double valorConvertido;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar tipo de moneda a consultar:");
        // Clave API
        String apiKey = "d52d1ef4880319015feb94f9";
        // Ingreso del tipo de moneda por el usuario
        monedaConsultada = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese tipo de moneda a la cual desea convertir:");
        monedaAConvertir = scanner.nextLine().toUpperCase();

        while (true) {
            System.out.println("Ingrese el valor que desea convertir:");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next(); // Limpiar entrada no valida
            }
        }
        // Enlace concatenado con la clave y respuesta de usuario
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaConsultada;

        // Conexion con el servidor de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        // Crear variable json con la informacion solicitada
        String json = response.body();
        // Imprimir respuesta (Prueba de codigo hasta aqui)
        System.out.println(json);
        // Creacion de objeto gson
        Gson gson = new Gson();
        // transformar datos de la solicitud
        ConversionApi data = gson.fromJson(json, ConversionApi.class);
        System.out.println("1- Resultado de consulta: " + data.getRespuesta());
        System.out.println("2- Moneda consultada: " + data.getTipoMoneda());
        System.out.println("3- Tabla: " + data.getMonedaYValor());
        System.out.println("4- Tipo de cambio: " + monedaAConvertir + " " + data
                .getMonedaYValor().get(monedaAConvertir));
        valorConvertido = data.getMonedaYValor().get(monedaAConvertir) * valor;
        System.out.println("5- El valor convertido es: " + monedaAConvertir + " " + valorConvertido);

        System.out.println("""
                ***************************************
                ¿Desea realizar otra consulta?
                
                1) Sí.
                2) Volver al menu.
                
                ***************************************                
                """);
        int opcion;
        boolean continuar = true;

        while (true) {

            opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    Api.main();
                    break;
                case 2:
                    Menu.mostrarMenu();
                    continuar = false;
                    break;
            }
        }


    }
}
