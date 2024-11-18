package com.example.grupo1musictool.repositories;

import com.example.grupo1musictool.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAnswerRepository extends JpaRepository<Answer, Integer> {
    @Query(value = "SELECT s.title AS nombre_encuesta, COUNT(p.id_survey) AS total_encuestas\n" +
            "             FROM answer p\n" +
            "             JOIN survey s ON p.id_survey = s.id\n" +
            "             GROUP BY s.title\n" +
            "             ORDER BY total_encuestas;",nativeQuery = true)
    public List<String[]> totalEncuestasRespondidas();
    @Query(value = " SELECT COUNT(id_respuestas) AS total_respuestas\n" +
            " FROM answer;\n",nativeQuery = true)
    public List<String[]> totalRespuestas();
}
