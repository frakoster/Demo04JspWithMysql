<%-- 
    Document   : listadoUsuarios
    Created on : Mar 28, 2023, 10:14:03 AM
    Author     : farmijo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/Demo04WithMysqlAsDB/css/style.css">
        <title>Aplicacion web</title>
    </head>
    <div class="header">
        <h1>Header</h1>
    </div>


    <div class="topnav">
        <a href="vista/dashboard.jsp">Home</a>
        <a href="#">Link</a>
        <a href="index.jsp">Volver</a>
    </div>



    <div class="center">
        <body>
            <h1>listadoUsuarios()</h1>
            <table border="1" class="center">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>EMAIL</th>
                    <th>TELEFONO</th>
                </tr>
                <c:forEach var="personas" items="${personas}">
                    <tr>
                        <td>${personas.getId()}</td>
                        <td>${personas.getNombre()}</td>
                        <td>${personas.getApellido()}</td>
                        <td>${personas.getEmail()}</td>
                        <td>${personas.getTelefono()}</td>
                    </tr>
                </c:forEach>
            </table>

        </body>
    </div>
    <div class="footer">
        <h1>Footer</h1>
      </div>
</html>
