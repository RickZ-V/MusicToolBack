package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Publics;
import com.example.grupo1musictool.repositories.IPublicsRepository;
import com.example.grupo1musictool.serviceinterfaces.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PublicServiceImplements implements IPublicService {
    @Autowired
    private IPublicsRepository pR;

    @Override
    public void insert(Publics rol){pR.save(rol);}
    @Override
    public List<Publics> list(){return pR.findAll();}
    @Override
    public void delete(int idPublic){pR.deleteById(idPublic);}
    @Override
    public Publics listid(int id){return pR.findById(id).orElse(new Publics());};
    @Override
    public void update(Publics idPublic){pR.save(idPublic);}
    @Override
    public List<Publics> buscarfecha (LocalDate fechapublicacion){
        return pR.buscarfecha(fechapublicacion);
    }
}
