package pe.upc.edu.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;
import pe.upc.edu.aaw.tf_finanzas.repositories.IDocumentoRepository;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IDocumentoService;

import java.util.List;

@Service
public class DocumentoServiceImplement implements IDocumentoService {
    @Autowired
    private IDocumentoRepository docR;

    @Override
    public void insert(Documento documento) {
        docR.save(documento);
    }

    @Override
    public List<Documento> list() {
        return docR.findAll();
    }

    @Override
    public void delete(int idDocumento) {
        docR.deleteById(idDocumento);
    }

    @Override
    public Documento listId(int idDocumento) {
        return docR.findById(idDocumento).orElse(new Documento());
    }

    @Override
    public List<Object[]> findDocumentosByCarteraId(int idCartera) {
        return docR.findDocumentosByCarteraId(idCartera);
    }
}
