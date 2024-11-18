package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Merchandising;
import com.example.grupo1musictool.repositories.IMerchadisingRepository;
import com.example.grupo1musictool.serviceinterfaces.IMerchandisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MerchandisingServiceImplement implements IMerchandisingService {
   @Autowired
    private IMerchadisingRepository mR;

    @Override
    public List<Merchandising> list() { return mR.findAll();
    }

    @Override
    public void insertMerchandising(Merchandising me) {mR.save(me);
    }


    @Override
    public void updateMerchandising(Merchandising me) {mR.save(me);

    }
    @Override
    public Merchandising listId(int idMerch){return mR.findById(idMerch).orElse(new Merchandising());};

    @Override
    public void deleteMerchandising(int id) {mR.deleteById(id);}

    @Override
    public List<Merchandising> buscarnombre(String nombre) { return mR.buscarnombre(nombre);
    }
    @Override
    public List<Merchandising> buscardescripcion(String descripcion) { return mR.buscardescripcion(descripcion);
    }


}



