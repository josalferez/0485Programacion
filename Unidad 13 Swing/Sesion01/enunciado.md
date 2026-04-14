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

El sistema utiliza un modelo de herencia de tablas (**Joined Table Inheritance**) para gestionar los diferentes perfiles de usuario.

### Script SQL de creación:
```sql
CREATE DATABASE IF NOT EXISTS universidad_db;
USE universidad_db;

-- 1. Tabla base para todos los usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    rol ENUM('alumno', 'profesor') NOT NULL DEFAULT 'alumno'
);

-- 2. Tabla especializada para alumnos
CREATE TABLE alumnos (
    usuario_id INT PRIMARY KEY,
    beca VARCHAR(50) DEFAULT 'Ninguna',
    promocion VARCHAR(20),
    CONSTRAINT fk_alumno_usuario FOREIGN KEY (usuario_id) 
        REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 3. Tabla especializada para profesores
CREATE TABLE profesores (
    usuario_id INT PRIMARY KEY,
    departamento VARCHAR(100),
    especialidad VARCHAR(100),
    CONSTRAINT fk_profesor_usuario FOREIGN KEY (usuario_id) 
        REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 4. Tabla de cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    creditos INT NOT NULL
);

-- 5. Tabla de matrículas (Relación N:M)
CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_matricula DATE NOT NULL,
    CONSTRAINT fk_mat_alumno FOREIGN KEY (alumno_id) 
        REFERENCES alumnos(usuario_id) ON DELETE CASCADE,
    CONSTRAINT fk_mat_curso FOREIGN KEY (curso_id) 
        REFERENCES cursos(id) ON DELETE CASCADE
);
```

---

## 🖥️ 3. Especificaciones de la Interfaz Gráfica (Swing)

### A. Ventana de Acceso (`Login.java`)
- **Componentes:** Campos para usuario, contraseña (`JPasswordField`), botón de acceso y registro.
- **Lógica:** Valida credenciales en la tabla `usuarios`.

### B. Ventana de Registro (`Registro.java`)
- **Componentes:** Formulario con Nombre, Apellidos, DNI, Email, Contraseña y Selector de Rol.
- **Campos Dinámicos:** Muestra campos de Alumno/Profesor según selección.
- **Lógica de Transacción:** Registro atómico en dos tablas.

### C. Ventana Principal de Gestión (`Principal.java`)
Es el panel de control del centro educativo. Debe implementar una interfaz dinámica:
1.  **Barra de Menús (`JMenuBar`):** Gestión de sesión, cambio de color y logout.
2.  **Navegación Lateral:** Botones para "Gestión Alumnos", "Gestión Cursos", "Gestionar Matrículas" y "Gestión Usuarios".
3.  **Área Central:** `JTable` que muestra los datos del módulo activo (JOINs para matrículas, lista de usuarios, etc.).
4.  **Panel de Operaciones (Dashboard Inteligente):** 
    - Formulario lateral que adapta sus etiquetas y visibilidad automáticamente.
    - Para **Usuarios**: Debe mostrar 7 campos (Username, Email, DNI, Nombre, Apellidos, Password y Selector de Rol).
    - Para **Alumnos/Cursos**: Debe simplificarse ocultando los campos extra para mantener la ergonomía.

---

## 📑 4. Contratos de Persistencia (Capa DAO)

Las interfaces deben reflejar el modelo de herencia y el soporte para el dashboard:

```java
public interface UsuarioDAO {
    // Acceso y Registro
    boolean validar(String user, String pass) throws SQLException;
    int registrar(Usuario usuario) throws SQLException;
    
    // Gestión integral (Principal)
    List<Usuario> listarTodos() throws SQLException;
    void actualizar(Usuario usuario) throws SQLException;
    void eliminar(int id) throws SQLException;
}

public interface AlumnoDAO {
    int insertar(Alumno a) throws SQLException;
    void actualizar(Alumno a) throws SQLException;
    List<Alumno> listarTodos() throws SQLException;
    void eliminar(int id) throws SQLException;
}
```

---

## 🟢 5. Criterios de Evaluación y Calidad

1.  **Modelo de Herencia:** Implementación correcta de `Joined Table inheritance` (DB y POJOs).
2.  **Integridad:** Uso de claves foráneas y `ON DELETE CASCADE`.
3.  **Interfaz Dinámica:** El panel de operaciones debe "reaccionar" al módulo seleccionado cambiando labels y visibilidad de componentes.
4.  **Desacoplamiento:** Las vistas se comunican exclusivamente vía objetos de dominio a través de los DAO.
5.  **Código Limpio:** Uso de `try-with-resources` y nombres descriptivos.