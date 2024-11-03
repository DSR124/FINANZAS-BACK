package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.CarteraSummaryDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.ContratoDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Contrato;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IContratoService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Contrato")

public class ContratoController {
    @Autowired
    private IContratoService contR;
    @PostMapping("Registrar")
    //@PreAuthorize("hasAuthority('administrador')")
    public void registrar(@RequestBody ContratoDTO dto){
        ModelMapper m=new ModelMapper();
        Contrato d=m.map(dto, Contrato.class);
        contR.insert(d);
    }
    @GetMapping("Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<ContratoDTO> listar(){
        return contR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("Eliminar/{id}")
    //  @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        contR.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody ContratoDTO dto){
        ModelMapper m=new ModelMapper();
        Contrato d=m.map(dto, Contrato.class);
        contR.insert(d);
    }
    @GetMapping("ListarporID/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public ContratoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ContratoDTO emp= m.map(contR.listId(id), ContratoDTO.class);
        return emp;
    }





}
