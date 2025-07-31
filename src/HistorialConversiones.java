import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private static List<RegistroConversion> historial = new ArrayList<>();

    public static void agregarRegistro(RegistroConversion registro) {
        historial.add(registro);
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            System.out.println(" Nº | Valor Consultado | Moneda Origen | → | Valor Resultante | Moneda Destino | Fecha y Hora");
            System.out.println("----|------------------|---------------|---|------------------|----------------|---------------------");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println(historial.get(i).formatoTabla(i+1));
            }
        }
    }
}