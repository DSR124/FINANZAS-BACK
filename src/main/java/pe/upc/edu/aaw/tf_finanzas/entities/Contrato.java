package pe.upc.edu.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="currency", length = 50, nullable = false)
    private String currency;
    @Column(name ="valorNominal", nullable = false)
    private double valorNominal;
    @Column(name ="tasaDescontada", nullable = false)
    private double tasaDescontada;
    @Column(name ="valorRecibido", nullable = false)
    private double valorRecibido;
    @Column(name ="dias", nullable = false)
    private Integer dias;
    @Column(name ="tep", nullable = false)
    private double tep;
    @Column(name ="tipoTasa", length = 50, nullable = false)
    private String tipoTasa;
    @Column(name ="valorTasa", nullable = false)
    private double valorTasa;
    @Column(name ="estado", length = 50, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private Documento documento;

    @ManyToOne
    @JoinColumn(name = "idBanco")
    private Banco banco;


    public Contrato() {
    }

    public Contrato(Long id, String currency, double valorNominal, double tasaDescontada, double valorRecibido, Integer dias, double tep, String tipoTasa, double valorTasa, String estado, Documento documento, Banco banco) {
        this.id = id;
        this.currency = currency;
        this.valorNominal = valorNominal;
        this.tasaDescontada = tasaDescontada;
        this.valorRecibido = valorRecibido;
        this.dias = dias;
        this.tep = tep;
        this.tipoTasa = tipoTasa;
        this.valorTasa = valorTasa;
        this.estado = estado;
        this.documento = documento;
        this.banco = banco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(double valorNominal) {
        this.valorNominal = valorNominal;
    }

    public double getTasaDescontada() {
        return tasaDescontada;
    }

    public void setTasaDescontada(double tasaDescontada) {
        this.tasaDescontada = tasaDescontada;
    }

    public double getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(double valorRecibido) {
        this.valorRecibido = valorRecibido;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public double getTep() {
        return tep;
    }

    public void setTep(double tep) {
        this.tep = tep;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public double getValorTasa() {
        return valorTasa;
    }

    public void setValorTasa(double valorTasa) {
        this.valorTasa = valorTasa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
