import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ConversionApi {
    @SerializedName("result")
    private String respuesta;
    @SerializedName("base_code")
    private String tipoMoneda;
    @SerializedName("conversion_rates")
    private Map <String, Double> monedaYValor;
    
    public String getRespuesta() {
        System.out.println(respuesta);
        return respuesta;
    }

    public String getTipoMoneda() {
        System.out.println(tipoMoneda);
        return tipoMoneda;
    }

    public Map<String, Double> getMonedaYValor() {
        System.out.println(monedaYValor);
        return monedaYValor;
    }
}
