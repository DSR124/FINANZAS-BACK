package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.BancoDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Banco;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IBancoService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Banco")
public class BancoController {
    @Autowired
    private IBancoService BancR;
    @PostMapping("/Registrar")
    //@PreAuthorize("hasAuthority('administrador')")
    public void registrar(@RequestBody BancoDTO dto){
        ModelMapper m=new ModelMapper();
        Banco d=m.map(dto, Banco.class);
        BancR.insert(d);
    }
    @GetMapping("/Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<BancoDTO> listar(){
        return BancR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,BancoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("Eliminar/{id}")
    //  @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        BancR.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody BancoDTO dto){
        ModelMapper m=new ModelMapper();
        Banco d=m.map(dto, Banco.class);
        BancR.insert(d);
    }
    @GetMapping("ListarporID/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public BancoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        BancoDTO emp= m.map(BancR.listId(id), BancoDTO.class);
        return emp;
    }
}
