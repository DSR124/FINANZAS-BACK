package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.CarteraDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.CarteraSummaryDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.ICarteraService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cartera")
public class CarteraController {
    @Autowired
    private ICarteraService carteR;
    @PostMapping("Registrar")
    //@PreAuthorize("hasAuthority('administrador')")
    public void registrar(@RequestBody CarteraDTO dto){
        ModelMapper m=new ModelMapper();
        Cartera d=m.map(dto, Cartera.class);
        carteR.insert(d);
    }
    @GetMapping("Listar")
    //@PreAuthorize("hasAuthority('administrador')")
    public List<CarteraDTO> listar(){
        return carteR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CarteraDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("Eliminar/{id}")
    //  @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        carteR.delete(id);
    }

    @PutMapping("Modificar")
    // @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody CarteraDTO dto){
        ModelMapper m=new ModelMapper();
        Cartera d=m.map(dto, Cartera.class);
        carteR.insert(d);
    }
    @GetMapping("ListarporID/{id}")
    // @PreAuthorize("hasAuthority('administrador')")
    public CarteraDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        CarteraDTO emp= m.map(carteR.listId(id), CarteraDTO.class);
        return emp;
    }


    @GetMapping("/cantidadReservaPorusuario")
    public List<CarteraSummaryDTO> CarteraSummary(){
        List<String[]> listaa = carteR.findAllCarteraWithDocumentCountAndTotalValue();
        List<CarteraSummaryDTO> lista_DTO = new ArrayList<>();
        for(String[] data:listaa){

            CarteraSummaryDTO dto = new CarteraSummaryDTO();
            dto.setIdCartera(Integer.parseInt(data[0]));
            dto.setNombreCartera(data[1]);
            dto.setFechaCreacion(data[2]);
            dto.setFechaDescuento(data[3]);
            dto.setNombreEmpresa(data[4]);

            // Asegúrate de que data[5] contenga un valor que pueda ser convertido a Double
            dto.setTcea(Double.parseDouble(data[5]));

            dto.setMoneda(data[6]);

            // Convierte data[7] a Long, si es necesario
            dto.setCantidadDocumentos(Long.parseLong(data[7]));

            // Convierte data[8] a Double, si es necesario
            dto.setMontoTotalCartera(Double.parseDouble(data[8]));

            lista_DTO.add(dto);
        }
        return lista_DTO;
    }

}
