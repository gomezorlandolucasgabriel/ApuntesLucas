package ejercicios.ud1.r6;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int combustibleDisponible;
        int precioLitro;
        int consumo100km;
        int numeroViaje = 1;
        int kilometrosViaje;
        int precioViaje;
        int combustibleConsumido;

        System.out.println("Introduce el combustible inicial: ");
        combustibleDisponible = scanner.nextInt();

        System.out.println("Precio del litro de combustible: ");
        precioLitro = scanner.nextInt();

        System.out.println("Consumo cada 100km:");
        consumo100km = scanner.nextInt();

        while (combustibleDisponible > 0) {
            System.out.println("Introduce los kilómetros del viaje " + numeroViaje + ": ");
            kilometrosViaje = scanner.nextInt();

            combustibleConsumido = kilometrosViaje * consumo100km / 100;

            if (combustibleConsumido <= combustibleDisponible) {
                precioViaje = combustibleConsumido * precioLitro;
                combustibleDisponible -= combustibleConsumido;

                System.out.println("Precio del viaje: " + precioViaje);
                System.out.println("Combustible restante: " + combustibleDisponible);

                numeroViaje++;
            }else{
                System.out.println("Combustible insuficiente");
                combustibleDisponible = 0;
            }
        }
            scanner.close();
    }
}

