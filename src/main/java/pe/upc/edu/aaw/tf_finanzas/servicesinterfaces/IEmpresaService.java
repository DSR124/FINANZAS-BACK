package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;

import java.util.List;

public interface IEmpresaService {
    public void insert(Empresa empresa);
    public List<Empresa> list();
    public void delete(int IdEmpresa);
    public Empresa listId(int idEmpresa);
    List<Empresa> listByUserId(Integer userId);
    List<Empresa> findByUsuario_Username(String username);
}
