# Aplicación de Escritorio Java: JDBC + DAO + Swing
**Módulo: Programación · Proyecto Final**

Desarrolla una solución de gestión con arquitectura MVC, persistencia con patrón DAO y una interfaz gráfica Swing profesional sobre el dominio que elijas.

---

## 🎯 Objetivo
Desarrollar una solución integral de escritorio aplicando arquitectura **MVC**, asegurando que la interfaz gráfica Swing esté totalmente desacoplada de la lógica de persistencia mediante el patrón **DAO**. El dominio del sistema es de **libre elección** (clínica, biblioteca, hotel, taller, tienda…), siempre que cumpla los requisitos técnicos del enunciado.

### Ejemplos de dominios sugeridos:
1.  **🏥 Clínica Veterinaria**: Gestión de mascotas, propietarios, veterinarios y citas médicas. Incluye historial de visitas.
2.  **📚 Biblioteca Municipal**: Gestión de libros, socios, préstamos y reservas. Alertas de retraso.
3.  **🏋️ Gimnasio**: Gestión de clientes, entrenadores, clases y suscripciones.
4.  **🍕 Restaurante / Delivery**: Gestión de la carta, pedidos, clientes y repartidores.
5.  **🏨 Hotel**: Gestión de habitaciones, huéspedes y reservas.
6.  **🚗 Taller Mecánico**: Gestión de vehículos, clientes, mecánicos y órdenes de reparación.
7.  **🎬 Videoclub / Alquiler**: Gestión de películas, series, clientes y alquileres.
8.  **🏪 Tienda / Inventario**: Gestión de productos, proveedores, empleados y ventas. Alerta de stock mínimo.
9.  **🌤️ Agencia de Viajes**: Gestión de destinos, clientes, agentes y reservas.
10. **⚽ Club Deportivo**: Gestión de jugadores, equipos, entrenadores y partidos.
11. **☕ Cafetería IES Francisco Ayala**: Gestionar los pedidos, productos, usuarios y tickets.
12. **🛠️ Gestor de incidencias (Tickets)**: Gestionar las incidencias en equipos o instalaciones del centro.
13. **💡 Problema del día a día**: Libre elección para gestionar algún otro problema cotidiano.

---

## 1. Organización del Proyecto (Estructura de Paquetes)
Es obligatorio respetar la siguiente estructura:

