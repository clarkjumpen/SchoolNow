<%-- 
    Document   : AgregarDocente
    Created on : 27-04-2013, 04:29:44 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Docente</title>
    </head>
    <body>
        <h1>Agregar Docente</h1>
        <form action="AgregarDocente.do" method="post" >
            <table border=1">

                <td>Rut:<td><input type="text" name="rut" required>
                <tr>
                    <td>Nombre:<td><input type="text" name="nombres" required>
                <tr>
                    <td>Fecha Nac:<td><input type="text" name="fechaNac" required>
                <tr>
                    <td>Sexo:<td><input type="text" name="sexo" required>
                <tr>

                    <td>Telefono:<td><input type="text" name="telefono" required>
                <tr>
                    <td>Direccion:<td><input type="text" name="direccion" required>
                <tr>
                    <td>Comuna:<td><input type="text" name="comuna" required>
                <tr>
                    <td>Email:<td><input type="text" name="email" required>
                <tr>
                    <td>es Jefe:<td><input type="text" name="esJefe" required>
                <tr>
                    <td>Curso Jefe:<td><input type="text" name="cursoJefe" required>
                <tr>

                    <td><input type="submit" value="Agregar">
                    <td><input type="reset" value="Limpiar">

            </table>
        </form>
    </body>
</html>
