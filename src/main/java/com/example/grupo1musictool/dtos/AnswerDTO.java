package com.example.grupo1musictool.dtos;

import com.example.grupo1musictool.entities.Survey;

public class AnswerDTO {
    private int id_Respuestas;
    private String respuesta_1;
    private String respuesta_2;
    private Survey su;

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
