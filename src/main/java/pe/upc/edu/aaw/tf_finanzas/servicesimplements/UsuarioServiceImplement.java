package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Usuario;
import pe.upc.edu.aaw.tf_finanzas.repositories.IUsuarioRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int idDessert) {
        uR.deleteById(idDessert);
    }

    @Override
    public Usuario listId(int idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }
    public int findLastUserRegister() {
        return uR.findLastUserRegister();
    }

    @Override
    public Usuario findByUsername(String username) {
        return uR.findByUsername(username);
    }
}
