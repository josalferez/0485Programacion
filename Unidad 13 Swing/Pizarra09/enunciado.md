Aquí tienes el enunciado completo y definitivo en formato **.md**. He integrado la nueva lógica de base de datos con la relación entre usuarios y alumnos, la estructura de paquetes y las especificaciones de la interfaz gráfica profesional.

```markdown
# 📦 Proyecto Final: Sistema de Gestión Académica (JDBC + DAO + Swing)

> 🎯 **Objetivo:**
> Desarrollar una solución integral de escritorio para la gestión de centros educativos. La aplicación debe implementar una arquitectura **MVC** (Modelo-Vista-Controlador), asegurando que la interfaz gráfica sea intuitiva y esté totalmente desacoplada de la lógica de persistencia **DAO**.

---

## ⚙️ 1. Organización del Proyecto (Estructura de Paquetes)

Es obligatorio organizar los ficheros en la siguiente estructura de carpetas para garantizar la escalabilidad del software:

```text
src/
├── db/          ← ConexionDB.java (Gestión de Connection y Transacciones)
├── model/       ← Entidades (Alumno.java, Profesor.java, Curso.java, Usuario.java)
├── dao/         ← Interfaces e Implementaciones (AlumnoDAO, ProfesorDAO, CursoDAO, UsuarioDAO)
├── dto/         ← Objetos de Transferencia (MatriculaDTO.java para consultas JOIN)
├── view/        ← Interfaz Swing (Login.java, Registro.java, Principal.java)
└── Main.java    ← Lanzador de la aplicación
```

---

## 📋 2. Diseño de la Base de Datos (`universidad_db`)

La base de datos separa la identidad académica de las credenciales de acceso, vinculándolas mediante claves foráneas opcionales.

### Script SQL de creación:
```sql
CREATE DATABASE IF NOT EXISTS universidad_db;
USE universidad_db;

-- 1. Tabla de alumnos (Datos maestros)
CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- 2. Tabla de profesores
CREATE TABLE profesores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- 3. Tabla de usuarios (Credenciales y Seguridad)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE, -- DNI del usuario
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    alumno_id INT UNIQUE, -- Relación opcional con alumnos
    profesor_id INT UNIQUE, -- Relación opcional con profesores
    rol ENUM('alumno', 'profesor') NOT NULL DEFAULT 'alumno',
    CONSTRAINT fk_usuario_alumno FOREIGN KEY (alumno_id) 
        REFERENCES alumnos(id) ON DELETE SET NULL,
    CONSTRAINT fk_usuario_profesor FOREIGN KEY (profesor_id) 
        REFERENCES profesores(id) ON DELETE SET NULL
);

-- 3. Tabla de cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    creditos INT NOT NULL
);

-- 4. Tabla de matrículas (Relación N:M)
CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_matricula DATE NOT NULL,
    CONSTRAINT fk_mat_alumno FOREIGN KEY (alumno_id) 
        REFERENCES alumnos(id) ON DELETE CASCADE,
    CONSTRAINT fk_mat_curso FOREIGN KEY (curso_id) 
        REFERENCES cursos(id) ON DELETE CASCADE
);

