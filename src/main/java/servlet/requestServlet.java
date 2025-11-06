package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceros-request")
public class requestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI().toString();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getRemoteAddr();
        int port = req.getServerPort();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Manejo de cabeceros 2025-2026</title>");
            out.println("<style>");
            out.println("body {");
            out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("  background-color: #0f172a;");
            out.println("  color: #e2e8f0;");
            out.println("  margin: 0;");
            out.println("  padding: 0;");
            out.println("  display: flex;");
            out.println("  flex-direction: column;");
            out.println("  align-items: center;");
            out.println("  min-height: 100vh;");
            out.println("}");
            out.println("h1 {");
            out.println("  background-color: #1e3a8a;");
            out.println("  width: 100%;");
            out.println("  text-align: center;");
            out.println("  padding: 1.2rem 0;");
            out.println("  margin: 0 0 2rem 0;");
            out.println("  color: #fff;");
            out.println("  box-shadow: 0 2px 10px rgba(0,0,0,0.4);");
            out.println("}");
            out.println("ul {");
            out.println("  list-style: none;");
            out.println("  padding: 0;");
            out.println("  width: 80%;");
            out.println("  max-width: 800px;");
            out.println("  background-color: #1e293b;");
            out.println("  border-radius: 12px;");
            out.println("  box-shadow: 0 4px 20px rgba(0,0,0,0.3);");
            out.println("  overflow: hidden;");
            out.println("}");
            out.println("li {");
            out.println("  padding: 0.8rem 1rem;");
            out.println("  border-bottom: 1px solid #334155;");
            out.println("  font-family: 'Courier New', monospace;");
            out.println("}");
            out.println("li:last-child { border-bottom: none; }");
            out.println("li:hover {");
            out.println("  background-color: #334155;");
            out.println("  transition: background-color 0.3s ease;");
            out.println("}");
            out.println(".container {");
            out.println("  display: flex;");
            out.println("  justify-content: center;");
            out.println("  align-items: center;");
            out.println("  margin-top: 2rem;");
            out.println("}");
            out.println("a.btn {");
            out.println("  display: inline-block;");
            out.println("  padding: 0.8rem 1.5rem;");
            out.println("  margin-bottom: 3rem;");
            out.println("  background-color: #2563eb;");
            out.println("  color: #fff;");
            out.println("  text-decoration: none;");
            out.println("  border-radius: 8px;");
            out.println("  font-weight: 600;");
            out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);");
            out.println("  transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;");
            out.println("}");
            out.println("a.btn:hover {");
            out.println("  background-color: #1d4ed8;");
            out.println("  transform: translateY(-2px);");
            out.println("  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.4);");
            out.println("}");
            out.println("a.btn:active {");
            out.println("  transform: translateY(0);");
            out.println("  box-shadow: 0 3px 8px rgba(0, 0, 0, 0.3);");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de Cabeceros - 2025 / 2026</h1>");
            out.println("<ul>");
            out.println("<li><strong>Método de petición:</strong> " + metodoHttp + "</li>");
            out.println("<li><strong>URI:</strong> " + requestURI + "</li>");
            out.println("<li><strong>URL:</strong> " + requestURL + "</li>");
            out.println("<li><strong>Contexto:</strong> " + contextPath + "</li>");
            out.println("<li><strong>Servlet:</strong> " + servletPath + "</li>");
            out.println("<li><strong>IP:</strong> " + ip + "</li>");
            out.println("<li><strong>Puerto:</strong> " + port + "</li>");
            out.println("<li><hr style='border: none; border-top: 2px solid #475569; margin: 1rem 0;'></li>");
            out.println("<li><strong>Cabeceras del Request:</strong></li>");

            Enumeration<String> headersNames = req.getHeaderNames();
            while (headersNames.hasMoreElements()) {
                String cabecera = headersNames.nextElement();
                out.println("<li><strong>" + cabecera + ":</strong> " + req.getHeader(cabecera) + "</li>");
            }

            out.println("</ul>");
            out.println("<div class='container'>");
            out.println("<a href='" + contextPath + "/index.html' class='btn' >Volver al inicio</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
