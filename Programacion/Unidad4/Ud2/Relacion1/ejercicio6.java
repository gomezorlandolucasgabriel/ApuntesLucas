package Programacion.Unidad4.Ud2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ejercicio6 {

    public static void main(String[] args) {

        ArrayList<String> frutas = new ArrayList<>(Arrays.asList("manzana", "banana", "naranja"));
        frutas.remove(0);
        frutas.add("fresa");

        String mensaje = "";
        for (String fruta : frutas) {
            mensaje += fruta + "|";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);

    }
}
