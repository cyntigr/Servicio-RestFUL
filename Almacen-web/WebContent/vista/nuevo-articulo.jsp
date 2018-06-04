<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">      
        <script src="js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="articulo" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                          
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">

                <h2>Artículo</h2>
                <div class="form-group">
                
                
                    <label for="codArticulo" class="control-label col-xs-4">Código artículo:</label>
                    <input type="text" name="codArticulo" id="codArticulo" class="form-control" value="${articulo.codArticulo}" required="true" />                                   
                    <br>
                    <label for="nombreArticulo" class="control-label col-xs-4">Nombre:</label>
                    <input type="text" name="nombreArticulo" id="nombreArticulo" class="form-control" value="${articulo.nombreArticulo}" required="true" />                                   
                    <br>
                    <label for="pCoste" class="control-label col-xs-4">Precio coste:</label>
                    <input type="text" name="pCoste" id="pCoste" class="form-control" value="${articulo.pCoste}" required="true" />                                   
                    <br>
                    <label for="pVenta" class="control-label col-xs-4">Precio venta:</label>
                    <input type="text" name="pVenta" id="pVenta" class="form-control" value="${articulo.pVenta}" required="true" />                                   

                    <br></br>
                    <button type="submit" class="btn btn-primary">Guardar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>