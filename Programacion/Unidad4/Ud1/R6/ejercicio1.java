package Programacion.Unidad4.Ud1.R6;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {

        final int NOTAMINIMA = 0, NOTAMAXIMA = 10, NOTAPARAAPROBAR = 5, PARARPROGRAMA = -1;
        double notaAlumno = 0, sumatorioNotas = 0;
        int contadorAlumnos = 1, alumnosAprobados = 0, alumnosSuspensos = 0;
        Scanner scanner = new Scanner(System.in);

        while (notaAlumno != PARARPROGRAMA) {
            System.out.print("Ingresa la nota del alumno " + contadorAlumnos + ": ");
            notaAlumno = scanner.nextInt();

            if (notaAlumno >= NOTAMINIMA && notaAlumno <= NOTAMAXIMA) {
                sumatorioNotas += notaAlumno;
                contadorAlumnos++;

                if (notaAlumno >= NOTAPARAAPROBAR) {
                    alumnosAprobados++;
                } else {
                    alumnosSuspensos++;
                }
            } else {
                if (notaAlumno != PARARPROGRAMA) {
                    System.out.println(
                        "Calificación incorrecta, vuelva a introducirla (0 - 10) o (-1) para parar el programa");
                }else {
                    System.out.println("Programa Finalizado!");
                }
            }
        }
        scanner.close();

        if (contadorAlumnos > 1) {
            double promedio =  sumatorioNotas / (contadorAlumnos - 1);
            System.out.println("Hay " + alumnosAprobados + " alumnos aprobados y " + alumnosSuspensos + " alumnos suspensos.");
            System.out.printf("La calificación media es %.2f" , promedio);
        }
        else{
                    System.out.println("¡No se ha introducido ninguna calificación!");
        }
    }
}
