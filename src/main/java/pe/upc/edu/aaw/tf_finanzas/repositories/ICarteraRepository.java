package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
@Repository
public interface ICarteraRepository extends JpaRepository<Cartera,Integer> {
}
