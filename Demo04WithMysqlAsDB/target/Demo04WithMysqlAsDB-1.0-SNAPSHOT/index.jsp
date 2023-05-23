<%-- 
    Document   : index
    Created on : Mar 27, 2023, 5:58:56 PM
    Author     : farmijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Aplicacion web</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
    </head>
    <div>
        <body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/Controlador?accion=listarUsuarios">ListarUsuarios()</a></li>
            <li><a href="${pageContext.request.contextPath}/vista/crearUsuario.jsp">CrearNuevoUsuario()</a></li>
            <li><a href="productos/dashProductos.jsp">Productos</a></li>
        </ul>
            
            

        </body>

</html>
