import java.io.IOException;

public class Tabla {
    public static void mostrarTabla() throws IOException, InterruptedException {

        int column = 5;
        int count = 0;
        //Ejecucion de la Api
        ConversionApi data = ApiCliente.obtenerConversion("USD");

        System.out.printf("%35s%n","Codigos de monedas disponibles");
        System.out.println("  ______________________________________");

        for (String moneda : data.getMonedaYValor().keySet()) {
            System.out.printf("%5s  |", moneda);
            count++;
            if (count % column == 0) {
                System.out.println();
            }
        }
        if (count % column != 0) {
            System.out.println();
        }
        System.out.println("  ______________________________________");


        System.out.println("\nVolviendo al menu principal\n");
        Menu.mostrarMenu();
    }
}
