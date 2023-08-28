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
            <h1>LIST</h1>
            <c:forEach items="${estudiantes}" var="estudiante">
                <div class="row">
                    <div class="col-md-12 card">
                        <div class="card-body">
                            <h5 class="card-title">Carnet: ${estudiante.carnet}</h5>
                            <p class="card-text">Nombre: ${estudiante.nombre}</p>
                            <p class="card-text">Apellidos: ${estudiante.nombre}</p>
                            <p class="card-text">Fecha NAcimiento: ${estudiante.fechaNacimiento}</p>
                            <a href="${pageContext.request.contextPath}/mvc/student-servlet?carnet=${estudiante.carnet}" class="btn btn-primary">Ver detalles</a>

                            <button type="button" onclick="loadDetails('${estudiante.carnet}', '${pageContext.request.contextPath}');" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal2">
                                Ver detalle ajax
                            </button>


                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>




        <div class="modal" id="myModal2" tabindex='-1'>
            <div class="modal-dialog modal-dialog-centered" id="ajax-detail">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modal Heading</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div id="ajax-detail">
                        </div>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
