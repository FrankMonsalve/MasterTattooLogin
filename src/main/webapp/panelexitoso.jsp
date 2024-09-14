<%-- 
    Document   : panelexitoso
    Created on : 30/08/2024, 6:52:38 a. m.
    Author     : Franko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>Panel de Usuario</title>
</head>
<body>
    <%
    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.html");
        return;
    }
    %>
    <header>
        <h1>Bienvenido, <%= session.getAttribute("username") %>!</h1>
        <nav>
            <ul>
                <li><a href="index.html">Inicio</a></li>
                <li><a href="profile.html">Perfil</a></li>
                <li><a href="logout.jsp">Cerrar sesión</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="panel-container">
        <h2>Panel de Control</h2>
        <p>¡Estás en el panel de usuario!</p>
        <!-- Aquí puedes añadir más contenido y funcionalidades para el panel -->
    </div>

    <footer class="footer">
        <p>Aprendiz Frank Monsalve <br>
           Servicio Nacional de Aprendizaje - SENA<br>
           Derechos reservados &copy; 2024</p>
    </footer>
</body>
</html>

