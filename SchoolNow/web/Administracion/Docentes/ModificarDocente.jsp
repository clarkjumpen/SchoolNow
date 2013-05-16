<%-- 
    Document   : ModificarDocente
    Created on : 27-04-2013, 04:29:50 PM
    Author     : usuario
--%>

<%@page import="Datos.Docente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String rutBuscar = request.getParameter("rutBuscar");
    String rut = request.getParameter("rut");
    String nombre = request.getParameter("nombres");
    String Fnac = request.getParameter("fechaNac");
    String Sexo = request.getParameter("sexo");
    String direccion = request.getParameter("direccion");
    String comuna = request.getParameter("comuna");
    String email = request.getParameter("email");
    String telefono = request.getParameter("telefono");
    //String pass = request.getParameter("rut");
    String esJefe = request.getParameter("esJefe");
    String cursoJefe = request.getParameter("cursoJefe");

    Docente docente = (Docente) request.getAttribute("docente");
    if (docente == null) {
        docente = new Docente();
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Docente</title>
    </head>
    <body>
        <h1>Modificar Docente</h1>
        <form action="BuscarDocente.do" method="post">
            <table border=1">
                <td>Busqueda
                <tr>
                    <td>Rut:<td> <input Type="text" name="rutBuscar" required
                        <% String value = "";
                            if (rutBuscar
                                    != null) {
                                value = rutBuscar;
                            }%> value="<%=value%>">
                <tr>
                    <td><input type="submit" value="Buscar">
            </table>
        </form>
        <br>

        <form action="ModificarDocente.do" method="post" >
            <table border=1">
                <td>Buscado:<td><input type="text"  name="Buscar" required
                                       <%value = "";
                            if (rutBuscar
                                    != null) {
                                value = rutBuscar;
                            }%> value="<%=value%>">
                <tr>
                <td>Rut:<td><input type="text" name="rut" required
                                   <%
                                       value = "";
                                       if (docente.getRut()
                                               != null) {
                                           value = docente.getRut();
                                       }%> value="<%=value%>">
                <tr>
                    <td>Nombre:<td><input type="text" name="nombres" required
                                          <%
                                              value = "";
                                              if (docente.getNombre()
                                                      != null) {
                                                  value = docente.getNombre();
                                              }%> value="<%=value%>">
                <tr>
                    <td>Fecha Nac:<td><input type="text" name="fechaNac" required
                                             <%
                                                 value = "";
                                                 if (docente.getFnac()
                                                         != null) {
                                                     value = docente.getFnac();
                                                 }%> value="<%=value%>">
                <tr>
                    <td>Sexo:<td><input type="text" name="sexo" required
                                        <% value = "";
                                            if (docente.getSexo() != null) {
                                                value = docente.getSexo();
                                            }%> value="<%=value%>">
                <tr>
                    <td>Direccion:<td><input type="text" name="direccion" required
                                             <% value = "";
                                                 if (docente.getDireccion() != null) {
                                                     value = docente.getDireccion();
                                                 }%> value="<%=value%>">
                <tr>
                    <td>Comuna:<td><input type="text" name="comuna" required
                                          <% value = "";
                                              if (docente.getComuna() != null) {
                                                  value = docente.getComuna();
                                              }%>  value="<%=value%>">
                <tr>
                    <td>Email:<td><input type="text" name="email" required
                                         <% value = "";
                                             if (docente.getEmail() != null) {
                                                 value = docente.getEmail();
                                             }%>  value="<%=value%>">
                <tr>
                    <td>Telefono:<td><input type="text" name="telefono" required
                                            <% value = "";
                                                if (docente.getTelefono() != null) {
                                                    value = docente.getTelefono();
                                                }%> value="<%=value%>">
                <tr>
                    <td>es Jefe<td>
                        <select name="esJefe"  required>
                            <option>Si</option>
                            <option>No</option>
                        </select>


                <tr>
                    <td>Curso Jefe:<td><input type="text" name="cursoJefe" required
                                              <% value = "";
                                                  if (docente.getCursoJefe() != null) {
                                                      value = docente.getCursoJefe();
                                                  }%>  value="<%=value%>">
                <tr>

                    <td>
                    <td><input type="submit" value="Modificar"><input type="reset" value="Limpiar">

            </table>
        </form>
        <form action="EliminarDocente.do" method="post">
            <td><input type="submit" value="ELIMINAR">

        </form>
    </body>
</html>
