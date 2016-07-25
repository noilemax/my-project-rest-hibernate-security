package ivanitsya.web;

import ivanitsya.users.dao.UserDAO;
import ivanitsya.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 23.06.2016.
 */
@Component
public class ViewHelper {
    @Autowired
    protected UserDAO userDAO;

    public ViewHelper() {
    }

    public ModelAndView generateView(Response response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(response);
        return modelAndView;
    }

    public Response getUsers() throws SQLException {
        Response response = new Response();
        response.setUsers((List<User>) userDAO.getAllUsers());
        return response;
    }

    public Response createUser(RequestSettings settings) throws SQLException {
        Response response = new Response();
        userDAO.addUser(new User(settings.getUserName(),settings.getPassword(),settings.getIsActive()),settings.getRoles());
        String message;
        response.setMessage("User created successfully");
        return response;
    }

    public Response deleteUser(RequestSettings settings){
        Response response = new Response();
        userDAO.deleteUser(settings.getUserName());
        String message;
        response.setMessage("User has been deleted");
        return response;
    }

}
