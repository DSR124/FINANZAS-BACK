package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.EmpresaDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IEmpresaService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaService EmprR;
    @PostMapping("Registrar")
    //@PreAuthorize("hasAuthority('administrador')")
    public void registrar(@RequestBody EmpresaDTO dto){
        ModelMapper m=new ModelMapper();
        Empresa d=m.map(dto, Empresa.class);
        EmprR.insert(d);
    }
    @GetMapping("Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<EmpresaDTO> listar(){
        return EmprR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EmpresaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("Eliminar/{id}")
    //  @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        EmprR.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody EmpresaDTO dto){
        ModelMapper m=new ModelMapper();
        Empresa d=m.map(dto, Empresa.class);
        EmprR.insert(d);
    }
    @GetMapping("ListarporID/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public EmpresaDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        EmpresaDTO emp= m.map(EmprR.listId(id), EmpresaDTO.class);
        return emp;
    }

    @GetMapping("ListarPorUsuario/{username}")
    public List<EmpresaDTO> listarPorUsuario(@PathVariable("username") String username) {
        ModelMapper modelMapper = new ModelMapper();
        return EmprR.findByUsuario_Username(username).stream()
                .map(empresa -> modelMapper.map(empresa, EmpresaDTO.class))
                .collect(Collectors.toList());
    }
}
