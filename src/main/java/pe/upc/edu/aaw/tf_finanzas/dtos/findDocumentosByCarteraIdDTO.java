package pe.upc.edu.aaw.tf_finanzas.dtos;

import java.time.LocalDate;

public class findDocumentosByCarteraIdDTO {
    private Integer idCartera;
    private String nombreCartera;
    private LocalDate fechaDescuento;
    private String moneda;
    private Integer idDocumento;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private Double valorDocumento;
    private String clienteNombre;
    private String clientePhone;
    private String documentoCurrency;
    private String estado;
    private String tipoDocumento;
    private Double tep; // Agregar el TEP del contrato asociado al documento

    public Integer getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Integer idCartera) {
        this.idCartera = idCartera;
    }

    public String getNombreCartera() {
        return nombreCartera;
    }

    public void setNombreCartera(String nombreCartera) {
        this.nombreCartera = nombreCartera;
    }

    public LocalDate getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(LocalDate fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
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

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClientePhone() {
        return clientePhone;
    }

    public void setClientePhone(String clientePhone) {
        this.clientePhone = clientePhone;
    }

    public String getDocumentoCurrency() {
        return documentoCurrency;
    }

    public void setDocumentoCurrency(String documentoCurrency) {
        this.documentoCurrency = documentoCurrency;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Double getTep() {
        return tep;
    }

    public void setTep(Double tep) {
        this.tep = tep;
    }
}
