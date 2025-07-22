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
                        System.out.println("Elegiste opcion 1");
                        break;
                    // convertir moneda
                    case 2:
                        System.out.println("Elegiste opcion 2");
                        break;
                    // Historial de conversiones
                    case 3:
                        System.out.println("Elegiste opcion 3");
                        break;
                    // Salir
                    case 4:
                        System.out.println("Saliste del menu");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Elija una opcion valida entre el 1 y el 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ha ingresado Texto");
                scanner.nextLine();
            }
        }
        return opcion;
    }
}
