<%-- 
   Document   : main_menu
   Created on : 08-30-2018, 04:40:08 PM
   Author     : julio.benavidesusam
--%>

<%@page import="controller.action.LoginAction"%>
<%@page import="controller.actionform.LoginActionForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

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
        <title>Menú principal</title>
    </head>
    <body>
        <div class="container-fluid bg">
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
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8 form-control">
                    <br/>
                    <h2 style="text-align: center">Administración</h2>
                    <br/>
                    <br/>
                    <h5>Gestion de</h5>
                    <ul>
                        <li><a class="btn btn-link" href="usuarios_menu.jsp">Usuarios</a></li>
                        <li><a class="btn btn-link" href="MedicoMenu.jsp">Medicos</a></li>
                        <li><a class="btn btn-link" href="especialidadesMenu.jsp">Especialidades</a></li>
                        <li><a class="btn btn-link" href="consultorioMenu.jsp">Consultorios</a></li>
                        <li><a class="btn btn-link" href="pacientesMenu.jsp">Pacientes</a></li>
                    </ul>
                </div>
                <div class="col-2"></div>
            </div>
        </div>
    </body>
</html>
