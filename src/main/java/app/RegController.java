package app;

import app.domain.UserDTO;
import app.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RegController {
    @Autowired
    private UserDTOService userDTOService;

    @PostMapping("/registration")
    public void addUser(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!userDTOService.isLoginVacant(user.getUsername())) {
            //response.sendRedirect("/error.html");
            response.sendRedirect("/registration.html?error");
        } else {
            userDTOService.register(user);
            request.login(user.getUsername(), user.getPassword());
            response.sendRedirect("/work.html");
        }

    }

    @PostMapping("/login")
    public void login(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN ");
        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        if (userDTOService.isLoginThere(user.getUsername(), user.getPassword())) {
            request.login(user.getUsername(), user.getPassword());
            response.sendRedirect("/work.html");
        } else {
            //response.sendRedirect("/error.html");
            response.sendRedirect("/login.html?error");
        }
    }
}
