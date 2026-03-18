package src.dao;

import java.util.List;
import java.util.Optional;
import src.model.*;

/**
 * Interfaz que define las operaciones de persistencia para la entidad Producto.
 */
public interface ProductoDAO {

    /**
     * Recupera todos los productos de la base de datos.
     * @return Lista de productos.
     */
    List<Producto> findAll();

    /**
     * Busca un producto por su identificador único.
     * @param id Identificador del producto.
     * @return Un Optional que contiene el producto si se encuentra, o vacío si no.
     */
    Optional<Producto> findById(int id);

    /**
     * Inserta un nuevo producto en la base de datos.
     * @param p Objeto producto con los datos a insertar.
     */
    void save(Producto p);

    /**
     * Actualiza un producto existente en la base de datos.
     * @param p Objeto producto con los datos actualizados (debe tener un ID válido).
     */
    void update(Producto p);

    /**
     * Elimina un producto de la base de datos.
     * @param id Identificador del producto a borrar.
     */
    void delete(int id);

    /**
     * Filtra y devuelve productos que pertenecen a una categoría específica.
     * @param categoria Nombre de la categoría.
     * @return Lista de productos filtrados.
     */
    List<Producto> findByCategoria(String categoria);
}