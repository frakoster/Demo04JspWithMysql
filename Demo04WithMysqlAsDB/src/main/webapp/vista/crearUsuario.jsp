<%-- 
    Document   : crearUsuario
    Created on : 22-05-2023, 18:08:34
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
        <h1>Crear nuevo usuario</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">index</a></li>
    </ul>
        
        <form action="${pageContext.request.contextPath}/Controlador?accion=crearUsuario" method="post">
            <div>
                <label>nombre</label>
                <input type="text" name="nombre">
            </div>
            <div>
                <label>apellido</label>
                <input type="text" name="apellido">
            </div>
            <div>
                <label>email</label>
                <input type="text" name="email">
            </div>
            <div>
                <label>telefono</label>
                <input type="text" name="telefono">
            </div>
            <div >
                <label>rut</label>
                <input type="text" name="dni">
            </div>
            <div>
                <input  type="submit" style="width: 60px;" value="Crear" >
                <input type="reset" style="width: 60px;" value="Limpiar">
            </div>
        </form>
    </body>
</html>
