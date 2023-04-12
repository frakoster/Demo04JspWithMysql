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
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
        <title>Aplicacion web</title>
    </head>
    <jsp:include page="/header.jsp" />  


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
            margin-left: 5px;
            margin-top: 5px;
        }

        .row1 {
            float: left;
            border-style: groove;
            width: 360px;
            height: 400px;
            text-align: center;
            margin-top: 50px;
            margin-bottom: 5px;
            margin-left: 10px;
            margin-right: 5px;


        }
        
                .row2 {
            float: left;
            border-style: groove;
            width: 700px;
            height: 400px;
            text-align: center;
            margin-top: 50px;
            margin-bottom: 5px;
            margin-left: 10px;
            margin-right: 5px;


        }

        .detalle_usuario {
            float: left;
            border-style: groove;
            width: 350px;
            height: 300px;
            text-align: left;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 5px;
            margin-right: 5px;

        }

        .main {
            border-style: groove;
            width: 1400px;
            height: 500px;
            text-align: left;
            margin-top: 10px;
            margin-bottom: 5px;
            margin-left: 5px;
            margin-right: 5px;

        }

        .div_table{
            margin-top: 20px;
            margin-left: 20px;
            overflow: auto;
            height: 300px;
            width: 680px;
        }

        .botonera {

            float: left;
            border-style: groove;
            width: 200px;
            height: 400px;
            text-align: center;
            margin-top: 50px;
            margin-bottom: 5px;
            margin-left: 25px;
            margin-right: 5px;


        }


        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 200px;
            background-color: #f1f1f1;
        }

        li a {
            margin-top: 50px;
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        /* Change the link color on hover */
        li a:hover {
            background-color: #555;
            color: white;
        }



        .menu_nav{
            margin-top: 10px;
            border-radius: 5px;
            border-style: groove;
            text-align: center;

        }
        lii {
            display: inline;
        }
        aa {
            display: inline;
            padding: 8px;

        }




    </style>
    <div class="menu_nav">
        <ull>
            <lii><aa href="#home">Home</aa></lii>
            <lii><aa href="#news">News</aa></lii>
            <lii><aa href="#contact">Contact</aa></lii>
            <lii><aa href="logIn.jsp">LogIn</aa></lii>
        </ull>
    </div>

    <body>
        <div class="main">

            <div class="botonera">
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#news">News</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li>
                </ul>
            </div>




            <div class="row1">
                <h2>Datos de usuario</h2>
                <div class="detalle_usuario">
                    <form action="Controlador?accion=crearUsuario" method="post">

                    <div style="margin-top: 50px;">
                        <label>NOMBRE</label>
                        <input type="text" name="nombre">
                    </div>
                    <div>
                        <label>APELLIDO</label>
                        <input type="text" name="apellido">
                    </div>
                    <div>
                        <label>EMAIL</label>
                        <input type="text" name="email">
                    </div>
                    <div>
                        <label>TELEFONO</label>
                        <input type="text" name="telefono">
                    </div>
                    <div >
                        <label>RUT</label>
                        <input type="text" name="dni">
                    </div>
                    <div>
                       
                        <div style="float: left; width: 80px;margin-left: 100px;">
                            <input  type="submit" style="width: 60px;" value="Crear()" >
                        </div>
                        <div style="float: left;width: 80px;">
                            <input type="submit" style="width: 60px;" value="Limpiar()">
                        </div>
                      
                    </div>
                    </form>
                </div>
            </div>

            <div class="row2">
                <h2>listadoUsuarios()</h2>
                <div class="div_table">
                    <table border="1" style="width: 650px">
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>EMAIL</th>
                            <th>TELEFONO</th>
                            <th>ACCIONES</th>
                        </tr>
                        <c:forEach var="listadoPersonas" items="${listadoPersonas}">
                            <tr>
                                <td>${listadoPersonas.getId()}</td>
                                <td>${listadoPersonas.getNombre()}</td>
                                <td>${listadoPersonas.getApellido()}</td>
                                <td>${listadoPersonas.getEmail()}</td>
                                <td>${listadoPersonas.getTelefono()}</td>
                                 <td>
                                     <a href="Controlador?accion=eliminarUsuario&idUser=${listadoPersonas.getId()}">Eliminar</a> 
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
