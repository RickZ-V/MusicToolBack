package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Pagos;
import com.example.grupo1musictool.repositories.IPagosRepository;
import com.example.grupo1musictool.serviceinterfaces.IPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PagosServiceImplement implements IPagosService {
    @Autowired
    private IPagosRepository pgR;
    @Override
    public List<Pagos> list() {
        return pgR.findAll();
    }

    @Override
    public void insert(Pagos pg) {
        pgR.save(pg);
    }

    @Override
    public Pagos listId(int id) {
        return pgR.findById(id).orElse(new Pagos());
    }

    @Override
    public void update(Pagos pg) {
        pgR.save(pg);
    }

    @Override
    public void delete(int id) {
        pgR.deleteById(id);
    }
    @Override
    public List<Pagos> buscar(Double monto) {
        return pgR.buscar(monto);}
    @Override
    public List<String[]> totalMetodoPago(){return pgR.totalMetodoPago();};
    @Override
    public List<String[]> totalTipoSub(){return pgR.totalTipoSub();};
}
