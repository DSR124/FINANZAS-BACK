package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.DocumentoDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.findDocumentosByCarteraIdDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Documento;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IDocumentoService;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Documento")
public class DocumentoController {
    @Autowired
    private IDocumentoService carteR;
    @Autowired
    private IUsuarioService usuarioService;
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
    @GetMapping("ListarPorUsuario/{username}")
    public List<DocumentoDTO> listarDocumentosPorUsuario(@PathVariable("username") String username) {
        List<Documento> documentos = carteR.findDocumentosByUsernameNative(username);
        ModelMapper modelMapper = new ModelMapper();
        return documentos.stream()
                .map(documento -> modelMapper.map(documento, DocumentoDTO.class))
                .collect(Collectors.toList());
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

            // Mapear los valores de los índices de la consulta
            dto.setIdCartera(doc[0] != null ? (Integer) doc[0] : null);
            dto.setNombreCartera(doc[1] != null ? (String) doc[1] : null);
            dto.setFechaDescuento(doc[2] != null ? LocalDate.parse(doc[2].toString()) : null);
            dto.setMoneda(doc[3] != null ? (String) doc[3] : null);
            dto.setIdDocumento(doc[4] != null ? (Integer) doc[4] : null);
            dto.setFechaEmision(doc[5] != null ? LocalDate.parse(doc[5].toString()) : null);
            dto.setFechaVencimiento(doc[6] != null ? LocalDate.parse(doc[6].toString()) : null);
            dto.setValorDocumento(doc[7] != null ? Double.parseDouble(doc[7].toString()) : null);
            dto.setClienteNombre(doc[8] != null ? (String) doc[8] : null);
            dto.setClientePhone(doc[9] != null ? (String) doc[9] : null);
            dto.setDocumentoCurrency(doc[10] != null ? (String) doc[10] : null);
            dto.setEstado(doc[11] != null ? (String) doc[11] : null);
            dto.setTipoDocumento(doc[12] != null ? (String) doc[12] : null);

            // Verificar y asignar el TEP si está disponible en la consulta
            if (doc.length > 13 && doc[13] != null) {
                dto.setTep(Double.parseDouble(doc[13].toString()));
            } else {
                dto.setTep(0.0); // Si no existe TEP, asignar 0.0 como valor predeterminado
            }

            documentosDTO.add(dto);
        }

        return documentosDTO;
    }


    @DeleteMapping("Eliminar2/{id}")
    public ResponseEntity<Map<String, String>> eliminarDocumento(@PathVariable("id") Integer id, @RequestParam("username") String username) {
        // Buscar el documento por ID
        Documento documento = carteR.listId(id);
        if (documento == null) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Documento no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Verificar si el usuario tiene permiso para eliminar el documento
        Empresa empresa = documento.getCartera().getEmpresa();
        if (!empresa.getUsuario().getUsername().equals(username)) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "No tiene permiso para eliminar este documento");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        // Eliminar el documento
        carteR.delete(id);

        // Devolver un mensaje de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "Documento eliminado exitosamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("ModificarEstado")
    public ResponseEntity<Map<String, String>> modificarEstadoDocumento(
            @RequestBody DocumentoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Documento documento = modelMapper.map(dto, Documento.class);

        // Validar si el documento existe
        Documento documentoExistente = carteR.listId(documento.getIdDocumento());
        if (documentoExistente == null) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Documento no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Actualizar el estado del documento
        documentoExistente.setEstado("DESCONTADO"); // Cambiar el estado a "DESCONTADO"
        carteR.update(documentoExistente);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Estado del documento actualizado exitosamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
