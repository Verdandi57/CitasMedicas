package hibernate.mantenimiento;

import com.myapp.struts.HibernateUtil;
import hibernate.persistencia.Medicos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MedicosMantenimiento  {

        
    Medicos medicos = new Medicos();
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    boolean flag;
    
    //Registra un medico en base de datos
    public boolean guardarMedico(Medicos medico) {
        try {
            session.beginTransaction();
            session.save(medico);
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
    
    public List<Medicos> listaM(){
        List<Medicos> listaM = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Medicos");
            listaM = (List<Medicos>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaM;
    }
    
    public Medicos infoMedico(int id_medico){
        medicos =new Medicos();
        try {
            session.beginTransaction();
            medicos = (Medicos) session.get(Medicos.class, id_medico);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return medicos;
    }
    
    public boolean editarInfoMedico(Medicos medico){
        try {
            session.beginTransaction();
            session.update(medico);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = true;
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
    public boolean removerMedico(int id_medico){
        try {
            session.beginTransaction();
            medicos = (Medicos) session.get(Medicos.class, id_medico);
            session.delete(medicos);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }flag = false;
        } finally {
            session.close();
        }
        return true;
    }

}
