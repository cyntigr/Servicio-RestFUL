<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils" %>
<%@page import="com.clase.almacen.model.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String usuari = request.getParameter("usuari");
	  String textoSinEncriptar=request.getParameter("contrasen"); 
	  String textoEncriptadoConMD5=DigestUtils.md5Hex(textoSinEncriptar); 
		String contrasen = textoEncriptadoConMD5;

		// Comprueba la existencia del número de socio introducido
		Class.forName("org.postgresql.Driver");
		Connection conexion = Conexion.crearConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuarios");
		HashMap<String, String> m = new HashMap<String, String>();
		while (resultado.next()) {
			
			m.put(resultado.getString("usuario"), resultado.getString("contrasena"));
		}
		if (m.containsKey(usuari)) {
			if (m.get(usuari).equals(contrasen)) {

				out.println(
						"<script> window.location.replace('http://localhost:8080/Almacen-web/home.jsp');</script>");
			} else {
				out.println("<br><br><br>");
				out.println("Lo siento, la contraseña es incorrecta.<br>");
				out.println("<br>");
				out.println("<form method=\"get\" action=\"index.jsp\" >");
				out.println("<button type=\"submit\" class=\"inicio\">Página Inicio</button>");
				out.println("</form>");
			}
		} else {
			out.println("<br><br><br>");
			out.println("Lo siento, el usuario es incorrecto.<br>");
			out.println("<br>");
			out.println("<form method=\"get\" action=\"index.jsp\" >");
			out.println("<button type=\"submit\" class=\"inicio\">Página Inicio</button>");
			out.println("</form>");
		}
		resultado.close();
		sentencia.close();
		conexion.close();
	%>
</body>
</html>