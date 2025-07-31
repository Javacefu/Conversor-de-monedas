import java.time.LocalDateTime;

public class RegistroConversion extends ConversionApi{
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

    public int getIteracion() {
        return iteracion;
    }
    public String getMonedaBase() {
        return monedaBase;
    }
    public double getMonto() {
        return monto;
    }
    public String getMonedaConvertida() {
        return monedaConvertida;
    }
    public double getConvertido() {
        return convertido;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "Iteración: " + iteracion + ", " + monedaBase + " " +
                monto + " → " + monedaConvertida + " " + convertido +
                " | Fecha: " + fechaHora;
    }

}
