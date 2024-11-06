package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Contrato;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;

import java.util.List;

public interface IContratoService {
    public void insert(Contrato contrato);
    public List<Contrato> list();
    public void delete(int idContrato);
    public Contrato listId(int idContrato);
}
