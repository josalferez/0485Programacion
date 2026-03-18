/*
EJERCICIO DE PRÁCTICA: SISTEMA DE GESTIÓN DE PEDIDOS DE UNA CAFETERÍA

Desarrollar una aplicación de consola en Java que simule el proceso de toma de pedidos y gestión del menú de una cafetería.

REQUISITOS DEL SISTEMA
------------------------------------------------------

1. Estructura de Datos (Arrays)

* Menú Fijo: Utiliza un Array Bidimensional de String (String[][]) llamado 'menu'.
    * Columna 0: Nombre del Ítem (e.g., "Café", "Tostada").
    * Columna 1: Precio (como String).
    * Columna 2: Disponibilidad (como String, e.g., "Disponible", "Agotado").

* Registro de Pedido: Utiliza un Array de String de tamaño fijo (máximo 12 ítems) llamado 'pedido'.
    * Este array solo debe almacenar los nombres de los ítems seleccionados.
    * Necesitarás un contador (int) para llevar el registro del número de ítems añadidos.

2. Interacción y Lógica de Compra

* Bucle Principal: Usa un bucle while para la interacción continua con el usuario. La condición de salida debe ser cuando el usuario 
* seleccione una opción de "Finalizar pedido" (e.g., seleccionando 0).
* Selección: Utiliza la clase Scanner y una estructura switch para manejar la selección del ítem del menú por parte del cliente (Ítem 1, Ítem 2, etc.).

3. Requisitos de Estructura y Conceptos (Java)

* Método mostrarMenu: Método static que reciba el 'menu' y lo imprima de forma clara en la consola, incluyendo el índice de selección (1, 2, 3...).
* Lógica de Selección (Doble Control if-else): Dentro de cada 'case' de la estructura switch:
    * PRIMER IF: Comprobar la disponibilidad del ítem en el 'menu' (Columna 2).
    * SEGUNDO IF (anidado): Comprobar si el 'pedido' ha alcanzado su límite de 12 ítems.
    * Si es válido: Añadir el nombre del ítem al array 'pedido' e incrementar el contador.
* Método procesarPedido: Método static que reciba el 'pedido', el contador de ítems y el 'menu'. Este método debe:
    * Calcular el total a pagar (en double).
    * Mostrar un ticket de compra detallado con los ítems y el total.

RESULTADO FINAL ESPERADO
------------------------------------------------------

Al seleccionar la opción de finalizar, el programa debe salir del bucle while e imprimir el Ticket de Compra final con el desglose de los ítems 
solicitados y el monto total a pagar.
*/

public class pizarra11T8{
    public static void main(String[] args) {
        String[]
    }
    
}
