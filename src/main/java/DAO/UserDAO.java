package DAO;

import DAO.entity.Role;
import DAO.entity.User;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Администратор on 06.07.2016.
 */
public interface UserDAO {
    public void addUser(User user) throws SQLException;
    public void updateUser(Long userId, User user) throws SQLException;
    public User getUserById(Long userId) throws SQLException;
    public Collection getAllUsers() throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public Collection getUsersByRole(Role role) throws SQLException;
}
