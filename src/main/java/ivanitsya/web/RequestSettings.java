package ivanitsya.web;

import com.sun.xml.internal.bind.v2.model.core.ID;
import ivanitsya.users.model.UserRole ;

import java.util.Map;

/**
 * Created by Администратор on 23.06.2016.
 */
public class RequestSettings {

    private Long id;
    private String userName;
    private String password;
    private Boolean isActive;
    private UserRole roles;

    public UserRole getRoles() {
        return roles;
    }

    public void setRoles(UserRole roles) {
        this.roles = roles;
    }

    public RequestSettings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
