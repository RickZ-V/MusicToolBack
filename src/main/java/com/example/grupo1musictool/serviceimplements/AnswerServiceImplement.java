package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.repositories.IAnswerRepository;
import com.example.grupo1musictool.serviceinterfaces.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.grupo1musictool.entities.Answer;

import java.util.List;

@Service
public class AnswerServiceImplement implements IAnswerService {
    @Autowired
    private IAnswerRepository aR;
    @Override
    public List<Answer> list() {
        return aR.findAll();
    }
    @Override
    public void insert(Answer an) { aR.save(an);}
    @Override
    public Answer listId(int id) {
        return aR.findById(id).orElse(new Answer());
    }
    @Override
    public void update(Answer an) {aR.save(an);}
    @Override
    public void delete(int id) {aR.deleteById(id);}
    public List<String[]> totalEncuestasRespondidas(){return aR.totalEncuestasRespondidas();};
    public List<String[]> totalRespuestas(){return aR.totalRespuestas();};
}
