<%-- 
    Document   : eliminar_producto
    Created on : 23-05-2023, 09:46:00
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
        <h1>eliminar producto</h1>
        <form action="${pageContext.request.contextPath}/ControladorProducto?accion=eliminarProducto" method="post">
            <h5>buscar producto por id</h5>
            <label>idProdcuto:</<label><input type="text" name="idProducto"> 
            <br>
            <label>lote:</<label><input type="text" name="lote"> 
            <br>    
            <input type="submit" value="buscar">        
        </form>
        <br><br>
        <table border="1">
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>descripcion</th>
                <th>lote</th>
                <th>accion</th>
            </tr>
            <tr>
                <td><input type="text" value="${producto.getIdProducto()}"></td>
                <td><input type="text" value="${producto.getNombre()}"></td>
                <td><input type="text" value="${producto.getDescripcion()}"></td>
                <td><input type="text" value="${producto.getLote()}"></td>
                <td><a href="${pageContext.request.contextPath}/ControladorProducto?accion=borrarProducto&idProducto=${producto.getIdProducto()}">Eliminar</a></td>
            </tr>
            
        </table>
        
    </body>
</html>
