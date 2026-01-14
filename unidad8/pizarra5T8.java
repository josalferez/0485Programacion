
public class pizarra5T8 {
    public static void main(String[] args) {
        // 1. Pido un número
        int numero = matematicas.metodos.pedirNumero();
        if (matematicas.metodos.esPar(numero)) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es impar");
        }
    }

}
