# 🏪 Ejercicio: Gestión de Tienda (CRUD Multi-Model)

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que realice un CRUD completo sobre **dos tablas** relacionadas indirectamente (Productos y Clientes), aplicando el patrón de diseño **DAO (Data Access Object)** de forma escalable. Este reto está diseñado para ser completado en **90 minutos**.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `tienda_db` con las siguientes tablas:

| Tabla         | Campos                                                                 |
|---------------|------------------------------------------------------------------------|
| **productos** | `id` (PK, AI), `nombre` (VARCHAR), `precio` (DECIMAL), `stock` (INT)   |
| **clientes**  | `id` (PK, AI), `nombre` (VARCHAR), `email` (VARCHAR), `telefono` (VARCHAR) |

**Script SQL de creación:**

```sql
CREATE DATABASE IF NOT EXISTS tienda_db;
USE tienda_db;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT DEFAULT 0
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(20)
);
```

### 2. Estructura del Proyecto

```
src/
├── model/           ← Producto.java, Cliente.java
├── dao/             ← ProductoDAO.java, ClienteDAO.java y sus Implementaciones (Impl)
├── db/              ← ConexionDB.java
└── Main.java        ← Menú interactivo con submenús
```

---

## 📋 Funcionalidades Requeridas

Debes implementar el mantenimiento completo para ambas entidades:

### Gestión de Productos
1. **Listar**: Ver catálogo completo.
2. **Añadir**: Registrar nuevo producto.
3. **Actualizar**: Editar precio y stock.
4. **Eliminar**: Retirar producto por ID.

### Gestión de Clientes
1. **Listar**: Ver base de datos de clientes.
2. **Añadir**: Registrar nuevo cliente (email único).
3. **Buscar**: Localizar cliente por su ID.
4. **Eliminar**: Dar de baja a un cliente.

---

## 📑 Interfaces DAO

Debes aplicar interfaces separadas para mantener el código organizado:
No te doy la interfaz de Producto porque debes pensar tú su CRUD e implementarlo

```java
// Ejemplo para Clientes
public interface ClienteDAO {
    void crear(Cliente cliente) throws SQLException;
    List<Cliente> obtenerTodos() throws SQLException;
    Cliente obtenerPorId(int id) throws SQLException;
    void actualizar(Cliente cliente) throws SQLException;
    void eliminar(int id) throws SQLException;
}
```

---

## 📋 Menú de la Aplicación

Se sugiere un menú principal que derive a submenús de gestión:

| Opción | Acción                    |
|--------|---------------------------|
| 1      | 📦 Gestión de Productos    |
| 2      | 👤 Gestión de Clientes     |
| 0      | 🚪 Salir                  |

---

## 🟢 Criterios de Evaluación

- ✅ **Escalabilidad:** El código está organizado para soportar múltiples DAOs sin conflictos.
- ✅ **Integridad:** Se manejan correctamente los campos `UNIQUE` (como el email del cliente).
- ✅ **Interactividad:** El menú permite navegar entre las dos áreas de gestión de forma fluida.
- ✅ **Seguridad:** Uso estricto de `PreparedStatement`.

---

## 💾 Anexo: Consultas SQL

- **Producto:** `INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)`
- **Cliente:** `INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)`
