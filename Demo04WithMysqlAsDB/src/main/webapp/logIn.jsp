<%-- 
    Document   : logIn
    Created on : 10-04-2023, 12:21:07
    Author     : farmijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
            <jsp:include page="header.jsp" />  
            <jsp:include page="menu_nav.jsp"/>  
        <div >
     <div class="interior">
                <h2>Login</h2>
                 <div class="icono">
                    <img src=img/bussines-man.jpg>
                 </div>   


                <form action="Controlador?accion=logIn" method="post">
                    <div class="nombre">
                        <label for="">usuario</label>
                    </div>
                        <input type="text" name="username" style="width: 300px; margin-left:50px;text-align: center;" >
                    
                    <div class="pwd">
                        <label class="lnom" for="">clave</label>
                    </div>

                    <div>
                        <input type="password" name="password" style="width: 300px;margin-left:50px;text-align: center;" >
                    
                    </div>
                    <div class="forgot">
                        <a href="#">Forgot?</a>

                    <div class="sbmt">
                        <input class="sbmButton" type="submit" value="Submit">
                    </div>
    
                </form>

            </div>
     
    </div>
    </body>
         <jsp:include page="footer.jsp"/> 
</html>
