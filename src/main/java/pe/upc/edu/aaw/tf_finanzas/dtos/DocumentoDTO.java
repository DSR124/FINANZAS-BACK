package pe.upc.edu.aaw.tf_finanzas.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.upc.edu.aaw.tf_finanzas.entities.Cartera;

import java.time.LocalDate;

public class DocumentoDTO {
    private int idDocumento;
    private String tipoDocumento;
    private Double valorDocumento;
    private String currency;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String estado;
    private String clienteNombre;
    private String ClientePhone;
    private CarteraDTO cartera;

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClientePhone() {
        return ClientePhone;
    }

    public void setClientePhone(String clientePhone) {
        ClientePhone = clientePhone;
    }

    public CarteraDTO getCartera() {
        return cartera;
    }

    public void setCartera(CarteraDTO cartera) {
        this.cartera = cartera;
    }
}
