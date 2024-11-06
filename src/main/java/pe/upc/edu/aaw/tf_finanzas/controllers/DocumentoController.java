package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.DocumentoDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.findDocumentosByCarteraIdDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IDocumentoService;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @GetMapping("ListarporIDCartera/{idCartera}")
    public List<findDocumentosByCarteraIdDTO> obtenerDocumentosPorCartera(@PathVariable("idCartera") Integer idCartera) {
        List<Object[]> documentos = carteR.findDocumentosByCarteraId(idCartera);
        List<findDocumentosByCarteraIdDTO> documentosDTO = new ArrayList<>();

        for (Object[] doc : documentos) {
            findDocumentosByCarteraIdDTO dto = new findDocumentosByCarteraIdDTO();
            dto.setIdCartera((Integer) doc[0]);
            dto.setNombreCartera((String) doc[1]);
            dto.setFechaDescuento(doc[2] != null ? LocalDate.parse(doc[2].toString()) : null);
            dto.setMoneda((String) doc[3]);
            dto.setIdDocumento((Integer) doc[4]);
            dto.setFechaEmision(doc[5] != null ? LocalDate.parse(doc[5].toString()) : null);
            dto.setFechaVencimiento(doc[6] != null ? LocalDate.parse(doc[6].toString()) : null);
            dto.setValorDocumento(doc[7] != null ? Double.parseDouble(doc[7].toString()) : null);
            dto.setClienteNombre((String) doc[8]);
            dto.setClientePhone((String) doc[9]);
            dto.setDocumentoCurrency((String) doc[10]);
            dto.setEstado((String) doc[11]);
            dto.setTipoDocumento((String) doc[12]);
            documentosDTO.add(dto);
        }

        return documentosDTO;
    }
}
