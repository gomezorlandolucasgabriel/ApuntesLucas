package Examen_Programacion;

import java.util.ArrayList;
import java.util.Scanner;

public class samvalentin {

    // ================== SYSOUT PRINTLN ==================

    // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
    public static void mensajeNuevaLineaString(String stringMostrar) {
        System.out.println(stringMostrar);
    }

    // ================== SYSOUT PRINT ==================

    // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
    public static void mensajeMismaLineaString(String stringMostrar) {
        System.out.print(stringMostrar);
    }

    // Funcion para hacer un menu con un minimo y un maximo (LLeva incluido control
    // de errores)

    public static int pedirRangoMenu(Scanner lector, String textoMenuString, String textoOpcionString,
            String mensajeError, int minimoPosible, int maximoPosible) {
        int opcionMenu;

        do {
            mensajeNuevaLineaString(textoMenuString);
            mensajeMismaLineaString(textoOpcionString);
            try {
                opcionMenu = Integer.parseInt(lector.nextLine());
            } catch (Exception e) {
                opcionMenu = minimoPosible - 1;
                mensajeNuevaLineaString(mensajeError);
            }
        } while (opcionMenu < minimoPosible || opcionMenu > maximoPosible);
        return opcionMenu;
    }

    // Funcion que muestra un 2 array intercalados con el separador elegido

    public static void mostrarArrayString(ArrayList<String> arrayAMostrar, String SEPARADOR,
            ArrayList<String> preferenciaAMostrar) {
        String mensaje = "";
        if (!arrayAMostrar.isEmpty()) {
            for (int i = 0; i < arrayAMostrar.size(); i++) {
                mensaje += "\nNombre: " + arrayAMostrar.get(i) + " , Preferencia: " + preferenciaAMostrar.get(i) + " "
                        + SEPARADOR;
            }
            mensaje = mensaje.substring(0, mensaje.length() - SEPARADOR.length() - 1);
            mensajeNuevaLineaString(mensaje);
        } else {
            mensajeNuevaLineaString("No hay nada para mostrar...");
        }
    }

    // Funcion que pide datos y rellena 2 arrays (lleva control de errores)
    public static void aniadirArray(Scanner lector, String mensajePedir, String mensajError,
            ArrayList<String> arrayARellenar, String mensajePedirPlan, ArrayList<String> arrayARellenarCandiatura) {
        String texto;
        String candidatura = "";
        do {
            mensajeMismaLineaString(mensajePedir);
            texto = lector.nextLine().trim();
            if (texto.isEmpty()) {
                mensajeNuevaLineaString(mensajError);
            }
        } while (texto.isEmpty());
        arrayARellenar.add(texto);

        do {
            mensajeMismaLineaString(mensajePedirPlan);
            candidatura = lector.nextLine().trim().toLowerCase();
            if (candidatura.isEmpty()) {
                mensajeNuevaLineaString(mensajError);
            }
        } while (!candidatura.equals("hibrido") && !candidatura.equals("presencial")
                && !candidatura.equals("telematico"));

        arrayARellenarCandiatura.add(candidatura);

    }

    // Funcion que busca dentro de un array y si no encuentra lo buscado te devuelve
    // un -1

