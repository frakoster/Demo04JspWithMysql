<%-- 
    Document   : listarProductos
    Created on : 23-05-2023, 10:57:37
    Author     : franc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar Productos</h1>
        <li><a href="productos/dashProductos.jsp">dashboard</a></li>
        <table border="1">
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>descripcion</th>
                <th>lote</th>
            </tr>
            <c:forEach var="listadoProductos" items="${listadoProductos}">
                <tr>
                    <td>${listadoProductos.getIdProducto()}</td>
                    <td>${listadoProductos.getNombre()}</td>
                    <td>${listadoProductos.getDescripcion()}</td>
                    <td>${listadoProductos.getLote()}</td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>
