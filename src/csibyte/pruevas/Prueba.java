package csibyte.pruevas;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String salir = "";
        while (!salir.equalsIgnoreCase("salir")){
            System.out.println("Escribe algo (escribe 'salir' para terminar):");
            String entrada = scanner.nextLine();
            System.out.println("Has escrito: " + entrada+ "\n*****************\n");

            System.out.println("¿Deseas continuar? (escribe 'no' para salir o cualquier otra cosa para continuar):");
            String continuar = scanner.nextLine();

            if (continuar.equalsIgnoreCase("no")){
                System.out.println("estas saliendo del bucle");
                break;
            }
            System.out.println("Has escrito: " + continuar+ "\n*****************\n");
        }
        System.out.println("has salido del bucle");
        scanner.close();
    }
}
