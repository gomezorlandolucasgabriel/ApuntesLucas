package Programacion.Unidad4.Ud1.R3;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        int resultado = 0;
        int operando1;
        int operando2;
        String operador;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el primer numero: ");
        operando1 = scanner.nextInt();

        System.out.println("Introduzca otro numero: ");
        operando2 = scanner.nextInt();

        System.out.println("Introduzca el operador (+, -, *, /): ");
        operador = scanner.next();
        scanner.close();

        if (operador.equals("+")) {
            resultado = operando1 + operando2;
        } else if (operador.equals("-")) {
            resultado = operando1 - operando2;
        } else if (operador.equals("*")) {
            resultado = operando1 * operando2;
        } else if (operador.equals("/")) {
            if (operando2 != 0) {
                resultado = operando1 / operando2;
            } else {
                System.out.println("No es posible dividir entre 0");
            }
        } else {
            System.out.println("Operador incorrecto");
        }
        System.out.println("El resultado de " + operando1 + operador + operando2 + " es " + resultado);

    }
}

