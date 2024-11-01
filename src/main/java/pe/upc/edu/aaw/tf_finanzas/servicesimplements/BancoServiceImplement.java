package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Banco;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;
import pe.upc.edu.aaw.tf_finanzas.repositories.IBancoRepository;
import pe.upc.edu.aaw.tf_finanzas.repositories.IEmpresaRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IBancoService;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IEmpresaService;

import java.util.List;

@Service
public class BancoServiceImplement implements IBancoService {

    @Autowired
    private IBancoRepository bancR;

    @Override
    public void insert(Banco banco) {
        bancR.save(banco);
    }

    @Override
    public List<Banco> list() {
        return bancR.findAll();
    }

    @Override
    public void delete(int idBanco) {
        bancR.deleteById(idBanco);
    }

    @Override
    public Banco listId(int idBanco) {
        return bancR.findById(idBanco).orElse(new Banco());
    }
}
