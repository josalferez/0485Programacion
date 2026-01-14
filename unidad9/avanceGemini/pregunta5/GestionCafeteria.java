public class GestionCafeteria {
    public static void main(String[] args) {
        Producto p1 = new Producto("Cafe", 1.5);
        Producto p2 = new Producto("Tostada", 2.5);

        Cliente c1 = new Cliente("Juan", 10);
        Cliente c2 = new Cliente("Maria", 2);

        Camarero cam1 = new Camarero("Amador", Turno.NOCHE, 1200);

        c2.pedirProducto(p2); // Maria pide un producto superior a su saldo
        cam1.traspasarSaldo(c1, c2, 5); // El camarero pasa 5 euros de juan a maría
        c2.pedirProducto(p2); // Maria pide nuevamente un producto
        System.out.println("Se han creado hasta la fecha " + Producto.getTotalProductosCreados() + " productos.");

        // Creamos al jefe
        Gerente jefe = new Gerente("Administración", true, 5000, 10, "Don Antonio", Turno.MAÑANA, 3000);

        // Creamos una lista de empleados (Polimorfismo)
        Empleado[] plantilla = { cam1, jefe };

        System.out.println("\n--- INICIO DE LA JORNADA ---");
        for (Empleado e : plantilla) {
            e.realizarTarea(); // Cada uno hace lo suyo automáticamente
        }

        // El jefe hace su magia
        jefe.modificarPrecio(p1, 2.0); // Sube el precio del café
        System.out.println("Nuevo precio del café: " + p1.getPrecio() + "€");
        jefe.organizarTurno(cam1, Turno.TARDE); // Cambia al camarero de turno
        System.out.println("Nuevo turno de " + cam1.getNombre() + ": " + cam1.getTurno());

    }
}