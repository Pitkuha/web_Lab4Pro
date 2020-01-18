package app;

import app.domain.Dot;
import app.domain.DotDTO;
import app.repository.DotRepository;
import app.util.DotManipulationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Пока не получается подключить SpringData и БД делаю локально
 */
@RestController
@CrossOrigin(origins = "http://localhost:63342", allowCredentials="true")
public class DotController{
    ArrayList<Dot> dotsList = new ArrayList<>();
    private final DotManipulationBean DMB = new DotManipulationBean();
    private final DotRepository dotRepository;

    @Autowired
    public DotController(DotRepository dotRepository) {
        this.dotRepository = dotRepository;
    }

//    private DotDtoSevice dotDtoSevice;

    @PostMapping(value = "/dots" ,produces = "application/json;")
//    @ResponseBody
    public String addDot(@Valid @RequestBody DotDTO request, BindingResult bindingResult, Principal principal){
        System.out.println("fffkfkkfkfkf");
//        dotDtoSevice.save(request);
        Dot d = new Dot();
        System.out.println("info");
        System.out.println(request.getX());
        System.out.println(request.getY());
        System.out.println(request.getY());
        d.setX(request.getX());
        d.setY(request.getY());
        d.setR(request.getR());
        d.setResult(DMB.checkDotArea(d));
//        dotRepository.save(d);
        dotsList.add(d);
        dotRepository.save(d);

        System.out.println(dotsList);
        return "ok";
    }


    @GetMapping("/dots")
    @ResponseBody
    public List<Dot> getAllDots(Principal principal){
        return dotsList;
    }
}
