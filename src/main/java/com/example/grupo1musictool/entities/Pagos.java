package com.example.grupo1musictool.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pago")
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "mount", nullable = false)
    private Double mount;
    @Column(name = "pay_date", nullable = false)
    private LocalDate pay_date;
    @Column(name = "pay_method", nullable = false, length = 100)
    private String pay_method;
    // Falta tabla suscripción para FK
    @ManyToOne
    @JoinColumn(name = "id_subs")
    private Suscription subs;


    public Pagos() {
    }

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
