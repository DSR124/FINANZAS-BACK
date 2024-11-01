package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Documento;

import java.util.List;

public interface IDocumentoService {
    public void insert(Documento documento);
    public List<Documento> list();
    public void delete(int idDocumento);
    public Documento listId(int idDocumento);
}
