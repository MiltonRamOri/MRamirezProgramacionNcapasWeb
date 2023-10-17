/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author digis
 */
@Entity 
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idinmueble;
    
    @Basic
    private String nombre;
    
    @ManyToOne
    @JoinColumn (name = "idtipoinmueble")
    private TipoInmueble tipoinmueble;
    private int precio;
    
    @ManyToOne
    @JoinColumn (name = "idmoneda")
    private Moneda moneda;
    
    @ManyToOne
    @JoinColumn (name = "idantiguedad")
    private Antiguedad antiguedad;
    
    private int numerorecamaras;
    private int numerobaños;
    private int numeroestacionamientos;
    private int superficie;
    
    @ManyToOne
    @JoinColumn (name = "idunidad")
    private Unidad unidad;
    
    private int latitud;
    private int longitud;
    
    @Lob
    private String imagen;

    public Inmueble() {
    }

    public Inmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public Inmueble(int idinmueble, String nombre, TipoInmueble tipoinmueble, int precio, Moneda moneda, Antiguedad antiguedad, int numerorecamaras, int numerobaños, int numeroestacionamientos, int superficie, Unidad unidad, int latitud, int longitud, String imagen) {
        this.idinmueble = idinmueble;
        this.nombre = nombre;
        this.tipoinmueble = tipoinmueble;
        this.precio = precio;
        this.moneda = moneda;
        this.antiguedad = antiguedad;
        this.numerorecamaras = numerorecamaras;
        this.numerobaños = numerobaños;
        this.numeroestacionamientos = numeroestacionamientos;
        this.superficie = superficie;
        this.unidad = unidad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public int getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoInmueble getTipoinmueble() {
        return tipoinmueble;
    }

    public void setTipoinmueble(TipoInmueble tipoinmueble) {
        this.tipoinmueble = tipoinmueble;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Antiguedad antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getNumerorecamaras() {
        return numerorecamaras;
    }

    public void setNumerorecamaras(int numerorecamaras) {
        this.numerorecamaras = numerorecamaras;
    }

    public int getNumerobaños() {
        return numerobaños;
    }

    public void setNumerobaños(int numerobaños) {
        this.numerobaños = numerobaños;
    }

    public int getNumeroestacionamientos() {
        return numeroestacionamientos;
    }

    public void setNumeroestacionamientos(int numeroestacionamientos) {
        this.numeroestacionamientos = numeroestacionamientos;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}














