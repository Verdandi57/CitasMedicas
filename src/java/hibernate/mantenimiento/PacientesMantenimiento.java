
package hibernate.mantenimiento;

import com.myapp.struts.HibernateUtil;
import hibernate.persistencia.Pacientes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PacientesMantenimiento {
    Pacientes pacientes;
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session  session = factory.openSession();
    boolean flag;
    
       
    
    public boolean guardarPaciente(Pacientes paciente){        
        try {
            session.beginTransaction();
            session.save(paciente);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = false;
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
    public Pacientes infoPaciente(int id_paciente){
        pacientes = new Pacientes();
         try {
            session.beginTransaction();
            pacientes = (Pacientes) session.get(Pacientes.class, id_paciente);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return pacientes;
    }
    public boolean actualizar(Pacientes paciente){
        try {
            session.beginTransaction();
            session.update(paciente);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = false;
            }
        } finally {
            session.close();
        }
        return flag;
    }
    public boolean removerPaciente(int id_paciente){
        try {
            session.beginTransaction();
            pacientes = (Pacientes) session.get(Pacientes.class, id_paciente);
            session.delete(pacientes);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = false;
            }
        } finally {
            session.close();
        }
        return flag;
        
    }
    public List<Pacientes> listaPacientes(){
        List<Pacientes> listaPacientes=null;    
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Pacientes");
            listaPacientes = (List<Pacientes>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
       return listaPacientes; 
    } 
}
