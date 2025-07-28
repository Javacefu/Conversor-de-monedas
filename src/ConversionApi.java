import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ConversionApi {
    @SerializedName("result")
    private String respuesta;
    @SerializedName("base_code")
    private String tipoMoneda;
    @SerializedName("conversion_rates")
    private Map<String, Double> monedaYValor;

    public String getRespuesta() {
        return respuesta;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public Map<String, Double> getMonedaYValor() {
        return monedaYValor;
    }

    void resultados(String primMoneda,
                    String segMoneda,
                    Double primValor,
                    Double segValor) {
        System.out.printf("* Monto consultado: %,.2f %s%n", primValor, getTipoMoneda());
        System.out.printf("* Tipo de cambio: 1 %s = %,.2f %s%n", primMoneda, getMonedaYValor()
                .get(segMoneda), segMoneda);
        segValor = getMonedaYValor().get(segMoneda) * primValor;
        System.out.printf("* Valor convertido: %,.2f %s%n", segValor, segMoneda);
    }
}

