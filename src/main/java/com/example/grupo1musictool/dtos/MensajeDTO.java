package com.example.grupo1musictool.dtos;


import java.time.LocalDate;

public class MensajeDTO {
    private int id;
    private String content;
    private LocalDate dateSent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }
    }

