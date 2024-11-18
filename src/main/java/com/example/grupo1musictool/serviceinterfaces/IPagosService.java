package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Pagos;

import java.util.List;

public interface IPagosService {
    public List<Pagos> list();
    public void insert(Pagos pg);
    public Pagos listId(int id);
    public void update(Pagos pg);
    public void delete(int id);
    public List<Pagos>buscar(Double monto);
    public List<String[]> totalMetodoPago();
    public List<String[]> totalTipoSub();
}
