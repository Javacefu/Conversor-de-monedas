import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCliente {
    public static ConversionApi obtenerConversion(String baseMoneda) throws IOException, InterruptedException {
        String apiKey = "d52d1ef4880319015feb94f9"; // Clave API
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/"+baseMoneda; // Enlace completo

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

        return gson.fromJson(json, ConversionApi.class);
    }
}
