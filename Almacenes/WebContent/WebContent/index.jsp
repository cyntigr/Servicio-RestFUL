<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="com.clases.Almacen"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.io.InputStreamReader"%>

<html>
<body style="text-align: center;">
	<div style="background-color: grey; with: 600px; height: 800px;">
		<h1 style="color: blue;">Almacenes</h1>
		<div>
			<%
				String myURL = "http://localhost:8080/Almacenes/rest/almacen";

				StringBuilder sb = new StringBuilder();
				URLConnection urlConn = null;
				InputStreamReader in = null;

				URL url = new URL(myURL);
				urlConn = url.openConnection();
				if (urlConn != null)
					urlConn.setReadTimeout(60 * 1000);
				if (urlConn != null && urlConn.getInputStream() != null) {
					in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
				}
				in.close();
				out.print(sb);
			%>
		</div>
		<a href="http://localhost:8080/Almacenes/rest/almacen/">Lista de
			almacenes</a>
		<form method="post" action="getEspecifico.jsp">
			<label>Introduce número de almacén: </label> <input type="number"
				name="idalmacen">
			<button type="submit" value="seleccion">Ir selección</button>
		</form>
		<form method="post" action="getEspecifico.jsp"
			action="http://localhost:8080/Almacenes/rest/almacen/post"  >

			<h2>Introduce un nuevo almacén:</h2>
			<label>idAlmacen:</label> <input type="number" name="idalmacen">
			<label>Nombre almacén:</label> <input type="text"
				name="nombrealmacen">
			<button type="submit" value="Añadir">Añadir</button>
		</form>
	</div>
</body>
</html>
