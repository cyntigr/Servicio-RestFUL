<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">      
        <script src="js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="stock" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                          
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">

                <h2>Stock</h2>
                <div class="form-group">
                    <br>
                    <label for="codArticulo" class="control-label col-xs-4">Código Artículo:</label>
                    <input type="text" name="codArticulo" id="codArticulo" class="form-control" value="${stock.codArticulo}" required="true" />                                   
                    <br>
                    <label for="idAlmacen" class="control-label col-xs-4">Id Almacen:</label>
                    <input type="text" name="idAlmacen" id="idAlmacen" class="form-control" value="${stock.idAlmacen}" required="true" />                                   
                    <br>
                    <label for="stock" class="control-label col-xs-4">Stock:</label>
                    <input type="text" name="stock" id="codArticulo" class="form-control" value="${stock.stock}" required="true" />                                   

                    <br></br>
                    <button type="submit" class="btn btn-primary">Guardar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>