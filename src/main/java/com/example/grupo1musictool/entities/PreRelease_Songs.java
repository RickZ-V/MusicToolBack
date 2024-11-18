package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
@Table(name = "PreRelease_Songs")
public class PreRelease_Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "genre", nullable = false, length = 100)
    private String genre;
    @Column(name = "duration", nullable = false, length = 10 )
    private Time duration;

    public PreRelease_Songs() {}

    public PreRelease_Songs(int id, String name, String genre, Time duration) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
