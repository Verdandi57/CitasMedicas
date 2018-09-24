/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import controller.actionform.UsuariosActionForm;
import hibernate.mantenimiento.UsuariosMantenimiento;
import hibernate.persistencia.Usuarios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author julio.benavidesusam
 */
public class UsuariosAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String result_userform = "result_userform";
    private static final String show_users = "show_users";
    private static final String edit_user = "edit_user";
    private static final String delete_user = "delete_user";
    private static final String error = "error";

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

        UsuariosActionForm formBean = (UsuariosActionForm) form;
        UsuariosMantenimiento mantenimiento = new UsuariosMantenimiento();
        Usuarios usuarios = new Usuarios();

        formBean.setMensaje(null);
        if (LoginAction.pass == null) {
            formBean.setMensaje("Error");
            return mapping.findForward(error);
        }

        switch (formBean.getAction()) {
            case "Agregar usuario":
                if (LoginAction.pass.equals("Administrador")) {
                    if (!(formBean.getUsuario() == null || formBean.getUsuario().equals("")
                            || formBean.getClave() == null || formBean.getClave().equals("")
                            || formBean.getNivelAcceso() == null || formBean.getNivelAcceso().equals(""))) {
                        List<Usuarios> checkusers = mantenimiento.checkAllUsers();
                        boolean equal = false;
                        for (Usuarios norepeat : checkusers) {
                            if (formBean.getUsuario().equals(norepeat.getUsuario())) {
                                formBean.setMensaje("El nombre de usuario ya esta en uso.\n Use otro nombre de usuario");
                                return mapping.findForward(result_userform);
                            } else {
                                equal = true;
                            }
                        }
                        if (equal) {
                            usuarios.setIdUsuario(0);
                            usuarios.setUsuario(formBean.getUsuario());
                            usuarios.setClave(formBean.getClave());
                            usuarios.setNivelAcceso(formBean.getNivelAcceso());
                            if (mantenimiento.saveUser(usuarios)) {
                                formBean.setMensaje("Un nuevo usuario fue agregado al registro");
                                if (formBean.getMensaje() != null) {
                                    return mapping.findForward(result_userform);
                                }
                            } else {
                                formBean.setMensaje("Error: El usuario no pudo ser agregado al registro");
                                if (formBean.getMensaje() != null) {
                                    return mapping.findForward(result_userform);
                                }
                            }
                        }
                    } else {
                        formBean.setMensaje("Complete todos los campos para realizar el registro del usuario");
                    }
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");

                }
                if (formBean.getMensaje() != null) {
                    return mapping.findForward(result_userform);
                }
                break;
            case "Ver todos":
                if (LoginAction.pass.equals("Administrador")) {
                    formBean.setListaUsuarios(mantenimiento.checkAllUsers());
                    return mapping.findForward(show_users);
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "Guardar cambios":
                if (LoginAction.pass.equals("Administrador")) {
                    if (!(formBean.getUsuario() == null || formBean.getUsuario().equals("")
                            || formBean.getClave() == null|| formBean.getClave().equals("")
                            || formBean.getNivelAcceso() == null || formBean.getNivelAcceso().equals(""))) {
                        List<Usuarios> checkusers = mantenimiento.checkAllUsers();
                        boolean equal = false;
                        for (Usuarios norepeat : checkusers) {
                            if (formBean.getUsuario().equals(norepeat.getUsuario())) {
                                formBean.setMensaje("El nombre de usuario ya esta en uso.\n Use otro nombre de usuario");
                                return mapping.findForward(result_userform);
                            } else {
                                equal = true;
                            }
                        }
                        if (equal) {
                            usuarios.setIdUsuario(formBean.getIdUsuario());
                            usuarios.setUsuario(formBean.getUsuario());
                            usuarios.setClave(formBean.getClave());
                            usuarios.setNivelAcceso(formBean.getNivelAcceso());
                            if (mantenimiento.updateUser(usuarios)) {
                                formBean.setMensaje("La informacion del usuario fue editada correctamente");
                                if (formBean.getMensaje() != null) {
                                    return mapping.findForward(result_userform);
                                }
                            } else {
                                formBean.setMensaje("Error: no se pudo editar los datos del usuario");
                                if (formBean.getMensaje() != null) {
                                    return mapping.findForward(result_userform);
                                }
                            }
                        }
                    } else {
                        formBean.setMensaje("Complete todos los campos para guardar los cambios hechos al usuario");
                    }
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");

                }
                if (formBean.getMensaje() != null) {
                    return mapping.findForward(result_userform);
                }
//                if (LoginAction.pass.equals("Administrador")) {
//                    if (!(formBean.getUsuario().equals("") || formBean.getUsuario() == null
//                            || formBean.getClave().equals("") || formBean.getClave() == null
//                            || formBean.getNivelAcceso().equals("") || formBean.getNivelAcceso() == null)) {
//                        usuarios.setIdUsuario(formBean.getIdUsuario());
//                        usuarios.setUsuario(formBean.getUsuario());
//                        usuarios.setClave(formBean.getClave());
//                        usuarios.setNivelAcceso(formBean.getNivelAcceso());
//                        if (mantenimiento.updateUser(usuarios)) {
//                            formBean.setMensaje("La informacion del usuario fue editada");
//                        } else {
//                            formBean.setMensaje("Error: no se pudo editar los datos del usuario");
//                        }
//                    } else {
//                        formBean.setMensaje("Complete todos los campos para realizar los cambios al usuario");
//                    }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
//                if (formBean.getMensaje() != null) {
//                    return mapping.findForward(edit_user);
//                }
                break;
            case "Borrar":
                if (LoginAction.pass.equals("Administrador")) {
                    if (mantenimiento.deleteUser(formBean.getIdUsuario())) {
                        formBean.setMensaje("Un usuario fue eliminado");
                        formBean.setListaUsuarios(mantenimiento.checkAllUsers());
                        return mapping.findForward(show_users);
                    } else {
                        formBean.setMensaje("Error: no se pudo eliminar usuario");
                    }
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "Editar":
                if (LoginAction.pass.equals("Administrador")) {
                    Usuarios usuario = mantenimiento.checkUser(formBean.getIdUsuario());
                    formBean.setIdUsuario(usuario.getIdUsuario());
                    formBean.setUsuario(usuario.getUsuario());
                    formBean.setClave(usuario.getClave());
                    formBean.setNivelAcceso(usuario.getNivelAcceso());
                    return mapping.findForward(edit_user);
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "Nuevo usuario":
                if (LoginAction.pass != null && LoginAction.pass.equals("Administrador")) {
                    formBean.setIdUsuario(0);
                    formBean.setUsuario("");
                    formBean.setClave("");
                    formBean.setNivelAcceso("");
                    formBean.setMensaje("Todos los campos son requeridos");
                    return mapping.findForward(result_userform);
                } else {
                    formBean.setMensaje("Debe iniciar session como administrador");
                }
                break;
        }

        if (formBean.getMensaje() == null) {
            formBean.setMensaje("Error, no se pudo realizar acción " + "Nivel usuario = " + LoginAction.pass + "\nAction = " + formBean.getAction());
        }

        return mapping.findForward(error);

    }
}
