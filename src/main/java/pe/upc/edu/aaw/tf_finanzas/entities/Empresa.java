package pe.upc.edu.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;
    @Column(name ="Nombre", length = 50, nullable = false)
    private String Nombre;
    @Column(name ="Tipo", length = 50, nullable = false)
    private String Tipo;
    @Column(name ="Ruc", nullable = false)
    private int Ruc;
    @Column(name ="Direccion", length = 50, nullable = false)
    private String Direccion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public Empresa() {
    }

    public Empresa(int idEmpresa, String nombre, String tipo, int ruc, String direccion, Usuario usuario) {
        this.idEmpresa = idEmpresa;
        Nombre = nombre;
        Tipo = tipo;
        Ruc = ruc;
        Direccion = direccion;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getRuc() {
        return Ruc;
    }

    public void setRuc(int ruc) {
        Ruc = ruc;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
