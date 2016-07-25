package ivanitsya.users.dao;

import ivanitsya.users.model.User;
import ivanitsya.users.model.UserRole;
import ivanitsya.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 06.07.2016.
 */
public class UserDAOImpl implements UserDAO {

    public void addUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при вставке");
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }


    public void addUser(User user, UserRole role) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(String.valueOf(user), role);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при вставке");

        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public void updateUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при вставке");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public Collection getAllUsers() throws SQLException {
        Session session = null;
        List users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка 'getAll'");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при удалении");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public void deleteUser(String username) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(username);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при удалении");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    @SuppressWarnings("unchecked")
    public User loadUserByUsername(String username) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String queryString = "from User where id = :username";
            Query query = session.createQuery(queryString);
            query.setString("username", username);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при получении одного пользователя", JOptionPane.OK_OPTION);
            System.out.println(e.getMessage() + "Ошибка при получении одного пользователя");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }


    //    public User getUserById(Long userId) throws SQLException {
//        Session session = null;
//        User user = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            user = (User) session.load(User.class, userId);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return user;
//    }
    //    public Collection getUsersByRole(UserRole userRole) throws SQLException {
//        Session session = null;
//        List users = new ArrayList<User>();
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//            Integer role_id = userRole.getUserRoleId();
//            Query query = session.createQuery("from User where username = :roleId").setLong("roleId", role_id);
//            users = (List<User>) query.list();
//            session.getTransaction().commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return users;
//    }
}

