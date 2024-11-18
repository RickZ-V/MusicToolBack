package com.example.grupo1musictool.dtos;

import com.example.grupo1musictool.entities.Suscription;

import java.time.LocalDate;

public class PagosDTO {
    private int id;
    private Double mount;
    private LocalDate pay_date;
    private String pay_method;
    private Suscription subs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    public LocalDate getPay_date() {
        return pay_date;
    }

    public void setPay_date(LocalDate pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public Suscription getSubs() {
        return subs;
    }

    public void setSubs(Suscription subs) {
        this.subs = subs;
    }
}
