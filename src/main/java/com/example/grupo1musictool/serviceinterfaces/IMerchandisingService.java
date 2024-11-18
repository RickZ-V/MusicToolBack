package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Merchandising;

import java.util.List;

public interface IMerchandisingService {
    public List<Merchandising> list();
    public void insertMerchandising (Merchandising me);
    public void updateMerchandising (Merchandising me);
    public void deleteMerchandising (int id);
    public Merchandising listId(int id);
    public List<Merchandising> buscarnombre(String nombre);
    public List<Merchandising> buscardescripcion(String descripcion);
}


