Aquí tienes el enunciado convertido a **formato Markdown (.md)**, listo para copiar y pegar:

```md
# 📦 Ejercicio: Gestión Académica con JDBC y Patrón DAO

> 🎯 **Objetivo:**  
Desarrollar una aplicación de consola en Java que gestione una base de datos relacional (alumnos, cursos y matrículas) aplicando el patrón de diseño **DAO (Data Access Object)**. El ejercicio introduce relaciones de clave foránea y transacciones SQL.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `universidad_db` con las siguientes tablas:

| Tabla        | Campos                                                                 |
|-------------|------------------------------------------------------------------------|
| **alumnos** | `id` (PK), `nombre`, `email` (UNIQUE)                                  |
| **cursos**  | `id` (PK), `titulo`, `creditos`                                        |
| **matriculas** | `id` (PK), `alumno_id` (FK), `curso_id` (FK), `fecha_matricula`    |

---

### 2. Arquitectura del Proyecto

```

src/
├── model/           ← Alumno.java, Curso.java, Matricula.java
├── dao/             ← Interfaces (AlumnoDAO.java, CursoDAO.java, MatriculaDAO.java) y sus implementaciones
├── db/              ← ConexionDB.java (Gestión de transacciones)
└── Main.java        ← Menú interactivo

````

---

## 📋 Funcionalidades Requeridas

- **CRUD Completo:** Implementar operaciones para Alumnos y Cursos.
- **Matricular Alumno:** Insertar en la tabla `matriculas` validando previamente que los IDs existan.
- **Listado con JOIN:** Consultar todas las matrículas mostrando: *Nombre del Alumno - Título del Curso - Fecha*.
- **Gestión de integridad:** Al eliminar un alumno, gestionar sus matrículas (ON DELETE CASCADE o eliminación manual).

---

## 📑 Interfaces DAO

Debes crear las siguientes interfaces:

```java
public interface AlumnoDAO {
    void insertar(Alumno alumno) throws SQLException;
    void actualizar(Alumno alumno) throws SQLException;
    void eliminar(int id) throws SQLException;
    Alumno obtenerPorId(int id) throws SQLException;
    List<Alumno> listarTodos() throws SQLException;
}

public interface CursoDAO {
    void insertar(Curso curso) throws SQLException;
    void actualizar(Curso curso) throws SQLException;
    void eliminar(int id) throws SQLException;
    Curso obtenerPorId(int id) throws SQLException;
    List<Curso> listarTodos() throws SQLException;
}

public interface MatriculaDAO {
    // Método principal para matricular (usar transacciones)
    void matricular(int alumnoId, int cursoId, LocalDate fecha) throws SQLException;
    
    // Listado con JOIN
    List<MatriculaDTO> listarMatriculasDetalladas() throws SQLException;

    void cancelarMatricula(int id) throws SQLException;
}
````

---

## 📋 Menú de la Aplicación

| Opción | Funcionalidad        | Descripción                           |
| ------ | -------------------- | ------------------------------------- |
| 1      | Listar alumnos       | Muestra todos los alumnos registrados |
| 2      | Buscar alumno por ID | Solicita un ID y muestra el alumno    |
| 3      | Crear alumno         | Inserta un nuevo alumno               |
| 4      | Actualizar alumno    | Modifica los datos de un alumno       |
| 5      | Eliminar alumno      | Elimina un alumno y sus matrículas    |
| 6      | Listar cursos        | Muestra todos los cursos              |
| 7      | Crear curso          | Inserta un nuevo curso                |
| 8      | Matricular alumno    | Asocia un alumno a un curso           |
| 9      | Listar matrículas    | Muestra alumno, curso y fecha (JOIN)  |
| 0      | Salir                | Finaliza el programa                  |

---

## 🟢 Buenas Prácticas y Evaluación

* **Uso de Transacciones:** Usar `connection.setAutoCommit(false)` al matricular.
* **Consultas seguras:** Uso de `PreparedStatement`.
* **Patrón DAO:** Separación clara entre entidad, persistencia y lógica.
* ✅ Todas las operaciones funcionan y persisten.
* ✅ Uso de *try-with-resources*.

---

> 💡 **Consejo:**
> Para el listado con JOIN, crea una clase DTO (Data Transfer Object) que contenga los nombres de los objetos relacionados para facilitar la visualización en consola.

```


