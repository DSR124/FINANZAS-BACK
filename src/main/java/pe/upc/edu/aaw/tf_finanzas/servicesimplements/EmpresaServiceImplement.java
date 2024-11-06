package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;
import pe.upc.edu.aaw.tf_finanzas.repositories.IEmpresaRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IEmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImplement implements IEmpresaService {

    @Autowired
    private IEmpresaRepository EmprR;

    @Override
    public void insert(Empresa empresa) {
        EmprR.save(empresa);
    }

    @Override
    public List<Empresa> list() {
        return EmprR.findAll();
    }

    @Override
    public void delete(int idEmpresa) {
        EmprR.deleteById(idEmpresa);
    }

    @Override
    public Empresa listId(int idEmpresa) {
        return EmprR.findById(idEmpresa).orElse(new Empresa());
    }
    @Override
    public List<Empresa> listByUserId(Integer userId) {
        return EmprR.findByUsuario_IdUsuario(userId);
    }

    @Override
    public List<Empresa> findByUsuario_Username(String username) {
        return EmprR.findByUsuario_Username(username);
    }
}
