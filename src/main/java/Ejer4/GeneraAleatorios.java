package Ejer4;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class GeneraAleatorios {
    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        String binarioJava = javaHome + "/bin/java";
        String rutaClasspath = System.getProperty("java.class.path") + File.pathSeparator + "build/classes/java/main";

        try {
            ProcessBuilder constructorProceso = new ProcessBuilder(binarioJava, "-cp", rutaClasspath, "Ejer4.Aleatorios");
            Process procesoHijo = constructorProceso.start();

            BufferedWriter escritorHijo = new BufferedWriter(new OutputStreamWriter(procesoHijo.getOutputStream()));
            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));

            String entradaUsuario;

            while (true) {
                // Lectura por teclado usando la clase Entrada
                entradaUsuario = Entrada.cadena();

                if (entradaUsuario == null) {
                    continue;
                }

                // Envía la petición al proceso hijo
                escritorHijo.write(entradaUsuario);
                escritorHijo.newLine();
                escritorHijo.flush();

                if (entradaUsuario.equalsIgnoreCase("fin")) {
                    break;
                }

                // Lee y muestra el número aleatorio devuelto por el hijo
                String numeroGenerado = lectorHijo.readLine();
                if (numeroGenerado != null) {
                    System.out.println(numeroGenerado);
                }
            }

            procesoHijo.destroy();
            procesoHijo.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la gestión de procesos aleatorios: " + e.getMessage());
        }
    }
}