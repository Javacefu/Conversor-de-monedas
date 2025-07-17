import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class ApiClient {
    public static RespuestaDeCambio obtenerTasasCambio(String monedaBase) {
        String apiKey = "d52d1ef4880319015feb94f9";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                System.out.println("Error al conectar con la API: " + connection.getResponseCode());
                return null;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                respuesta.append(inputLine);
            }
            in.close();

            //Parseamos con Gson
            Gson gson = new Gson();
            return gson.fromJson(respuesta.toString(), RespuestaDeCambio.class);


        } catch (Exception e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
            return null;
        }

    }
}
