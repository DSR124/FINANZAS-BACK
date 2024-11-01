package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Rol;

import java.util.List;

public interface IRolService {
    public void insert(Rol rol);
    public List<Rol> list();
    public void delete(int idRol);
    public Rol listId(int idRol);
}
