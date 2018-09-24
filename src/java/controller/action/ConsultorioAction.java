/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import controller.actionform.ConsultorioActionForm;
import hibernate.mantenimiento.ConsultorioMantenimiento;
import hibernate.persistencia.Consultorios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Admin116
 */
public class ConsultorioAction extends org.apache.struts.action.Action {

    private static final String result = "set";
    private static final String consultar = "consultar";
    private static final String get = "get";
    private static final String fallar = "fallar";
    private static final String also = "also";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ConsultorioActionForm conaf = (ConsultorioActionForm) form;
        ConsultorioMantenimiento man = new ConsultorioMantenimiento();
        Consultorios con = new Consultorios();
        List<Consultorios> all;

        switch (conaf.getAction()) {
            case "Agregar":
                if (LoginAction.pass.equals("Administrador")) {
                    if ((conaf.getNombre().equals("") || conaf.getNombre() == null || conaf.getUbicacion().equals("")
                            || conaf.getUbicacion() == null || conaf.getTelefono().equals("") || conaf.getTelefono() == null)) {
                        conaf.setMensaje("Error:complete todods los campos para poder Ingresarlo");
                    } else {
                        con.setIdConsultorio(0);
                        con.setNombre(conaf.getNombre());
                        con.setUbicacion(conaf.getUbicacion());
                        con.setTelefono(conaf.getTelefono());
                        if (man.saveRooms(con)) {
                            conaf.setMensaje("Exito: El Consultorio Fue Agregado Exitosamente.");
                            all = man.allRooms();
                            conaf.setAllRooms(all);
                            if (conaf.getMensaje() != null) {
                                return mapping.findForward(consultar);
                            }
                        } else {
                            conaf.setMensaje("Error: El Consultorio no pudo ser Ingresado.");
                            return mapping.findForward(result);
                        }
                    }
                } else {
                    conaf.setMensaje("No Puede Ingresar nuevo consultorio");
                }
                if (conaf.getMensaje() != null) {
                    return mapping.findForward(result);
                }
                break;
//----------------------------------------------------------------------------------- 
            case "direccion":
                                if (LoginAction.pass.equals("Administrador")) {

                if (conaf.getMensaje() == null) {
                    return mapping.findForward(result);
                    } else {
                    conaf.setMensaje("No Puede Ingresar nuevo consultorio");
                }
                }
                break;
//-----------------------------------------------------------------------------------                
            case "Mostrar Listado":
                if (LoginAction.pass.equals("Administrador")) {
                    all = man.allRooms();
                    conaf.setAllRooms(all);
                    if (conaf.getMensaje() == null) {
                        return mapping.findForward(consultar);
                    }
                } else {
                    conaf.setMensaje("No Tienes Permiso Para realizar esta Accion");
                }
                break;
//-----------------------------------------------------------------------------------                
            case "Modificar":
                if (LoginAction.pass.equals("Administrador")) {
                    con = man.checkRoom(conaf.getIdConsultorio());
                    conaf.setIdConsultorio(con.getIdConsultorio());
                    conaf.setNombre(con.getNombre());
                    conaf.setUbicacion(con.getUbicacion());
                    conaf.setTelefono(con.getTelefono());
//                System.out.println(con.getIdConsultorio());
//                System.out.println(con.getNombre());
//                System.out.println(con.getUbicacion());
//                System.out.println(con.getTelefono());
                    if (conaf.getMensaje() == null) {
                        return mapping.findForward(get);
                    }
                } else {
                    conaf.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
//-----------------------------------------------------------------------------------                
            case "Actualizar":
                if (LoginAction.pass.equals("Administrador")) {
                    if (conaf.getNombre().equals("") || conaf.getNombre() == null
                            || conaf.getUbicacion().equals("") || conaf.getUbicacion() == null
                            || conaf.getTelefono().equals("") || conaf.getTelefono() == null) {
                        conaf.setMensaje("complete todods los campos para poder Ingresarlo");
                        return mapping.findForward(also);
                    } else {
                        con.setIdConsultorio(conaf.getIdConsultorio());
                        con.setNombre(conaf.getNombre());
                        con.setUbicacion(conaf.getUbicacion());
                        con.setTelefono(conaf.getTelefono());
                        if (man.updateRoom(con)) {
                            conaf.setMensaje("El Consultorio Fue Editado Exitosamente.");
                            all = man.allRooms();
                            conaf.setAllRooms(all);
                            if (conaf.getMensaje() != null) {
                                return mapping.findForward(consultar);
                            }
                            return mapping.findForward("Mostrar Listado");
                        } else {
                            conaf.setMensaje("Error: El Consultorio no pudo ser Editado.");
                        }
                    }
                } else {
                    conaf.setMensaje("No Puede Ingresar nuevo consultorio");
                }
                if (conaf.getMensaje() == null) {
                    return mapping.findForward(fallar);
                }
                break;
//-----------------------------------------------------------------------------------                
            case "Eliminar":
                if (LoginAction.pass.equals("Administrador")) {
                    man.deleteRoom(conaf.getIdConsultorio());
                    conaf.setMensaje("Consultorio Eliminado");
                    all = man.allRooms();
                    conaf.setAllRooms(all);
                    if (conaf.getMensaje() != null) {
                        return mapping.findForward(consultar);
                    }
                } else {
                    conaf.setMensaje("No Puede Ingresar nuevo consultorio");
                }

                break;
        }
        conaf.setMensaje("A ocurrido un error");
        return mapping.findForward(fallar);
    }

}
