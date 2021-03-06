package hibernate.persistencia;
// Generated 08-21-2018 04:31:34 PM by Hibernate Tools 4.3.1



/**
 * Citas generated by hbm2java
 */
public class Citas  implements java.io.Serializable {


     private Integer idCita;
     private Consultorios consultorios;
     private Medicos medicos;
     private Pacientes pacientes;
     private String fechaCita;
     private String horaCita;

    public Citas() {
    }

    public Citas(Consultorios consultorios, Medicos medicos, Pacientes pacientes, String fechaCita, String horaCita) {
       this.consultorios = consultorios;
       this.medicos = medicos;
       this.pacientes = pacientes;
       this.fechaCita = fechaCita;
       this.horaCita = horaCita;
    }
   
    public Integer getIdCita() {
        return this.idCita;
    }
    
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    public Consultorios getConsultorios() {
        return this.consultorios;
    }
    
    public void setConsultorios(Consultorios consultorios) {
        this.consultorios = consultorios;
    }
    public Medicos getMedicos() {
        return this.medicos;
    }
    
    public void setMedicos(Medicos medicos) {
        this.medicos = medicos;
    }
    public Pacientes getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }
    public String getFechaCita() {
        return this.fechaCita;
    }
    
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
    public String getHoraCita() {
        return this.horaCita;
    }
    
    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }




}


