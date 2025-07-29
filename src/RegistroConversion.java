import java.time.LocalDateTime;

public class RegistroConversion {
    private int iteracion;
    private String monedaBase;
    private double monto;
    private String monedaConvertida;
    private double convertido;
    private LocalDateTime fechaHora;

    public RegistroConversion(int iteracion, String monedaBase,
                              double monto, String monedaConvertida,
                              double convertido, LocalDateTime fechaHora) {
        this.iteracion = iteracion;
        this.monedaBase = monedaBase;
        this.monto = monto;
        this.monedaConvertida = monedaConvertida;
        this.convertido = convertido;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Iteración: " + iteracion + ", " + monedaBase + " " +
                monto + " → " + monedaConvertida + " " + convertido +
                " | Fecha: " + fechaHora;
    }

}
