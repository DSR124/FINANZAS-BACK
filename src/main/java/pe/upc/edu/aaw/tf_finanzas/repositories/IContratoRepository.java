package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
import pe.upc.edu.aaw.tf_finanzas.entities.Contrato;

import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato,Integer> {
    // Consulta nativa para obtener contratos por username
    @Query(value = "SELECT c.* " +
            "FROM contrato c " +
            "JOIN documento d ON c.id_documento = d.id_documento " +
            "JOIN cartera ca ON d.id_cartera = ca.id_cartera " +
            "JOIN empresa e ON ca.id_empresa = e.id_empresa " +
            "JOIN usuario u ON e.id_usuario = u.id_usuario " +
            "WHERE u.username = :username", nativeQuery = true)
    List<Contrato> findContratosByUsernameNative(@Param("username") String username);
}
