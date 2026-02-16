package Programacion.Unidad4.Ud2.Relacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {

        String libroNuevo;
        int cantidadNueva = 0;
        String libroActualizar;
        int nuevaCantidad = 0;


        ArrayList<String> libros = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        libros.add("El quijote");
        cantidades.add(5);

        libros.add("La Biblia");
        cantidades.add(3);

        libros.add("Manual de resistencia");
        cantidades.add(1);

        libros.add("La criada");
        cantidades.add(7);

        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("4")) {

            System.out.println("""
                1. Añadir un nuevo libro
                2. Actualizar cantidad
                3. Ver inventario
                4. Salir
                """);

            opcion = scanner.nextLine();

            if (opcion.equals("1")) {

                System.out.print("Introduzca el nombre del libro: ");
                libroNuevo = scanner.nextLine();

                System.out.print("Cantidad disponible: ");
                cantidadNueva = Integer.parseInt(scanner.nextLine());

                libros.add(libroNuevo);
                cantidades.add(cantidadNueva);

            } else if (opcion.equals("2")) {

                System.out.print("Nombre del libro a actualizar: ");
                 libroActualizar = scanner.nextLine();

                System.out.print("Nueva cantidad: ");
                 nuevaCantidad = Integer.parseInt(scanner.nextLine());

                boolean encontrado = false;

                for (int i = 0; i < libros.size() && !encontrado; i++) {
                    if (libros.get(i).equals(libroActualizar)) {
                        cantidades.set(i, nuevaCantidad);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Libro no encontrado");
                }

            } else if (opcion.equals("3")) {

                System.out.println("Inventario:");
                for (int i = 0; i < libros.size(); i++) {
                    System.out.println(libros.get(i) + " - " + cantidades.get(i) + " unidades");
                }
            }
        }

        scanner.close();
    }
}
