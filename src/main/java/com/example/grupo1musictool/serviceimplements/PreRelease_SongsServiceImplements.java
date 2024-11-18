package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.PreRelease_Songs;
import com.example.grupo1musictool.repositories.IPreRelease_SongsRepository;
import com.example.grupo1musictool.serviceinterfaces.IPreRelease_SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PreRelease_SongsServiceImplements implements IPreRelease_SongsService {
    @Autowired
    private IPreRelease_SongsRepository pR;
    @Override
    public List<PreRelease_Songs> list(){return pR.findAll();}
    @Override
    public void insertPreRelease(PreRelease_Songs so){pR.save(so);}
    @Override
    public void updatetPreRelease(PreRelease_Songs so){pR.save(so);};
    @Override
    public PreRelease_Songs listId(int id) {return pR.findById(id).orElse(new PreRelease_Songs());};
    @Override
    public void deletePreRelease(int id){pR.deleteById(id);};
    @Override
    public List<PreRelease_Songs> buscarGenero(String genre){
        return pR.buscarGenero(genre);
    }
    @Override
    public List<PreRelease_Songs> buscarNombre(String nombre){return pR.buscarNombre(nombre);}
    @Override
    public List<String[]> contarCancionesOrden(){return pR.contarCancionesOrden();}
    @Override
    public List<String[]> totalCanciones(){return pR.totalCanciones();};

}
