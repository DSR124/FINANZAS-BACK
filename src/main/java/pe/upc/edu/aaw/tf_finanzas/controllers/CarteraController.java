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


    @GetMapping("/findAllCarteraWithDocumentCountAndTotalValue")
    public List<CarteraSummaryDTO> CarteraSummary() {
        List<String[]> listaa = carteR.findAllCarteraWithDocumentCountAndTotalValue();
        List<CarteraSummaryDTO> lista_DTO = new ArrayList<>();

        for (String[] data : listaa) {
            CarteraSummaryDTO dto = new CarteraSummaryDTO();

            // Manejo de conversión de idCartera
            dto.setIdCartera(data[0] != null ? Integer.parseInt(data[0]) : null);

            dto.setNombreCartera(data[1]);

            // Conversión de fechaCreacion y fechaDescuento
            if (data[2] != null && !data[2].isEmpty()) {
                dto.setFechaCreacion(LocalDate.parse(data[2]));
            }

            if (data[3] != null && !data[3].isEmpty()) {
                dto.setFechaDescuento(LocalDate.parse(data[3]));
            }

            dto.setNombreEmpresa(data[4]);

            // Conversión de TCEA
            dto.setTcea(data[5] != null ? Double.parseDouble(data[5]) : null);

            dto.setMoneda(data[6]);

            // Conversión de cantidadDocumentos
            dto.setCantidadDocumentos(data[7] != null ? Long.parseLong(data[7]) : null);

            // Conversión de montoTotalCartera
            dto.setMontoTotalCartera(data[8] != null ? Double.parseDouble(data[8]) : null);

            lista_DTO.add(dto);
        }

        return lista_DTO;
    }
}
