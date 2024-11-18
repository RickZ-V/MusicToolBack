package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Respuestas;
    @Column(name = "respuesta_1", length = 200, nullable = false)
    private String respuesta_1;
    @Column(name = "respuesta_2", length = 200, nullable = false)
    private String respuesta_2;
    @ManyToOne
    @JoinColumn(name = "idSurvey")
    private Survey su;


    public Answer() {
    }

    public Answer(int id_Respuestas, String respuesta_1, String respuesta_2, Survey su) {
        this.id_Respuestas = id_Respuestas;
        this.respuesta_1 = respuesta_1;
        this.respuesta_2 = respuesta_2;
        this.su = su;
    }

    public int getId_Respuestas() {
        return id_Respuestas;
    }

    public void setId_Respuestas(int id_Respuestas) {
        this.id_Respuestas = id_Respuestas;
    }

    public String getRespuesta_1() {
        return respuesta_1;
    }

    public void setRespuesta_1(String respuesta_1) {
        this.respuesta_1 = respuesta_1;
    }

    public String getRespuesta_2() {
        return respuesta_2;
    }

    public void setRespuesta_2(String respuesta_2) {
        this.respuesta_2 = respuesta_2;
    }

    public Survey getSu() {
        return su;
    }

    public void setSu(Survey su) {
        this.su = su;
    }
}