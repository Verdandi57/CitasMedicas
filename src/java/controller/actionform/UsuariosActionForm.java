/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actionform;

import hibernate.persistencia.Usuarios;
import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts.action.ActionErrors;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

/**
 *
 * @author julio.benavidesusam
 */
public class UsuariosActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer idUsuario;
    private String usuario;
    private String clave;
    private String nivelAcceso;    
    private String action;    
    private String mensaje;    
    private List<Usuarios> listaUsuarios;    
    private boolean error;
    
    /**
     * @return
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * @param idUsuario 
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * @return
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * @return
     */
    public String getClave() {
        return clave;
    }
    
    /**
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * @return
     */
    public String getNivelAcceso() {
        return nivelAcceso;
    }
    
    /**
     * @param nivelAcceso 
     */
    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
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
    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }
    
    /**
     * @param listaUsuarios 
     */
    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    /**
     * @return
     */
    public boolean isError() {
        return error;
    }
    
    /**
     * @param error 
     */
    public void setError(boolean error) {
        this.error = error;
    }
    
//    public UsuariosActionForm() {
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