*   **src/**
    *   **db/**: `ConexionDB.java` (gestión de Connection y transacciones).
    *   **model/**: Entidades del dominio (mínimo 3 clases POJO).
    *   **dao/**: Interfaces + Implementaciones (un DAO por entidad).
    *   **dto/**: Objetos de transferencia para consultas con JOIN.
    *   **view/**: `Login.java`, `Registro.java`, `Principal.java`.
    *   **Main.java**: Lanzador de la aplicación.

---

## 2. Diseño de la Base de Datos
El modelo relacional debe incluir:
*   **Tabla base de usuarios**: username, password, email, nombre, apellidos, DNI y rol.
*   **Joined Table Inheritance**: Al menos dos tablas hijas que amplían la tabla base.
*   **Tabla entidad principal**: Cursos, productos, habitaciones...
*   **Tabla de relación N:M**: Matrículas, reservas, pedidos... con fecha y campos extra.
*   **Claves foráneas + ON DELETE CASCADE**: En todas las relaciones dependientes.

---

## 3. Especificaciones de la Interfaz Gráfica (Swing)

### A — Ventana de Login
*   **Componentes**: Campo username, JPasswordField, botón Entrar y enlace a Registro.
*   **Lógica**: Valida credenciales; mensaje de error si son incorrectas.

### B — Ventana de Registro
*   **Formulario dinámico**: Muestra u oculta campos según el rol seleccionado.
*   **Transacción atómica**: Inserta en usuarios + tabla hija en una sola transacción con rollback en caso de error.

### C — Ventana Principal (Dashboard)
*   **JMenuBar**: Opciones de sesión y preferencias de tema.
*   **Panel lateral de navegación**: Mínimo 3 módulos de gestión.
*   **JTable central**: Muestra registros del módulo activo (resuelve relaciones con JOIN).
*   **Panel de operaciones adaptativo**: Formulario lateral con botones Nuevo / Guardar / Eliminar.
*   **Feedback visual**: JOptionPane de confirmación o error.

---

## 4. Capa de Persistencia — Patrón DAO
*   **UsuarioDAO**: `validar()`, `registrar()`, `listarTodos()`, `actualizar()`, `eliminar()`.
*   **DAO entidad principal**: `insertar()`, `actualizar()`, `listarTodos()`, `eliminar()`.
*   **DAO relación N:M**: `insertar()`, `listarTodos()` con JOIN, `eliminar()`.
*   **ConexionDB**: Singleton o método estático; credenciales desde `.env` o `.properties`.

### Buenas prácticas obligatorias:
*   **try-with-resources** en todos los bloques JDBC.
*   **PreparedStatement exclusivamente** (prohibido concatenar SQL).
*   **Gestión de transacciones manual** (setAutoCommit / commit / rollback).

---

## 5. Extensiones Opcionales (Hasta +2 puntos)
*   **API REST**: Meteorología, cambio de moneda, TMDB, Open Library...
*   **Integración con IA**: Asistente contextual o generación de informes.
*   **Exportación de datos**: JTable a CSV o PDF (iText / Apache PDFBox).
*   **Gráficas estadísticas**: Panel con JFreeChart.
*   **Cifrado de contraseñas**: Almacenamiento con BCrypt.
*   **Modo oscuro/claro**: Cambio de Look & Feel en tiempo de ejecución.
*   **Otras**: Notificaciones Telegram, lectores QR, etc.

---

## 6. Justificación del Trabajo — WakaTime
Es **obligatorio** utilizar WakaTime durante todo el desarrollo para garantizar la autoría.

1.  Crea cuenta en [wakatime.com](https://wakatime.com).
2.  Instala el plugin en tu IDE.
3.  Nombre del proyecto: `"ProyectoFinal-Programacion"`.
4.  Genera un **informe público** al finalizar.
5.  Debe acreditar un mínimo de **10 horas registradas**.

⚠️ **Sin el informe de WakaTime, la nota máxima será un 5.**

---

## 7. Condiciones de Entrega
*   **Formato**: Archivo `.zip` o `.rar` con el proyecto completo.
*   **Contenido**: `/src` + script SQL + `.env` de ejemplo.
*   **GitHub (OBLIGATORIO)**: Enlace al repositorio con commits continuos.
*   **Idioma**: Puede realizarse en inglés o español.

---

## 8. Defensa del Proyecto
*   **Duración**: 20 minutos (entre el 11 y el 22 de mayo).
*   **Idioma**: Inglés o español (se valora positivamente el inglés).
*   **Evaluación**: Determina el **apto / no apto** final.
*   **Uso de IA**: Permitido, pero **obligatorio entender cada línea**. Si no se comprende el código en la defensa, el proyecto estará suspenso.

---

## Rúbrica de Evaluación (10 puntos)

| Criterio | Excelente (100%) | Bien (70%) | Suficiente (40%) | Insuficiente (0%) | Pts |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Base de datos** | Herencia correcta, CASCADE, script funcional, datos prueba. | Estructura correcta, faltan CASCADE o datos prueba. | Sin herencia o FK mal definidas. | Script incompleto o erróneo. | 1.5 |
| **Capa DAO** | Interfaz+Impl, CRUD completo, PreparedStmt, try-with-resources. | Completo pero con fallos leves de seguridad o recursos. | DAOs parciales o mezcla de lógica. | Sin capa DAO. | 2 |
| **Transacciones** | Gestión manual correcta (commit/rollback) en multi-tabla. | Implementadas pero sin rollback en algún caso. | Solo autocommit por defecto. | Ausente o incorrecta. | 1 |
| **Login/Registro** | Funcional, campos dinámicos y transacción atómica. | Funcional pero sin dinamismo o sin rollback. | Solo Login funcional. | No funciona o ausente. | 1 |
| **Dashboard** | Adaptativo, navegación lateral, JTable con JOIN. | Funcional pero no adaptativo o faltan módulos. | JTable visible pero sin operaciones. | No funciona o ausente. | 2 |
| **Arquitectura MVC** | Vistas sin lógica SQL, comunicación vía DAO. | Separación mayoritaria, algún fallo puntual. | Separación parcial; mezcla notable. | Sin separación de capas. | 1 |
| **Calidad Código** | Nombres descriptivos, organizado, sin código muerto. | Legible, fallos menores de estructura o nombres. | Funcional pero difícil de leer. | Incomprensible. | 0.5 |
| **WakaTime** | Informe ≥10h, distribuido en sesiones. | Informe 7-9h o muy concentrado. | Menos de 7h o poco creíble. | Sin informe. | 1 |
| **Extensiones** | 1 o más funcionales y coherentes. | Parcialmente funcional o superficial. | Decorativa, sin valor real. | Sin extensiones. | +2* |

*\*Las extensiones solo computan si la nota base supera el 4.*

---
**Módulo: Programación · 2º DAM · Curso 2025-26**
