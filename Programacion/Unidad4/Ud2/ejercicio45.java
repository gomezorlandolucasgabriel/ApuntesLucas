package ejercicios.ud2;

import java.util.ArrayList;

public class Ejercicio45 {

    public static void main(String[] args) {

        // Ejercicio 4
        ArrayList<String> animales = new ArrayList<>();
        animales.add("perro");
        animales.add("gato");

        animales.add(0, "loro");
        animales.add(0, "tortuga");
        System.out.println(String.join(",", animales));

        // Ejercicio 5
        animales.remove(0);
        System.out.println(String.join(",", animales));

    }
}
