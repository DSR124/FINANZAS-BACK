package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Contrato;
import pe.upc.edu.aaw.tf_finanzas.repositories.IContratoRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IContratoService;

import java.util.List;
@Service
public class ContratoServiceImplement  implements IContratoService {

    @Autowired
    private IContratoRepository conR;

    @Override
    public void insert(Contrato contrato) {
        conR.save(contrato);
    }

    @Override
    public List<Contrato> list() {
        return conR.findAll();
    }

    @Override
    public void delete(int idContrato) {
        conR.deleteById(idContrato);
    }

    @Override
    public Contrato listId(int idContrato) {
        return conR.findById(idContrato).orElse(new Contrato());
    }

    @Override
    public List<Contrato> findContratosByUsernameNative(String username) {
        return conR.findContratosByUsernameNative(username);
    }

}
