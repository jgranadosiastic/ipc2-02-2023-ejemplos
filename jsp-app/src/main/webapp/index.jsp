<%-- 
    Document   : index
    Created on : Aug 17, 2023, 3:44:25 PM
    Author     : jose
    Java Server Pages
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form GET jsp</h1>
        <form method="GET" action="get-action.jsp">
            <label>Nombre</label>
            <input id="nombre" name="nombre"/>
            
            <label>Apellidos</label>
            <input id="apellidos" name="apellidos"/>
            
            <label>aprobado</label>
            <input type="checkbox" name="aprobado"/>
            
            <button type="submit">Enviar!</button>
        </form>
        
        
        <h1>Form POST jsp</h1>
        <form method="POST" action="post-action.jsp">
            <label>Nombre</label>
            <input id="nombre" name="nombre"/>
            
            <label>Apellidos</label>
            <input id="apellidos" name="apellidos"/>
            
            <label>aprobado</label>
            <input type="checkbox" name="aprobado"/>
            
            <button type="submit">Enviar!</button>
        </form>
    </body>
</html>
