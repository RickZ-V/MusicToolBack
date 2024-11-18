package com.example.grupo1musictool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.grupo1musictool.entities.Merchandising;

import java.util.List;
@Repository
public interface IMerchadisingRepository extends JpaRepository<Merchandising,Integer>{
    @Query("select s from Merchandising s where s.description_merchandising like %:descripcion%")
    public List<Merchandising> buscardescripcion(@Param(("descripcion")) String descripcion);
    @Query("select s from Merchandising s where s.name_merchandising like %:nombre%")
    public List<Merchandising> buscarnombre(@Param(("nombre")) String nombre);
}

