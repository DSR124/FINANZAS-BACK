package pe.upc.edu.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Cartera")
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCartera;
    @Column(name ="Nombre", length = 50, nullable = false)
    private String Nombre;
    @Column(name ="fechaDescuento", nullable = false)
    private LocalDate fechaDescuento;
    @Column(name ="Moneda", length = 50, nullable = false)
    private String Moneda;
    @Column(name ="tcea", nullable = false)
    private int tcea;
    @Column(name ="fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Cartera() {
    }

    public Cartera(int idCartera, String nombre, LocalDate fechaDescuento, String moneda, int tcea, LocalDate fechaCreacion, Empresa empresa) {
        this.idCartera = idCartera;
        Nombre = nombre;
        this.fechaDescuento = fechaDescuento;
        Moneda = moneda;
        this.tcea = tcea;
        this.fechaCreacion = fechaCreacion;
        this.empresa = empresa;
    }

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
