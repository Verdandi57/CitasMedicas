/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.mantenimiento;

import hibernate.persistencia.Consultorios;

/**
 *
 * @author diego.rodriguezUSAM
 */
public class pruevas {

    public static void main(String[] args) {
        ConsultorioMantenimiento ma = new ConsultorioMantenimiento();
        Consultorios cons = new Consultorios();

        cons.setIdConsultorio(0);
        cons.setNombre("");
        cons.setUbicacion("");
        cons.setTelefono("");

//        guardar consultorio
//        if (ma.saveRooms(cons)) {
//            System.out.println("Guardado");
//        } else {
//            System.out.println("No guardado");
//        }
//        consulta Consultorio ID
//        System.out.println(ma.checkRoom(cons.getIdConsultorio()).toString());
        //consultar Consultorios
//        Iterator iter = ma.checkAllRooms().iterator();
//        while (iter.hasNext()) {            
//            System.out.println(iter.next());
//        }
        //modificar consultorio
//        if (ma.updateRoom(cons)) {
//            System.out.println("Modificado");
//        } else {
//            System.out.println("No modificado");
//        }
        //eliminar consultorio
//        if (ma.deleteRoom(cons.getIdConsultorio())) {
//            System.out.println("Eliminado");
//        } else {
//            System.out.println("No se pudo eliminar");
//        }
    }
}
