package com.example.grupo1musictool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.grupo1musictool.entities.Publics;
import com.example.grupo1musictool.entities.Suscription;

import java.time.LocalDate;
import java.util.List;

public interface IPublicsRepository extends JpaRepository<Publics, Integer> {
    @Query(value = "select p from Publics p where p.date=:fechapublicacion")
    public List<Publics> buscarfecha(@Param("fechapublicacion") LocalDate fechapublicacion);
}
