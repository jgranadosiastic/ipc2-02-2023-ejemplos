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
    <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">Carnet: ${estudianteOpt.get().carnet}</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
            <p class="card-text">Nombre: ${estudianteOpt.get().nombre}</p>
            <p class="card-text">Apellidos: ${estudianteOpt.get().apellidos}</p>
            <p class="card-text">Fecha NAcimiento: ${estudianteOpt.get().fechaNacimiento}</p>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        </div>
    </div>
</c:if>
<c:if test="${!estudianteOpt.present}">
    <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">Error</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
            <div class="alert alert-danger" role="alert">
                Es estudiante no existe!
            </div>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        </div>
    </div>
</c:if>
