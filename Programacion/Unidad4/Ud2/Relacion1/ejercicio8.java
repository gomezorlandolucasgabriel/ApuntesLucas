package ejercicios.ud2;

import java.util.ArrayList;
import java.util.Arrays;

public class ejercicio8 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(100, 200, 300));
        int temporal = numeros.get(0);
        String mensaje = "";

        numeros.set(0, numeros.getLast());//[300,200,300]
        numeros.set(2, temporal);//[300,200,100]

        for (int numero : numeros) {
            mensaje += numero + "|";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);

    }
}
