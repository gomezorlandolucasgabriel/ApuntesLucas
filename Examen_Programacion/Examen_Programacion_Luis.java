package Examen_Programacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen_Programacion_Luis {
    // funcion mensajes aleatorios(SITUACION PERFECTO)
    public static String mensajePerfecto() {
        String[] mensajes = {
                "PERFECTO",
                "¡Ole ole, encaje total!"
        };

        int posicion = (int) (Math.random() * mensajes.length);
        return mensajes[posicion];
    }

    // funcion mensajes aleatorios (SITUACION BIEN)
    public static String mensajeBien() {
        String[] mensajes = {
                "BIEN",
                "¡Buen encaje entre empresa y candidato!"
        };

        int posicion = (int) (Math.random() * mensajes.length);
        return mensajes[posicion];
    }

    // funcion mensajes aleatorios (SITUACION REGULAR)
    public static String mensajeRegular() {
        String[] mensajes = {
                "REGULAR",
                "Regular la verdad, hay q llegar a un acuerdo"
        };

        int posicion = (int) (Math.random() * mensajes.length);
        return mensajes[posicion];
    }

    // funcion mensajes aleatorios (SITUACION MAL)
    public static String mensajeMal() {
        String[] mensajes = {
                "MAL",
                "Mal encaje, pueden haber problemas entre candidato y empresa"
        };

        int posicion = (int) (Math.random() * mensajes.length);
        return mensajes[posicion];
    }

    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        // variables declaradas
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ ---\n1. Añadir Empresa\n2. Añadir Candidato\n3. Listar Empresas\n4. Listar Candidatos\n5. Evaluar Candidatura (por indice)\n6. Eliminar Empresa\n7. Eliminar Candidato\n8. Salir\nElige una opción: ");
                opcionJuego = escaner.nextInt();
                escaner.nextLine();
            } catch (Exception e) {
                // para que me entre de nuevo en el dowhile si falla, declaramos la opcion del
                // juego -1
                System.out.println("Algo ha fallado");
                opcionJuego = -1;
                escaner.nextLine();
            }

        } while (opcionJuego < 1 || opcionJuego > 8);

        return opcionJuego;
    }

    // funcion de añadir empresa (opcion1)
    public static void aniadirEmpresa(ArrayList<String> listaEmpresa, ArrayList<String> listaPreferenciasEmpresa,
            Scanner escaner) {

        // variables declaradas
        String nombreEmpresa = "";
        String tipoPreferencia = "";
        try {
            System.out.println("Introduce el nombre de la empresa: ");
            nombreEmpresa = escaner.nextLine();

            tipoPreferencia = "";
            do {
                System.out.println("Elige tipo de Preferencia (presencial, hibrido, telematico): ");
                tipoPreferencia = escaner.nextLine().toLowerCase();
            } while (!tipoPreferencia.equals("presencial") && !tipoPreferencia.equals("hibrido")
                    && !tipoPreferencia.equals("telematico"));
            // añades a los arrays la info pedida en los system outs
            listaEmpresa.add(nombreEmpresa);
            listaPreferenciasEmpresa.add(tipoPreferencia);
        } catch (Exception e) {
            System.out.println("Ha habido un problema al introducir los datos");
            escaner.nextLine();
        }
    }

    // funcion añadir candidato (opcion 2)
    public static void aniadirCandidato(ArrayList<String> listaCandidatos, ArrayList<String> listaPreferenciasCandidato,
            Scanner escaner) {

        // variables declaradas
        String nombreCandidatos = "";
        String tipoPreferencia = "";

        try {
            System.out.println("Introduce el nombre del candidato: ");
            nombreCandidatos = escaner.nextLine();

            tipoPreferencia = "";
            do {
                System.out.println("Elige tipo de Preferencia (presencial, hibrido, telematico): ");
                tipoPreferencia = escaner.nextLine().toLowerCase();
            } while (!tipoPreferencia.equals("presencial") && !tipoPreferencia.equals("hibrido")
                    && !tipoPreferencia.equals("telematico"));
            // añades a los arrays la info pedida en los system outs
            listaCandidatos.add(nombreCandidatos);
            listaPreferenciasCandidato.add(tipoPreferencia);

        } catch (Exception e) {
            System.out.println("Ha habido un problema al introducir los datos");
            escaner.nextLine();
        }
    }

    // funcion listar empresas (opcion 3)
    public static void listarEmpresas(ArrayList<String> listaEmpresa, ArrayList<String> listaPreferenciasEmpresa) {
        // si no hay nada en el array listaEmpresa saldria "Vacio"
        if (listaEmpresa.isEmpty()) {
            System.out.println("Vacio");
        } else {
            for (int i = 0; i < listaEmpresa.size(); i++) {
                System.out.println(i + " --> " + listaEmpresa.get(i) + " | " + listaPreferenciasEmpresa.get(i));
            }
        }
    }

    // funcion listar candidatos (opcion 4)
    public static void listarCandidatos(ArrayList<String> listaCandidatos,
            ArrayList<String> listaPreferenciasCandidato) {
        // si no hay nada en el array listaCandidatos saldria "Vacio"
        if (listaCandidatos.isEmpty()) {
            System.out.println("Vacio");
        } else {
            for (int i = 0; i < listaCandidatos.size(); i++) {
                System.out.println(i + " --> " + listaCandidatos.get(i) + " | " + listaPreferenciasCandidato.get(i));
            }
        }
    }

    // funcion evaluar candidatura por indice (opcion 5)
    public static void evaluarCandidatura(ArrayList<String> listaEmpresa, ArrayList<String> listaCandidatos,
            ArrayList<String> listaPreferenciasEmpresa, ArrayList<String> listaPreferenciasCandidato, Scanner escaner) {
        // variables declaradas
        int indiceCandidato = 0;
        int indiceEmpresa = 0;
        String prefCandidato = "";
        String prefEmpresa = "";

        try {
            // pedimos los indices de cada para compararlos
            System.out.println("Introduce el indice del candidato: ");
            indiceCandidato = escaner.nextInt();
            escaner.nextLine();

            System.out.println("Introduce el indice de la empresa");
            indiceEmpresa = escaner.nextInt();
            escaner.nextLine();
            if ((indiceCandidato >= 0 && indiceEmpresa >= 0) && indiceEmpresa < listaEmpresa.size()
                    && indiceCandidato < listaCandidatos.size()) {
                // aqui hago unas variables que representen las preferencias de los candidatos y
                // las empresas respecto a los indices
                prefCandidato = listaPreferenciasCandidato.get(indiceCandidato);
                prefEmpresa = listaPreferenciasEmpresa.get(indiceEmpresa);
                // si tienen la misma preferencia la empresa y el candidato
                if (prefCandidato.equals(prefEmpresa)) {
                    System.out.println(mensajePerfecto());
                } else {
                    // si no tienen la misma preferencia la empresa y el candidato pues ya comparas
                    // respecto a la tabla del examen
                    if (prefCandidato.equals("presencial")) {
                        if (prefEmpresa.equals("hibrido")) {
                            System.out.println(mensajeBien());
                        } else if (prefEmpresa.equals("telematico")) {
                            System.out.println(mensajeMal());
                        }
                    } else if (prefCandidato.equals("hibrido")) {
                        if (prefEmpresa.equals("presencial")) {
                            System.out.println(mensajeBien());
                        } else if (prefEmpresa.equals("telematico")) {
                            System.out.println(mensajeRegular());
                        }
                    } else if (prefCandidato.equals("telematico")) {
                        if (prefEmpresa.equals("presencial")) {
                            System.out.println(mensajeRegular());
                        } else if (prefEmpresa.equals("hibrido")) {
                            System.out.println(mensajeRegular());
                        }
                    }
                }
            }

        } catch (Exception e) {

            System.out.println("Error, ha habido un fallo introduciendo datos");
        }
    }

    // funcion eliminar empresa (opcion 6)
    public static void eliminarEmpresa(ArrayList<String> listaEmpresa, ArrayList<String> listaPreferenciasEmpresa,
            Scanner escaner) {
        // variables declaradas
        int indice = 0;

        try {
            System.out.println("Introduce el indice de la empresa: ");
            indice = escaner.nextInt();
            escaner.nextLine();
            if (indice >= 0 && indice < listaEmpresa.size()) {
                // elimino informacion del indice de la empresa introducido
                listaEmpresa.remove(indice);
                listaPreferenciasEmpresa.remove(indice);
                System.out.println("Has eliminado la empresa con indice " + indice + " de la lista de empresas");
            } else {
                System.out.println("Indice inválido");
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al introducir los datos");
            escaner.nextLine();
        }
    }

    // funcion eliminar candidato (opcion 7)
    public static void eliminarCandidato(ArrayList<String> listaCandidato, ArrayList<String> listaPreferenciasCandidato,
            Scanner escaner) {
        int indice = 0;
        try {
            System.out.println("Introduce el indice del candidato: ");
            indice = escaner.nextInt();
            escaner.nextLine();
            if (indice >= 0 && indice < listaCandidato.size()) {
                // elimino informacion del indice del candidato introducido
                listaCandidato.remove(indice);
                listaPreferenciasCandidato.remove(indice);
                System.out.println("Has eliminado al candidato con indice " + indice + " de la lista de candidatos");
            } else {
                System.out.println("Indice inválido");
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al introducir los datos");
            escaner.nextLine();
        }
    }

    public static void main(String[] args) {

        // Enunciamos los Arrays y el Scanner
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombreEmpresa = new ArrayList<>();
        ArrayList<String> nombreCandidato = new ArrayList<>();
        ArrayList<String> preferenciasEmpresa = new ArrayList<String>();
        ArrayList<String> preferenciasCandidato = new ArrayList<String>();

        int opcion = -1;

        // bucle para entrar en el menu y elegir opciones
        while (opcion != 8) {
            // enuncio funcion de pedir opciones
            opcion = pedirOpcion(scanner);
            if (opcion == 1) {
                // enuncio funcion de añadir empresa
                aniadirEmpresa(nombreEmpresa, preferenciasEmpresa, scanner);
            } else if (opcion == 2) {
                // enuncio funcion de añadir candidato
                aniadirCandidato(nombreCandidato, preferenciasCandidato, scanner);
            } else if (opcion == 3) {
                // enuncio funcion de listar empresas
                listarEmpresas(nombreEmpresa, preferenciasEmpresa);
            } else if (opcion == 4) {
                // enuncio funcion de listar candidatos
                listarCandidatos(nombreCandidato, preferenciasCandidato);
            } else if (opcion == 5) {
                // enuncio funcion de evaluar candidaturas entre candidatos y empresas
                evaluarCandidatura(nombreEmpresa, nombreCandidato, preferenciasEmpresa, preferenciasCandidato, scanner);
            } else if (opcion == 6) {
                // enuncio funcion de eliminar empresa
                eliminarEmpresa(nombreEmpresa, preferenciasEmpresa, scanner);
            } else if (opcion == 7) {
                // enuncio funcion de eliminar candidatura
                eliminarCandidato(nombreCandidato, preferenciasCandidato, scanner);
            }
        }
        // cierro scanner
        scanner.close();
    }
}