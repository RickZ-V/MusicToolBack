package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Publics;

import java.time.LocalDate;
import java.util.List;

public interface IPublicService {
    public void insert(Publics rol);
    public List<Publics> list();

    public void delete(int idPublic);
    public Publics listid(int id);
    public void update(Publics idPublic);
    public List<Publics> buscarfecha(LocalDate fechapublicacion );

}
