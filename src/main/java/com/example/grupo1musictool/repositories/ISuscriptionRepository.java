package com.example.grupo1musictool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.grupo1musictool.entities.Suscription;

import java.time.LocalDate;
import java.util.List;

public interface ISuscriptionRepository extends JpaRepository<Suscription, Integer> {
    @Query("select s from Suscription s where s.type_susciption like %:tiposuscripcion%")
    public List<Suscription> buscartipodesuscripcion(@Param(("tiposuscripcion")) String tiposuscripcion);
    @Query("select s from Suscription s where s.sub_date between :fechainicio and :fechafin")
    public List<Suscription> buscarrango(@Param(("fechainicio")) LocalDate fechainicio, @Param(("fechafin")) LocalDate fechafin );
}
