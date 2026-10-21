package Ejer3;



public class Visualizador {

    public static void main(String[] args) {
        // Se esperan 2 argumentos: cadena y número
        if (args.length != 2) {
            System.err.println("Error: Se necesitan 2 argumentos (cadena y número).");
            System.exit(1);
            return;
        }

        String cadena = args[0];
        int veces;

        if (cadena.isEmpty()) {
            System.err.println("Cadena introducida vacia");
            System.exit(1); // Finaliza con código 1 si la cadena está vacía
            return;
        }

        try {
            veces = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error: El segundo argumento debe ser un número.");
            System.exit(1);
            return;
        }

        for (int i = 1; i <= veces; i++) {
            System.out.println(i + ". " + cadena);
        }
    }
}