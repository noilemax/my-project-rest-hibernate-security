package DAO.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 05.07.2016.
 */
public class Role {

    private Long id;
    private String roleName;
    private Set usersRole = new HashSet();

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(Set usersRole) {
        this.usersRole = usersRole;
    }
}
