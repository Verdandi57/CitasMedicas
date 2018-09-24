<%-- 
    Document   : modificar
    Created on : 09-14-2018, 01:55:16 PM
    Author     : cristian.martinez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Actualizacion Paciente</title>
    </head>
    <body style="background-image: url('WEB-IMG/wallpaper1.jpg'); background-repeat: no-repeat; background-size: cover;">
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
    <center>
        <html:form action="/PacientesAction">

            <h1 style="font:'';color: #99ff33"><center>Actualizacion Paciente</center></h1>
            <h1 style="font:'';color: #99ff33"><p><center>Favor llenar Formulario</center></p></h1>
            <table border="1" style="border-color: #ffcccc">
                <tbody>
                    <tr hidden="">
                        <td>id:</td>
                        <td><html:text name="PacientesActionForm" property="idPaciente"/></td>
                    </tr>
                    <tr>
                        <td>Dui:</td>
                        <td><html:text name="PacientesActionForm" property="dui" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>Apellido:</td>
                        <td><html:text name="PacientesActionForm" property="apellido" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><html:text name="PacientesActionForm" property="nombre" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>fecha Nacimiento:</td>
                        <td><html:text name="PacientesActionForm" property="fecha_nacimiento" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>Sexo:</td>
                        <td><html:text name="PacientesActionForm" property="sexo" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>tipo de sangre:</td>
                        <td><html:text name="PacientesActionForm" property="tipo_sangre" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>telefono:</td>
                        <td><html:text name="PacientesActionForm" property="telefono" size="12" maxlength="10"/></td>
                    </tr>
                    <tr>
                        <td>Contacto:</td>
                        <td><html:text property="contacto" size="12" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td>Direccion:</td>
                        <td><html:text name="PacientesActionForm" property="direccion" size="12" maxlength="200"/></td>
                    </tr>
                    <tr>
                    </tr>
                </tbody>
            </table>
            <html:submit property="action" value="Actualizar"  style="font-size : 10pt ; color : green"/>
            <br>
        </html:form>
    </center>
    <center>    
        <br><b><bean:write name="PacientesActionForm" property="mensaje" filter="false"/></b>
    </center>
    <br>
</body>
</html>

