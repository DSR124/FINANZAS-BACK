package pe.upc.edu.aaw.tf_finanzas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Entity
@Table(name = "Banco")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBanco;
    @Column(name ="nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name ="imageUrl", nullable = false)
    private byte[] imageUrl;
    @Column(name ="balance", nullable = false)
    private double balance;
    @Column(name ="tasaNomninal", nullable = false)
    private double tasaNomninal;

    @Column(name ="tasaEfectiva", nullable = false)
    private double tasaEfectiva;


    @Column(name ="creationDate", nullable = false)
    private LocalDate creationDate;

    public Banco() {
    }

    public Banco(int idBanco, String nombre, byte[] imageUrl, double balance, double tasaNomninal, double tasaEfectiva, LocalDate creationDate) {
        this.idBanco = idBanco;
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.balance = balance;
        this.tasaNomninal = tasaNomninal;
        this.tasaEfectiva = tasaEfectiva;
        this.creationDate = creationDate;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTasaNomninal() {
        return tasaNomninal;
    }

    public void setTasaNomninal(double tasaNomninal) {
        this.tasaNomninal = tasaNomninal;
    }

    public double getTasaEfectiva() {
        return tasaEfectiva;
    }

    public void setTasaEfectiva(double tasaEfectiva) {
        this.tasaEfectiva = tasaEfectiva;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
