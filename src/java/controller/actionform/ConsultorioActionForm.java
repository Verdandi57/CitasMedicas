/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actionform;

import hibernate.persistencia.Consultorios;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin116
 */
public class ConsultorioActionForm extends org.apache.struts.action.ActionForm {

    private Integer idConsultorio;
        private List<Consultorios> allRooms;
    private String nombre, ubicacion, telefono, action, mensaje;
    private Set citases = new HashSet(0);

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set getCitases() {
        return citases;
    }

    public void setCitases(Set citases) {
        this.citases = citases;
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

    public List<Consultorios> getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(List<Consultorios> allRooms) {
        this.allRooms = allRooms;
    }

}
