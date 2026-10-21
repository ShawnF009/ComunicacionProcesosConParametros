package Ejer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Aleatorios {

    public static void main(String[] args) {
        // El hijo lee de System.in para saber CUÁNDO actuar
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Random random = new Random();

            // Mientras el padre siga enviando peticiones (líneas)...
            while (br.readLine() != null) {
                int numAleatorio = random.nextInt(11); // Aleatorio entre 0 y 10

                // El hijo escribe el resultado en System.out
                System.out.println(numAleatorio);
                // Hacemos flush para que el padre lo reciba al instante
                System.out.flush();
            }
        } catch (IOException e) {
        }
    }
}