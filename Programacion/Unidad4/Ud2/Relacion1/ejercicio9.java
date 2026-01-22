package ejercicios.ud2;

import java.util.ArrayList;

public class Ejercicio9 {

    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<>();
        final int TAMANIOCOLA = 10;
        String clienteAtendido;
        for (int i = 1; i <= TAMANIOCOLA; i++) {
            cola.add("cliente " + i);
        }

        while (!cola.isEmpty()) {            
            clienteAtendido = cola.removeFirst();
            System.out.println("He atendido a " + clienteAtendido);
            System.out.println("Clientes restantes: " + String.join("|", cola));
        }       
    }
}
