<%-- 
    Document   : crear_producto
    Created on : 22-05-2023, 19:31:28
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear producto</h1>
        <form action="${pageContext.request.contextPath}/ControladorProducto?accion=crearProducto" method="post">
            <label>cantidad productos:</label><input type="text" name="cantidadProductos">
            <br>
            <label>nombre producto:</label><input type="text" name="nombreProducto">
            <br>
            <label>lote producto:</label><input type="text" name="loteProducto">
            <br>
            <label>detalle del producto:</label><textarea type="text" rows="2" name="detalleProducto"></textarea>  
            <br>
            <input type="submit" name="btncrear" value="crear producto">
        </form>
        
        
    </body>
</html>
