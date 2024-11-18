package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "question1", nullable = false, length = 100)
    private String question1;
    @Column(name = "question2", nullable = false, length = 100)
    private String question2;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "creationDate", nullable = false)
    private LocalDate creationDate;

    public Survey() {
    }

    public Survey(int id, String question1, String question2, String title, String description, LocalDate creationDate) {
    this.id = id;
    this.question1 = question1;
    this.question2 = question2;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
