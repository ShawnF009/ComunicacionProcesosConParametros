package Ejer1;

public class ValidaArgumentos {

    public static void main(String[] args) {
        // 1: Si el número de argumentos es menor que 1
        if (args.length < 1) {
            System.exit(1);
        }

        try {
            int numeroIngresado = Integer.parseInt(args[0]);

            // 3: Si el argumento es un número entero menor que 0
            if (numeroIngresado < 0) {
                System.exit(3);
            } else {
                // 4: En cualquier otra situación (número mayor o igual que 0)
                System.exit(4);
            }
        } catch (NumberFormatException e) {
            // 2: Si el argumento no se puede convertir a entero, es una cadena
            System.exit(2);
        }
    }
}