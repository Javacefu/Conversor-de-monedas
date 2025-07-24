import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // mensaje de bienvenida
        System.out.println("Bienvenido/a al conversor de monedas");

        // mostrar menu de opciones
        Menu.mostrarMenu();

        // Interaccion del menu
        ValidadorOpciones.opciones(scanner);
    }
}
