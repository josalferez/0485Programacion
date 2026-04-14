# 📦 Ejercicio: Gestión de Inventario (CRUD Single-Model)

> **🎯 Objetivo:** Desarrollar una aplicación de consola en Java que realice un CRUD completo sobre una única tabla de productos, aplicando el patrón de diseño **DAO (Data Access Object)**. Este reto está diseñado para ser completado en **60 minutos**.

---

## ⚙️ Requisitos Técnicos

### 1. Base de Datos

La base de datos debe llamarse `almacen_db` con una única tabla:

| Tabla         | Campos                                                                 |
|---------------|------------------------------------------------------------------------|
| **productos** | `id` (PK, AI), `nombre` (VARCHAR), `cantidad` (INT), `precio` (DECIMAL) |

**Script SQL de creación:**

```sql
CREATE DATABASE IF NOT EXISTS almacen_db;
USE almacen_db;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT DEFAULT 0,
    precio DECIMAL(10, 2) NOT NULL
);
```

### 2. Estructura del Proyecto

```
src/
├── model/           ← Producto.java
├── dao/             ← ProductoDAO.java (Interfaz) y ProductoDAOImpl.java
├── db/              ← ConexionDB.java
└── Main.java        ← Menú interactivo
```

---

## 📋 Funcionalidades Requeridas

Implementar las siguientes operaciones para la entidad **Producto**:
1. **Insertar**: Añadir un nuevo producto al inventario.
2. **Listar**: Mostrar todos los productos registrados.
3. **Buscar**: Localizar un producto específico por su ID.
4. **Actualizar**: Modificar el nombre, cantidad o precio de un producto existente.
5. **Eliminar**: Borrar un producto de la base de datos por su ID.

---

## 📑 Interfaz DAO

Debes implementar la siguiente interfaz:

```java
public interface ProductoDAO {
    void crear(Producto producto) throws SQLException;
    List<Producto> obtenerTodos() throws SQLException;
    Producto obtenerPorId(int id) throws SQLException;
    void actualizar(Producto producto) throws SQLException;
    void eliminar(int id) throws SQLException;
}
```

---

## 📋 Menú de la Aplicación

El programa debe presentar el siguiente menú interactivo:

| Opción | Acción                | Descripción                                   |
|--------|-----------------------|-----------------------------------------------|
| 1      | Ver Inventario        | Lista todos los productos                     |
| 2      | Añadir Producto       | Solicita datos e inserta un nuevo producto    |
| 3      | Buscar por ID         | Muestra los detalles de un producto específico |
| 4      | Actualizar Producto   | Modifica los datos de un producto por su ID   |
| 5      | Eliminar Producto     | Borra un producto del sistema                 |
| 0      | Salir                 | Cierra la aplicación                          |

---

## 🟢 Criterios de Evaluación

- ✅ **Conectividad:** La aplicación se conecta correctamente a MySQL.
- ✅ **Patrón DAO:** Existe una separación clara entre la lógica de negocio y el acceso a datos.
- ✅ **Tratamiento de Errores:** Se gestionan las excepciones `SQLException`.
- ✅ **Limpieza:** Uso de `PreparedStatement` para evitar inyecciones SQL.

---

## 💾 Anexo: Consultas SQL Sugeridas

- **Insertar:** `INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)`
- **Listar:** `SELECT * FROM productos`
- **Buscar:** `SELECT * FROM productos WHERE id = ?`
- **Actualizar:** `UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE id = ?`
- **Eliminar:** `DELETE FROM productos WHERE id = ?`