    public static int buscarEnArrayString(ArrayList<String> array, String elemento) {
        int numeroEncontrado = -1;
        if (!array.isEmpty()) {

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals(elemento)) {
                    numeroEncontrado = i;
                }
            }
        }
        return numeroEncontrado;
    }

    // Funcion que obliga a no poder introducir un string vacio
    public static String pedirStringNoVacio(Scanner lector, String mensajePedir, String mensajError) {
        String texto;
        do {
            mensajeMismaLineaString(mensajePedir);
            texto = lector.nextLine().trim();
            if (texto.isEmpty()) {
                mensajeNuevaLineaString(mensajError);
            }
        } while (texto.isEmpty());
        return texto;
    }

    // Funcion que borra de 2 arrays

    public static void eliminarArray(ArrayList<String> arrayNombres, ArrayList<String> arrayCandidaturas,
            Scanner lector, String mensajePedir, String mensajError) {
        String elementoAeliminar = "";
        int indice;
        elementoAeliminar = pedirStringNoVacio(lector, mensajePedir, mensajError);
        indice = buscarEnArrayString(arrayNombres, elementoAeliminar);
        if (indice != -1) {

            arrayNombres.remove(indice);
            arrayCandidaturas.remove(indice);

        } else {
            mensajeNuevaLineaString("No hay nada con ese nombre registrado ahora mismo...");
        }
    }

    // Funcion que genera un numero aleatorio segun el minimo y maximo que le pases
    public static int numeroRandomEntero(int min, int max) {
        int numeroAleatorio;
        numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
        return numeroAleatorio;
    }

    // Funcion que muestra un mensaje aleatorio segun la candidatura recibida y la
    // evalua
    public static void evaluarCandidatura(ArrayList<String> nombresCandidato, ArrayList<String> preferenciaCandidato,
            String candidatoNombreBuscar, String nombreEmpresaBuscar, ArrayList<String> nombrEmpresa,
            ArrayList<String> preferenciaEmpresa, ArrayList<String> MensajesP, ArrayList<String> MensajesB,
            ArrayList<String> MensajesR, ArrayList<String> MensajesM) {

        int indiceMensaje;
        int indiceCandidato;
        int indiceEmpresa;
        String preferenciaEmpleado;
        String preferenciaEmpresaTipo;
        indiceCandidato = buscarEnArrayString(nombresCandidato, candidatoNombreBuscar);
        indiceEmpresa = buscarEnArrayString(nombrEmpresa, nombreEmpresaBuscar);

        if (indiceCandidato == -1 || indiceEmpresa == -1) {

            mensajeNuevaLineaString(
                    "No hemos podido encontrar la combinacion que estas buscando verifica que existe en la opcion 3 y 4. ");

        } else {
            preferenciaEmpresaTipo = preferenciaEmpresa.get(indiceEmpresa);
            preferenciaEmpleado = preferenciaCandidato.get(indiceCandidato);

            if (preferenciaEmpresaTipo.equals(preferenciaEmpleado)) {
                indiceMensaje = numeroRandomEntero(0, MensajesP.size() - 1);
                mensajeNuevaLineaString(MensajesP.get(indiceMensaje));

            } else if (preferenciaEmpresaTipo.equals("telematico") && preferenciaEmpleado.equals("presencial")) {
                indiceMensaje = numeroRandomEntero(0, MensajesM.size() - 1);
                mensajeNuevaLineaString(MensajesM.get(indiceMensaje));

            } else if ((preferenciaEmpresaTipo.equals("hibrido") && preferenciaEmpleado.equals("presencial"))
                    || (preferenciaEmpresaTipo.equals("presencial") && preferenciaEmpleado.equals("hibrido"))) {
                indiceMensaje = numeroRandomEntero(0, MensajesB.size() - 1);
                mensajeNuevaLineaString(MensajesB.get(indiceMensaje));
            } else {
                indiceMensaje = numeroRandomEntero(0, MensajesR.size() - 1);
                mensajeNuevaLineaString(MensajesR.get(indiceMensaje));
            }

        }
    }

    public static void main(String[] args) {
        // Declaracion de variables

        Scanner scanner = new Scanner(System.in);

        // Mensajes para mostrar dentro de mis funciones
        final String textoOpcion = "Selecciona una opcion: ";
        final String pedirNombreCandidato = "Introduce el Nombre del candidato: ";
        final String pedirNombreEmpresa = "Introduce el Nombre de la empresa: ";
        final String mensajError = "Error al introducir el valor";
        final String mensajePlan = "Introduce la preferencia (hibrido, telematico, presencial): ";
        final String mensajeErrorStringLLeno = "El string no puede estar vacio";

        int opcionUsuarioMenu;
        boolean ejecutar = true;
        ArrayList<String> candidatos = new ArrayList<String>();
        ArrayList<String> empresas = new ArrayList<String>();
        ArrayList<String> preferenciaEmpresa = new ArrayList<String>();
        ArrayList<String> preferenciaCandidato = new ArrayList<String>();
        ArrayList<String> DiccionarioMensajesPerfecto = new ArrayList<String>();
        ArrayList<String> DiccionarioMensajesBien = new ArrayList<String>();
        ArrayList<String> DiccionarioMensajesRegular = new ArrayList<String>();
        ArrayList<String> DiccionarioMensajesMal = new ArrayList<String>();
        String nombreCandidatoBuscar;
        String nombreEmpresa;

        final String textoMenu = "\n1. Añadir Empresa\n2. Añadir Candidato\n3. Listar empresas\n4. Listar Candidatos\n5. Evaluar candidatura\n6. Eliminar Empresa\n7. Eliminar Candidato\n8. Salir";

        // Introduzco en cada Array 3 Mensajes
        DiccionarioMensajesPerfecto.add("La quimica entre la empresa y el candidato es mas que perfecta. (Perfecto)");
        DiccionarioMensajesPerfecto.add("Esta empresa y este empleado Son perfectos entre si. (Perfecto)");
        DiccionarioMensajesPerfecto.add("Esta empresa y este empleado acaban de hacer match. (Perfecto)");
        DiccionarioMensajesBien
                .add("Esta empresa y el candidato se van a llevar bien pero pueden surgir problemas... (Bien)");
        DiccionarioMensajesBien.add("Me gusta esta combinacion pero falta todavia un poco para ser perfecta... (Bien)");
        DiccionarioMensajesBien.add("Esta combinacion suena bien... (Bien)");
        
        DiccionarioMensajesRegular.add("No esta mal esta combinacion pero podria ser mejor... (Regular)");
        DiccionarioMensajesRegular
                .add("Esta empresa y este empleado no estoy seguro de si se van a llevar bien... (Regular)");
        DiccionarioMensajesRegular.add("No me gusta mucho como puede salir esta relacion... (Regular)");

        DiccionarioMensajesMal.add("Entre esta empresa y ese candidato no vas a ver mucha quimica... (Mal)");
        DiccionarioMensajesMal.add("Mejor que no se de esta combinacion... (Mal)");
        DiccionarioMensajesMal.add("Esta combinacion puede ser muy peligrosa... (Mal)");


        // Bucle con las opciones y llamadas necesarias a funciones
        while (ejecutar) {
            opcionUsuarioMenu = pedirRangoMenu(scanner, textoMenu, textoOpcion, mensajError, 1, 8);

            if (opcionUsuarioMenu == 1) {
                aniadirArray(scanner, pedirNombreEmpresa, mensajError, empresas, mensajePlan, preferenciaEmpresa);
            } else if (opcionUsuarioMenu == 2) {
                aniadirArray(scanner, pedirNombreCandidato, mensajError, candidatos, mensajePlan, preferenciaCandidato);
            } else if (opcionUsuarioMenu == 3) {

                mensajeNuevaLineaString("\nEMPRESAS: ");
                mostrarArrayString(empresas, " ", preferenciaEmpresa);

            } else if (opcionUsuarioMenu == 4) {
                mensajeNuevaLineaString("\nCANDIDATOS: ");
                mostrarArrayString(candidatos, " ", preferenciaCandidato);

            } else if (opcionUsuarioMenu == 5) {
                nombreCandidatoBuscar = pedirStringNoVacio(scanner, pedirNombreCandidato, mensajError);
                nombreEmpresa = pedirStringNoVacio(scanner, pedirNombreEmpresa, mensajError);
                evaluarCandidatura(candidatos, preferenciaCandidato, nombreCandidatoBuscar, nombreEmpresa, empresas,
                        preferenciaEmpresa, DiccionarioMensajesPerfecto, DiccionarioMensajesBien,
                        DiccionarioMensajesRegular, DiccionarioMensajesMal);

            } else if (opcionUsuarioMenu == 6) {
                eliminarArray(empresas, preferenciaEmpresa, scanner, pedirNombreEmpresa, mensajeErrorStringLLeno);

            } else if (opcionUsuarioMenu == 7) {
                eliminarArray(candidatos, preferenciaCandidato, scanner, pedirNombreCandidato, mensajeErrorStringLLeno);

            } else {
                ejecutar = false;
            }

        }

    }
}