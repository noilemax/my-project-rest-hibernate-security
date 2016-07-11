//package ivanitsya.users.dao;
//
//import ivanitsya.users.model.UserRole;
//import ivanitsya.users.model.User;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import ivanitsya.util.HibernateUtil;
//
//import javax.swing.*;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by Администратор on 06.07.2016.
// */
//public class RoleDAOImpl implements RoleDAO {
//
//    public void addRole(UserRole userRole) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.save(userRole);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//
//                session.close();
//            }
//        }
//    }
//
//    public void updateRole(Long roleId, UserRole userRole) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.update(userRole);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//    }
//
//    public UserRole getRoleById(Long roleId) throws SQLException {
//        Session session = null;
//        UserRole userRole = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            userRole = (UserRole) session.load(UserRole.class, roleId);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return userRole;
//    }
//
//    public Collection getAllRoles() throws SQLException {
//        Session session = null;
//        List roles = new ArrayList<UserRole>();
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            roles = session.createCriteria(UserRole.class).list();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return roles;
//    }
//
//    public void deleteRole(UserRole userRole) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(userRole);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    public Collection getRolesByUser(User role) throws SQLException {
//        Session session = null;
//        List roles = new ArrayList<User>();
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//            Long user_id = role.getUserId();
//            Query query = session.createQuery("from Role where id = :userId").setLong("userId", user_id);
//            roles = (List<UserRole>) query.list();
//            session.getTransaction().commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return roles;
//    }
//}
