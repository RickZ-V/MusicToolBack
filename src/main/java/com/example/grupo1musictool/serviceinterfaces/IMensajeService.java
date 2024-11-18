package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    public List<Mensaje> list();
    public void insert(Mensaje me);
    public Mensaje listId(int id);
    public void update(Mensaje me);
    public void delete(int id);
    public List<Mensaje>buscar(String contenido);
}
