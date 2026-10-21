package Ejer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LectorTxt {

    public static void main(String[] args) {
        // Configuración para lanzar el proceso hijo
        String classPath = System.getProperty("java.class.path");
        String className = "ejercicio2.TransformadorTxt";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, className);

        try {
            // Iniciamos el proceso hijo
            Process p = pb.start();

            // 1. Flujo para ENVIAR datos al hijo
            // Obtenemos el flujo de salida conectado a la entrada estándar del subproceso
            // Usamos PrintWriter para facilitar la escritura de líneas
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));

            // 2. Flujo para LEER datos del hijo
            // Obtenemos el flujo de entrada conectado a la salida estándar del subproceso
            BufferedReader brHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));

            // 3. Flujo para LEER datos del usuario
            BufferedReader brUsuario = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduce texto (escribe 'fin' para salir):");
            String lineaUsuario;

            while ((lineaUsuario = brUsuario.readLine()) != null) {
                if ("fin".equalsIgnoreCase(lineaUsuario)) {
                    break;
                }

                // Escribimos la línea en el flujo de salida del hijo
                pw.println(lineaUsuario);
                pw.flush(); // Aseguramos que se envíe

                // Leemos la respuesta transformada del hijo
                String lineaHijo = brHijo.readLine();
                System.out.println(lineaHijo);
            }

            // Cerramos los flujos y esperamos al proceso
            System.out.println("Finalizando...");
            pw.close(); // Esto cerrará el System.in del hijo.
            brHijo.close();
            brUsuario.close();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}