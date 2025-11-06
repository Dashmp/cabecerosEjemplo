package service;

import models.Producto;
import java.util.List;

// Interfaz que define el contrato del servicio de productos
// Establece las operaciones que cualquier implementación deberá proveer
public interface ProductoService {

    // Método que debe devolver una lista de productos
    // Representa la acción de obtener todos los productos disponibles
    List<Producto> listar();
}
