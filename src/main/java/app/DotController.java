package app;

import app.domain.Dot;
import app.domain.DotDTO;
import app.repository.DotRepository;
import app.service.DotDTOService;
import app.util.DotManipulationBean;
import org.hibernate.hql.internal.ast.tree.DotNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DotController{
    @Autowired
    private final DotManipulationBean DMB = new DotManipulationBean();


    private DotDTOService dotDTOService;

    @PostMapping(value = "/dots" ,produces = "application/json;")
//    @ResponseBody
    public String addDot(@Valid @RequestBody DotDTO request, BindingResult bindingResult, Principal principal){
        System.out.println(principal.getName());
        dotDTOService.save(request, principal.getName());
        return "ok";
    }


    @GetMapping("/dots")
    @ResponseBody
    public List<DotDTO> getAllDots(Principal principal){
        return dotDTOService.loadUsersDots(principal.getName());
    }
}
