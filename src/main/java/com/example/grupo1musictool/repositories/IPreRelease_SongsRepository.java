package com.example.grupo1musictool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.grupo1musictool.entities.PreRelease_Songs;

import java.util.List;

@Repository
public interface IPreRelease_SongsRepository extends JpaRepository<PreRelease_Songs, Integer> {
    @Query("select p from PreRelease_Songs p where p.genre like %:genre%")
    public List<PreRelease_Songs> buscarGenero(@Param(("genre")) String genero);
    @Query("select p from PreRelease_Songs p where p.name like %:name%")
    public List<PreRelease_Songs> buscarNombre(@Param(("name")) String nombre);
    @Query(value = "select genre, count(*) as total_canciones\n" +
            " from pre_release_songs\n" +
            " group by genre\n" +
            " order by total_canciones desc;",nativeQuery = true)
    public List<String[]> contarCancionesOrden();
    @Query(value = " SELECT COUNT(id) AS total_canciones FROM pre_release_songs",nativeQuery = true)
    public List<String[]> totalCanciones();
}
