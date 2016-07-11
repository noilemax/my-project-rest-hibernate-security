package ivanitsya.users.dao.factory;

//import ivanitsya.users.dao.RoleDAOImpl;
import ivanitsya.users.dao.UserDAO;
import ivanitsya.users.dao.UserDAOImpl;
//import ivanitsya.users.dao.RoleDAO;

/**
 * Created by Администратор on 06.07.2016.
 */
public class Factory {
    private static UserDAO userDAO = null;
//    private static RoleDAO roleDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance ==null) {
        instance = new Factory();
        }
        return instance;
    }

//    public RoleDAO getRoleDAO(){
//        if(roleDAO==null){
//            roleDAO= new RoleDAOImpl();
//        }
//        return roleDAO;
//    }

    public UserDAO getUserDAO(){
        if (userDAO==null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }


}
