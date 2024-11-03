package pe.upc.edu.aaw.tf_finanzas.dtos;

public class CarteraSummaryDTO {
    private Integer idCartera;
    private String nombreCartera;
    private String fechaCreacion;
    private String fechaDescuento;
    private String nombreEmpresa;
    private Double tcea;
    private String moneda;
    private Long cantidadDocumentos;
    private Double montoTotalCartera;

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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(String fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Double getTcea() {
        return tcea;
    }

    public void setTcea(Double tcea) {
        this.tcea = tcea;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getCantidadDocumentos() {
        return cantidadDocumentos;
    }

    public void setCantidadDocumentos(Long cantidadDocumentos) {
        this.cantidadDocumentos = cantidadDocumentos;
    }

    public Double getMontoTotalCartera() {
        return montoTotalCartera;
    }

    public void setMontoTotalCartera(Double montoTotalCartera) {
        this.montoTotalCartera = montoTotalCartera;
    }
}