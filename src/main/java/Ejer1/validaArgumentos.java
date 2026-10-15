package Ejer1;

public class validaArgumentos {
    public static void main(String[] args) {
        // 1. Si no se envían argumentos
        if (args.length == 0) {
            System.out.println("No hay argumentos...");
            System.exit(1);
        }

        String arg = args[0];

        try {
            // Intentamos parsear el argumento como un número entero
            int numero = Integer.parseInt(arg);

            // 2. Si es un número menor que 0
            if (numero < 0) {
                System.out.println("Número menor que 0...");
                System.exit(3);
            }
            // 3. Si es un número mayor o igual que 0
            else {
                System.out.println("Número mayor o igual que 0...");
                System.exit(4);
            }

        } catch (NumberFormatException e) {
            // 4. Si no se puede convertir a número, significa que es una cadena de texto
            System.out.println("Es una cadena...");
            System.exit(2);
        }
    }
}