<%-- 
    Document   : editarInfo_medico
    Created on : 08-28-2018, 02:20:24 PM
    Author     : Admin123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Actualizacion Medicos</title>
    </head>
    <body style=" background-image: url(WEB-IMG/fondo1.png)">
        <div class="container">
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
            <br>
            <br>
            <center> 
                <font color="#ffffff" size="30">Actualizar Medicos</font>
                <html:form action="/medicosMantenimiento">

                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-6">
                            <table class="table table-striped table-dark">
                                <tbody>
                                    <tr hidden="active">
                                        <td><h4 style="color: #ff0000">ID:</h4></td>
                                        <td><html:text name="MedicosActionForm" property="idMedico"/></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">DUI:</h4></td>
                                        <td><html:text property="dui" size="15" maxlength="10"/></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Nombre:</h4></td>
                                        <td><html:text property="nombre" size="15" maxlength="100"/></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Apellido:</h4></td>
                                        <td><html:text property="apellido" size="15" maxlength="100"/></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Sexo:</h4></td>
                                        <td><html:select property="sexo">
                                                <html:option value=""></html:option>
                                                <html:option value="Masculino">Masculino</html:option>
                                                <html:option value="Femenino">Femenino</html:option>
                                            </html:select></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Tipo de Sagre:</h4></td>
                                        <td><html:select property="tipo_sangre">
                                                <html:option value=" "></html:option>
                                                <html:option value="A+">A+</html:option>
                                                <html:option value="A-">A-</html:option>
                                                <html:option value="B+">B+</html:option>
                                                <html:option value="B-">B-</html:option>
                                                <html:option value="O+">O+</html:option>
                                                <html:option value="O-">O-</html:option>
                                                <html:option value="AB+">AB+</html:option>
                                                <html:option value="AB-">AB-</html:option>
                                            </html:select></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Telefono:</h4></td>
                                        <td><html:text property="telefono" size="15" maxlength="9"/></td>
                                    </tr>
                                    <tr>
                                        <td><h4 style="color: #ff0000">Contacto:</h4></td>
                                        <td><html:text property="contacto" size="15" maxlength="50"/></td>
                                    </tr>
                                </tbody>
                            </table>
                            <br>
                            <html:submit property="action" value="Actualizar" styleClass="btn btn-outline-danger"/><br>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>
                                            <font color="#3b044c" size="4"><bean:write name="MedicosActionForm" property="mensaje"/></font>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                                        
                </html:form> 
            </center>
        </div>

    </body>
</html>
