<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="css/bootstrap.min.css">      
        <script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administración</title>

</head>
<body style="background-image:url(fondo.jpg);background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; " >
    <br><br><br><br>
<div style="margin:auto;width:400px;background-color:rgba(215, 215, 215, 0.8);padding-top:1px;padding-left:25px;padding-bottom:10px;">
<form action="comprobarContrasena.jsp" method="get"  role="form" data-toggle="validator">
<fieldset >
  <legend>Administración de almacenes</legend>
  <div style="margin:5%;">
  <div class="form-group" >
    <label for="usuario">Usuario: </label>
    <input type="text" style="width: 150px;" class="form-control" name="usuari">
  </div>
  <div class="form-group">
    <label for="contrasena">Contraseña: </label>
    <input type="password" style="width: 150px;" class="form-control" name="contrasen">
  </div>
  <button type="submit" class="btn btn-default">Entrar</button>
  </div>
</fieldset>
</form>
</div>

</body>
</html>