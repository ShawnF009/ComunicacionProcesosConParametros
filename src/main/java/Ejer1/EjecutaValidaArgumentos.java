package Ejer1;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {
        System.out.print("Introduce un argumento (cadena o número): ");
        String argumentoUsuario = Entrada.cadena();

        String javaHome = System.getProperty("java.home");
        String binarioJava = javaHome + "/bin/java";

        // Añadimos la carpeta de clases compiladas al classpath actual
        String rutaClasspath = System.getProperty("java.class.path") + File.pathSeparator + "build/classes/java/main";

        try {
            List<String> comando = new ArrayList<>();
            comando.add(binarioJava);
            comando.add("-cp");
            comando.add(rutaClasspath);
            comando.add("Ejer1.ValidaArgumentos");

            // Si el usuario introduce algo, lo añadimos como argumento al proceso hijo
            if (argumentoUsuario != null && !argumentoUsuario.trim().isEmpty()) {
                comando.add(argumentoUsuario.trim());
            }

            ProcessBuilder constructorProceso = new ProcessBuilder(comando);
            Process procesoValidador = constructorProceso.start();
            int codigoSalida = procesoValidador.waitFor();

            System.out.println("Valor de salida: " + codigoSalida);

            switch (codigoSalida) {
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
                    System.out.println("Situación desconocida...");
                    break;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error durante la ejecución del proceso: " + e.getMessage());
        }
    }
}