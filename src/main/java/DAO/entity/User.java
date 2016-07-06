package DAO.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 05.07.2016.
 */
public class User {
    private Long userId;
    private String userName;
    private String passWord;
    //    private Boolean isActive;
    private Set roles = new HashSet();
    private Long role_id;

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
