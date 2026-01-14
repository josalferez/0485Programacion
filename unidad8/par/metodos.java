package par;

import java.util.Scanner;

public class metodos {
    // 1. metodo que pide un numero.
    // No recibe parámetros
    // Devuelve un int
    public static int pidoNumero() {
        Scanner sc = new Scanner(System.in);
        int numero = -1;
        System.out.print("Introduce un numero: ");

        if (sc.hasNextInt()) {
            numero = sc.nextInt();
        }

        // Cierro el Scanner
        sc.close();

        return numero;
    }

    // 2. método que calcula si un numero es par o no
    // Recibe un int
    // Devuelve un boolean
    public static boolean esPar(int number) {
        return (number % 2 == 0);
    }
}
