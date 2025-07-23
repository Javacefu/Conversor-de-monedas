import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // mensaje de bienvenida
        System.out.println("Bienvenido/a al conversor de monedas");
        // mostrar menu de opciones
        Menu.mostrarMenu();

        Scanner scanner = new Scanner(System.in);
        // Interaccion del menu
        ValidadorOpciones.opciones(scanner);
    }
}
