package Ejer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GeneraAleatorios {

    public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");
        String className = "ejercicio4.Aleatorios";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, className);

        try {
            Process p = pb.start();

            // Flujo para ENVIAR peticiones al hijo
            PrintWriter peticionHijo = new PrintWriter(p.getOutputStream());

            // Flujo para LEER respuestas del hijo
            BufferedReader respuestaHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));

            // Flujo para LEER al usuario
            BufferedReader brUsuario = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Escribe cualquier cosa para generar un aleatorio (o 'fin' para salir):");
            String lineaUsuario;

            while ((lineaUsuario = brUsuario.readLine()) != null) {
                if ("fin".equalsIgnoreCase(lineaUsuario)) {
                    break;
                }

                // 1. Enviamos una "petición" al hijo
                peticionHijo.println("genera"); // El contenido no importa, solo que es una línea
                peticionHijo.flush();

                // 2. Leemos la respuesta del hijo
                String numAleatorio = respuestaHijo.readLine();
                System.out.println(numAleatorio);
            }

            // Finalizar
            System.out.println("Finalizando...");
            // Cerramos el flujo de peticiones. El readLine() del hijo devolverá null.
            peticionHijo.close();

            respuestaHijo.close();
            brUsuario.close();
            p.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}