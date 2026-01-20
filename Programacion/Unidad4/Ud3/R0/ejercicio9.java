package ejercicios.ud3.r0;

// 9. Obtener el menor de tres números
// Crea una función llamada menorDeTres que reciba tres números y
// devuelva el menor de los tres.

// function menorDeTres(a, b, c) {
//     let minimo = a
//     if (b < minimo) {
//         minimo = b
//     }
//     if (c < minimo) {
//         minimo = c
//     }
//     return minimo
// }

// ================== MAIN ================== //

// let minimo = menorDeTres(3, 7, 1)
// console.log(minimo)

public class Ejercicio9 {
    
    public static int menorDeTres (int numero1, int numero2, int numero3){
        int minimo = numero1;
        
        if (numero2 < minimo){
            minimo = numero2;
        }
        if (numero3 < minimo){
            minimo = numero3;
        }

        return minimo;
    }

    // ================== MAIN ================== //

    public static void main(String[] args){
        System.out.println(menorDeTres(9,3,6));
    }

}
