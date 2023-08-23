<%-- 
    Document   : get-action
    Created on : Aug 17, 2023, 3:50:25 PM
    Author     : jose
    MVC: Model-View-Controller
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:include page="/includes/header.jsp"/>
        <div class="container">
            <h1>POST</h1>
            <div>
                Nombre: ${estudiante.nombre} <br>
                Apellidos: ${estudiante.apellidos} <br>
                <div>

                    <c:if test="${estudiante != null}">
                        <p>Ha sido insertado</p>
                    </c:if>
                    <c:if test="${estudiante == null}">
                        <p>Ha fallado</p>
                    </c:if>
                </div>
            </div>
        </div>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
