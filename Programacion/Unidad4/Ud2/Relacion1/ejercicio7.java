package ejercicios.ud2;

import java.util.ArrayList;
import java.util.Arrays;

public class ejercicio7 {

    public static void main(String[] args) {

        ArrayList<String> dias = new ArrayList<>(Arrays.asList("L", "M", "X", "J", "V", "S", "D"));
        dias.set(dias.size() - 1, "Domingo (fin de semana)");
        //dias.set(dias.indexOf("D"), "Domingo (fin de semana)");
        System.out.println(String.join("~", dias));
    }
}
