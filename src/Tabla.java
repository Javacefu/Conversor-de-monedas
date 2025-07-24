import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Tabla {
    public static void mostrarTabla() throws IOException, InterruptedException {
        System.out.println("Clase tabla creada, en construccion...");

        String apiKey = "d52d1ef4880319015feb94f9"; // Clave API
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD"; // Enlace completo

        // Conexion con el servidor de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        ConversionApi data = gson.fromJson(json, ConversionApi.class);

        System.out.println("Mostrando tabla sin procesar: " + data.getMonedaYValor().keySet());

        System.out.println("Volviendo al menu principal");
        Menu.mostrarMenu();
    }
}
