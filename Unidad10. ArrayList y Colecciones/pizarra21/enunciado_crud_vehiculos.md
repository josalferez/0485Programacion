# Enunciado: Menú CRUD para el diccionario de vehículos

## Objetivo
Crear un programa en Java que gestione un `HashMap<Integer,Vehiculo>` mediante un menú interactivo que permita Crear, Leer, Actualizar y Borrar (CRUD) entradas. Se partirá de las clases existentes: `Vehiculo`, `Coche` y `Moto` y del fichero `PruebaHash.java`.

---

## Requisitos mínimos

- Implementar un menú con las opciones:
  1. Añadir vehículo (pedir tipo: coche/moto, matrícula y marca; asignar `key` automáticamente).
  2. Listar todos los vehículos (mostrar `key` + datos mediante `mostrarDatos()`).
  3. Mostrar un vehículo por `key`.
  4. Actualizar un vehículo (cambiar matrícula y/o marca por `key`).
  5. Eliminar un vehículo por `key`.
  6. Eliminar todos los vehículos cuya matrícula empiece por una determinada `key`.
  0. Salir.

- Usar `HashMap<Integer,Vehiculo>` para almacenar los vehículos.
- No iterar y eliminar directamente sobre el `HashMap` (recopilar keys a borrar y luego eliminarlas).
- Al añadir, calcular la siguiente `key` libre (por ejemplo `maxKey+1`).
- Separar funcionalidades en métodos (p.ej. `mostrarMenu()`, `siguienteKey()`, `eliminarPorPrefijo()`).
- Entrada y salida por consola con `Scanner`.

---

## Ejemplo de interacción

- Programa muestra el menú:

```
--- MENÚ CRUD ---
1. Añadir vehículo
2. Listar vehículos
3. Mostrar vehículo por key
4. Actualizar vehículo
5. Eliminar vehículo por key
6. Eliminar vehículos cuya matrícula empiece por '86'
0. Salir
```

- Flujo de ejemplo:
  - El usuario elige `2` → se listan todos los vehículos con sus `key`.
  - El usuario elige `6` → `Eliminados 1 vehículos cuyo prefijo es '86'` (si existían).
  - El usuario elige `1`, introduce tipo `1` (Coche), matrícula `123ABC`, marca `Fiat` → `Añadido con key=12`.

---

## Casos de prueba sugeridos

1. Listar cuando el diccionario está vacío → mostrar "Diccionario vacío.".
2. Añadir varios vehículos y comprobar que las `key` son consecutivas (`maxKey+1`).
3. Mostrar por `key` correcta e incorrecta → mensaje "No existe key X" si no existe.
4. Actualizar un vehículo y dejar un campo en blanco (enter) para mantener el valor anterior.
5. Eliminar por `key` existente y por `key` inexistente.
6. Eliminar por prefijo "86":
   - Cuando existen vehículos con matrícula que empieza por `86` → comprobar número eliminado.
   - Cuando no existen → comprobar mensaje de "No se encontraron...".
7. Prueba de robustez: introducir letras donde espera números en el menú (no debe crashear).

---

## Extensiones opcionales (bonus)

- Búsqueda por matrícula (devuelve `key` y datos).
- Guardar/leer el diccionario a/desde un fichero (CSV simple o serialización).
- Búsqueda por marca y filtrado.
- Confirmaciones antes de eliminar (p.ej. "¿Seguro? (s/n)").

---