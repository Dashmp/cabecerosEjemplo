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
            //generar plantilla
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Manejo de cabeceros 2025-2026</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de cabeceros</h1>");
            out.println("<ul>");
            out.println("<li>Obteniendo el método de petición: " + metodoHttp + "</li>");
            out.println("<li>Obtniendo la URI: " + requestURI + "</li>");
            out.println("<li>Obteniendo la URL: " + requestURL + "</li>");
            out.println("<li>Obteniendo el contexto: " + contextPath + "</li>");
            out.println("<li>Obteniendo el servlet; "+ servletPath + "</li>");
            out.println("<li>Obteniendo la ip: " + ip + "</li>");
            out.println("<li>Obteniendo el port: " + port + "</li>");
            Enumeration<String> headersNames = req.getHeaderNames();
            while(headersNames.hasMoreElements()) {
                String cabecera = headersNames.nextElement();
                out.println("<li>" + cabecera + " : " + req.getHeader(cabecera) + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }

    }
}
