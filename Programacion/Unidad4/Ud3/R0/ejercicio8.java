package ejercicios.ud3.r0;

public class Ejercicio8 {


    //Funcion para saber el numero mas grande
    public static int mayor (int a, int b) {
        int maximo = b;
        if (a > b) {
            maximo = a;
        } 
        return maximo;
    }



    public static void main(String[] args) {
        int resultadoComparacion = mayor(5, 10);
        System.out.println("El numero mayor: " + resultadoComparacion);
    }
} 