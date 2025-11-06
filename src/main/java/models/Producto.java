package models;

// Clase que representa un producto dentro del sistema
public class Producto {

    // Atributo identificador único del producto
    private Long id;
    private String nombre;
    private String tipo;
    private double precio;

    // Constructor vacío necesario para frameworks o instanciación manual sin parámetros
    public Producto() {
    }

    // Constructor con todos los parámetros para inicializar el objeto Producto
    public Producto(Long id, String nombre, String tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // ---------- Métodos Getters y Setters ----------
    // Retorna el id del producto
    public Long getId() {
        return id;
    }

    // Asigna un valor al id del producto
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Asigna un nombre al producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Retorna el tipo del producto
    public String getTipo() {
        return tipo;
    }

    // Asigna un tipo al producto
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Retorna el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Asigna un precio al producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
