package app;

import app.domain.UserDTO;
import app.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowCredentials="true")
public class RegController {
    @Autowired
    private UserDTOService userDTOService;

    @RequestMapping("/registration")
    public void addUser(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!userDTOService.isLoginVacant(user.getUsername())) {
            response.sendRedirect("http://localhost:63342/registration?error");
        } else {
            userDTOService.register(user);
            request.login(user.getUsername(), user.getPassword());
            response.sendRedirect("http://localhost:63342/main?reg");
        }

    }
}
