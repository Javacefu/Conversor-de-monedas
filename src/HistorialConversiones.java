import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
//    historial es una Lista
//    iteracion mira el tamaño de la lista y se suma 1 mas
//    registro deriva de la Clase RegistroConversion y utiliza las variables
//    LocalDateTime.now() entrega la fecha y hora actuales
//    historial.add(registro) se agrega la informacion de registro a la lista de historial

    private static List<RegistroConversion> historial = new ArrayList<>();

    public static void agregarRegistro (String monedaBase,      // Moneda solicitada
                                        double monto,           // Monto solicitado
                                        String monedaDestino,   // Moneda que se desea
                                        double convertido) {    // Valor convertido
        int iteracion = historial.size() + 1;
        RegistroConversion registro = new RegistroConversion(iteracion, monedaBase, monto, monedaDestino,
                convertido, LocalDateTime.now());
        historial.add(registro);
    }

    public static void mostrarHistorial() {
        for (RegistroConversion r : historial) {
            System.out.println(r);
        }
    }

    //    Getter de historial
    public static List<RegistroConversion> getHistorial() {
        return historial;
    }

}
