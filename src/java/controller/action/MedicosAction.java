package controller.action;

import controller.actionform.MedicosActionForm;
import hibernate.mantenimiento.MedicosMantenimiento;
import hibernate.persistencia.Medicos;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MedicosAction extends org.apache.struts.action.Action {

    private static final String add_result = "add_result";
    private static final String edit_result = "edit_result";
    private static final String MostrarMed = "MostrarMed";
    private static final String in = "index";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MedicosActionForm formBean = (MedicosActionForm) form;
        MedicosMantenimiento mantenimiento = new MedicosMantenimiento();
        Medicos med = new Medicos();
        List<Medicos> listaM;

        switch (formBean.getAction()) {
            case "Nuevo":
                med.getDui();
                med.getApellido();
                med.getNombre();
                med.getSexo();
                med.getTipoSangre();
                med.getTelefono();
                med.getContacto();
                break;
            case "Agregar":
//                if (LoginAction.pass.equals("Administrador")) {
                if (formBean.getDui().equals("") || formBean.getDui() == null
                        || formBean.getApellido().equals("") || formBean.getApellido() == null
                        || formBean.getNombre().equals("") || formBean.getNombre() == null
                        || formBean.getSexo().equals("") || formBean.getSexo() == null
                        || formBean.getTipo_sangre().equals("") || formBean.getTipo_sangre() == null
                        || formBean.getTelefono().equals("") || formBean.getTelefono() == null
                        || formBean.getContacto().equals("") || formBean.getContacto() == null) {
                    formBean.setMensaje("Complete todos los campos para realizar el registro");
                } else {
                    med.setIdMedico(0);
                    med.setDui(formBean.getDui());
                    med.setApellido(formBean.getApellido());
                    med.setNombre(formBean.getNombre());
                    med.setSexo(formBean.getSexo());
                    med.setTipoSangre(formBean.getTipo_sangre());
                    med.setTelefono(formBean.getTelefono());
                    med.setContacto(formBean.getContacto());
                    if (mantenimiento.guardarMedico(med)) {
                        formBean.setMensaje("El medico fue agregado al registro");
                        listaM = mantenimiento.listaM();
                        formBean.setListaM(listaM);
                        return mapping.findForward(MostrarMed);
                    } else {
                        formBean.setMensaje("Error: El medico no pudo ser agregado al registro");
                        return mapping.findForward(in);
                    }
                }
                if (formBean.getMensaje() != null) {
                    return mapping.findForward(in);
                }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                break;
            case "Mostrar":
                formBean.setMensaje(null);
//                if (LoginAction.pass.equals("Administrador")) {
                listaM = mantenimiento.listaM();
                formBean.setListaM(listaM);
                if (formBean.getMensaje() == null) {
                    return mapping.findForward(MostrarMed);
                }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                break;
            case "Modificar":
//                if (LoginAction.pass.equals("Administrador")) {
                med = mantenimiento.infoMedico(formBean.getIdMedico());
                System.out.println("ID Medico: " + med.getIdMedico());
                formBean.setIdMedico(med.getIdMedico());
                formBean.setDui(med.getDui());
                formBean.setApellido(med.getApellido());
                formBean.setNombre(med.getNombre());
                formBean.setSexo(med.getSexo());
                formBean.setTipo_sangre(med.getTipoSangre());
                formBean.setTelefono(med.getTelefono());
                formBean.setContacto(med.getContacto());
                if (formBean.getMensaje() == null) {
                    return mapping.findForward(edit_result);
                }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                break;
            case "Actualizar":
                formBean.setMensaje(null);
//                if (LoginAction.pass.equals("Administrador")) {
                System.out.println("estoy aqui en actualizar");
                if (formBean.getDui().equals("") || formBean.getDui() == null
                        || formBean.getApellido() == null || formBean.getApellido().equals("")
                        || formBean.getNombre().equals("") || formBean.getNombre() == null
                        || formBean.getSexo().equals("") || formBean.getSexo() == null
                        || formBean.getTipo_sangre().equals("") || formBean.getTipo_sangre() == null
                        || formBean.getTelefono().equals("") || formBean.getTelefono() == null
                        || formBean.getContacto().equals("") || formBean.getContacto() == null) {
                    formBean.setMensaje("Llene todos los campos");
                } else {
                    med.setIdMedico(formBean.getIdMedico());
                    med.setDui(formBean.getDui());
                    med.setApellido(formBean.getApellido());
                    med.setNombre(formBean.getNombre());
                    med.setSexo(formBean.getSexo());
                    med.setTipoSangre(formBean.getTipo_sangre());
                    med.setTelefono(formBean.getTelefono());
                    med.setContacto(formBean.getContacto());
                    if (mantenimiento.editarInfoMedico(med)) {
                        formBean.setMensaje("La informacion del medico fue editada");
                        listaM = mantenimiento.listaM();
                        formBean.setListaM(listaM);
                        if (formBean.getMensaje() != null) {
                            return mapping.findForward(MostrarMed);
                        } else {
                            formBean.setMensaje("Error: No se pudo editar la información del ");
                        }

                    }
//                } else {
//                    formBean.setMensaje("No tiene los permisos para realizar la acción");
//                }
                    if (formBean.getMensaje() != null) {
                        return mapping.findForward(edit_result);
                    }
//                case "":
//                formBean.setMensaje(null);
//              if (LoginAction.pass.equals("Administrador")) {
//                mantenimiento.removerMedico(formBean.getIdMedico());
//                formBean.setMensaje("Medico Eliminado");
//                listaM = mantenimiento.listaM();
//                formBean.setListaM(listaM);
//                if (formBean.getMensaje() != null) {
//                    System.out.println("aqui");
//                    return mapping.findForward(MostrarMed);
//                }
                    break;
                }

        }
        return mapping.findForward(add_result);
    }

}
