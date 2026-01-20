package ejercicios.ud1.r3;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        int numeroUsuario, primerdigito, segundodigito, suma = 0;
        boolean numeroDosCifras;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un número de dos cifras");
        numeroUsuario = scanner.nextInt();
        numeroDosCifras = (numeroUsuario >= 10 && numeroUsuario <= 99);
        
        while (!numeroDosCifras) {
            System.out.println("Por favor, introduzca un numero de dos cifras");
            numeroUsuario = scanner.nextInt();
            numeroDosCifras = (numeroUsuario >= 10 && numeroUsuario <= 99);
        }
        scanner.close();
        primerdigito = numeroUsuario / 10;
        segundodigito = numeroUsuario % 10;
        suma = primerdigito + segundodigito;
        System.out.println("La suma de " + primerdigito + " + " + segundodigito + " es " + suma);
    }
}

