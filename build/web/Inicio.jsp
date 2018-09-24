<%-- 
    Document   : Inicio
    Created on : 08-22-2018, 08:51:13 AM
    Author     : Admin123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/login.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/login.js" type="text/javascript"></script>
        <title>Inicio</title>
    </head>
    <body onload="document.getElementById('id01').style.display = 'block'">
        <div class="container-fluid">
            <div id="id01" class="modal">
                <html:form styleClass="modal-content animate" action="/inicioSesion">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                        <img src="WEB-IMG/Key-icon.png" alt="Key" class="avatar">
                    </div>

                    <div class="container">
                        <label for="usuario"><b>Nombre de usuario</b></label>
                        <html:text property="usuario" size="" maxlength=""/>
                        <label for="clave"><b>Contraseña</b></label>
                        <html:password property="clave"/>
                        <html:submit property="action" value="Iniciar sesion" styleClass="btn-success form-control"/>
                    </div>

                    <div class="container" style="background-color:#f1f1f1">
                        <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Cancelar</button>
                        <span class="psw">Forgot <a href="#">password?</a></span>
                    </div>
                    <bean:write name="LoginActionForm" property="error" filter="false"/>
                </html:form>
            </div>

            <%--
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modal Heading</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <html:form action="/inicioSesion">
                                <table border="0">
                                    <tbody>
                                        <tr>
                                            <td>Usuario: </td>
                                            <td><html:text property="" size="" maxlength=""></html:text></td>
                                            </tr>
                                            <tr>
                                                <td>Contraseña: </td>
                                                <td><html:text property="" size="" maxlength=""></html:text></td>
                                            </tr>
                                            <tr colspan="2">
                                            <bean:write name="/LoginActionForm" property="" filter="false"/>
                                        </tr>
                                    </tbody>
                                </table>
                                <html:submit property="action" value="login"/>
                            </html:form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                    
                </div>
            </div>
            --%>
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
            <div>

            </div>
        </div>
    </body>
</html>
