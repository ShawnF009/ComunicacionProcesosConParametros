package Ejer3;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {
    public static void main(String[] args) {
        System.out.print("Introduce una cadena: ");
        String cadenaUsuario = Entrada.cadena();

        String javaHome = System.getProperty("java.home");
        String binarioJava = javaHome + "/bin/java";
        String rutaClasspath = System.getProperty("java.class.path") + File.pathSeparator + "build/classes/java/main";

        try {
            ProcessBuilder constructorProceso = new ProcessBuilder(
                    binarioJava, "-cp", rutaClasspath, "Ejer3.Visualizador", cadenaUsuario, "5"
            );
            Process procesoHijo = constructorProceso.start();

            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String lineaSalida;

            while ((lineaSalida = lectorHijo.readLine()) != null) {
                System.out.println(lineaSalida);
            }

            int codigoSalida = procesoHijo.waitFor();
            System.out.println("Valor de salida: " + codigoSalida);

            if (codigoSalida == 0) {
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el visualizador: " + e.getMessage());
        }
    }
}