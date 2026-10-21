package Ejer3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {

    public static void main(String[] args) {
        // Leer la cadena del usuario
        BufferedReader brUsuario = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce una cadena: ");

        try {
            String cadena = brUsuario.readLine();

            // Configurar el ProcessBuilder
            String classPath = System.getProperty("java.class.path");
            String className = "ejercicio3.Visualizador";

            // Pasamos la cadena y el número "5" como argumentos
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, className, cadena, "5");

            // Hacemos que la E/S del hijo se conecte a la del padre
            // La salida y error  del hijo irán a la consola del padre.
            pb.inheritIO();

            // Iniciar y esperar
            Process p = pb.start();
            int exitVal = p.waitFor();

            // Imprimir resultado
            System.out.println("Valor de salida: " + exitVal);
            if (exitVal == 0) { //
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}