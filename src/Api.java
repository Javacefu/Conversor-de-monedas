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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar tipo de moneda a consultar");
        // Clave API
        String apiKey = "d52d1ef4880319015feb94f9";
        // Ingreso del tipo de moneda por el usuario
        String monedaConsultada = scanner.nextLine().toUpperCase();
        // Enlace concatenado con la clave y respuesta de usuario
        String endpoint = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+monedaConsultada;

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
        ConversionApi conversionApi = gson.fromJson(json,ConversionApi.class);
        conversionApi.getRespuesta();
        conversionApi.getTipoMoneda();
        conversionApi.getMonedaYValor();


    }
}
