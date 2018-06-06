<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="css/bootstrap.min.css">      
        <script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administración</title>
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
      <a class="navbar-brand" href="#">Alhambra</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home.jsp">Home</a></li>
        <li><a href="almacenes.jsp">Listado</a></li>
        <li><a href="contacto.jsp">Contacto</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span>
            Login</a></li>
      </ul>
    </div>
  </div>
  </nav>

      <div id="cabecera"><img src="alhambra.jpg"></div>
      <br><br>
<footer class="container-fluid text-center">
  <p>Almacenes Alhambra</p>
</footer>
</body>
</html>