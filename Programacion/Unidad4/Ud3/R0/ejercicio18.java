package ejercicios.ud3.r0;

import java.util.Scanner;

public class ejercicio18 {
    public static int contarVocalesEnCadena(String cadenaTexto) {
        int cantidadVocales = 0;
        char caracterTexto;
        for (int i = 0; i < cadenaTexto.length(); i++) {
            caracterTexto = cadenaTexto.charAt(i);
            if (caracterTexto == 'a' || caracterTexto == 'e' || caracterTexto == 'i' || caracterTexto == 'o' || caracterTexto == 'u') {
                cantidadVocales++;
            }
        }
        return cantidadVocales;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cadenaTextoUsuario = "";

        System.out.print("Introduce una cadena de texto: ");
        cadenaTextoUsuario = scanner.nextLine().toLowerCase();
        scanner.close();

        System.out.println("El número de vocales es: " + contarVocalesEnCadena(cadenaTextoUsuario));
    }
}