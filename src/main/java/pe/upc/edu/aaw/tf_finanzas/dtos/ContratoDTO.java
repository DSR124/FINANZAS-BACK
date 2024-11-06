package pe.upc.edu.aaw.tf_finanzas.dtos;
import java.time.LocalDate;

public class ContratoDTO {
    private Long id;
    private String currency;
    private double valorNominal;
    private double tasaDescontada;
    private double valorRecibido;
    private Integer dias;
    private double tep;
    private String tipoTasa;
    private double valorTasa;
    private String estado;
    private DocumentoDTO documento;
    private BancoDTO banco;

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

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public double getTep() {
        return tep;
    }

    public void setTep(double tep) {
        this.tep = tep;
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

    public DocumentoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDTO documento) {
        this.documento = documento;
    }

    public BancoDTO getBanco() {
        return banco;
    }

    public void setBanco(BancoDTO banco) {
        this.banco = banco;
    }
}
