package src.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import src.model.PrestamoDTO;

public interface PrestamoDAO {
    // Método principal para registrar un préstamo (Debe usarse con transacciones en la implementación)
    void registrarPrestamo(int socioId, int libroId, LocalDate fecha) throws SQLException;

    // Método para el listado con JOIN (usando un DTO o String para la consola)
    // El objetivo es mostrar: Nombre Socio - Título Libro - Fecha
    List<PrestamoDTO> listarPrestamosDetallados() throws SQLException;

    void cancelarPrestamo(int id) throws SQLException;
}