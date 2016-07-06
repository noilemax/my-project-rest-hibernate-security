package DAO;

import DAO.entity.Role;
import DAO.entity.User;

import java.util.Collection;
import java.sql.SQLException;

/**
 * Created by Администратор on 06.07.2016.
 */
public interface RoleDAO {
    public void addRole(Role role) throws SQLException;
    public void updateRole(Long roleId, Role role) throws SQLException;
    public Role getRoleById(Long roleId) throws SQLException;
    public Collection getAllRoles() throws SQLException;
    public void deleteRole(Role role) throws SQLException;
    public Collection getRolesByUser(User role) throws SQLException;
}
