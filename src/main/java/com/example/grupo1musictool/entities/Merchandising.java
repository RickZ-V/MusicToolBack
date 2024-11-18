package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Merchandising")
public class Merchandising {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_merchandising;
    @Column(name = "name_merchandising", nullable = false, length = 20)
    private String name_merchandising;
    @Column(name = "description_merchandising", nullable = false, length = 300)
    private String description_merchandising;
    @Column(name = "price_merchandising", length = 25)
    private int price_merchandising;

    public Merchandising() {
    }

    public Merchandising(int id_merchandising, String name_merchandising, String description_merchandising, int price_merchandising) {
        this.id_merchandising = id_merchandising;
        this.name_merchandising = name_merchandising;
        this.description_merchandising = description_merchandising;
        this.price_merchandising = price_merchandising;
    }

    public int getId_merchandising() {
        return id_merchandising;
    }

    public void setId_merchandising(int id_merchandising) {
        this.id_merchandising = id_merchandising;
    }

    public String getName_merchandising() {
        return name_merchandising;
    }

    public void setName_merchandising(String name_merchandising) {
        this.name_merchandising = name_merchandising;
    }

    public String getDescription_merchandising() {
        return description_merchandising;
    }

    public void setDescription_merchandising(String description_merchandising) {
        this.description_merchandising = description_merchandising;
    }

    public int getPrice_merchandising() {
        return price_merchandising;
    }

    public void setPrice_merchandising(int price_merchandising) {
        this.price_merchandising = price_merchandising;
    }
}

