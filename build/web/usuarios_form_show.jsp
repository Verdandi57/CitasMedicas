<%-- 
    Document   : usuarios_form
    Created on : 09-03-2018, 08:49:20 AM
    Author     : julio.benavidesusam
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
        <style>body, html {
                height: 100%;
            }

            .bg {
                /* The image used */
                background-image: url("WEB-IMG/Estetoscopio, herramienta de la medicina 3840x2160 UHD 4K Fondos de pantalla [es.best-wallpaper.net].jpg");

                /* Full height */
                height: 100%;

                /* Center and scale the image nicely */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }</style>
        <script>
            function showpassword() {
                var password = document.getElementById("userpassword");
                if (password.style.display === "none") {
                    password.style.display = "block";
                } else {
                    password.style.display = "none"
                }
            }
        </script>
        <title>Usuarios form</title>
    </head>
    <body>
        <div class="container-fluid bg">
            <div class="row">
                <div class="col-12">
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
                </div>
            </div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <table class="table table-light">
                        <thead>
                            <tr style="text-align: center">
                                <th hidden="hidden">ID usuario</th>
                                <th>Usuario</th>
                                <th>Contraseña</th>
                                <th>Nivel de acceso</th>
                                <th> </th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="UsuariosActionForm" property="listaUsuarios">
                                <logic:iterate id="ver" name="UsuariosActionForm" property="listaUsuarios">
                                    <tr>
                                        <html:form action="/usuariosEditDelete">
                                            <td hidden="hidden"><html:text name="ver" property="idUsuario"/></td>
                                            <td><bean:write name="ver" property="usuario"/></td>
                                            <td style="text-align: center"><html:password name="ver" property="clave"/></td>
                                            <td><bean:write name="ver" property="nivelAcceso"/></td>
                                            <td><html:submit property="action" value="Editar" styleClass="btn btn-outline-warning btn-sm"/></td>
                                            <td><html:submit property="action" value="Borrar" styleClass="btn btn-outline-danger btn-sm" onclick="return confirm('El usuario sera borrado permanentemente\n¿Esta seguro de continuar?')"/></td>
                                        </html:form>
                                    </tr>
                                </logic:iterate>
                            </logic:notEmpty>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td>
                                    <div class="alert alert-danger"><bean:write name="UsuariosActionForm" property="mensaje"/></div>
                                </td> 
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="col-2"></div>
            </div>
        </div>
    </body>
</html>
