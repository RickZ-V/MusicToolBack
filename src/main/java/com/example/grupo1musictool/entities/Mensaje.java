package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content", nullable = false, length = 100)
    private String content;
    @Column(name = "dateSent", nullable = false, length = 500)
    private LocalDate dateSent;

    public Mensaje() {
    }

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
