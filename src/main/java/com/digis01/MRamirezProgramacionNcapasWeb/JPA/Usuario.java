/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.JPA;

import jakarta.persistence.Basic;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author digis
 */
@Entity
public class Usuario implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;
    
    @Basic
//    @NotEmpty(message = "Ingresa datos")
//    @Size(min = 3, max = 5, message = "Cadena entre 3 y 5")
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String username;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento; 
    
    private String Email;
    private String Password;
    private char Sexo;
    private String Telefono;
    
    @ManyToOne
    @JoinColumn (name = "idrol")
    private Rol rol;
    
    @Lob
    private String imagen;
    
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }

    public Usuario(int idusuario, String nombre, String apellidopaterno, String apellidomaterno, String username, Date fechanacimiento, String Email, String Password, char Sexo, String Telefono, Rol rol, String imagen, String status, String Celular, String Curp) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.username = username;
        this.fechanacimiento = fechanacimiento;
        this.Email = Email;
        this.Password = Password;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.rol = rol;
        this.imagen = imagen;
        this.status = status;
        this.Celular = Celular;
        this.Curp = Curp;
    }
    
    
    
    
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(int idusuario, String nombre, String apellidopaterno, String apellidomaterno, String username, Date fechanacimiento, String Email, String Password, char Sexo, String Telefono, Rol rol, String Celular, String Curp) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.username = username;
        this.fechanacimiento = fechanacimiento;
        this.Email = Email;
        this.Password = Password;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.rol = rol;
        this.Celular = Celular;
        this.Curp = Curp;
    }
    
    
    
    public Usuario(int idusuario, String nombre, String apellidopaterno, String apellidomaterno, String username, Date fechanacimiento, String Email, String Password, char Sexo, String Telefono, String Celular, String Curp, Rol rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.username = username;
        this.fechanacimiento = fechanacimiento;
        this.Email = Email;
        this.Password = Password;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Curp = Curp;
        this.rol = rol;
    }
    private String Celular;
    private String Curp;

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno, String username, Date fechanacimiento, String Email, String Password, char Sexo, String Telefono, String Celular, String Curp, Rol rol, String imagen) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.username = username;
        this.fechanacimiento = fechanacimiento;
        this.Email = Email;
        this.Password = Password;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Curp = Curp;
        this.rol = rol;
        this.imagen = imagen;
    }

    
    
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
  

    public Usuario() {
    }

    
    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

    
    
}
