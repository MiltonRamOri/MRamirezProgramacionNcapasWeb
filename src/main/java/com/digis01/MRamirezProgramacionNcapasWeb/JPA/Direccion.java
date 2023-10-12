/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author digis
 */
@Entity
public class Direccion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddireccion;
    private String calle;
    private int numerointerior;
    private int numeroexterior;
    
    
    @ManyToOne //Muchos direcciones para una colonis 
    @JoinColumn (name = "idcolonia")
    private Colonia colonia;

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }
    
    @OneToOne //Un usuario solo tiene direccionunica
    @JoinColumn (name = "idusuario")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(String calle, int numerointerior, int numeroexterior, Colonia colonia, Usuario usuario) {
        this.calle = calle;
        this.numerointerior = numerointerior;
        this.numeroexterior = numeroexterior;
        this.colonia = colonia;
        this.usuario = usuario;
    }
    

    public Direccion(int iddireccion, String calle, int numerointerior, int numeroexterior, Colonia colonia, Usuario usuario) {
        this.iddireccion = iddireccion;
        this.calle = calle;
        this.numerointerior = numerointerior;
        this.numeroexterior = numeroexterior;
        this.colonia = colonia;
        this.usuario = usuario;
    }
     public Direccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public int getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumerointerior() {
        return numerointerior;
    }

    public void setNumerointerior(int numerointerior) {
        this.numerointerior = numerointerior;
    }

    public int getNumeroexterior() {
        return numeroexterior;
    }

    public void setNumeroexterior(int numeroexterior) {
        this.numeroexterior = numeroexterior;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setMunicipio(Colonia colonia) {
        this.colonia = colonia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
