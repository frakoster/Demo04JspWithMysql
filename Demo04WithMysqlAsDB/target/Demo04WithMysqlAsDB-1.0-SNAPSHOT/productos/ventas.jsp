<%-- 
    Document   : ventas
    Created on : 24-05-2023, 14:06:28
    Author     : franc
--%>
<%@page import="java.util.List"%>
<%@page import="batch.Producto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ventas</h1>

        <form action="${pageContext.request.contextPath}/ControladorProducto?accion=getProductoById" method="post">
            <label>producto:</label>
            <select name="id">
                <c:forEach var="listadoProducto" items="${listadoProducto}">
                    <option value="${listadoProducto.getIdProducto()}"> 
                        ${listadoProducto.getNombre()}
                    </option>
                </c:forEach> 
            </select>
            <input type="submit" value="buscar">
        </form>
        <form method="post" action="${pageContext.request.contextPath}/ControladorProducto?accion=agregarProducto&idProducto=${producto.getIdProducto()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>nombre</th>
                        <th>detalle</th>
                        <th>precio</th>
                        <th>lote</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${producto.getIdProducto()}</td>
                        <td>${producto.getNombre()}</td>
                        <td>${producto.getDescripcion()}</td>
                        <td>${producto.getPrecio()}</td>
                        <td>${producto.getLote()}</td>
                    </tr>

                </tbody>

            </table>
            <input type="submit" value="Agregar">
        </form>
                    <h1> Listado de productos seleccionados </h1>
        <table border="1">
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>detalle</th>
                <th>precio</th>
             </tr>    
                <c:forEach var="misProductos" items="${misProductos}">
                <tr>
                    <td>${misProductos.getIdProducto()}</td>
                    <td>${misProductos.getNombre()}</td>
                    <td>${misProductos.getDescripcion()}</td>
                    <td>${misProductos.getPrecio()}</td>
                </tr>
                </c:forEach> 
        </table>
</body>
</html>
