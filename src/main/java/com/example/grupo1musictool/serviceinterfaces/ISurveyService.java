package com.example.grupo1musictool.serviceinterfaces;

import com.example.grupo1musictool.entities.Survey;

import java.time.LocalDate;
import java.util.List;

public interface ISurveyService {
    public List<Survey> list();
    public void insertSurvey (Survey su);
    public void updateSurvey (Survey su);
    public void deleteSurvey (int id);
    public Survey listid(int id);
    public List<Survey> buscarTitulo(String titulo);
    public List<Survey> buscarFecharango(LocalDate fechainicio, LocalDate fechafin);
    public List<Survey> buscarFecha(LocalDate fecha);
}
