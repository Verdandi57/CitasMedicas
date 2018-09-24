<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body style=" background-image: url(WEB-IMG/fondo1.png)">
        <nav class="navbar navbar-expand-sm navbar-light bg-light">
                <a class="navbar-brand" href="#"><img src="WEB-IMG/Caduceo de Hermes.png" alt="" width="60" height="60"/></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="Inicio.jsp">Inicio<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="main_menu.jsp">Menu principal</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Opciones
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Administracion</a>
                                <a class="dropdown-item" href="#">Medicos</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Pacientes (Solo consultas)</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">Disabled</a>
                        </li>
                    </ul>
                    <table>
                        <tr>
                            <td>
                                <form class="form-inline my-2 my-lg-0">
                                    <button class="btn btn-sm btn-outline-primary my-2 my-sm-0" onclick="document.getElementById('id01').style.display = 'block'">Iniciar sesion</button>  
                                </form>
                            </td>
                            <td> </td>
                            <td>
                                <html:form action="/cerrarSesion">
                                    <html:submit property="action" value="Cerrar sesion" styleClass="btn btn-sm btn-outline-secondary"/>
                                </html:form>
                            </td>
                        </tr>
                    </table>
                </div>
            </nav>
        <br>
        <br>
    <center>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12"><br><br>
                    <table class="table table-striped table-dark " border="0">
                        <thead>
                            <tr>
                                <td><h4 style="color: #007bff">#</h4></td>
                                <td><h4 style="color: #007bff">DUI</h4></td>
                                <td><h4 style="color: #007bff">Apellido</h4></td>
                                <td><h4 style="color: #007bff">Nombre</h4></td>
                                <td><h4 style="color: #007bff">Sexo</h4></td>
                                <td><h4 style="color: #007bff">Tipo de Sangre</h4></td>
                                <td><h4 style="color: #007bff">Telefono</h4></td>
                                <td><h4 style="color: #007bff">Contacto</h4></td>
                                <td><h4 style="color: #007bff">Modificar</h4></td>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="MedicosActionForm" property="listaM">
                                <logic:iterate id="medicos" name="MedicosActionForm" property="listaM">
                                    <tr>
                                        <html:form action="/medicosMantenimiento">
                                            <td>
                                                <bean:write name="medicos" property="idMedico"/>
                                                <div hidden="hidden">
                                                    <html:text name="medicos" property="idMedico"/>
                                                </div>
                                            </td>
                                            <td><bean:write name="medicos" property="dui"/></td>
                                            <td><bean:write name="medicos" property="apellido"/></td>
                                            <td><bean:write name="medicos" property="nombre"/></td>
                                            <td><bean:write name="medicos" property="sexo"/></td>
                                            <td><bean:write name="medicos" property="tipoSangre"/></td>
                                            <td><bean:write name="medicos" property="telefono"/></td>
                                            <td><bean:write name="medicos" property="contacto"/></td>
                                            <td>
                                                <html:submit property="action" value="Modificar" styleClass="btn btn-outline-danger"/>
                                            </td>
                                        </html:form>
                                    </tr>
                                </logic:iterate>
                            </logic:notEmpty>
                        </tbody>
                    </table>
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <font color="#3b044c" size="5"><bean:write name="MedicosActionForm" property="mensaje"/></font>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </center>
</body>
</html>
