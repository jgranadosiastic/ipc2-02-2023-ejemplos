<%-- 
    Document   : get-action
    Created on : Aug 17, 2023, 3:50:25 PM
    Author     : jose
--%>

<%@page import="com.jgranados.jsp.app.db.DBEstudiante"%>
<%@page import="com.jgranados.jsp.app.db.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Estudiante estudiante = new Estudiante(request.getParameter("carnet"), 
                    request.getParameter("nombre"), 
                    request.getParameter("apellidos"), 
                    request.getParameter("fechaNacimiento"));
            
                    DBEstudiante dbEstudiante = new DBEstudiante();
                    boolean result = dbEstudiante.crearEstudiante(estudiante);

        %>
        <jsp:include page="/includes/header.jsp"/>
        <div class="container">
            <h1>POST</h1>
            <div>
                Nombre: <%= request.getParameter("nombre")%> <br>
                Apellidos: <%= request.getParameter("apellidos")%> <br>
                <div>

                    <% if (result) { %>
                    <p>Ha sido insertado</p>
                    <% } else { %>
                    <p>Ha fallado</p>
                    <%}%>
                </div>
            </div>
        </div>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
