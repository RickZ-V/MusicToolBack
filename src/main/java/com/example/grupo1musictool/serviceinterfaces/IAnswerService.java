package com.example.grupo1musictool.serviceinterfaces;


import com.example.grupo1musictool.entities.Answer;

import java.util.List;


public interface IAnswerService {
    public List<Answer> list();
    public  void insert(Answer an);
    public Answer listId(int id);
    public void update(Answer an);
    public void  delete(int id);
    public List<String[]> totalEncuestasRespondidas();
    public List<String[]> totalRespuestas();
}
