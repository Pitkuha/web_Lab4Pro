package app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message", method = {RequestMethod.POST, RequestMethod.GET})
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class HelloWorldController {
    @PostMapping
    public String list(){
        return "index";
    }
}
