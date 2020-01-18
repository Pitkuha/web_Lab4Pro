package app.util;

import app.domain.Dot;
import app.domain.DotDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DotManipulationBean {
    public List<Dot> dotListFromRequest(DotDTO request){
        List<Dot> list = new ArrayList<>();
        Dot d = new Dot(request.getX(),request.getY(),request.getR(),false);
        d.setResult(checkDotArea(d));
        list.add(d);
        return list;
    }

    public boolean checkDotArea(Dot dot) {
        double x = dot.getX();
        double y = dot.getY();
        double r = dot.getR();
        System.out.println(x + " " + y + " " + r);
        return (x >= 0) && (y >= 0) && (x <= r) && (y <= r/2) ||
                (x >= 0) && (y <= 0) && (x*x + y*y <= r*r) ||
                (x <= 0) && (y <= 0) && (y + 2*x >= -r);
    }
}
