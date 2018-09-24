
package controller.actionform;

import hibernate.persistencia.Pacientes;
import java.util.List;


public class PacientesActionForm  extends org.apache.struts.action.ActionForm{
    
    private int idPaciente;
    private String dui;
    private String apellido;
    private String nombre;
    private String fecha_nacimiento;
    private String sexo;
    private String tipo_sangre;
    private String telefono;
    private String contacto;
    private String direccion;
    private String action;
    private String mensaje;
    private List<Pacientes> listaPacientes;
    private boolean error;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int id_paciente) {
        this.idPaciente = id_paciente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Pacientes> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Pacientes> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
}
