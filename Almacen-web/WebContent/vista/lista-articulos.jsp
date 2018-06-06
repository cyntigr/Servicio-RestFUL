<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
	background-color: #ADD5F7;
}
</style>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Lista Artículos</title>
</head>
<body>
<nav style="color:#FF0000;" class="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Alhambra</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="home.jsp">Home</a></li>
				<li><a href="almacenes.jsp">Listado</a></li>
				<li><a href="contacto.jsp">Contacto</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
<br>
		<div class="dropdown" style="float: right; margin-top: 3%;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Artículos <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="almacenes.jsp">Almacenes</a></li>
				<li><a href="stocks.jsp">Stock</a></li>
			</ul>
		</div>
		<br>
		<!-- Formulario buscar Artículos -->

		<form action="articulo" method="get" id="buscarArticuloForm"
			role="form">
			<input type="hidden" id="buscarAction" name="buscarAction"
				value="buscarPorNombre">
			<div class="form-group col-xs-5">
				<input type="text" name="nombreArticulo" id="nombreArticulo"
					class="form-control" required="true"
					placeholder="Escriba el nombre del artículo" />
			</div>
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Buscar
			</button>
		</form>

		<br>
		<br>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<form action="articulo" method="post" id="articuloForm" role="form">
			<input type="hidden" id="codArticulo" name="codArticulo"> <input
				type="hidden" id="action" name="action">
			<c:choose>
				<c:when test="${not empty listaArticulos}">
					<table class="table table-striped">
						<thead>
							<tr>
								<td>Código Artículo</td>
								<td>Nombre Artículo</td>
								<td>Precio Coste</td>
								<td>Precio Venta</td>
							</tr>
						</thead>
						<c:forEach var="articulo" items="${listaArticulos}">
							<c:set var="classSucess" value="" />
							<c:if test="${codArticulo == articulo.codArticulo}">
								<c:set var="classSucess" value="info" />
							</c:if>
							<tr class="${classSucess}">
								<td><a
									href="articulo?codArticulo=${articulo.codArticulo}&buscarAction=buscarPorId">${articulo.codArticulo}</a></td>
								<td>${articulo.nombreArticulo}</td>
								<td>${articulo.pCoste}</td>
								<td>${articulo.pVenta}</td>
								<td><a href="#" id="eliminar"
									onclick="document.getElementById('codArticulo').value='${articulo.codArticulo}';
                              document.getElementById('action').value='eliminar';
                              document.getElementById('articuloForm').submit();">
										<span class="glyphicon glyphicon-trash" />
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<br>
					<div class="alert alert-info">No se encontraron registros
						para la búsqueda</div>
				</c:otherwise>
			</c:choose>
		</form>
		<form action="articulo" method="get" style="float: right;">
			<input type="hidden" id="buscarAction" name="buscarAction"
				value="nuevo"> <br></br>
			<button type="submit" class="btn btn-primary  btn-md">Nuevo
				artículo</button>

		</form>

	</div>
	<br>
	<br>
	<footer class="container-fluid text-center">
	<p>Almacenes Alhambra</p>
	</footer>
</body>
</html>