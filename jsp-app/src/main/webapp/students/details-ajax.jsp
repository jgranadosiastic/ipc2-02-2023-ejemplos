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

<c:if test="${estudianteOpt.present}">
    <div class="row">
        <div class="col-md-12 card">
            <div class="card-body">
                <h5 class="card-title">Carnet: ${estudianteOpt.get().carnet}</h5>
                <p class="card-text">Nombre: ${estudianteOpt.get().nombre}</p>
                <p class="card-text">Apellidos: ${estudianteOpt.get().apellidos}</p>
                <p class="card-text">Fecha NAcimiento: ${estudianteOpt.get().fechaNacimiento}</p>
            </div>

        </div>
    </div>
</c:if>
<c:if test="${!estudianteOpt.present}">
    <div class="alert alert-danger" role="alert">
        Es estudiante no existe!
    </div>
</c:if>
