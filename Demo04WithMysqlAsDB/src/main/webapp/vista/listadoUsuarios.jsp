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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>listadoUsuarios()</h1>
        <table border="1">
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
</html>
