<%-- 
    Document   : dashProductos
    Created on : 22-05-2023, 19:19:06
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
        <h1>Dashboard de productos</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">index</li></a>
            <li><a href="crear_producto.jsp">crear producto</li></a>
            <li><a href="eliminar_producto.jsp">eliminar producto</a></li>
            <li><a href="${pageContext.request.contextPath}/ControladorProducto?accion=listarProductos">listar productos</a></li>
            
        </ul>
    </body>
</html>
