<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">   		
        <script src="js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="almacen" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">

                <h2>Almacén</h2>
                <div class="form-group">
                    <label for="idAlmacen" class="control-label col-xs-4">Id Almacen:</label>
                    <input type="text" name="idAlmacen" id="idAlmacen" class="form-control" value="${almacen.idAlmacen}" required="true" />                                   
                    <br>
                    <label for="nombreAlmacen" class="control-label col-xs-4">Nombre:</label>
                    <input type="text" name="nombreAlmacen" id="nombreAlmacen" class="form-control" value="${almacen.nombreAlmacen}" required="true" />                                   

                    <br></br>
                    <button type="submit" class="btn btn-primary">Guardar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>