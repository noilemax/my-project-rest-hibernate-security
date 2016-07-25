package ivanitsya.web;

import ivanitsya.users.model.User;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 23.06.2016.
 */
public class Response implements Serializable {

    private String message;
    private Error error;
    private List<User> users = Collections.emptyList();

    public Response() {
        super();
    }

    public Response(Error error) {
        this();
        this.setError(error);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
