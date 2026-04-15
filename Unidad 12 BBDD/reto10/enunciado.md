# 🔧 Ejercicio: Taller Mecánico (CRUD Multi-Model)

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que realice un CRUD completo sobre **tres tablas** (Vehículos, Mecánicos y Reparaciones), aplicando el patrón de diseño **DAO**. Este reto está diseñado para ser completado en **120 minutos**.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `taller_db`:

| Tabla            | Campos                                                   |
|------------------|----------------------------------------------------------|
| **vehiculos**    | `id` (PK, AI), `matricula` (VARCHAR UNIQUE), `marca` (VARCHAR), `modelo` (VARCHAR) |
| **mecanicos**    | `id` (PK, AI), `nombre` (VARCHAR), `especialidad` (VARCHAR) |
| **reparaciones** | `id` (PK, AI), `descripcion` (TEXT), `fecha` (DATE), `coste` (DECIMAL) |

**Script SQL:**

```sql
CREATE DATABASE IF NOT EXISTS taller_db;
USE taller_db;

CREATE TABLE vehiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL
);

CREATE TABLE mecanicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100)
);

CREATE TABLE reparaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    fecha DATE NOT NULL,
    coste DECIMAL(10, 2) DEFAULT 0.00
);
```

### 2. Estructura del Proyecto

```
src/
├── model/           ← Vehiculo.java, Mecanico.java, Reparacion.java
├── dao/             ← VehiculoDAO, MecanicoDAO, ReparacionDAO (y sus Impls)
├── db/              ← ConexionDB.java
└── Main.java        ← Menú interactivo
```

---

## 📋 Menú de la Aplicación

| Opción | Acción                      |
|--------|-----------------------------|
| 1      | 🚗 Gestión de Vehículos      |
| 2      | 👨‍🔧 Gestión de Mecánicos      |
| 3      | 🛠️ Gestión de Reparaciones   |
| 0      | 🚪 Salir                    |

---

## 💾 Anexo: Consultas SQL

- **Vehículo:** `INSERT INTO vehiculos (matricula, marca, modelo) VALUES (?, ?, ?)`
- **Mecánico:** `INSERT INTO mecanicos (nombre, especialidad) VALUES (?, ?)`
- **Reparación:** `INSERT INTO reparaciones (descripcion, fecha, coste) VALUES (?, ?, ?)`
