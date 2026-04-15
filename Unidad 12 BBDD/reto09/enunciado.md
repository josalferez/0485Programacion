# 🎓 Ejercicio: Centro Educativo (CRUD Multi-Model)

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que realice un CRUD completo sobre **tres tablas** (Estudiantes, Profesores y Asignaturas), aplicando el patrón de diseño **DAO**. Este reto está diseñado para ser completado en **120 minutos**.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `escuela_db`:

| Tabla           | Campos                                               |
|-----------------|------------------------------------------------------|
| **estudiantes** | `id` (PK, AI), `nombre` (VARCHAR), `email` (VARCHAR UNIQUE) |
| **profesores**  | `id` (PK, AI), `nombre` (VARCHAR), `especialidad` (VARCHAR) |
| **asignaturas** | `id` (PK, AI), `nombre` (VARCHAR), `creditos` (INT)   |

**Script SQL:**

```sql
CREATE DATABASE IF NOT EXISTS escuela_db;
USE escuela_db;

CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE profesores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100)
);

CREATE TABLE asignaturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    creditos INT DEFAULT 6
);
```

### 2. Estructura del Proyecto

```
src/
├── model/           ← Estudiante.java, Profesor.java, Asignatura.java
├── dao/             ← EstudianteDAO, ProfesorDAO, AsignaturaDAO (y sus Impls)
├── db/              ← ConexionDB.java
└── Main.java        ← Menú interactivo
```

---

## 📋 Menú de la Aplicación

| Opción | Acción                      |
|--------|-----------------------------|
| 1      | 🧑‍🎓 Gestión de Estudiantes   |
| 2      | 👨‍🏫 Gestión de Profesores     |
| 3      | 📚 Gestión de Asignaturas   |
| 0      | 🚪 Salir                    |

---

## 💾 Anexo: Consultas SQL

- **Estudiante:** `INSERT INTO estudiantes (nombre, email) VALUES (?, ?)`
- **Profesor:** `INSERT INTO profesores (nombre, especialidad) VALUES (?, ?)`
- **Asignatura:** `INSERT INTO asignaturas (nombre, creditos) VALUES (?, ?)`
