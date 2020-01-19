package app.service;

import app.domain.Dot;
import app.domain.DotDTO;
import app.repository.DotRepository;
import app.repository.UserRepository;
import app.util.DotManipulationBean;

import java.util.ArrayList;
import java.util.List;

public class DotDTOService {
    private final DotRepository dotRepository;
    private DotManipulationBean dotManipulationBean;
    private final UserRepository userRepository;

    public DotDTOService(DotRepository dotRepository, DotManipulationBean dotManipulationBean, UserRepository userRepository) {
        this.dotRepository = dotRepository;
        this.dotManipulationBean = dotManipulationBean;
        this.userRepository = userRepository;
    }

    public void save(DotDTO dots, String owner) {
        List<Dot> dotList = dotManipulationBean.dotListFromRequest(dots,owner);
        for (Dot d : dotList) {
            dotRepository.save(d);
            System.out.println(d);
        }

    }
    public List<DotDTO> loadUsersDots(String name) {
        List<Dot> fromDB = dotRepository.findAllByOwner(userRepository.findByUsername(name));
        List<DotDTO> toClient = new ArrayList<>();
        for (Dot d :
                fromDB) {
            toClient.add(new DotDTO(d));
        }
        return toClient;
    }
}
