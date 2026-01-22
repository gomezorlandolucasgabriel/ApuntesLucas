package ejercicios.ud2;

import java.util.ArrayList;

public class Ejercicio10 {

    public static void main(String[] args) {
        ArrayList<Integer> pila = new ArrayList<>();
        final int TAMANIOCPILA = 12;
        int clienteAtendido;
        final String SEPARADOR = "--";
        String mensaje;
        for (int i = 1; i <= TAMANIOCPILA; i++) {
            pila.add(i * 10);
        }

        while (!pila.isEmpty()) {
            clienteAtendido = pila.removeLast();
            System.out.println("He atendido a " + clienteAtendido);
            mensaje = "";
            for (int numero : pila) {
                mensaje += numero + SEPARADOR;
            }
            if (!mensaje.isEmpty()) {
                mensaje = mensaje.substring(0, mensaje.length() - SEPARADOR.length());
            }
            System.out.println("Clientes restantes: " + mensaje);
        }
    }
}
