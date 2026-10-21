package Ejer2;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class LectorTxt {
    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        String binarioJava = javaHome + "/bin/java";
        String rutaClasspath = System.getProperty("java.class.path") + File.pathSeparator + "build/classes/java/main";

        try {
            ProcessBuilder constructorProceso = new ProcessBuilder(binarioJava, "-cp", rutaClasspath, "Ejer2.TransformadorTxt");
            Process procesoHijo = constructorProceso.start();

            BufferedWriter escritorHijo = new BufferedWriter(new OutputStreamWriter(procesoHijo.getOutputStream()));
            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));

            String lineaLeida;

            while (true) {
                // Lectura por teclado usando la clase Entrada
                lineaLeida = Entrada.cadena();

                if (lineaLeida == null) {
                    continue;
                }

                // Envía la línea al proceso hijo
                escritorHijo.write(lineaLeida);
                escritorHijo.newLine();
                escritorHijo.flush();

                // Si se introduce "fin", se finaliza la ejecución
                if (lineaLeida.equalsIgnoreCase("fin")) {
                    break;
                }

                // Lee el resultado transformado del hijo y lo muestra por consola
                String resultadoTransformado = lectorHijo.readLine();
                if (resultadoTransformado != null) {
                    System.out.println(resultadoTransformado);
                }
            }

            procesoHijo.destroy();
            procesoHijo.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la comunicación de procesos: " + e.getMessage());
        }
    }
}