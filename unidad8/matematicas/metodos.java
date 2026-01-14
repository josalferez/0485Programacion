package matematicas;

import java.util.Scanner;

public class metodos {
    public static boolean esPar(int numero) {
        return (numero % 2 == 0);
    }

    public static int pedirNumero() {
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

    // Devuelve true si el numero que le pasamos como argumento
    // es capicúa
    public static boolean esCapicua(int numero) {
        // 1. Guardamos el número original para compararlo al final
        int original = numero;

        // 2. Inicializamos la variable para construir el número invertido
        int invertido = 0;

        // 3. Iteramos mientras el número sea mayor que 0
        while (numero > 0) {
            // Obtenemos el último dígito del número
            int digito = numero % 10;

            // Construimos el número invertido: multiplicamos 'invertido' por 10
            // y le sumamos el 'digito' actual
            invertido = invertido * 10 + digito;

            // Eliminamos el último dígito del número original
            numero = numero / 10;
        }

        // 4. Comparamos el número original con el invertido
        // Si son iguales, el número es capicúa.
        return original == invertido;
    }

    // Metodo esPrimo. Devuelve verdadero/falso si el numero que se le pasa como
    // argumento es/no_es primo
    public static boolean esPrimo(int numero) {
        boolean primoEs = numero > 1; // 0 y 1 no son primos
        for (int i = 2; i * i <= numero && primoEs; i++) {
            if (numero % i == 0) {
                primoEs = false;
            }
        }
        return primoEs;
    }

    // Metodo siguiente primo devuelve un entero y se le pasa un entero
    public static int siguientePrimo(int numero){
        numero += 1;
        while (!esPrimo(numero)){
            numero++;
        }
        return numero;
    }
}
