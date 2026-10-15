package Ejer1;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.File;
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
                    System.out.print("Introduce el número mayor o igual a 0: ");
                    String numPos = Entrada.cadena(); // O puedes usar Entrada.entero() y pasarlo a String
                    ejecutarProceso(numPos);
                    break;
                case 2:
                    // No se envía ningún argumento (null o array vacío)
                    ejecutarProceso(null);
                    break;
                case 3:
                    System.out.print("Introduce la cadena de texto: ");
                    String cadena = Entrada.cadena();
                    ejecutarProceso(cadena);
                    break;
                case 4:
                    System.out.print("Introduce el número menor que 0: ");
                    String numNeg = Entrada.cadena();
                    ejecutarProceso(numNeg);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void ejecutarProceso(String argumento) {
        try {
            String javaHome = System.getProperty("java.home");
            String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");

            List<String> comando = new ArrayList<>();
            comando.add(javaBin);
            comando.add("-cp");
            comando.add(classpath);
            comando.add("Ejer1.validaArgumentos");

            // Solo añadimos el argumento si realmente se ha pasado uno (para el caso de "no enviar nada")
            if (argumento != null && !argumento.isEmpty()) {
                comando.add(argumento);
            }

            ProcessBuilder builder = new ProcessBuilder(comando);
            Process proceso = builder.start();

            // Esperamos a que termine el proceso y obtenemos su código de salida
            int codigoSalida = proceso.waitFor();

            // Mostramos el resultado tal como pide el ejemplo
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
                    System.out.println("Resultado desconocido.");
                    break;
            }

        } catch (Exception e) {
        System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }
}