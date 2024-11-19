package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;

import java.util.List;

@Repository
public interface ICarteraRepository extends JpaRepository<Cartera,Integer> {
    @Query(value = "SELECT " +
            "c.id_cartera, " +
            "c.nombre AS nombre_cartera, " +
            "c.fecha_creacion, " +
            "c.fecha_descuento, " +
            "e.nombre AS nombre_empresa, " +
            "c.moneda, " +
            "COUNT(d.id_documento) AS cantidad_documentos, " +
            "COALESCE(SUM(d.valor_documento), 0) AS monto_total_cartera, " +
            "CASE " +
            "    WHEN COUNT(CASE WHEN d.estado != 'DESCONTADO' THEN 1 END) > 0 THEN 0 " +
            "    ELSE COALESCE(AVG(con.tep), 0) " +
            "END AS tcea " +
            "FROM cartera c " +
            "LEFT JOIN empresa e ON c.id_empresa = e.id_empresa " +
            "LEFT JOIN usuario u ON e.id_usuario = u.id_usuario " +
            "LEFT JOIN documento d ON c.id_cartera = d.id_cartera " +
            "LEFT JOIN contrato con ON d.id_documento = con.id_documento " +
            "WHERE u.username = :username " +
            "GROUP BY c.id_cartera, c.nombre, c.fecha_creacion, c.fecha_descuento, e.nombre, c.moneda " +
            "ORDER BY c.id_cartera", nativeQuery = true)
    List<Object[]> findAllCarteraWithDocumentCountAndTotalValueByUsername(@Param("username") String username);

}
