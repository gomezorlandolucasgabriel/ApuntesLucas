package Programacion.Unidad4.Ud1.R4;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        int numeroIntroducido;
        int intento;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un numero secreto (Del 1 al 10): ");
        numeroIntroducido = scanner.nextInt();
        System.out.print("Introduza el numero secreto: ");
        intento = scanner.nextInt();
        

        while (numeroIntroducido != intento) {
            System.out.println("Numero " + intento + " es incorrecto");
            System.out.println("Introduza el numero secreto: ");
            intento = scanner.nextInt();
        } 
        System.out.println("¡Correcto! Has adivinado el número.");
        scanner.close();
    }
}
