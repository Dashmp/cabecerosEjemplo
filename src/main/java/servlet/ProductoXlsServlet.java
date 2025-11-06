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

// Configuración del servlet para responder en dos rutas: productos.xls y productos.html
@WebServlet({"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Se instancia el servicio de productos para obtener la lista
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();

        // Se obtiene la ruta del servlet actual para identificar el formato de salida
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls"); // Si termina en .xls, se exportará como Excel

        // Configuración de encabezados según el formato solicitado
        if (esXls) {
            // Tipo MIME para archivos de Excel
            resp.setContentType("application/vnd.ms-excel");
            // Forzar descarga con nombre del archivo
            resp.setHeader("Content-Disposition", "attachment; filename=Productos.xls");
        } else {
            // Tipo MIME para HTML con codificación UTF-8
            resp.setContentType("text/html;charset=UTF-8");
        }

        // Se obtiene el flujo de salida para escribir la respuesta
        try (PrintWriter out = resp.getWriter()) {
            if (!esXls) {
                // ---------- HTML Y ESTILO ----------
                out.println("<!DOCTYPE html>");
                out.println("<html lang='es'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<title>Listado de Productos</title>");
                out.println("<style>");
                out.println("body {font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;background-color:#0f172a;color:#e2e8f0;margin:0;padding:0;display:flex;flex-direction:column;align-items:center;min-height:100vh;}");
                out.println("h1 {background-color:#1e3a8a;width:100%;text-align:center;padding:1.2rem 0;margin:0 0 2rem 0;color:#fff;box-shadow:0 2px 10px rgba(0,0,0,0.4);}");
                out.println("table {border-collapse:collapse;width:80%;max-width:900px;background-color:#1e293b;border-radius:12px;overflow:hidden;box-shadow:0 4px 20px rgba(0,0,0,0.3);}");
                out.println("th, td {padding:0.8rem 1rem;text-align:left;border-bottom:1px solid #334155;}");
                out.println("th {background-color:#2563eb;color:#fff;text-transform:uppercase;}");
                out.println("tr:hover {background-color:#334155;transition:background-color 0.3s ease;}");
                out.println(".btn-container {display:flex;gap:1rem;margin:2rem 0;}");
                out.println("a.btn {display:inline-block;padding:0.8rem 1.5rem;background-color:#2563eb;color:#fff;text-decoration:none;border-radius:8px;font-weight:600;box-shadow:0 4px 10px rgba(0,0,0,0.3);transition:background-color 0.3s ease,transform 0.2s ease,box-shadow 0.3s ease;}");
                out.println("a.btn:hover {background-color:#1d4ed8;transform:translateY(-2px);box-shadow:0 6px 16px rgba(0,0,0,0.4);}");
                out.println("a.btn:active {transform:translateY(0);box-shadow:0 3px 8px rgba(0,0,0,0.3);}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado de Productos</h1>");

                // ---------- BOTONES DE ACCIÓN ----------
                out.println("<div class='btn-container'>");
                // Botón para descargar archivo Excel
                out.println("<a href='" + req.getContextPath() + "/productos.xls' class='btn'>Descargar Excel</a>");
                // Botón para ver los datos en formato JSON
                out.println("<a href='" + req.getContextPath() + "/productojson' class='btn'>Ver JSON</a>");
                // Botón para volver al inicio
                out.println("<a href='" + req.getContextPath() + "/index.html' class='btn'>Volver al Inicio</a>");
                out.println("</div>");
            }

            // ---------- TABLA DE PRODUCTOS ----------
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Precio</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            // Se recorre la lista de productos y se imprimen las filas dinámicamente
            for (Producto p : productos) {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                // Se formatea el precio a dos decimales
                out.println("<td>$" + String.format("%.2f", p.getPrecio()) + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            // Cierre del documento HTML si no es formato Excel
            if (!esXls) {
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
