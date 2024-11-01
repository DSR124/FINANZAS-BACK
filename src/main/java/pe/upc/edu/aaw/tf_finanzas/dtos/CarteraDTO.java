package pe.upc.edu.aaw.tf_finanzas.dtos;

import jakarta.persistence.*;
import pe.upc.edu.aaw.tf_finanzas.entities.Empresa;

import java.time.LocalDate;

public class CarteraDTO {

    private int idCartera;
    private String Nombre;
    private LocalDate fechaDescuento;
    private String Moneda;
    private int tcea;
    private LocalDate fechaCreacion;
    private EmpresaDTO empresa;

    public int getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public LocalDate getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(LocalDate fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public int getTcea() {
        return tcea;
    }

    public void setTcea(int tcea) {
        this.tcea = tcea;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }
}

