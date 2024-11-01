package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Banco;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;

import java.util.List;

public interface IBancoService {
    public void insert(Banco banco);
    public List<Banco> list();
    public void delete(int idBanco);
    public Banco listId(int idBanco);
}
