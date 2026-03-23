# 📚 Ejercicio: Gestión de Biblioteca con JDBC y Patrón DAO

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que gestione una base de datos relacional (socios, libros y préstamos) aplicando el patrón de diseño **DAO (Data Access Object)**. El ejercicio introduce relaciones de clave foránea y transacciones SQL.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `biblioteca_db` con las siguientes tablas:

| Tabla         | Campos                                                                 |
|---------------|------------------------------------------------------------------------|
| **socios**    | `id` (PK), `nombre`, `email` (UNIQUE)                                  |
| **libros**    | `id` (PK), `titulo`, `autor`                                           |
| **prestamos** | `id` (PK), `socio_id` (FK), `libro_id` (FK), `fecha_prestamo`         |

### 2. Arquitectura del Proyecto

```
src/
├── model/           ← Socio.java, Libro.java, Prestamo.java
├── dao/             ← Interfaces (SocioDAO.java, LibroDAO.java, PrestamoDAO.java)
│                       y sus implementaciones (SocioDAOImpl.java, LibroDAOImpl.java, PrestamoDAOImpl.java)
├── db/              ← ConexionDB.java (Gestión de transacciones)
└── Main.java        ← Menú interactivo
```

---

## 📋 Funcionalidades Requeridas

- **CRUD Completo:** Implementar operaciones para Socios y Libros.
- **Registrar Préstamo:** Insertar en la tabla `prestamos` validando previamente que los IDs existan.
- **Listado con JOIN:** Consultar todos los préstamos mostrando: *Nombre del Socio - Título del Libro - Fecha*.
- **Gestión de integridad:** Al eliminar un socio, gestionar sus préstamos (restricción ON DELETE CASCADE o eliminación manual).

---

## 📑 Interfaces DAO

Debes crear las siguientes interfaces:

```java
public interface SocioDAO {
    void insertar(Socio socio) throws SQLException;
    void actualizar(Socio socio) throws SQLException;
    void eliminar(int id) throws SQLException;
    Socio obtenerPorId(int id) throws SQLException;
    List<Socio> listarTodos() throws SQLException;
}

public interface LibroDAO {
    void insertar(Libro libro) throws SQLException;
    void actualizar(Libro libro) throws SQLException;
    void eliminar(int id) throws SQLException;
    Libro obtenerPorId(int id) throws SQLException;
    List<Libro> listarTodos() throws SQLException;
}

public interface PrestamoDAO {
    // Método principal para registrar un préstamo (Debe usarse con transacciones en la implementación)
    void registrarPrestamo(int socioId, int libroId, LocalDate fecha) throws SQLException;

    // Método para el listado con JOIN (usando un DTO o String para la consola)
    // El objetivo es mostrar: Nombre Socio - Título Libro - Fecha
    List<PrestamoDTO> listarPrestamosDetallados() throws SQLException;

    void cancelarPrestamo(int id) throws SQLException;
}
```

---

## 📋 Menú de la Aplicación

La aplicación debe mostrar el siguiente menú por consola:

| Opción | Funcionalidad          | Descripción                              |
|--------|------------------------|------------------------------------------|
| 1      | Listar socios          | Muestra todos los socios registrados     |
| 2      | Buscar socio por ID    | Solicita un ID y muestra el socio        |
| 3      | Crear socio            | Inserta un nuevo socio                   |
| 4      | Actualizar socio       | Modifica los datos de un socio           |
| 5      | Eliminar socio         | Elimina un socio y sus préstamos         |
| 6      | Listar libros          | Muestra todos los libros                 |
| 7      | Crear libro            | Inserta un nuevo libro                   |
| 8      | Registrar préstamo     | Asocia un socio a un libro               |
| 9      | Listar préstamos       | Muestra socio, libro y fecha (JOIN)      |
| 0      | Salir                  | Finaliza el programa                     |

---

## 🟢 Buenas Prácticas y Evaluación

- **Uso de Transacciones:** Usar `connection.setAutoCommit(false)` al registrar préstamos para asegurar integridad.
- **Consultas seguras:** Uso riguroso de `PreparedStatement`.
- **Patrón DAO:** Separación clara entre entidad, persistencia y lógica.
- ✅ Todas las operaciones funcionan y persisten.
- ✅ Uso de try-with-resources.

---

> **💡 Consejo:** Para el listado con JOIN, crea una clase DTO (Data Transfer Object) o un modelo específico que contenga los nombres de los objetos relacionados para facilitar la visualización en la consola.
