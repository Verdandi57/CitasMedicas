package hibernate.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import com.myapp.struts.HibernateUtil;
import hibernate.persistencia.Citas;
import java.util.List;

/**
 *
 * @author julio.benavidesusam
 */
public class CitasMantenimiento {

    Citas citas;
    SessionFactory factory;
    Session session;
    boolean flag;

    public boolean guardarCita(Citas cita) {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(cita);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = false;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    public List<Citas> todasCitas() {
        List<Citas> listaCitas = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Citas");
            listaCitas = (List<Citas>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaCitas;
    }

    public Citas infoCitas(int idCitas) {
        citas = new Citas();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            citas = (Citas) session.get(Citas.class, idCitas);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return citas;
    }

    public boolean editarCita(Citas cita) {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(cita);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = false;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean eliminarCita(int id_cita) {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            citas = (Citas) session.get(Citas.class, id_cita);
            session.delete(citas);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }

}