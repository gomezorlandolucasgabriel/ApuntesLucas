package ejercicios.ud2;

import java.util.ArrayList;

public class ejercicio23 {

    public static void main(String[] args) {

        //Ejercicio 2
        ArrayList<String> colores = new ArrayList<>();
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Azul");
        // System.out.println(String.join(",", colores));  
    
        String mensaje = "";
        final String SEPARADOR = "- ";
        for (String color : colores) {
            mensaje += color + "-";            
        }
        mensaje = mensaje.substring(0, mensaje.length() -1);
        System.out.println(mensaje);

        //Ejercicio 3
        String eliminado = colores.remove(colores.size()-1);
        System.out.println(eliminado);

        mensaje = "";
        for (String color : colores) {
            mensaje += color + "-";            
        }
        mensaje = mensaje.substring(0, mensaje.length() -SEPARADOR.length());
        System.out.println(mensaje);

    }
}
