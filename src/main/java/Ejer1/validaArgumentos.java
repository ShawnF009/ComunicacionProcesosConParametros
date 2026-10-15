package Ejer1;

public class validaArgumentos {

    public static void main(String[] args) {
        // 1. Si el número de argumentos es menor que 1
        if (args == null || args.length < 1) {
            System.exit(1);
        }

        String arg = args[0];

        try {
            // Intentamos parsear el primer argumento a entero
            int numero = Integer.parseInt(arg);

            // 3. Si el argumento es un número entero menor que 0
            if (numero < 0) {
                System.exit(3);
            } else {
                // 4. Cualquier otra situación (entero >= 0)
                System.exit(4);
            }
        } catch (NumberFormatException e) {
            // 2. Si no es un entero, se considera que el argumento es una cadena
            System.exit(2);
        }
    }
}