package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Survey;
import com.example.grupo1musictool.repositories.ISurveyRepository;
import com.example.grupo1musictool.serviceinterfaces.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class SurveyServiceImplement implements ISurveyService {
    @Autowired
    private ISurveyRepository sR;

    @Override
    public List<Survey> list() {
        return sR.findAll();
    }

    @Override
    public void insertSurvey(Survey su) { sR.save(su);}

    @Override
    public void updateSurvey(Survey su) { sR.save(su);}

    @Override
    public void deleteSurvey(int id) {
        sR.deleteById(id);
    }
    @Override
    public Survey listid(int id){return sR.findById(id).orElse(new Survey());};

    @Override
    public List<Survey> buscarTitulo(String titulo) {
        return sR.buscarTitulo(titulo);
    }

    @Override
    public List<Survey> buscarFecharango(LocalDate fechainicio, LocalDate fechafin) {
        return sR.buscarFecharango(fechainicio, fechafin);
    }

    @Override
    public List<Survey> buscarFecha(LocalDate fecha) {
        return sR.buscarFecha(fecha);
    }


}
