package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;

import java.util.List;

public interface ICarteraService {
    public void insert(Cartera cartera);
    public List<Cartera> list();
    public void delete(int idCartera);
    public Cartera listId(int idCartera);
    List<Object[]> findAllCarteraWithDocumentCountAndTotalValueByUsername(String username);


}
