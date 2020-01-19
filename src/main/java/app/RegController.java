package app;

import app.domain.UserDTO;
import app.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
//@CrossOrigin(origins = "http://localhost:63342", allowCredentials="true")
public class RegController {
    @Autowired
    private UserDTOService userDTOService;

    @PostMapping("/registration")
    public void addUser(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //user.getUsername() = 0 ПОЧЕМУ?
        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        if (!userDTOService.isLoginVacant(user.getUsername())) {
            response.sendRedirect("http://localhost:63342/web_Lab4Pro/static/registration.html?error");
        } else {
            System.out.println("/registration перешли на блок else");
            userDTOService.register(user);
            request.login(user.getUsername(), user.getPassword());
            response.sendRedirect("http://localhost:63342/web_Lab4Pro/static/work.html");
        }

    }
}
