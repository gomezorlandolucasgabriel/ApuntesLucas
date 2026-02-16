package Programacion.Unidad4.ud3.R0;

import java.util.Scanner;

public class ejercicio17 {
    public static String revertirCadena(String cadena) {
        String cadenaRevertida = "";
        for (int i = cadena.length(); i > 0; i--) {
             cadenaRevertida += cadena.charAt(i-1);
        }
        return cadenaRevertida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una cadena de texto: ");
        String texto = scanner.nextLine();
        scanner.close();
        System.out.println("Cadena revertida: " + revertirCadena(texto));
    }
}
