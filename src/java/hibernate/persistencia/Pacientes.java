package hibernate.persistencia;
// Generated 08-21-2018 04:31:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pacientes generated by hbm2java
 */
public class Pacientes  implements java.io.Serializable {


     private Integer idPaciente;
     private String dui;
     private String apellido;
     private String nombre;
     private String fechaNacimiento;
     private String sexo;
     private String tipoSangre;
     private String telefono;
     private String contacto;
     private String direccion;
     private Set citases = new HashSet(0);

    public Pacientes() {
    }

    public Pacientes(String dui, String apellido, String nombre, String fechaNacimiento, String sexo, String tipoSangre, String telefono, String contacto, String direccion, Set citases) {
       this.dui = dui;
       this.apellido = apellido;
       this.nombre = nombre;
       this.fechaNacimiento = fechaNacimiento;
       this.sexo = sexo;
       this.tipoSangre = tipoSangre;
       this.telefono = telefono;
       this.contacto = contacto;
       this.direccion = direccion;
       this.citases = citases;
    }
   
    public Integer getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTipoSangre() {
        return this.tipoSangre;
    }
    
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set citases) {
        this.citases = citases;
    }




}


