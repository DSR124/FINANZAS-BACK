package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.UsuarioDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Usuario;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("Registrar")
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }
    @GetMapping("Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("Eliminar/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        uS.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uS.insert(u);
    }
    @GetMapping("ListarporID/{id}")
    //@PreAuthorize("hasAuthority('administrador')")
    public UsuarioDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO u= m.map(uS.listId(id), UsuarioDTO.class);
        return u;
    }

}
