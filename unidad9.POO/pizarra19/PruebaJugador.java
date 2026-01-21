
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaJugador {

    public static void main(String[] args) {

        // 5.1. Creo el ArrayList liga
        ArrayList<Jugador> liga = new ArrayList<>();

        // 5.2. Añade 2 jugadores amateur y dos profesionales
        JugadorAmateur ja1 = new JugadorAmateur(false, 0, "Chamorro", 0, RolJugador.TANQUE);
        JugadorAmateur ja2 = new JugadorAmateur(false, 0, "Ana", 0, RolJugador.TANQUE);
        JugadorProfesional jp1 = new JugadorProfesional(2500, 0, "Carlos", 150, RolJugador.TANQUE);
        JugadorProfesional jp2 = new JugadorProfesional(2500, 0, "Jose", 160, RolJugador.TANQUE);
        liga.add(ja1);
        liga.add(ja2);
        liga.add(jp1);
        liga.add(jp2);

        // 5.3. Muestro el tamaño de la lista
        System.out.println("La lista tiene un tamaño de: " + liga.size());
        for (Jugador jugador : liga) {
            System.out.println(jugador);
        }

        // 6. instanceof y Polimorfismo
        for (Jugador jugador : liga) {
            if (jugador instanceof JugadorProfesional pro)
                pro.entrenar();
            else
                System.out.println("El jugador " + jugador.getNombre() + " es un jugador amateur.");
        }

        // 7. Comparo objetos en foreach
        Jugador anterior = null;
        for (Jugador actual : liga) {
            if (anterior != null) {
                if (anterior.equals(actual))
                    System.out.println("El jugador " + anterior.getNombre()
                            + " y el jugador " + actual.getNombre() + " están duplicados.");
            }
            anterior = actual;
        }

        // 8. Operaciones con ArrayList
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        while (opcion != 0) {
            System.out.println("\nPulsa ENTER para continuar...");
            sc.nextLine();
            System.out.print("\033c"); // Limpio la pantalla
            System.out.println("\n--- MENÚ OPERACIONES ARRAYLIST ---");
            System.out.println("1. Comprobar si existe un jugador (contains)");
            System.out.println("2. Modificar un jugador por posición (set)");
            System.out.println("3. Obtener un jugador por posición (get)");
            System.out.println("4. Eliminar jugadores amateur (removeIf)");
            System.out.println("5. Mostrar lista final");
            System.out.println("6. Listar todos los jugadores");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre a buscar: ");
                    String nombreBusqueda = sc.nextLine();
                    // contains usa el método equals definido en la clase Jugador
                    // Creo un jugador me da igual amateur que profesional porque el contains va a
                    // buscar en el arrayList de liga
                    if (liga.contains(new JugadorAmateur(false, 0, nombreBusqueda, 0, RolJugador.TANQUE))) {
                        System.out.println("¡El jugador está en la liga!");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Índice a modificar: ");
                    int idxMod = sc.nextInt();
                    sc.nextLine();
                    if (idxMod >= 0 && idxMod < liga.size()) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        liga.set(idxMod, new JugadorAmateur(false, 0, nuevoNombre, 0, RolJugador.TANQUE));
                        System.out.println("Jugador actualizado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                    break;

                case 3:
                    System.out.print("Índice a consultar: ");
                    int idxGet = sc.nextInt();
                    if (idxGet >= 0 && idxGet < liga.size()) {
                        System.out.println("Jugador: " + liga.get(idxGet));
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    // removeIf utiliza un predicado (lambda) para filtrar
                    liga.removeIf(j -> !j.esProfesional());
                    System.out.println("Se han eliminado todos los jugadores amateur.");
                    break;

                case 5:
                    System.out.println("--- LIGA ACTUAL ---");
                    for (Jugador j : liga) {
                        System.out.println(j);
                    }
                    break;

                case 6: // Listo todos los jugadores
                    for (Jugador jugador : liga) {
                        System.out.println(jugador);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();

        // Le subo un nivel a un jugador
        ja1.subirNivel();

        // Le subo 10 niveles a un jugador
        ja2.subirNivel(10);

        // 10.1 Salida final
        System.out.println("Estado inicial de la liga");
        for (Jugador jugador : liga) {
            System.out.println(jugador);
        }

        // 10.2 Cambios tras entrenamientos
        // ja1 Entrena
        ja1.entrenar();
        jp1.entrenar();

        // 10.3 Detecto jugadores duplicados
        System.out.println("Detecto jugadores duplicados");
        for (int i = 0; i < liga.size(); i++) {
            for (int j = i + 1; j < liga.size(); j++) {
                if (liga.get(i).equals(liga.get(j))) {
                    System.out.println("Duplicados: "
                            + liga.get(i).getNombre()
                            + " y "
                            + liga.get(j).getNombre());
                }
            }
        }

        // 10.4 lista final tras eliminaciones
        for (Jugador jugador : liga) {
            System.out.println(jugador);
        }

    }

}
