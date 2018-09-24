/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.mantenimiento;

import com.myapp.struts.HibernateUtil;
import hibernate.persistencia.Consultorios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin116
 */
public class ConsultorioMantenimiento {

    Consultorios consultorios;
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    boolean x;

    public boolean saveRooms(Consultorios consultorios) {
        try {
            session.beginTransaction();
            session.save(consultorios);
            session.getTransaction().commit();
            x = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                x = false;
            }
        } finally {
            session.close();
        }
        return x;
    }

    public List<Consultorios> allRooms() {
        List<Consultorios> allRooms = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Consultorios");
            allRooms = (List<Consultorios>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return allRooms;
    }

    public Consultorios checkRoom(int idConsultorio) {
        consultorios = new Consultorios();
        try {
            session.beginTransaction();
            consultorios = (Consultorios) session.get(Consultorios.class, idConsultorio);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return consultorios;
    }

    public boolean updateRoom(Consultorios consultorios) {
        try {
            session.beginTransaction();
            session.update(consultorios);
            session.getTransaction().commit();
            x = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                x = false;
            }
        } finally {
            session.close();
        }
        return x;
    }

    public boolean deleteRoom(int idConsultorio) {

        try {
            session.beginTransaction();
            consultorios = (Consultorios) session.get(Consultorios.class, idConsultorio);
            session.delete(consultorios);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            x = false;
        } finally {
            session.close();
        }
        return true;
    }
}
