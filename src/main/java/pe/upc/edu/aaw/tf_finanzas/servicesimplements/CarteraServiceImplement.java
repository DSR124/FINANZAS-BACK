package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;
import pe.upc.edu.aaw.tf_finanzas.repositories.ICarteraRepository;
import pe.upc.edu.aaw.tf_finanzas.repositories.IEmpresaRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.ICarteraService;

import java.util.List;

@Service
public class CarteraServiceImplement implements ICarteraService {
    @Autowired
    private ICarteraRepository CartR;

    @Override
    public void insert(Cartera cartera) {
        CartR.save(cartera);
    }

    @Override
    public List<Cartera> list() {
        return CartR.findAll();
    }

    @Override
    public void delete(int idCartera) {
        CartR.deleteById(idCartera);
    }

    @Override
    public Cartera listId(int idCartera) {
        return CartR.findById(idCartera).orElse(new Cartera());
    }
}
