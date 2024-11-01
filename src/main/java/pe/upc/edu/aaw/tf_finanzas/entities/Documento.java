package pe.upc.edu.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;

    @Column(name ="tipoDocumento", length = 50, nullable = false)
    private String tipoDocumento;

    @Column(name ="valorDocumento", nullable = false)
    private Double valorDocumento;

    @Column(name ="currency", length = 50, nullable = false)
    private String currency;

    @Column(name ="fechaEmision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name ="fechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;


    @Column(name ="estado", length = 50, nullable = false)
    private String estado;

    @Column(name ="clienteNombre", length = 50, nullable = false)
    private String clienteNombre;

    @Column(name ="ClientePhone", length = 50, nullable = false)
    private String ClientePhone;


    @ManyToOne
    @JoinColumn(name = "idCartera")
    private Cartera cartera;

    public Documento() {
    }

    public Documento(int idDocumento, String tipoDocumento, Double valorDocumento, String currency, LocalDate fechaEmision) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.valorDocumento = valorDocumento;
        this.currency = currency;
        this.fechaEmision = fechaEmision;
    }

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

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }
}
