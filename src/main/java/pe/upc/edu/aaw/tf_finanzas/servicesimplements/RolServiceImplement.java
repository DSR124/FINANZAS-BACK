package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Rol;
import pe.upc.edu.aaw.tf_finanzas.repositories.IRolRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement  implements IRolService {
    @Autowired
    private IRolRepository rolR;

    @Override
    public void insert(Rol rol) {
        rolR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return rolR.findAll();
    }

    @Override
    public void delete(int idRol) {
        rolR.deleteById(idRol);
    }

    @Override
    public Rol listId(int idRol) {
        return rolR.findById(idRol).orElse(new Rol());
    }
}
