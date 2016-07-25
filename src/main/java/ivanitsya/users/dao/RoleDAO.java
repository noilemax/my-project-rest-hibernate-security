package ivanitsya.users.dao;

import ivanitsya.users.model.User;
import ivanitsya.users.model.UserRole;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Администратор on 06.07.2016.
 */
public interface RoleDAO {
    void addRole(UserRole userRole) throws SQLException;

    void updateRole(UserRole userRole) throws SQLException;

//     UserRole getRoleById(Long roleId) throws SQLException;

    Collection getAllRoles() throws SQLException;

    void deleteRole(UserRole userRole) throws SQLException;

//     Collection getRoleByUser(User role) throws SQLException;

    UserRole findByRoleName(String role);
}
