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
        <jsp:include page="/includes/resources.jsp"/>
        <title>JSP Page</title>
    </head>
    <body class="d-flex flex-column h-100">
        <jsp:include page="/includes/header.jsp"/>
        <div class="container">
            <h1>Form GET jsp</h1>
            <div class="row">
                <div class="col-md-12">
                    <form method="GET" action="get-action.jsp">
                        <label>Nombre</label>
                        <input class="form-control" id="nombre" name="nombre"/>

                        <label>Apellidos</label>
                        <input class="form-control" id="apellidos" name="apellidos"/>

                        <label>aprobado</label>
                        <input type="checkbox" name="aprobado"/>

                        <button class="btn btn-primary" type="submit">Enviar!</button>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h1>Form POST jsp</h1>
                    <form method="POST" action="${pageContext.request.contextPath}/mvc/student-servlet">
                        <label>Carnet</label>
                        <input class="form-control" id="carnet" name="carnet"/>
                        
                        <label>Nombre</label>
                        <input class="form-control" id="nombre" name="nombre"/>

                        <label>Apellidos</label>
                        <input class="form-control" id="apellidos" name="apellidos"/>

                        <label>fecha nacimiento</label>
                        <input type="date" pattern="\d{4}-\d{2}-\d{2} name="fechaNacimiento"/>

                        <button class="btn btn-primary" type="submit">Enviar!</button>
                    </form>
                </div>
            </div>
        </div>



        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
