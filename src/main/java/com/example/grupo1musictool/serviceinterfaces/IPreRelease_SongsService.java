package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.PreRelease_Songs;

import java.util.List;


public interface IPreRelease_SongsService {
    public List<PreRelease_Songs> list();
    public void insertPreRelease(PreRelease_Songs so);
    public void updatetPreRelease(PreRelease_Songs so);
    public void deletePreRelease(int id);
    public PreRelease_Songs listId(int id);
    public List<PreRelease_Songs> buscarGenero(String genre);
    public List<PreRelease_Songs> buscarNombre(String nombre);
    public List<String[]> contarCancionesOrden();
    public List<String[]> totalCanciones();

}
