package Ejer1;

public class ValidaArgumentos {

    public static void main(String[] args) {

        // 1. Si el número de argumentos es < 1
        if (args.length < 1) {
            System.exit(1);
        }

        try {
            // Intenta convertir el primer argumento a número
            int num = Integer.parseInt(args[0]);

            // 3. Si es un número entero menor que 0
            if (num < 0) {
                System.exit(3);
            }

            // 4. Si es un número >= 0
            System.exit(4);

        } catch (NumberFormatException e) {
            // 2. Si el argumento es una cadena (no se pudo convertir a número)
            System.exit(2);
        }
    }
}
