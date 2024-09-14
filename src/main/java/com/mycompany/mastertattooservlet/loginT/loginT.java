package com.mycompany.mastertattooservlet.loginT;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "loginT", urlPatterns = {"/loginTattoo"})
public class loginT extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginT.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mastertattoo";
        
        try (Connection cnx = DriverManager.getConnection(url, "root", "1090482620");
             PreparedStatement ps = cnx.prepareStatement("SELECT * FROM usuarioartista WHERE username = ? AND password = ?")) {

            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Usuario y contraseña correctos
                request.getSession().setAttribute("username", userName);
                response.sendRedirect("panelexitoso.jsp");
            } else {
                // Usuario o contraseña incorrectos
                response.sendRedirect("index.html");
            }

        } catch (SQLException ex) {
            Logger.getLogger(loginT.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().println("Error al conectar con la base de datos.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

