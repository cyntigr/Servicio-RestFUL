<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.io.InputStreamReader"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Almacén concreto</title>


</head>
<body>
	<%
		String myURL = "http://localhost:8080/Almacenes/rest/almacen/" + request.getParameter("idalmacen");

		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;

		URL url = new URL(myURL);
		urlConn = url.openConnection();
		if (urlConn != null) {
			urlConn.setReadTimeout(60 * 1000);
		}
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
		sb.toString();
		out.print(sb);
	%>
</body>
</html>