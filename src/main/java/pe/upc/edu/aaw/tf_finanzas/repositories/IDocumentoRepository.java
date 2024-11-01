package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;

import javax.swing.text.Document;

@Repository
public interface IDocumentoRepository extends JpaRepository<Documento,Integer> {
}
