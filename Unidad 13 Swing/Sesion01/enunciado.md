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

-- Datos iniciales
INSERT INTO usuarios (username, password, email, nombre, apellidos, dni, rol) 
VALUES ('admin', '1234', 'admin@universidad.com', 'Admin', 'Sistema', '00000000T', 'profesor');
INSERT INTO profesores (usuario_id, departamento, especialidad) VALUES (1, 'Administración', 'Gestión');
```

---

## 🖥️ 3. Especificaciones de la Interfaz Gráfica (Swing)

### A. Ventana de Acceso (`Login.java`)
- **Componentes:** Campos para usuario, contraseña (`JPasswordField`), botón de acceso y registro.
- **Lógica:** Valida credenciales en la tabla `usuarios`. El sistema debe identificar el rol y cargar el perfil completo realizando el JOIN correspondiente.

### B. Ventana de Registro (`Registro.java`)
- **Componentes:** Formulario con Nombre, Apellidos, DNI, Email, Contraseña y Selector de Rol.
- **Campos Dinámicos:** Al seleccionar el rol, la interfaz debe mostrar campos específicos (Beca/Promoción para alumnos; Departamento/Especialidad para profesores).
- **Lógica de Transacción:** El proceso de registro debe ser atómico:
    1. Insertar en `usuarios` y obtener el ID generado.
    2. Insertar en la tabla especializada (`alumnos` o `profesores`) usando dicho ID.

### C. Ventana Principal de Gestión (`Principal.java`)
Es el panel de control del centro educativo. Debe incluir:
1.  **Barra de Menús (`JMenuBar`):** Gestión de sesión y preferencias.
2.  **Navegación Lateral:** Alternar entre "Gestión Alumnos", "Gestión Cursos" y "Nueva Matrícula".
3.  **Área Central:** `JTable` dinámico con los datos.
4.  **Panel de Operaciones:** Formulario dinámico para CRUD que respete la estructura de herencia (actualiza ambas tablas).

---

## 📑 4. Contratos de Persistencia (Capa DAO)

Las interfaces deben reflejar el modelo de herencia:

```java
public interface UsuarioDAO {
    // Valida credenciales y retorna true si existe
    boolean validar(String user, String pass) throws SQLException;
    
    // Inserta datos base y retorna el ID generado
    int registrar(Usuario usuario) throws SQLException;
}

public interface AlumnoDAO {
    // Inserta en la tabla alumnos vinculando al usuario_id
    int insertar(Alumno a) throws SQLException;
    
    // Actualiza tanto campos base (usuarios) como especializados (alumnos)
    void actualizar(Alumno a) throws SQLException;
    
    // Consulta con JOIN para obtener objeto Alumno completo
    List<Alumno> listarTodos() throws SQLException;
}

// Interfaz ProfesorDAO sigue un patrón idéntico a AlumnoDAO
```

---

## 🟢 5. Criterios de Evaluación y Calidad

1.  **Modelo de Herencia:** Implementación correcta de `Joined Table inheritance` tanto en DB como en POJOs (`extends`).
2.  **Integridad:** Uso de claves foráneas y `ON DELETE CASCADE`.
3.  **Transaccionalidad:** Los procesos que involucren múltiples tablas (como el Registro o la Matrícula) deben usar transacciones manuales.
4.  **Desacoplamiento:** Las vistas no conocen la estructura de las tablas; toda comunicación es vía objetos de dominio a través de los DAO.
5.  **Código Limpio:** Uso de `try-with-resources` y nombres de variables descriptivos en español/inglés coherente.