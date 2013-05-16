<%-- 
    Document   : Login
    Created on : 21-abr-2013, 14:51:41
    Author     : Clark
--%>
<%@page import="Datos.Admin"%>
<%@page import="Conexion.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

       
        <%List errorMsgs = new LinkedList();
            int duracion = 0;
            // Recuperar parámetros del formulario
            String user = request.getParameter("user");
            String password = request.getParameter("pass");



            if ((user == null) || (user.trim().length() == 0)) {
                user = request.getParameter("genero");
            }

            // Verificación del formulario
            if (password == null || password.trim().length() == 0) {
                errorMsgs.add("Por favor ingrese la contraseña.");
            }


            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                
               

                // lógica de negocios
                Admin a = new Admin(user, password);

                // Guarda el item en la solicitud de alcance
                request.setAttribute("User", a);
                // Envía la vista al Servlet Suceso
                RequestDispatcher view = request.getRequestDispatcher("intranet.jsp");
                view.forward(request, response);
            }
        %>
    </body>
</html>
