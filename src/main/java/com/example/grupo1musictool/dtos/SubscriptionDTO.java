package com.example.grupo1musictool.dtos;

import java.time.LocalDate;

public class SubscriptionDTO {
    private int id;
    private String type_susciption;
    private LocalDate sub_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_susciption() {
        return type_susciption;
    }

    public void setType_susciption(String type_susciption) {
        this.type_susciption = type_susciption;
    }

    public LocalDate getSub_date() {
        return sub_date;
    }

    public void setSub_date(LocalDate sub_date) {
        this.sub_date = sub_date;
    }
}
