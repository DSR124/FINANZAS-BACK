package pe.upc.edu.aaw.tf_finanzas.servicesinterfaces;

import pe.upc.edu.aaw.tf_finanzas.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public void delete(int idUsuario);
    public Usuario listId(int idUsuario);


}
