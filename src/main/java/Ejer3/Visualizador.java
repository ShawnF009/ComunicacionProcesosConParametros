package Ejer3;

public class Visualizador {
    public static void main(String[] args) {
        // Valida que se reciba al menos un argumento y que la cadena no esté vacía
        if (args.length < 1 || args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("Cadena introducida vacía");
            System.exit(1);
        }

        String cadenaTexto = args[0];
        int numeroVeces = 5; // Valor por defecto

        if (args.length >= 2) {
            try {
                numeroVeces = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.exit(1);
            }
        }

        for (int i = 1; i <= numeroVeces; i++) {
            System.out.println(i + ". " + cadenaTexto);
        }

        System.exit(0);
    }
}