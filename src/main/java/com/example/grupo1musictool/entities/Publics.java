package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "publics")
public class Publics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "comments", nullable = false)
    private String comments;

    public Publics() {
    }

    public Publics(int id, String content, LocalDate date, String comments) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.comments = comments;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
