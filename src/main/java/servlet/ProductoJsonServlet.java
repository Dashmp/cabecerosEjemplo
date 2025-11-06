package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Producto;
import service.ProductoService;
import service.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// Servlet accesible desde la ruta /productojson
@WebServlet("/productojson")
public class ProductoJsonServlet extends HttpServlet {

    // Método que responde a las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Se obtiene la lista de productos desde el servicio
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();

        // Se define el tipo de contenido de la respuesta como JSON con codificación UTF-8
        resp.setContentType("application/json;charset=UTF-8");

        // Construcción  del JSON
        StringBuilder json = new StringBuilder();
        json.append("[");

        // Se recorre la lista de productos y se genera cada objeto JSON
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            json.append("{")
                    .append("\"id\":").append(p.getId()).append(",")
                    .append("\"nombre\":\"").append(escapeJson(p.getNombre())).append("\",")
                    .append("\"tipo\":\"").append(escapeJson(p.getTipo())).append("\",")
                    .append("\"precio\":").append(p.getPrecio())
                    .append("}");
            // Se agrega una coma si no es el último elemento
            if (i < productos.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        // Se envía el JSON al cliente
        try (PrintWriter out = resp.getWriter()) {
            out.print(json.toString());
        }
    }

    // Método auxiliar para escapar caracteres especiales en cadenas JSON
    private String escapeJson(String value) {
        if (value == null) return "";
        // Reemplaza comillas dobles por su secuencia escapada
        return value.replace("\"", "\\\"");
    }
}
