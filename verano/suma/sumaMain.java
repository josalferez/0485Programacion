package suma;

import java.util.Scanner;

public class sumaMain {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("dame un valor");
        int valorUno = sc.nextInt();

        System.out.println("dame el segundo valor");
        int valorDos = sc.nextInt();

        suma operacion = new suma(valorUno,valorDos);

        operacion.imprimirResultado();

    }
}
