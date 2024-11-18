package com.example.grupo1musictool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.grupo1musictool.entities.Pagos;

import java.util.List;

public interface IPagosRepository extends JpaRepository<Pagos, Integer> {
    @Query("select p from Pagos p where p.mount = :monto")
    public List<Pagos> buscar(@Param("monto") Double monto);
    @Query(value = "select pay_method, count(*) as total_metodo\n" +
            " from pago\n" +
            " group by pay_method\n" +
            " order by total_metodo desc;",nativeQuery = true)
    public List<String[]> totalMetodoPago();
    @Query(value = " SELECT s.type_susciption AS tipo_suscripcion, COUNT(p.id_subs) AS total_suscripciones\n" +
            " FROM pago p\n" +
            " JOIN suscription s ON p.id_subs = s.id\n" +
            " GROUP BY s.type_susciption\n" +
            " ORDER BY total_suscripciones;\n",nativeQuery = true)
    public List<String[]> totalTipoSub();
}
