<!-- en la directiva page observamos el import="java.sql.*"-->
<!-- esta es la analogia en java a importar paquetes y/o clases-->
<!-- en el paquete java.sql.* estan las clases necesarias-->
<!-- para la conexion a la bd mysql -->
<%@ page language="java" import="java.sql.*" %>
<%
	/*conexion sera nuestra conexion a la bd*/
	Connection conexion=null;
	
	String mensaje="";
	
	/*rescatando la conexion de la session*/
	conexion=(Connection)session.getAttribute("conexion");
	
	/*cerrando la conexion*/
	conexion.close();
	
	mensaje="conectado";
	if(conexion.isClosed()){
		mensaje="desconectado";
	}
%>
<html>
	<head>
		<title>EJERCICIO 03 CONEXION BD CON JSP</title>
	</head>
	<body>
		<form action="index.jsp" method="post">
			<input name="estado" type="text" value="Estado: <%=mensaje%>"/>
			<input type="submit" value="Conectar"/>
		</form>
	</body>
</html>
