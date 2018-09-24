/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actionform;

//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts.action.ActionErrors;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Admin123
 */
public class LoginActionForm extends org.apache.struts.action.ActionForm {
    
    private int id_usuario;
    private String usuario;
    private String clave;
    private String nivel_acceso;
    private String action;
    private String error;
    
    /**
     * @return 
     */
    public int getId_usuario() {
        return id_usuario;
    }
    
    /**
     * @param id_usuario 
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
    public String getNivel_acceso() {
        return nivel_acceso;
    }
    
    /**
     * @param nivel_acceso 
     */
    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
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
    public String getError() {
        return action;
    }
    
    /**
     * @param error  
     */
    public void setError(String error) {
        this.action = error;
    }
    
    
    /**
     *
     */
//    public LoginActionForm() {
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
//            // TODO: add 'error.usuario.required' key to your resources
//        }
//        return errors;
//    }
}
