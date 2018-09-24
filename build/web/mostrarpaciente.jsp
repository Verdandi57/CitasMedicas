<%-- 
    Document   : mostrarpaciente
    Created on : 09-07-2018, 03:43:52 PM
    Author     : cristian.martinez
--%>


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
        <title>Lista Pacientes</title>
    </head>
    <body style=" background-color:  #007bff">
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
                                    <button class="btn btn-sm btn-outline-primary my-2 my-sm-0 "" onclick="document.getElementById('id01').style.display = 'block'">Iniciar sesion</button>  
                                </form>
                            </td>
                            <td> </td>
                            <td>
                                <html:form action="/cerrarSesion">
                                    <html:submit property="action" value="Cerrar sesion" styleClass="btn btn-sm btn-outline-secondary"></html:submit>
                                </html:form>
                            </td>
                        </tr>
                    </table>
                </div>
            </nav>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped table-info">
                        <thead>
                            <tr>
                                <td>N° de Paciente</td>
                                <td>DUI</td>
                                <td>Apellido</td>
                                <td>Nombre</td>
                                <td>fecha de Nacimiento</td>
                                <td>Sexo</td>
                                <td>Tipo de Sangre</td>
                                <td>Telefono</td>
                                <td>Direccion</td>
                                <td>Contacto</td>
                                <td>Editar</td>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="PacientesActionForm" property="listaPacientes">
                                <logic:iterate id="ver" name="PacientesActionForm" property="listaPacientes">
                                    <tr>
                                        <html:form action="/PacientesAction">
                                            <td>
                                    <center>
                                        <bean:write name="ver" property="idPaciente"/> 
                                        <div hidden="active">
                                            <html:text name="ver" property="idPaciente"/> 
                                        </div>
                                    </center>
                                    </td> 
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="dui"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="apellido"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="nombre"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="fechaNacimiento"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="sexo"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="tipoSangre"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="telefono"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="direccion"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <bean:write name="ver" property="contacto"/>
                                    </center>
                                    </td>
                                    <td>
                                    <center>
                                        <html:submit styleClass="btn btn-success" property="action" value="Modificar"/>
                                    </center>
                                    </td>
                                </html:form>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

