public class ejercicio2T7 {

    public static void main(String[] args) {
        final int TAMANO = 10;
        char[] simbolo = new char[TAMANO];

        // Asignación de valores según la tabla (índices 0, 1, 4, 6, 7, 8)
        simbolo[0] = 'a';
        simbolo[1] = 'x';
        // simbolo[2] no asignado -> \u0000
        // simbolo[3] no asignado -> \u0000
        simbolo[4] = '@';
        // simbolo[5] no asignado -> \u0000
        simbolo[6] = ',';
        simbolo[7] = '+';
        simbolo[8] = 'Q';
        // simbolo[9] no asignado -> \u0000

        // Mostrar el contenido
        System.out.println("--- Contenido del Array 'simbolo' ---");
        System.out.println("Índice | Valor (char) | Código ASCII (int)");
        System.out.println("------------------------------------");

        for (int i = 0; i < TAMANO; i++) {
            System.out.printf("  %d    |      %c     |         %d\n", i, simbolo[i], (int)simbolo[i]);
        }
    }
}