-- Datos iniciales
INSERT INTO usuarios (username, password, email) VALUES ('admin', '1234', 'admin@universidad.com');
```

---

## 🖥️ 3. Especificaciones de la Interfaz Gráfica (Swing)

### A. Ventana de Acceso (`Login.java`)
- **Componentes:** Campos para usuario, contraseña (`JPasswordField`), botón de acceso y registro.
- **Lógica:** Valida credenciales en la tabla `usuarios`. Si existe un `alumno_id` asociado, el sistema debe reconocer al alumno vinculado tras el inicio de sesión.

### B. Ventana de Registro (`Registro.java`)
- **Componentes:** Formulario extendido (Nombre y Apellidos, DNI, Email, Password y Confirmación). 
- **Mapeo:** El campo **DNI** actúa como `username` para el login.
- **Selector de Rol:** `JComboBox` para elegir entre Alumno o Profesor.
- **Lógica de Vinculación:** Al registrarse, el sistema debe primero crear la entidad académica (inserción en `alumnos` o `profesores`) y posteriormente crear el `usuario` vinculado mediante el ID correspondiente.

### C. Ventana Principal de Gestión (`Principal.java`)
Es el panel de control del administrativo o alumno. Debe incluir:

1.  **Barra de Menús (`JMenuBar`):** Opciones para cerrar sesión, salir, cambiar preferencias de color y ayuda.
2.  **Navegación Lateral:** Botones para alternar entre "Gestión Alumnos", "Gestión Cursos" y "Nueva Matrícula".
3.  **Área Central:** * Un `JTable` dinámico que muestre los datos según la opción seleccionada.
    * Un `JTextArea` inferior (Consola) para mostrar logs del sistema (ej: "Conexión OK", "Registro guardado").
4.  **Panel de Operaciones:** Formulario lateral con campos de texto y botones (Guardar, Actualizar, Eliminar) para manipular los registros seleccionados.

---

## 📑 4. Contratos de Persistencia (Capa DAO)

Implementación obligatoria de las siguientes interfaces:

```java
public interface UsuarioDAO {
    // SQL: SELECT id, rol, alumno_id, profesor_id FROM usuarios WHERE username = ? AND password = ?
    boolean validar(String user, String pass) throws SQLException;
    
    // SQL: INSERT INTO usuarios (username, password, email, rol, alumno_id, profesor_id) VALUES (?, ?, ?, ?, ?, ?)
    void registrar(Usuario usuario) throws SQLException;
    
    // Opcional: obtener usuario con los datos del alumno vinculado
    // SQL: SELECT u.*, a.nombre AS nombre_alumno, a.email AS email_alumno FROM usuarios u LEFT JOIN alumnos a ON u.alumno_id = a.id WHERE u.username = ?
}

public interface AlumnoDAO {
    // SQL: INSERT INTO alumnos (nombre, email) VALUES (?, ?)
    int insertar(Alumno a) throws SQLException; // Debe retornar el ID generado
    
    // SQL: UPDATE alumnos SET nombre = ?, email = ? WHERE id = ?
    void actualizar(Alumno a) throws SQLException;
    
    // SQL: DELETE FROM alumnos WHERE id = ?
    void eliminar(int id) throws SQLException;
    
    // SQL: SELECT id, nombre, email FROM alumnos
    List<Alumno> listarTodos() throws SQLException;
}

public interface ProfesorDAO {
    // SQL: INSERT INTO profesores (nombre, email) VALUES (?, ?)
    int insertar(Profesor p) throws SQLException; // Debe retornar el ID generado
    
    // SQL: UPDATE profesores SET nombre = ?, email = ? WHERE id = ?
    void actualizar(Profesor p) throws SQLException;
    
    // SQL: DELETE FROM profesores WHERE id = ?
    void eliminar(int id) throws SQLException;
    
    // SQL: SELECT id, nombre, email FROM profesores
    List<Profesor> listarTodos() throws SQLException;
}

public interface MatriculaDAO {
    // SQL: INSERT INTO matriculas (alumno_id, curso_id, fecha_matricula) VALUES (?, ?, ?)
    void matricular(int aluId, int curId) throws SQLException; // Transaccional
    
    // SQL: SELECT m.id, a.nombre AS alumno, c.titulo AS curso, m.fecha_matricula FROM matriculas m JOIN alumnos a ON m.alumno_id = a.id JOIN cursos c ON m.curso_id = c.id
    List<MatriculaDTO> listarMatriculasDetalladas() throws SQLException; // SQL JOIN
}
```

---

## 🟢 5. Criterios de Evaluación y Calidad

1.  **MVC Real:** Las vistas (`view`) no contienen lógica SQL. Todas las peticiones pasan por los `DAO`.
2.  **Seguridad:** Uso estricto de `PreparedStatement` para prevenir Inyección SQL.
3.  **Integridad de Datos:** Uso de `setAutoCommit(false)`, `commit()` y `rollback()` en el proceso de matriculación.
4.  **Feedback:** Uso de `JOptionPane` para errores y avisos críticos; uso de la consola de la `Principal` para mensajes de estado.
5.  **Código Limpio:** Implementación de `try-with-resources` para el cierre automático de conexiones y flujos.
```