package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Suscription;

import java.time.LocalDate;
import java.util.List;

public interface ISuscriptionService {
    public void insert(Suscription suscription);
    public List<Suscription> list();

    public void delete(int idSub);
    public Suscription listId(int id);

    public void update(Suscription idSub);
    public List<Suscription> buscartipodesuscripcion (String tiposuscripcion);
    public List<Suscription> buscarrango (LocalDate fechainicio, LocalDate fechafin);
}
