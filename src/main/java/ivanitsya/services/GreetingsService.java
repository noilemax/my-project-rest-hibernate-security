package ivanitsya.services;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Администратор on 13.07.2016.
 */

@RestController
@RequestMapping("/greeting")
public class GreetingsService {

    @RequestMapping
    public String greettings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hallo,  " + authentication.getName();
    }
}
