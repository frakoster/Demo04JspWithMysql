<%-- 
    Document   : listadoUsuarios
    Created on : Mar 28, 2023, 10:14:03 AM
    Author     : farmijo
--%>
<%@page import="modelo.Persona"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/vista_style.css">
        <title>Aplicacion web</title>
    </head>
    <jsp:include page="header_int.jsp" />  

    <jsp:include page="menu_nav_int.jsp"/>  

    <body>
        <div class="main">

            <div class="botonera">
                <jsp:include page="menu_nav_user.jsp"/> 
            </div>

            <div class="row1">
                <h2>Datos de usuario</h2>
                <div class="detalle_usuario">
                    <form action="Controlador?accion=actualizarUsuario&idUsuario=${id}" method="post">

                        <div style="margin-top: 50px;">

                            <label>NOMBRE</label>
                            <input type="text" name="nombre" value="${nombre}">
                        </div>
                        <div>
                            <label>APELLIDO</label>
                            <input type="text" name="apellido" value="${apellido}">
                        </div>
                        <div>
                            <label>EMAIL</label>
                            <input type="text" name="email" value="${email}">
                        </div>
                        <div>
                            <label>TELEFONO</label>
                            <input type="text" name="telefono" value="${telefono}">
                        </div>
                        <div >
                            <label>RUT</label>
                            <input type="text" name="dni" value="${dni}">
                        </div>
                        <div>

                            <div style="float: left; width: 80px;margin-left: 100px;">
                                <input  type="submit" style="width: 60px;" value="Actualizar" >
                            </div>
                            <div style="float: left;width: 80px;">
                                <input type="reset" style="width: 60px;" value="Limpiar">
                            </div>

                        </div>
                    </form>
                </div>
            </div>

            <div class="row2">
                <h2>Tabla de usuarios</h2>
                <div class="div_table">
                    <table border="1" style="width: 750px">
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>EMAIL</th>
                            <th>TELEFONO</th>
                            <th>DNI</th>
                            <th>ACCIONES</th>
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
            </div>
        </div>
    </body>

    <jsp:include page="/footer.jsp"/> 
</html>
