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
| **prestamos** | `id` (PK), `socio_id` (FK), `libro_id` (FK), `fecha_prestamo`          |

**Script SQL de creación:**

```sql
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

CREATE TABLE socios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    socio_id INT NOT NULL,
    libro_id INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (socio_id) REFERENCES socios(id) ON DELETE CASCADE,
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE
);
```
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

---

## 💾 Anexo: Consultas SQL de las Implementaciones DAO

A continuación se muestran las consultas SQL utilizadas en las clases que implementan las interfaces (DAOImpl):

### SocioDAOImpl
- **insertar**: `INSERT INTO socios (nombre, email) VALUES (?, ?)`
- **actualizar**: `UPDATE socios SET nombre = ?, email = ? WHERE id = ?`
- **eliminar**: `DELETE FROM socios WHERE id = ?`
- **obtenerPorId**: `SELECT * FROM socios WHERE id = ?`
- **listarTodos**: `SELECT * FROM socios`

### LibroDAOImpl
- **insertar**: `INSERT INTO libros (titulo, autor) VALUES (?, ?)`
- **actualizar**: `UPDATE libros SET titulo = ?, autor = ? WHERE id = ?`
- **eliminar**: `DELETE FROM libros WHERE id = ?`
- **obtenerPorId**: `SELECT * FROM libros WHERE id = ?`
- **listarTodos**: `SELECT * FROM libros`

### PrestamoDAOImpl
- **registrarPrestamo** (Transacción):
  - `INSERT INTO prestamos (socio_id, libro_id, fecha) VALUES (?, ?, ?)`
  - `UPDATE libros SET disponible = false WHERE id = ?`
- **listarPrestamosDetallados**:
  - `SELECT s.nombre AS socio_nombre, l.titulo AS libro_titulo, p.fecha FROM prestamos p JOIN socios s ON p.socio_id = s.id JOIN libros l ON p.libro_id = l.id`
- **cancelarPrestamo** (Transacción):
  - `UPDATE libros SET disponible = true WHERE id = (SELECT libro_id FROM prestamos WHERE id = ?)`
  - `DELETE FROM prestamos WHERE id = ?`
