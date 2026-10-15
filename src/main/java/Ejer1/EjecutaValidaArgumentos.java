package Ejer1;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE PRUEBAS ---");
            System.out.println("1. Enviar un número mayor o igual a 0 (ej: 5)");
            System.out.println("2. No enviar argumentos");
            System.out.println("3. Enviar una cadena (ej: hola)");
            System.out.println("4. Enviar un número menor que 0 (ej: -5)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = Entrada.entero();

            switch (opcion) {
                case 1:
                    ejecutarProceso("5");
                    break;
                case 2:
                    ejecutarProceso(); // Sin argumentos
                    break;
                case 3:
                    ejecutarProceso("hola");
                    break;
                case 4:
                    ejecutarProceso("-5");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void ejecutarProceso(String... argumentos) {
        try {
            String rutaClases = System.getProperty("java.class.path");

            List<String> comando = new ArrayList<>();
            comando.add("java");
            comando.add("-cp");
            comando.add(rutaClases);
            comando.add("ValidaArgumentos");

            for (String arg : argumentos) {
                comando.add(arg);
            }

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process proceso = pb.start();

            int valorSalida = proceso.waitFor();

            System.out.println("Valor de salida: " + valorSalida);

            switch (valorSalida) {
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
                    System.out.println("Código de salida desconocido: " + valorSalida);
                    break;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}