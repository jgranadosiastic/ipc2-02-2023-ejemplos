<%-- 
    Document   : get-action
    Created on : Aug 17, 2023, 3:50:25 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>POST</h1>
        <div>
            Nombre: <%= request.getParameter("nombre")%> <br>
            Apellidos: <%= request.getParameter("apellidos")%> <br>
            <div>

                <% if ("on".equals(request.getParameter("aprobado"))) { %>
                <p>Ha sido aprobado</p>
                <% } else { %>
                <p>Ha sido reprobado</p>
                <%}%>
            </div>
        </div>
    </body>
</html>
