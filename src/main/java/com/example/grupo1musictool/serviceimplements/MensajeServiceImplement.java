package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Mensaje;
import com.example.grupo1musictool.repositories.IMensajeRepository;
import com.example.grupo1musictool.serviceinterfaces.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajeRepository mR;
    @Override
    public List<Mensaje> list(){
        return mR.findAll();
    }

    @Override
    public void insert(Mensaje me) { mR.save(me); }

    @Override
    public Mensaje listId(int id) {
        return mR.findById(id).orElse(new Mensaje());
    }

    @Override
    public void update(Mensaje me) {
        mR.save(me);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<Mensaje> buscar(String contenido) {
        return mR.buscar(contenido);
    }
}
