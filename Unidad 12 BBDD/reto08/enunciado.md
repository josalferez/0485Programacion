# 🏋️ Ejercicio: Gestión de Gimnasio (CRUD Multi-Model)

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que realice un CRUD completo sobre **dos tablas** (Socios y Clases), aplicando el patrón de diseño **DAO**. Este reto está diseñado para ser completado en **90 minutos**.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `gimnasio_db`:

| Tabla      | Campos                                                   |
|------------|----------------------------------------------------------|
| **socios** | `id` (PK, AI), `nombre` (VARCHAR), `dni` (VARCHAR UNIQUE), `fecha_alta` (DATE) |
| **clases** | `id` (PK, AI), `nombre` (VARCHAR), `monitor` (VARCHAR), `cupo` (INT) |

**Script SQL:**

```sql
CREATE DATABASE IF NOT EXISTS gimnasio_db;
USE gimnasio_db;

CREATE TABLE socios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    fecha_alta DATE NOT NULL
);

CREATE TABLE clases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    monitor VARCHAR(100),
    cupo INT DEFAULT 20
);
```

### 2. Estructura del Proyecto

```
src/
├── model/           ← Socio.java, Clase.java
├── dao/             ← SocioDAO.java, ClaseDAO.java y sus Impls
├── db/              ← ConexionDB.java
└── Main.java        ← Menú interactivo
```

---

## 📋 Menú de la Aplicación

| Opción | Acción                    |
|--------|---------------------------|
| 1      | 👤 Gestión de Socios       |
| 2      | 📅 Gestión de Clases       |
| 0      | 🚪 Salir                  |

---

## 💾 Anexo: Consultas SQL

- **Socio:** `INSERT INTO socios (nombre, dni, fecha_alta) VALUES (?, ?, ?)`
- **Clase:** `INSERT INTO clases (nombre, monitor, cupo) VALUES (?, ?, ?)`
