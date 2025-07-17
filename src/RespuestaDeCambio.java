import java.util.Map;

public class RespuestaDeCambio {
    private String resultado;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getResultado() {
        return resultado;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
