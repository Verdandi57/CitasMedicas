/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actionform;

import hibernate.persistencia.Citas;
import hibernate.persistencia.Consultorios;
import hibernate.persistencia.Medicos;
import hibernate.persistencia.Pacientes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author julio.benavidesusam
 */
public class CitasActionForm extends org.apache.struts.action.ActionForm {
    
    private int idCita;
    private String fechaCita;
    private String horaCita;
    private Pacientes paciente;
    private Medicos medico;
    private Consultorios consultorio;
    private String action;
    private String mensaje;
    private List<Medicos> listamedicos;
    private List<Pacientes> listapacientes;
    private List<Consultorios> listaconsultorios;
    private List<Citas> listaCitas;

    /**
     * @return
     */
    public int getIdCita() {
        return idCita;
    }
    
    /**
     * @param idCita 
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * @return
     */
    public String getFechaCita() {
        return fechaCita;
    }
    
    /**
     * @param fechaCita 
     */
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    /**
     * @return
     */
    public String getHoraCita() {
        return horaCita;
    }
    
    /**
     * @param horaCita 
     */
    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    /**
     * @return
     */
    public Pacientes getPaciente() {
        return paciente;
    }
    
    /**
     * @param paciente 
     */
    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    /**
     * @return
     */
    public Medicos getMedico() {
        return medico;
    }
    
    /**
     * @param medico 
     */
    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    /**
     * @return
     */
    public Consultorios getConsultorio() {
        return consultorio;
    }
    
    /**
     * @param consultorio 
     */
    public void setConsultorio(Consultorios consultorio) {
        this.consultorio = consultorio;
    }

    /**
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }
    
    /**
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return
     */
    public String getAction() {
        return action;
    }
    
    /**
     * @param action 
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return
     */
    public List<Medicos> getListamedicos() {
        return listamedicos;
    }
    
    /**
     * @param listamedicos 
     */
    public void setListamedicos(List<Medicos> listamedicos) {
        this.listamedicos = listamedicos;
    }

    /**
     * @return
     */
    public List<Pacientes> getListapacientes() {
        return listapacientes;
    }
    
    /**
     * @param listapacientes  
     */
    public void setListapacientes(List<Pacientes> listapacientes) {
        this.listapacientes = listapacientes;
    }

    /**
     * @return
     */
    public List<Consultorios> getListaconsultorios() {
        return listaconsultorios;
    }
    
    /**
     * @param listaconsultorios 
     */
    public void setListaconsultorios(List<Consultorios> listaconsultorios) {
        this.listaconsultorios = listaconsultorios;
    }

    /**
     * @return
     */
    public List<Citas> getListaCitas() {
        return listaCitas;
    }
    
    /**
     * @param listaCitas 
     */
    public void setListaCitas(List<Citas> listaCitas) {
        this.listaCitas = listaCitas;
    }
    
    

    /**
     *
     */
//    public CitasActionForm() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
//        return errors;
//    }
}
