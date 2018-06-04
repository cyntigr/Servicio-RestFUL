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
<title>Lista Almacenes</title>
<style>
.navbar {
      margin-bottom: 0;
      border-radius: 0;
      background-color:#ADD5F7;

    }
    </style>
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
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Projects</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</div>
	</nav>
<div class="container">
	<br> <br>
	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button"
			data-toggle="dropdown">
			Almacenes <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="articulos.jsp">Artículos</a></li>
			<li><a href="stocks.jsp">Stock</a></li>
		</ul>
	</div>
	<br>
	<!-- Formulario buscar Almacen -->

	<form action="almacen" method="get" id="buscarAlmacenForm" role="form">
		<input type="hidden" id="buscarAction" name="buscarAction"
			value="buscarPorNombre">
		<div class="form-group col-xs-5">
			<input type="text" name="nombreAlmacen" id="nombreAlmacen"
				class="form-control" required="true"
				placeholder="Escriba el nombre del almacen" />
		</div>
		<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Buscar
		</button>
	</form>
	<br> <br>
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<form action="almacen" method="post" id="almacenForm" role="form">
		<input type="hidden" id="idAlmacen" name="idAlmacen"> <input
			type="hidden" id="action" name="action">
		<c:choose>
			<c:when test="${not empty listaAlmacenes}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id Almacén</td>
							<td>Nombre Almacén</td>
						</tr>
					</thead>
					<c:forEach var="almacen" items="${listaAlmacenes}">
						<c:set var="classSucess" value="" />
						<c:if test="${idAlmacen == almacen.idAlmacen}">
							<c:set var="classSucess" value="info" />
						</c:if>
						<tr class="${classSucess}">
							<td><a
								href="almacen?idAlmacen=${almacen.idAlmacen}&buscarAction=buscarPorId">${almacen.idAlmacen}</a></td>
							<td>${almacen.nombreAlmacen}</td>

							<td><a href="#" id="eliminar"
								onclick="document.getElementById('idAlmacen').value='${almacen.idAlmacen}';
            									document.getElementById('action').value='eliminar';
            									document.getElementById('almacenForm').submit();">
									<span class="glyphicon glyphicon-trash" />
							</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No se encontraron registros para
					la búsqueda</div>
			</c:otherwise>
		</c:choose>
	</form>
  <form action="almacen" method="get" style="float:right;">
    <input type="hidden" id="buscarAction" name="buscarAction"
      value="nuevo"> <br></br>
    <button type="submit" class="btn btn-primary  btn-md">Nuevo
      almacén</button>

  </form>
  <div style="clear:both;"></div>
  <br><br>
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>