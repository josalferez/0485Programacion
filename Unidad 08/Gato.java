import java.util.Scanner; // Necesario para leer la entrada del usuario

public class Gato {

    // ----------------------------------------------------------------------
    // --- SIMULACIÓN DE MÉTODOS GETTER y SETTER (Fuera de main) ---
    // (Mantenemos estos métodos para seguir el ejemplo de POO que iniciaste)
    // ----------------------------------------------------------------------

    /** Simula el 'Setter' para el nombre: establece un nuevo valor. */
    public static String setNombre(String nuevoNombre) {
        System.out.println("-> [SETTER] Modificando el nombre a: " + nuevoNombre);
        return nuevoNombre;
    }

    /** Simula el 'Getter' para el nombre: devuelve el valor actual. */
    public static String getNombre(String nombreActual) {
        System.out.println("<- [GETTER] Accediendo al nombre actual: " + nombreActual);
        return nombreActual;
    }

    // ----------------------------------------------------------------------
    // --- MÉTODO PRINCIPAL MAIN CON SWITCH ---
    // ----------------------------------------------------------------------
    public static void main(String[] args) {

        // 1. Declaración e Inicialización de Variables (Simulación de "Atributos")
        String nombre = "Mittens";
        int edad = 3;
        String raza = "Siamés";
        String sexo = "Hembra";
        boolean salir = false;

        // Inicializamos el objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        int opcion;

        while (!salir) {

            System.out.println("=========================================");
            System.out.println("   INTERACCIÓN CON EL GATO " + nombre.toUpperCase());
            System.out.println("=========================================");

            // 2. Menú de Opciones
            System.out.println("Elige una acción para el gato:");
            System.out.println("1. Obtener el nombre (GET)");
            System.out.println("2. Cambiar el nombre (SET)");
            System.out.println("3. ¿Qué sonido hace? (Comportamiento)");
            System.out.println("4. Mostrar Raza");
            System.out.println("5. Salir ");
            System.out.print("Introduce tu opción (1-5): ");

            // Leemos la opción del usuario
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la línea que queda después del nextInt()

            // 3. ESTRUCTURA SWITCH
            // El 'switch' evaluará el valor de la variable 'opcion'.
            System.out.println("\n--- Ejecutando Acción ---");
            switch (opcion) {
                case 1:
                    // Opción 1: Obtener el nombre (Usa el getter simulado)
                    String nombreActual = getNombre(nombre);
                    System.out.println("¡Su nombre es " + nombreActual + "!");
                    break;

                case 2:
                    // Opción 2: Cambiar el nombre (Usa el setter simulado)
                    System.out.print("Introduce el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    nombre = setNombre(nuevoNombre);
                    System.out.println("✅ ¡El nombre del gato ha sido actualizado a " + nombre + "!");
                    break;

                case 3:
                    // Opción 3: Un comportamiento específico
                    System.out.println("El gato hace: ¡MIAUUUU! 🐈");
                    break;

                case 4:
                    // Opción 4: Mostrar Raza (Switch anidado o secundario)
                    System.out.println("El gato es de raza: " + raza);

                    // Ejemplo de un switch basado en la RAZA
                    switch (raza.toLowerCase()) {
                        case "siamés":
                            System.out.println("Es un gato muy vocal y de ojos azules intensos.");
                            break;
                        case "persa":
                            System.out.println("Es un gato de pelo largo y cara chata.");
                            break;
                        default:
                            System.out.println("Es una raza común o desconocida.");
                            break;
                    }
                    break;

                case 5:
                    // Opción 3: Un comportamiento específico
                    System.out.println("Hasta la próxima!");
                    salir = true;
                    break;

                default:
                    // Opción por defecto (se ejecuta si 'opcion' no coincide con ningún case)
                    System.out.println("❌ Opción no válida. Debes elegir entre 1 y 5.");
                    break;
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("Fin del programa");
        System.out.println("El nombre final es: " + nombre);
        System.out.println("El sexo es : " + sexo);
        System.out.println("La raza final es: " + raza);
        System.out.println("El gato tiene: " + edad + " años");
        sc.close();

    }
}