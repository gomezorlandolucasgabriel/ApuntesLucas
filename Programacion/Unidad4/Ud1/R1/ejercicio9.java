package ejercicios.ud1.r1;

import java.util.Scanner;

//    - Pide al usuario cuántos caramelos tiene y cuántos niños hay. 
//    Calcula cuántos caramelos recibe cada niño y cuántos sobran.
public class Ejercicio9 {
    public static void main(String[] args) {

        int numeroDeCaramelos, numeroDeNinios, caramelosPorNinio, restoDeCaramelos;
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos caramelos tienes? ");
        numeroDeCaramelos = scanner.nextInt();
        System.out.print("¿Cuántos niños hay? ");
        numeroDeNinios = scanner.nextInt();
        scanner.close();

        caramelosPorNinio = numeroDeCaramelos / numeroDeNinios;
        restoDeCaramelos = numeroDeCaramelos % numeroDeNinios;
        System.out.println("A cada niño le tocan " + caramelosPorNinio +
                " caramelos y han sobrado " + restoDeCaramelos);

    }

}
