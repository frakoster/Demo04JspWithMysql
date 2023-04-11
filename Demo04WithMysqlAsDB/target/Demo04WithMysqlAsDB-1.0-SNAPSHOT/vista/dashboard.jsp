<%-- 
    Document   : dashboard
    Created on : 28-03-2023, 21:20:13
    Author     : farmijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>dashboard</title>
    </head>
    <jsp:include page="/header.jsp" />  
     <body>
        <div class="menu_nav">
    <ul>
        <li><a href="Controlador?accion=listarUsuarios">Usuarios</a></li>
        <li><a href="#news">News</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="logIn.jsp">LogOut</a></li>
      </ul>
    </div>
    </body>    
    <div class="body">
    <body>
        <h2>Dashboard</h2>
    </body>
    </div>
<jsp:include page="/footer.jsp"/> 
</html>
