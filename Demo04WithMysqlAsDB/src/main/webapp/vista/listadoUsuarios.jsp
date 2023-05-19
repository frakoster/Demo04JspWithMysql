<%-- 
    Document   : listadoUsuarios
    Created on : Mar 28, 2023, 10:14:03 AM
    Author     : farmijo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Aplicacion web</title>
    </head>
    <header>

    </header>
    <body>
        <a href="Controlador?accion=listarUsuarios">ListarUsuarios()</a>
        
        
            <div class="row2">
                <h2>Tabla de usuarios</h2>
                <div class="div_table">
                    <table border="1" style="width: 750px">
                        <tr>
                            <th>id</th>
                            <th>nombre</th>
                            <th>apellido</th>
                            <th>email</th>
                            <th>telefono</th>
                            <th>rut</th>
                            <th>acciones</th>
                        </tr>
                        <c:forEach var="listadoPersonas" items="${listadoPersonas}">
                            <tr>
                                <td>${listadoPersonas.getId()}</td>
                                <td>${listadoPersonas.getNombre()}</td>
                                <td>${listadoPersonas.getApellido()}</td>
                                <td>${listadoPersonas.getEmail()}</td>
                                <td>${listadoPersonas.getTelefono()}</td>
                                <td>${listadoPersonas.getDni()}</td>
                                <td>
                                    <a href="Controlador?accion=eliminarUsuario&idUser=${listadoPersonas.getId()}">Eliminar</a> 
                                    <a href="Controlador?accion=editarUsuario&idUser=${listadoPersonas.getId()}">Editar</a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <label style="text-align: left">Usuarios= ${listadoPersonas.size()}</label> 
            </div>

        </div>
    </body>
</html>
