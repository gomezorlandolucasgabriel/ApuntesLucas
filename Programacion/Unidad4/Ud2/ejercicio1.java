package ejercicios.ud2;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        // numeros.add(5);
        // numeros.add(10);
        // numeros.add(15);
        // numeros.add(20);

        System.out.println(numeros.get(0));
        System.out.println(numeros.get(numeros.size()-1));

        // String mensaje = "";
        // for (int numero : numeros) {
        //     mensaje += numero + ",";            
        // }
        // mensaje = mensaje.substring(0, mensaje.length() -1);
        // System.out.println(mensaje);
    }
}
