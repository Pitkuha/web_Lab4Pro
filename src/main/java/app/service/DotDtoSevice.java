//package app.service;
//
//import app.domain.Dot;
//import app.domain.DotDTO;
//import app.repository.DotRepository;
//import app.util.DotManipulationBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DotDtoSevice {
//    private final DotRepository dotRepository;
//    private DotManipulationBean dotManipulationBean;
//
//    public DotDtoSevice(DotRepository dotRepository, DotManipulationBean dotManipulationBean) {
//        this.dotRepository = dotRepository;
//        this.dotManipulationBean = dotManipulationBean;
//    }
//
//    public void save(DotDTO dots) {
//        List<Dot> dotList = dotManipulationBean.dotListFromRequest(dots);
//        for (Dot d : dotList) {
//            dotRepository.save(d);
//            System.out.println(d);
//        }
//
//    }
//    //todo На вход будет принимать имя юзера и возвращать все точки где совпадает имя
//    public List<DotDTO> loadUsersDots() {
//        List<Dot> fromDB = dotRepository.findAllByX(1);
//        List<DotDTO> toClient = new ArrayList<>();
//        for (Dot d :
//                fromDB) {
//            toClient.add(new DotDTO(d));
//        }
//        return toClient;
//    }
//}
