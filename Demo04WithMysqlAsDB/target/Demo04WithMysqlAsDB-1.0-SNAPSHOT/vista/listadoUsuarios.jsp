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
    <jsp:include page="/header.jsp" />  
    <div class="menu_nav">
        <ul>
            <li><a href="Controlador?accion=listarUsuarios">Usuarios</a></li>
            <li><a href="#news">News</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="logIn.jsp">LogOut</a></li>
        </ul>
    </div>
    <style>
        label {
            display: inline-block;
            width: 100px;


        }

        input {
            display: inline-block;
            width: 200px;
        }

        div {
            width: auto;
            height: auto;
            text-align: left;
            margin-left: 50px;
            margin-top: 20px;
        }

        .row1 {
            float: left;
            border-style: groove;
            width: 500px;
            height: 400px;
            text-align: center;
            margin-top: 10px;
            margin-bottom: 5px;
            margin-left: 120px;
            margin-right: 5px;


        }

        .detalle_usuario {
            float: left;
            border-style: groove;
            width: 400px;
            height: 300px;
            text-align: left;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 5px;
            margin-right: 5px;

        }

        .main {
            border-style: groove;
            width: 1380px;
            height: 420px;
            text-align: left;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 50px;
            margin-right: 5px;

        }

        .div_table{
            margin-left: 20px;
            overflow: auto;
            height: 300px;
        }

    </style>


    <body>
        <div class="main">
            <div class="row1">
                <h2>Datos de usuario</h2>
                <div class="detalle_usuario">

                    <div>
                        <label>NOMBRE</label>
                        <input type="text">
                    </div>
                    <div>
                        <label>APELLIDO</label>
                        <input type="text">
                    </div>
                    <div>
                        <label>EMAIL</label>
                        <input type="text">
                    </div>
                    <div>
                        <label>TELEFONO</label>
                        <input type="text">
                    </div>
                    <div style="text-align: left;">
                        <label>RUT</label>
                        <input type="text">
                    </div>
                </div>
            </div>
            <div class="row1">
                <h1>listadoUsuarios()</h1>
                <div class="div_table">
                    <table border="1" >
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>EMAIL</th>
                            <th>TELEFONO</th>
                        </tr>
                        <c:forEach var="listadoPersonas" items="${listadoPersonas}">
                            <tr>
                                <td>${listadoPersonas.getId()}</td>
                                <td>${listadoPersonas.getNombre()}</td>
                                <td>${listadoPersonas.getApellido()}</td>
                                <td>${listadoPersonas.getEmail()}</td>
                                <td>${listadoPersonas.getTelefono()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>

    <jsp:include page="/footer.jsp"/> 
</html>
