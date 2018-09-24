package hibernate.persistencia;
// Generated 08-21-2018 04:31:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Medicos generated by hbm2java
 */
public class Medicos  implements java.io.Serializable {


     private Integer idMedico;
     private String dui;
     private String apellido;
     private String nombre;
     private String sexo;
     private String tipoSangre;
     private String telefono;
     private String contacto;
     private Set citases = new HashSet(0);
     private Set especialidadeses = new HashSet(0);

    public Medicos() {
    }

    public Medicos(String dui, String apellido, String nombre, String sexo, String tipoSangre, String telefono, String contacto, Set citases, Set especialidadeses) {
       this.dui = dui;
       this.apellido = apellido;
       this.nombre = nombre;
       this.sexo = sexo;
       this.tipoSangre = tipoSangre;
       this.telefono = telefono;
       this.contacto = contacto;
       this.citases = citases;
       this.especialidadeses = especialidadeses;
    }
   
    public Integer getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
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
    public Set getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set citases) {
        this.citases = citases;
    }
    public Set getEspecialidadeses() {
        return this.especialidadeses;
    }
    
    public void setEspecialidadeses(Set especialidadeses) {
        this.especialidadeses = especialidadeses;
    }




}

