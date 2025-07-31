import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double valorIngresado;
    private double valorConvertido;
    private LocalDateTime fechaYHora;

    public RegistroConversion(String monedaOrigen, String monedaDestino, double valorIngresado, double valorConvertido) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.valorIngresado = valorIngresado;
        this.valorConvertido = valorConvertido;
        this.fechaYHora = LocalDateTime.now();
    }

    public String formatoTabla(int number){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH:mm:ss");
        return String.format("%3d | %,16.2f | %13s | → | %,16.2f | %14s | %s",
                number,
                valorIngresado,
                monedaOrigen,
                valorConvertido,
                monedaDestino,
                fechaYHora.format(formato)
        );
    }

}
