package ivanitsya.users.dao;

import ivanitsya.users.model.User;
import ivanitsya.users.model.UserRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Администратор on 06.07.2016.
 */
public interface UserDAO {
    void addUser(User user, UserRole role) throws SQLException;

    void updateUser(User user) throws SQLException;

//    User getUserById(Long userId) throws SQLException;

    Collection getAllUsers() throws SQLException;

    void deleteUser(User user) throws SQLException;

    void deleteUser(String username);

//    Collection getUsersByRole(UserRole userRole) throws SQLException;

    User loadUserByUsername(String username);

    void addUser(User user);
}
