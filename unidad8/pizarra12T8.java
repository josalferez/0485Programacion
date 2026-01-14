/**
 * Desarrollar una aplicación de consola en Java que simule un Sistema de Reserva
 * de Asientos de Teatro, centrado en la manipulación y gestión de un array bidimensional.
 *
 * * =================================================================
 * REQUISITOS DEL SISTEMA DE RESERVAS
 * =================================================================
 *
 * * 1. Estructura de Datos (Array Bidimensional de char)
 * - Mapa de Asientos: Usar un Array Bidimensional de 'char' (char[][]) llamado 'sala'.
 * - Dimensiones: 5 filas y 10 columnas (5x10).
 * - Inicialización: Todos los asientos deben ser inicializados con el carácter 'L' (Libre).
 * - Estados Posibles:
 * - 'L': Libre (Disponible para reserva).
 * - 'R': Reservado (Asiento ocupado).
 *
 * * 2. Interacción y Lógica de Gestión
 * - Bucle Principal: Usar un bucle while que muestre un menú de opciones (Reservar, Cancelar, Mostrar Sala, Salir).
 * - Entrada del Usuario: El usuario especificará un asiento usando coordenadas: Fila (1-5) y Columna (1-10).
 *
 * * 3. Requisitos de Estructura y Conceptos (Java)
 *
 * - Método inicializarSala: Método static que reciba el array 'sala' y pueble todos sus elementos con 'L'.
 *
 * - Método mostrarSala: Método static que reciba el array 'sala' y lo imprima claramente en la consola.
 * Debe incluir cabeceras de columnas y filas (1 a 10 y 1 a 5, respectivamente)
 * para que el usuario lo visualice correctamente.
 *
 * - Método reservarAsiento: Método static que reciba la 'sala', la 'fila' y la 'columna' (coordenadas de usuario 1-N).
 * - Debe realizar la conversión de las coordenadas de usuario a índices de array (0-N-1).
 * - Debe validar los límites del array.
 * - Debe validar si el asiento está actualmente 'L'. Si es así, cambia el estado a 'R'.
 *
 * - Método cancelarAsiento: Método static que reciba la 'sala', la 'fila' y la 'columna' (coordenadas de usuario 1-N).
 * - Debe realizar la conversión de las coordenadas de usuario a índices de array (0-N-1).
 * - Debe validar los límites del array.
 * - Debe validar si el asiento está actualmente 'R'. Si es así, cambia el estado a 'L'.
 *
 * * RESULTADO FINAL ESPERADO:
 * * El programa debe permitir la interacción continua y la última visualización de la sala debe reflejar todos los cambios de estado ('L' o 'R').
 */
import java.util.Scanner;

public class pizarra12T8 {
    public static void main(String[] args) {
        char
    }
}