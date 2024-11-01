package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.DocumentoDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IDocumentoService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Documento")
public class DocumentoController {
    @Autowired
    private IDocumentoService carteR;
    @PostMapping("Registrar")
    //@PreAuthorize("hasAuthority('administrador')")
    public void registrar(@RequestBody DocumentoDTO dto){
        ModelMapper m=new ModelMapper();
        Documento d=m.map(dto, Documento.class);
        carteR.insert(d);
    }
    @GetMapping("Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<DocumentoDTO> listar(){
        return carteR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DocumentoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("Eliminar/{id}")
    //  @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        carteR.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody DocumentoDTO dto){
        ModelMapper m=new ModelMapper();
        Documento d=m.map(dto, Documento.class);
        carteR.insert(d);
    }
    @GetMapping("ListarporID/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public DocumentoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        DocumentoDTO emp= m.map(carteR.listId(id), DocumentoDTO.class);
        return emp;
    }
}
