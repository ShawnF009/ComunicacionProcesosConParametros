package Ejer1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjecutaValidaArgumentos {

    private static void ejecutarProceso(String... args) {
        // Obtenemos la ruta al classpath actual de Java
        String classPath = System.getProperty("java.class.path");
        String className = "ejercicio1.ValidaArgumentos";

        try {
            // Creamos una lista para los comandos
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-cp");
            command.add(classPath);
            command.add(className);
            // Añadimos los argumentos dinámicos
            command.addAll(Arrays.asList(args));

            // Creamos el ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder(command);

            // Iniciamos el proceso
            Process p = pb.start();
            // Esperamos a que el proceso termine y obtenemos su código de salida
            int exitVal = p.waitFor();

            System.out.println("Valor de salida: " + exitVal);

            // Mostramos el mensaje correspondiente
            switch (exitVal) {
                case 1:
                    System.out.println("No hay argumentos...");
                    break;
                case 2:
                    System.out.println("Es una cadena...");
                    break;
                case 3:
                    System.out.println("Número menor que 0...");
                    break;
                case 4:
                    System.out.println("Número mayor o igual que 0...");
                    break;
                default:
                    System.out.println("Valor de salida desconocido.");
            }

       } catch (IOException e) { //
            System.err.println("Error de E/S al ejecutar el proceso.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido.");
            Thread.currentThread().interrupt();
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        // Caso 1: Número mayor o igual a 0
        System.out.println("Ejecutando con argumento '10':");
        ejecutarProceso("10");

        // Caso 2: Sin argumentos
        System.out.println("Ejecutando sin argumentos:");
        ejecutarProceso();

        // Caso 3: Cadena
        System.out.println("Ejecutando con argumento 'Hola':");
        ejecutarProceso("Hola");

        // Caso 4: Número menor que 0
        System.out.println("Ejecutando con argumento '-5':");
        ejecutarProceso("-5");
    }
}