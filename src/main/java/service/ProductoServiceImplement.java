package service;

import models.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Implementación concreta de la interfaz ProductoService
// Esta clase define la lógica para obtener la lista de productos
public class ProductoServiceImplement implements ProductoService {

    // Sobrescribe el método listar declarado en la interfaz ProductoService
    @Override
    public List<Producto> listar() {
        // Devuelve una lista inmutable (creada con Arrays.asList) con varios objetos Producto predefinidos.
        return Arrays.asList(
                new Producto(1L, "laptop", "computacion", 523.21),
                new Producto(2L, "Mouse", "inalambrico", 15.25),
                new Producto(3L, "Impresora", "tinta continua", 256.25),
                new Producto(4L, "Tablet", "Tecnologia", 150.99),
                new Producto(5L, "Teclado", "inalambrico", 15.25),
                new Producto(6L, "Celular", "Tecnologia", 350.99)
        );
    }
}
