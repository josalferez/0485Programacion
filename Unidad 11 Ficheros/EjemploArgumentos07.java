/**
 * Paso de argumentos en la línea de comandos
 *
 * @author Luis José Sánchez
 */
class EjemploArgumentos07 {
    public static void main(String[] args) {
        System.out.print("La suma de los argumentos es: ");
        int suma = 0;
        for (String numero : args) {
            suma += Integer.parseInt(numero);
        }
        System.out.print(suma);
    }
}