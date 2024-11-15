package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;

import java.util.List;

public interface IDocumentoService {
    public void insert(Documento documento);
    public List<Documento> list();
    public void delete(int idDocumento);
    public Documento listId(int idDocumento);
    List<Object[]> findDocumentosByCarteraId(int idCartera);
    List<Documento> findDocumentosByUsernameNative(String username);

}
