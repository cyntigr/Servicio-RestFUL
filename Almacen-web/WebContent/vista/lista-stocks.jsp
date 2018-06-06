<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
.navbar {
  margin-bottom: 0;
  border-radius: 0;
  background-color: #ADD5F7;
}
</style>
<title>Lista Stock</title>
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
		<br> <br>
		<div class="dropdown" style="float: right; margin-top: 3%;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Stock <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="almacenes.jsp">Almacenes</a></li>
				<li><a href="articulos.jsp">Art�culos</a></li>
			</ul>
		</div>
		<br>
		<!-- Formulario buscar Stock -->

		<form action="stock" method="get" id="buscarStockForm" role="form">
			<input type="hidden" id="buscarAction" name="buscarAction"
				value="buscarPorNombre">
			<div class="form-group col-xs-5">
				<input type="text" name="idAlmacen" id="idAlmacen"
					class="form-control" required="true"
					placeholder="Escriba el n�mero del almacen" />
			</div>
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Buscar
			</button>
		</form>
		<br> <br>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<form action="stock" method="get" id="stockForm" role="form">
			<input type="hidden" id="idAlmacen" name="idAlmacen"> <input
				type="hidden" id="action" name="action">

			<c:choose>
				<c:when test="${not empty listaStocks}">
					<table class="table table-striped">
						<thead>
							<tr>
								<td>Id Almac�n</td>
								<td>Codigo Art�culo</td>
								<td>Stock</td>
							</tr>
						</thead>
						<c:forEach var="stock" items="${listaStocks}">
							<c:set var="classSucess" value="" />
							<c:if test="${idAlmacen == stock.idAlmacen}">
								<c:set var="classSucess" value="info" />
							</c:if>
							<tr class="${classSucess}">
								<td><a
									href="stock?idAlmacen=${stock.idAlmacen}&codArticulo=${stock.codArticulo}&buscarAction=buscarPorId">${stock.idAlmacen}</a></td>
								<td id="codArticulo">${stock.codArticulo}</td>
								<td>${stock.stock}</td>

								<td><a
									href="stock?idAlmacen=${stock.idAlmacen}&codArticulo=${stock.codArticulo}&buscarAction=eliminar">
										<span class="glyphicon glyphicon-trash" />
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<br>
					<div class="alert alert-info">No se encontraron registros
						para la b�squeda</div>
				</c:otherwise>
			</c:choose>
		</form>

		<form action="stock" method="get" style="float: right;">
			<input type="hidden" id="buscarAction" name="buscarAction"
				value="nuevo"> <br></br>
			<button type="submit" class="btn btn-primary  btn-md">Nuevo
				stock</button>

		</form>
	</div>

	<br>
	<br>
	<footer class="container-fluid text-center">
	<p>Almacenes Alhambra</p>
	</footer>
</body>
</html>