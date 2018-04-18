<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Almacén concreto</title>


</head>
<body>
<% String endpoint = "http://localhost:8080/Almacenes/rest/almacen/" + request.getParameter("idalmacen");%>
<a href="<%= endpoint %> ">Almacén</a>
</body>
</html>