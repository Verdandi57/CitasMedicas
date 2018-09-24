package hibernate.mantenimiento;

import com.myapp.struts.HibernateUtil;
import hibernate.persistencia.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Julio Moisés Benavides
 */
public class UsuariosMantenimiento {

    Usuarios usuarios;
    Session session;
    SessionFactory factory;
    boolean flag;

    public boolean saveUser(Usuarios usuario) {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(usuario);
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
    
    public List checkAllUsers(){
        List<Usuarios> allUsers = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Usuarios");
            allUsers = (List<Usuarios>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return allUsers;
    }
    
    public Usuarios checkUser(int id_usuario){
        usuarios = new Usuarios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        
        try {
            session.beginTransaction();
            usuarios = (Usuarios) session.get(Usuarios.class, id_usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return usuarios;
    }
    
    public boolean updateUser(Usuarios usuario) {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(usuario);
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
    
    public boolean deleteUser(int id_usuario){
        usuarios = new Usuarios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        
        try {
            session.beginTransaction();
            usuarios = (Usuarios) session.get(Usuarios.class, id_usuario);
            session.delete(usuarios);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            flag = false;
        }finally{
            session.close();
        }
        return true;
    }
}
