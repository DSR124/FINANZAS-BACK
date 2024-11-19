package pe.upc.edu.aaw.tf_finanzas.dtos;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

public class BancoDTO {

    private int idBanco;
    private String nombre;
    private byte[] imageUrl;
    private double balance;
    private double tasaNomninal;
    private double tasaEfectiva;
    private LocalDate creationDate;

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
