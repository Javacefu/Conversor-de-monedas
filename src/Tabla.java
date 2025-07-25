import java.io.IOException;

public class Tabla {
    public static void mostrarTabla() throws IOException, InterruptedException {
        System.out.println("Clase Tabla en construccion...");
        int column = 4;
        int count = 0;
        //Ejecucion de la Api
        ConversionApi data = ApiCliente.obtenerConversion("USD");

        System.out.println("Codigos de monedas disponibles:");

        System.out.println("Mostrando tabla sin procesar: " + data.getMonedaYValor().keySet());
        System.out.printf("%-10s |", "MONEDA");
        System.out.println("-----------------");

        data.getMonedaYValor().keySet();

//        for (int i = 0; i < data.getMonedaYValor().size(); i++) {
//            System.out.println(data.getMonedaYValor().get());
//        }


        System.out.println("Volviendo al menu principal");
        Menu.mostrarMenu();
    }
}
