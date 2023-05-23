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
        <title>Aplicacion web</title>
    </head>
    <body>
        <div class="main">
            <a href="${pageContext.request.contextPath}/index.jsp">index</a>
            <a href="Controlador?accion=listarUsuarios">ListarUsuarios()</a>

            <div class="row1">
                <h2>Datos de usuario</h2>
                <div class="detalle_usuario">
                    <form action="Controlador?accion=actualizarUsuario&idUsuario=${id}" method="post">

                        <div>

                            <label>nombre</label>
                            <input type="text" name="nombre" value="${nombre}">
                        </div>
                        <div>
                            <label>apellido</label>
                            <input type="text" name="apellido" value="${apellido}">
                        </div>
                        <div>
                            <label>email</label>
                            <input type="text" name="email" value="${email}">
                        </div>
                        <div>
                            <label>telefono</label>
                            <input type="text" name="telefono" value="${telefono}">
                        </div>
                        <div >
                            <label>rut</label>
                            <input type="text" name="dni" value="${dni}">
                        </div>
                        <div>
                                 <input  type="submit" style="width: 60px;" value="Actualizar" >
                                <input type="reset" style="width: 60px;" value="Limpiar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
