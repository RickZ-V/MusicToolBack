package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Suscription;
import com.example.grupo1musictool.repositories.ISuscriptionRepository;
import com.example.grupo1musictool.serviceinterfaces.ISuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImplements implements ISuscriptionService {
    @Autowired
    private ISuscriptionRepository sR;
    @Override
    public void insert(Suscription sr){sR.save(sr);}
    @Override
    public List<Suscription> list(){return sR.findAll();}
    @Override
    public void delete(int idSub){sR.deleteById(idSub);}
    @Override
    public void update(Suscription idSub){sR.save(idSub);}
    @Override
    public Suscription listId(int id){return sR.findById(id).orElse(new Suscription());};
    @Override
    public List<Suscription> buscartipodesuscripcion (String tiposuscripcion){
        return sR.buscartipodesuscripcion(tiposuscripcion);
    }
    @Override
    public List<Suscription> buscarrango (LocalDate fechainicio, LocalDate fechafin) {
        return sR.buscarrango(fechainicio, fechafin);
    }
}
