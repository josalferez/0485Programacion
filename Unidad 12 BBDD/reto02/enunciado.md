
# 📦 Ejercicio: Gestión de Productos con JDBC y Patrón DAO

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que implemente operaciones CRUD completas sobre una base de datos MySQL, utilizando el patrón de diseño **DAO (Data Access Object)**. El dominio de este ejercicio es un catálogo de productos de una tienda.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

* Utilizar **MySQL** (puede levantarse mediante Docker con la imagen `mysql:8.0`).
* La base de datos debe llamarse `tienda_db`.
* Tabla `productos` con los siguientes campos:

| Campo | Tipo | Restricciones | Descripción |
| --- | --- | --- | --- |
| `id` | INT | PRIMARY KEY, AUTO_INCREMENT | Identificador único del producto |
| `nombre` | VARCHAR(150) | NOT NULL | Nombre del producto |
| `categoria` | VARCHAR(100) | NOT NULL | Categoría (ej: Electrónica, Ropa, Hogar…) |
| `precio` | DECIMAL(10,2) | NOT NULL | Precio de venta del producto |
| `stock` | INT | DEFAULT 0 | Unidades disponibles en almacén |

### 2. Conector JDBC

* Debes crear una carpeta llamada **`lib`** en la raíz de tu proyecto.
* Descarga el conector JDBC de MySQL (`mysql-connector-j-x.x.x.jar`) y colócalo dentro de dicha carpeta.
* Asegúrate de añadir este archivo `.jar` al *Classpath* de tu proyecto en VS Code (sección "Referenced Libraries").

### 3. Arquitectura del Proyecto

El proyecto debe seguir una estructura de paquetes clara y respetar el patrón DAO:

```text
nombre-proyecto/
├── lib/
│   └── mysql-connector-j-x.x.x.jar  ← Driver JDBC
├── src/
│   ├── model/
│   │   └── Producto.java            ← Clase entidad (POJO)
│   ├── dao/
│   │   ├── ProductoDAO.java         ← Interfaz con los métodos CRUD
│   │   └── ProductoDAOImpl.java     ← Implementación con JDBC
│   ├── db/
│   │   └── ConexionDB.java          ← Gestión de la conexión a MySQL
│   └── Main.java                    ← Menú interactivo de consola

```

---

## 📋 Funcionalidades Requeridas

La aplicación debe presentar un **menú por consola** con las siguientes opciones:

| Opción | Funcionalidad | Descripción |
| --- | --- | --- |
| **1** | Listar todos los productos | Muestra todos los registros en formato tabular. |
| **2** | Buscar producto por ID | Solicita un ID y muestra los datos del producto, o indica si no existe. |
| **3** | Crear nuevo producto | Solicita nombre, categoría, precio y stock, e inserta el registro. |
| **4** | Actualizar producto | Solicita un ID y los nuevos valores para modificar el registro. |
| **5** | Eliminar producto | Solicita un ID y elimina el producto. |
| **6** | Filtrar por categoría | Solicita una categoría y lista los productos coincidentes. |
| **0** | Salir | Finaliza la ejecución del programa. |

---

## 🔧 Detalles de Implementación

### Clase `Producto.java`

* Atributos privados: `id`, `nombre`, `categoria`, `precio`, `stock`.
* Constructor vacío y con parámetros.
* Getters y setters.
* Sobreescribir `toString()` para mostrar los datos formateados.

### Interfaz `ProductoDAO.java`

* `List<Producto> findAll()`
* `Optional<Producto> findById(int id)`
* `void save(Producto p)`
* `void update(Producto p)`
* `void delete(int id)`
* `List<Producto> findByCategoria(String categoria)`

### Clase `ConexionDB.java`

* Los datos de conexión deben estar definidos como constantes (`URL`, `USER`, `PASS`).

---

## 🟢 Buenas Prácticas Obligatorias

* Usar **`PreparedStatement`** en todas las consultas para prevenir inyección SQL.
* Gestionar los recursos con **`try-with-resources`** para asegurar su cierre automático.
* Implementar validaciones: nombre no vacío, precio > 0, stock >= 0.
* Capturar y gestionar adecuadamente las excepciones `SQLException`.

> **📄 Criterios de Evaluación:**
> * ✅ Correcta implementación del patrón DAO (interfaz + implementación).
> * ✅ Todas las operaciones CRUD funcionan y persisten en la base de datos.
> * ✅ Uso de `PreparedStatement` y `try-with-resources`.
> * ✅ Carpeta `lib` configurada correctamente en el proyecto.
> * ✅ Código organizado según la estructura indicada.
> 
>