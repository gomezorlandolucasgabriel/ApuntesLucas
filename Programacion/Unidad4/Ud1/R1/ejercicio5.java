package Programacion.Unidad4.Ud1.R1;

import java.util.Scanner;

//    Pide el peso del usuario y calcula cuánto 
//    pesaría en la Luna (aproximadamente el 16.5% de su peso en la Tierra).
public class ejercicio5 {
    public static void main(String[] args) {
        final double GRAVEDADLUNA = 0.165;
        Scanner scanner = new Scanner(System.in);
        double pesoUsuario;
        double pesoLuna;
        
        System.out.print("Introduce tu peso para calcularlo en La Luna: ");
        
        pesoUsuario = scanner.nextDouble();
        scanner.close();

        pesoLuna = pesoUsuario * GRAVEDADLUNA;

        System.out.printf("El usuario que pesa %.2f kgs en La Tierra, pesa %.2f kgs en La Luna\n", pesoUsuario, pesoLuna);

    }

}
