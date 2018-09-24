<%-- 
    Document   : consultoriomod
    Created on : 09-07-2018, 11:49:27 AM
    Author     : diego.rodriguezUSAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="bootstrap/css/Style.css" rel="stylesheet" type="text/css"/>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="bootstrap/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/popper.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
    <body class="jumbotron-fluid">
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
                    <html:link action="/ConsultorioAction.do?action=Mostrar Listado" styleClass="btn btn-outline-success">Atras</html:link>
                        <tr>
                            <td>
                                <form class="form-inline my-2 my-lg-0">
                                    <button class="btn btn-sm btn-outline-primary my-2 my-sm-0" onclick="document.getElementById('id01').style.display = 'block'">Iniciar sesion</button>  
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
        <font color="#3b044c" size="30">Actualizar Consultorio</font>
        <html:form action="/ConsultorioAction">
            <div class="card-body">
                <div>
                    <div hidden="">
                        <html:text name="ConsultorioActionForm" property="idConsultorio"/>
                    </div>
                    <br>
                    <font color="#3b044c" size="6">Nombre: </font>
                    <html:text property="nombre" size="20" maxlength="50"/>
                    <br>
                    <font color="#3b044c" size="6">Ubicacion: </font>
                    <html:text property="ubicacion" size="20" maxlength="100"/>
                    <br>
                    <font color="#3b044c" size="6">Telefono: </font>
                    <html:text property="telefono" size="20" maxlength="13"/>
                    <br>
                    <html:submit property="action" value="Actualizar" styleClass="btn btn-outline-success" />
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <font color="#3b044c" size="4"><bean:write name="ConsultorioActionForm" property="mensaje"/></font>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </html:form>
    </center>
</body>
</html>
