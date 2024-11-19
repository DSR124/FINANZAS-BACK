package pe.upc.edu.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.aaw.tf_finanzas.dtos.CarteraDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.CarteraSummaryDTO;
import pe.upc.edu.aaw.tf_finanzas.dtos.findDocumentosByCarteraIdDTO;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;
import pe.upc.edu.aaw.tf_finanzas.servicesinterfaces.ICarteraService;

import java.time.LocalDate;
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

    @GetMapping("/findAllCarteraWithDocumentCountAndTotalValueByUsername/{username}")
    public List<CarteraSummaryDTO> CarteraSummaryByUsername(@PathVariable("username") String username) {
        List<Object[]> rawData = carteR.findAllCarteraWithDocumentCountAndTotalValueByUsername(username);
        List<CarteraSummaryDTO> dtoList = new ArrayList<>();

        for (Object[] data : rawData) {
            CarteraSummaryDTO dto = new CarteraSummaryDTO();

            // Parsing and setting values
            dto.setIdCartera(data[0] != null ? ((Number) data[0]).intValue() : null);
            dto.setNombreCartera(data[1] != null ? data[1].toString() : null);
            dto.setFechaCreacion(data[2] != null ? LocalDate.parse(data[2].toString()) : null);
            dto.setFechaDescuento(data[3] != null ? LocalDate.parse(data[3].toString()) : null);
            dto.setNombreEmpresa(data[4] != null ? data[4].toString() : null);
            dto.setMoneda(data[5] != null ? data[5].toString() : null);
            dto.setCantidadDocumentos(data[6] != null ? ((Number) data[6]).longValue() : null);
            dto.setMontoTotalCartera(data[7] != null ? ((Number) data[7]).doubleValue() : null);
            dto.setTcea(data[8] != null ? ((Number) data[8]).doubleValue() : 0.0); // Si es null, asignar 0.0

            dtoList.add(dto);
        }
        return dtoList;
    }



}
