/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import controller.actionform.LoginActionForm;
import hibernate.mantenimiento.UsuariosMantenimiento;
import hibernate.persistencia.Usuarios;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Admin123
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    static String pass = null;
    private String message;
    private static final String system = "Administrador";
    private static final String doctor = "Medico";
//    private static final String paciente = "paciente";
    private static final String ERROR = "error";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginActionForm formBean = (LoginActionForm) form;
        UsuariosMantenimiento mantenimiento = new UsuariosMantenimiento();

        switch (formBean.getAction()) {
            case "Iniciar sesion":
                List<Usuarios> allusers = mantenimiento.checkAllUsers();
                if (formBean.getUsuario() == null || formBean.getUsuario().equals("") || formBean.getClave().equals("") || formBean.getClave() == null) {
                    formBean.setError("Falta usuario y/o contraseña");
                    return mapping.findForward(ERROR);
                } else {
                    allusers.stream().filter((usuario) -> (usuario.getUsuario().equals(formBean.getUsuario()) && usuario.getClave().equals(formBean.getClave()))).forEachOrdered((usuario) -> {
                        pass = usuario.getNivelAcceso();
                    });
                    if (pass == null) {
                        formBean.setError("No se encontro el usuario / Usuario o contraseña incorrecta");
                        return mapping.findForward(ERROR);
                    }
                    if (pass.equals("Administrador")) {
                        return mapping.findForward(system);
                    }
                    if (pass.equals("Medico")) {
                        return mapping.findForward(doctor);
                    }
//                    if (pass.equals("User")) {
//                        return mapping.findForward(paciente);
//                    }
                }
                break;
            case "Cerrar sesion":
                if (pass != null) {
                    pass = null;
                    return mapping.findForward(ERROR);
                }
                break;
        }

        /*-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------_-------*/
//        switch (formBean.getAction()) {
//            case "Iniciar sesion":
//                List<Usuarios> allusers = mantenimiento.checkAllUsers();
//                if ((formBean.getUsuario() == null || formBean.getUsuario().equals("")) || (formBean.getClave() == null || formBean.getClave().equals(""))) {
//                    message = "Error, complete los campos usuario y contraseña";
//                    formBean.setError(message);
//                    return mapping.findForward(ERROR);
//                } else {
//                    allusers.forEach((userslist) -> {
//                        if (userslist.getUsuario().equals(formBean.getUsuario()) && userslist.getClave().equals(formBean.getClave())) {
//                            pass = userslist.getNivelAcceso();
//                        }
////                        else {
////                            message = "Usuario no encontrado";
////                            formBean.setError(message);                            
////                            //return mapping.findForward(ERROR);
////                        }
//                    });
//                    if (pass == null) {
//                        formBean.setError("USUARIO NO ENCONTRADO");
//                        return mapping.findForward(ERROR);
//                    }
//
//                }
//                if (pass.equals("System")) {
//                    return mapping.findForward(system);
//                }
//                if (pass.equals("Administrador")) {
//                    return mapping.findForward(doctor);
//                }
//                if (true) {
//                    return mapping.findForward(ERROR);
//                }
//                break;
//            case "":
//                break;
//        }
        formBean.setError("Error desconocido");
        return mapping.findForward(ERROR);
    }
}
