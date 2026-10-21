package Ejer4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        BufferedReader lectorEntrada = new BufferedReader(new InputStreamReader(System.in));
        Random generadorAleatorio = new Random();

        try {
            String peticion;
            while ((peticion = lectorEntrada.readLine()) != null) {
                if (peticion.equalsIgnoreCase("fin")) {
                    break;
                }
                // Genera un número aleatorio del 0 al 10
                int numeroAleatorio = generadorAleatorio.nextInt(11);
                System.out.println(numeroAleatorio);
            }
        } catch (IOException e) {
            System.err.println("Error en el proceso de aleatorios: " + e.getMessage());
        }
    }
}