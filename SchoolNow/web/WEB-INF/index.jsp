<!-- en la directiva page observamos el import="java.sql.*"-->
<!-- esta es la analogia en java a importar paquetes y/o clases-->
<!-- en el paquete java.sql.* estan las clases necesarias-->
<!-- para la conexion a la bd mysql -->
<%@ page language="java" import="java.sql.*" %>

%>
<html>
	<head>
		<title>EJERCICIO 03 CONEXION BD CON JSP</title>
	</head>
	<body>
		<form action="desconectar.jsp" method="post">
			<input name="estado" type="text" value="Estado: <%=mensaje%>"/>
			<input type="submit" value="Desconectar"/>
		</form>
	</body>
</html>
