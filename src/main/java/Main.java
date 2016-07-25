import ivanitsya.users.dao.UserDAOImpl;
import ivanitsya.users.model.User;
import ivanitsya.users.model.UserRole;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 05.07.2016.
 */

@EnableWebMvc
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {

//        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
//        applicationContext.registerShutdownHook();
//        SpringApplication.run(Main.class, args);
        UserDAOImpl userDAO = new UserDAOImpl();

        User user = new User("Lesha", "122", true);
        UserRole userRole = new UserRole(user, "ADMIN");


        User user1 = new User("Ivan", "111", false);
        UserRole userRole1 = new UserRole(user, "USER");
        User user2 = new User("Petya", "122", true);
        UserRole userRole2 = new UserRole(user2, "ADMIN");

//        userDAO.addUser(user);
//        userDAO.addUser(user1);
//        userDAO.addUser(user2);
        userDAO.addUser(user, userRole);
        userDAO.addUser(user1, userRole1);
        userDAO.addUser(user2, userRole2);

        List users = new ArrayList();
        users.addAll(userDAO.getAllUsers());
        System.out.println("-------показать всех в базе------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }
        System.out.println("---------------------------------------------");

        userDAO.deleteUser(user2);
        System.out.println("-------Удалили петю------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }
        System.out.println("---------------------------------------------");
        user1.setPassword("666");
        userDAO.updateUser(user1);
        System.out.println("-------показать всех в базе------------------");
        for (Object users1 : userDAO.getAllUsers()) {
            System.out.println(users1.toString());
        }

        System.out.println("---------------------------------------------");

        System.out.println("-------Lesha из базы------------------");
        System.out.println(userDAO.loadUserByUsername("Lesha"));
        System.out.println("---------------------------------------------");

        //-----------------------------------------------------------

    }
}
