import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorOpciones {
    public static int opciones(Scanner scanner) {

        int opcion = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    // Ver tabla
                    case 1:
                        Tabla.mostrarTabla();
                        break;
                    // convertir moneda
                    case 2:
                        Api.apiResponse();
                        break;
                    // Historial de conversiones
                    case 3:
                        System.out.println("Elegiste opcion 3");
                        HistorialDeConversiones.Historial();
                        break;
                    // Salir
                    case 4:
                        System.out.println("Finalizando conversor de monedas, hasta luego.");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Elija una opcion valida entre el 1 y el 4");
                }
            } catch (InputMismatchException | IOException | InterruptedException e) {
                System.out.println("Error: Ha ingresado Texto: " + e.getMessage());
                scanner.nextLine();
            }

        }
        return opcion;
    }
}
