package controller.action;

import controller.actionform.PacientesActionForm;
import hibernate.mantenimiento.PacientesMantenimiento;
import hibernate.persistencia.Pacientes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PacientesAction extends org.apache.struts.action.Action {

    private static final String add_result = "add_result";
    private static final String edit_result = "edit_result";
    private static final String consultartodo = "mostrarpaciente";
    private static final String in = "index";
    private static final String modificar = "modificar";
    private static final String ingresarpaciente = "ingresarpaciente";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PacientesActionForm formBean = (PacientesActionForm) form;
        PacientesMantenimiento manto = new PacientesMantenimiento();
        Pacientes paciente = new Pacientes();
        List<Pacientes> listaPacientes = null;

        switch (formBean.getAction()) {

            case "Agregar":
                formBean.setMensaje(null);
//                if (LoginAction.pass.equals("Administrador")) {
                if (formBean.getDui().equals("") || formBean.getDui() == null
                        || formBean.getApellido().equals("") || formBean.getApellido() == null
                        || formBean.getNombre().equals("") || formBean.getNombre() == null
                        || formBean.getFecha_nacimiento().equals("") || formBean.getFecha_nacimiento() == null
                        || formBean.getSexo().equals("") || formBean.getSexo() == null
                        || formBean.getTipo_sangre().equals("") || formBean.getTipo_sangre() == null
                        || formBean.getTelefono().equals("") || formBean.getTelefono() == null
                        || formBean.getContacto().equals("") || formBean.getContacto() == null
                        || formBean.getDireccion().equals("") || formBean.getDireccion() == null) {
                    formBean.setMensaje("Complete todos los campos para realizar el registro");

                } else {
                    paciente.setIdPaciente(0);
                    paciente.setDui(formBean.getDui());
                    paciente.setApellido(formBean.getApellido());
                    paciente.setNombre(formBean.getNombre());
                    paciente.setFechaNacimiento(formBean.getFecha_nacimiento());
                    paciente.setSexo(formBean.getSexo());
                    paciente.setTipoSangre(formBean.getTipo_sangre());
                    paciente.setTelefono(formBean.getTelefono());
                    paciente.setContacto(formBean.getContacto());
                    paciente.setDireccion(formBean.getDireccion());
                    if (manto.guardarPaciente(paciente)) {
                        formBean.setMensaje("El paciente fue agregado al registro");
                        formBean.setMensaje("La informacion del paciente fue editada");
                        listaPacientes = manto.listaPacientes();
                        formBean.setListaPacientes(listaPacientes);
                        if (formBean.getMensaje() != null) {
                            return mapping.findForward(consultartodo);
                        }
                    } else {
                        formBean.setMensaje("Error: El paciente no pudo ser agregado al registro");
                        return mapping.findForward(ingresarpaciente);
                    }
                }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                if (formBean.getMensaje() != null) {
                    return mapping.findForward(ingresarpaciente);
                }
                break;
            case "consultar todo":

                formBean.setMensaje(null);
//                if (LoginAction.pass.equals("")) {
                listaPacientes = manto.listaPacientes();
                formBean.setListaPacientes(listaPacientes);
                if (formBean.getMensaje() == null) {
                    return mapping.findForward(consultartodo);
                }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                break;
            case "Modificar":
//                if (!(LoginAction.pass.equals("Administrador"))) {
                paciente = manto.infoPaciente(formBean.getIdPaciente());
                formBean.setIdPaciente(paciente.getIdPaciente());
                formBean.setDui(paciente.getDui());
                formBean.setApellido(paciente.getApellido());
                formBean.setNombre(paciente.getNombre());
                formBean.setFecha_nacimiento(paciente.getFechaNacimiento());
                formBean.setSexo(paciente.getSexo());
                formBean.setTipo_sangre(paciente.getTipoSangre());
                formBean.setTelefono(paciente.getTelefono());
                formBean.setContacto(paciente.getContacto());
                formBean.setDireccion(paciente.getDireccion());
                if (formBean.getMensaje() == null) {
                    return mapping.findForward(modificar);
                }
//                } else {
//                formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                break;
            case "Actualizar":
                formBean.setMensaje(null);
//                if (LoginAction.pass.equals("Administrador")) {

                if (formBean.getDui().equals("") || formBean.getDui() == null
                        || formBean.getApellido().equals("") || formBean.getApellido() == null
                        || formBean.getNombre().equals("") || formBean.getNombre() == null
                        || formBean.getFecha_nacimiento().equals("") || formBean.getFecha_nacimiento() == null
                        || formBean.getSexo().equals("") || formBean.getSexo() == null
                        || formBean.getTipo_sangre().equals("") || formBean.getTipo_sangre() == null
                        || formBean.getTelefono().equals("") || formBean.getTelefono() == null
                        || formBean.getContacto().equals("") || formBean.getContacto() == null
                        || formBean.getDireccion().equals("") || formBean.getDireccion() == null) {

                    System.out.println("comprobacion OK");
                    formBean.setMensaje("Llene todos los campos");
                    return mapping.findForward(modificar);
                } else {

//                System.err.println(formBean.getIdPaciente());
//                System.err.println(formBean.getDui());
//                System.err.println(formBean.getApellido());
//                System.err.println(formBean.getNombre());
//                System.err.println(formBean.getFecha_nacimiento());
//                System.err.println(formBean.getSexo());
//                System.err.println(formBean.getTipo_sangre());
//                System.err.println(formBean.getTelefono());
//                System.err.println(formBean.getContacto());
//                System.err.println(formBean.getDireccion());
                    paciente.setSexo(formBean.getSexo());
                    paciente.setIdPaciente(formBean.getIdPaciente());
                    paciente.setDui(formBean.getDui());
                    paciente.setApellido(formBean.getApellido());
                    paciente.setNombre(formBean.getNombre());
                    paciente.setFechaNacimiento(formBean.getFecha_nacimiento());
                    paciente.setTipoSangre(formBean.getTipo_sangre());
                    paciente.setTelefono(formBean.getTelefono());
                    paciente.setContacto(formBean.getContacto());
                    paciente.setDireccion(formBean.getDireccion());
                    if (manto.actualizar(paciente)) {
                        formBean.setMensaje("La informacion del paciente fue editada");
                        listaPacientes = manto.listaPacientes();
                        formBean.setListaPacientes(listaPacientes);
                        if (formBean.getMensaje() != null) {
                            return mapping.findForward(consultartodo);
                        }
                    } else {
                        formBean.setMensaje("Error: No se pudo editar la información del ");
                        if (formBean.getMensaje() != null) {
                            return mapping.findForward(modificar);
                        }
                    }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                }
                if (formBean.getMensaje() != null) {
                    return mapping.findForward(modificar);
                }
                break;

        }
        formBean.setMensaje("algo anda mal!");
        return mapping.findForward(add_result);
    }
}
