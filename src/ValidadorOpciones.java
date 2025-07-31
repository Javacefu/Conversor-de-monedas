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
                    case 3:
                        HistorialConversiones.mostrarHistorial();
                        try {
                            System.out.println("\nRedirigiendo al menú en 3 segundos\n");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("La pausa fue interrumpida.");
                        }
                        Menu.mostrarMenu();
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
