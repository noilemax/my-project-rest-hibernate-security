import ivanitsya.users.dao.UserDAOImpl;
import ivanitsya.users.model.User;
import ivanitsya.users.model.UserRole;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 05.07.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();


        User user = new User("Lesha", "122", true);
        UserRole userRole = new UserRole(user, "ADMIN");


        User user1 = new User("Ivan", "111", true);
        UserRole userRole1 = new UserRole(user, "USER");
        User user2 = new User("Petya", "122", true);
        UserRole userRole2 = new UserRole(user, "ADMIN");

        try {
            userDAO.addUser(user, userRole);
            userDAO.addUser(user1, userRole1);
            userDAO.addUser(user2, userRole2);
        } catch (SQLException e) {
            System.out.println("не добавляет юзера");
            e.printStackTrace();
        }

        List users = new ArrayList();
        users.addAll(userDAO.getAllUsers());
        System.out.println("-------показать всех в базе------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }

        userDAO.deleteUser(user2);
        System.out.println("-------Удалили петю------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }
        user1.setPassword("666");
        userDAO.updateUser(user1);
        System.out.println("-------показать всех в базе------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }

        System.out.println("-------Lesha из базы------------------");
        System.out.println(userDAO.findByUserName("Lesha"));


    }


//    public class Main {
//        public static void main(String[] args) throws SQLException {
//
//            Collection routes = Factory.getInstance().getRouteDAO().getAllRoutes();
//            Iterator iterator = routes.iterator();
//            System.out.println("========Все маршруты=========");
//            while (iterator.hasNext()) {
//                Route route = (Route) iterator.next();
//                System.out.println("Маршрут : " + route.getName() + "  Номер маршрута : " + route.getNumber());
//                Collection busses = Factory.getInstance().getBusDAO().getBussesByRoute(route);
//                Iterator iterator2 = busses.iterator();
//                while (iterator2.hasNext()) {
//                    Bus bus = (Bus) iterator2.next();
//                    System.out.println("Автобус № " + bus.getNumber());
//
//                }
//            }
//
//            Collection busses = Factory.getInstance().getBusDAO().getAllBusses();
//            iterator = busses.iterator();
//            System.out.println("========Все автобусы=========");
//            while (iterator.hasNext()) {
//                Bus bus = (Bus) iterator.next();
//                Collection drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
//                Iterator iterator2 = drivers.iterator();
//                System.out.println("Автобус № " + bus.getNumber());
//                while (iterator2.hasNext()) {
//                    Driver driver = (Driver) iterator2.next();
//                    System.out.println("Имя : " + driver.getName() + "   Фамилия: " + driver.getSurname());
//
//                }
//            }
//
//        }
//    }* This source code was highlighted with Source Code Highlighter.


//    private static final SessionFactory ourSessionFactory;
//    private static final ServiceRegistry serviceRegistry;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }
}
