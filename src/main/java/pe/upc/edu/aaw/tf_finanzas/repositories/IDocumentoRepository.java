package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;

import javax.swing.text.Document;
import java.util.List;

@Repository
public interface IDocumentoRepository extends JpaRepository<Documento,Integer> {
    @Query(value = "SELECT " +
            "c.id_cartera, " +
            "c.nombre AS nombre_cartera, " +
            "c.fecha_descuento, " +
            "c.moneda, " +
            "d.id_documento, " +
            "d.fecha_emision, " +
            "d.fecha_vencimiento, " +
            "d.valor_documento, " +
            "d.cliente_nombre, " +
            "d.cliente_phone, " +
            "d.currency AS documento_currency, " +
            "d.estado, " +
            "d.tipo_documento " +
            "FROM cartera c " +
            "JOIN documento d ON c.id_cartera = d.id_cartera " +
            "WHERE c.id_cartera = :idCartera", nativeQuery = true)
    List<Object[]> findDocumentosByCarteraId(@Param("idCartera") Integer idCartera);

    @Query(value = "SELECT d.* FROM Documento d JOIN Cartera c ON d.id_cartera = c.id_cartera JOIN Empresa e ON c.id_empresa = e.id_empresa JOIN Usuario u ON e.id_usuario = u.id_usuario WHERE u.username = :username", nativeQuery = true)
    List<Documento> findDocumentosByUsernameNative(@Param("username") String username);


}
