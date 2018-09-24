/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import controller.actionform.CitasActionForm;
import hibernate.mantenimiento.CitasMantenimiento;
import hibernate.mantenimiento.MedicosMantenimiento;
import hibernate.mantenimiento.PacientesMantenimiento;
import hibernate.mantenimiento.ConsultorioMantenimiento;
import hibernate.persistencia.Citas;
import hibernate.persistencia.Medicos;
import hibernate.persistencia.Pacientes;
import hibernate.persistencia.Consultorios;
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
public class CitasAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String resul_citas = "resul_citas";
    private static final String show_citas = "show_citas";
    private static final String edit_citas = "edit_citas";
    private static final String error_citas = "error_citas";

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
        CitasActionForm formBean = (CitasActionForm) form;
        CitasMantenimiento mantenimiento = new CitasMantenimiento();
        ConsultorioMantenimiento consultorioMantenimiento = new ConsultorioMantenimiento();
        Citas citas = new Citas();
        
        if (LoginAction.pass == null) {
            formBean.setMensaje("Inicie sesion para continuar");
            return mapping.findForward(error_citas);
        }
        switch (formBean.getAction()){
            case "Nueva cita":
                formBean.setListamedicos();
                formBean.setListapacientes();
                formBean.setListaconsultorios(consultorioMantenimiento.allRooms());
                if (formBean.getListamedicos() != null && formBean.getListapacientes()!= null  && formBean.getListaconsultorios()!= null ) {
                    return mapping.findForward(resul_citas);
                }
                break;
            case "Agregar cita":
                if (LoginAction.pass.equals("Administrador") || LoginAction.pass.equals("Medico")) {
                    if (!(formBean.getFechaCita() == null || formBean.getFechaCita().equals("")
                            || formBean.getHoraCita()== null || formBean.getHoraCita().equals("")
                            || formBean.getPaciente()== null 
                            || formBean.getMedico() == null 
                            || formBean.getConsultorio() == null
                            )) {
                        List<Citas> checkCitas = mantenimiento.todasCitas();
                        
                        for (Citas norepeat : checkCitas) {
                            if (norepeat.getFechaCita().equals(formBean.getFechaCita()) &&
                                    norepeat.getHoraCita().equals(formBean.getHoraCita()) &&
                                    norepeat.getMedicos().equals(formBean.getMedico())
                                    ) {
                                formBean.setMensaje("El medico ya tiene una cita asignada el "+formBean.getFechaCita()+" a las "+formBean.getHoraCita());
                                return mapping.findForward(resul_citas);
                            }
                            if (norepeat.getFechaCita().equals(formBean.getFechaCita()) &&
                                    norepeat.getHoraCita().equals(formBean.getHoraCita()) &&
                                    norepeat.getConsultorios().equals(formBean.getConsultorio())
                                    ) {
                                formBean.setMensaje("El consultorio ya esta ocupado por una cita asignada el "+formBean.getFechaCita()+" a las "+formBean.getHoraCita());
                                return mapping.findForward(resul_citas);
                            }
                            if (norepeat.getFechaCita().equals(formBean.getFechaCita()) &&
                                    norepeat.getHoraCita().equals(formBean.getHoraCita()) &&
                                    norepeat.getPacientes().equals(formBean.getPaciente())
                                    ) {
                                formBean.setMensaje("El paciente ya tiene una cita asignada el "+formBean.getFechaCita()+" a las "+formBean.getHoraCita());
                                return mapping.findForward(resul_citas);
                            }
                        }
                        citas.setIdCita(0);
                        citas.setFechaCita(formBean.getFechaCita());
                        citas.setHoraCita(formBean.getHoraCita());
                        citas.setMedicos(formBean.getMedico());
                        citas.setPacientes(formBean.getPaciente());
                        citas.setConsultorios(formBean.getConsultorio());
                        if (mantenimiento.guardarCita(citas)) {
                            formBean.setMensaje("Cita agendada");
                            return mapping.findForward(resul_citas);
                        }else{
                            formBean.setMensaje("La cita no pudo ser agendada");
                            return mapping.findForward(resul_citas);
                        }
                    } else {
                        formBean.setMensaje("Complete todos los campos para realizar el registro del usuario");
                    }
                }else{
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "Ver citas":
                if (LoginAction.pass.equals("Administrador") || LoginAction.pass.equals("Medico")) {
                    formBean.setListaCitas(mantenimiento.todasCitas());
                    return mapping.findForward(show_citas);
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "Editar":
                if (LoginAction.pass.equals("Administrador") || LoginAction.pass.equals("Medico")) {
                    
                } else {
                    formBean.setMensaje("No tiene los permisos para realizar la acción");
                }
                break;
            case "case1":
                break;
        }
        
        return mapping.findForward(error_citas);
    }
}
