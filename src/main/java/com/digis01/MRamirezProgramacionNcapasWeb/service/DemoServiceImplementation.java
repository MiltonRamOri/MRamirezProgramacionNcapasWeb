/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.service;

import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Datos;
import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Resultado;

/**
 *
 * @author digis
 */
public class DemoServiceImplementation implements IDemoService {
    
    @Override
    public Resultado Suma(Datos datos){
        return new Resultado(datos.getNumero1() + datos.getNumero2());
        
    }
    @Override
    public Resultado Resta(Datos datos){
        return new Resultado(datos.getNumero1() - datos.getNumero2());
        
    }
    @Override
    public Resultado Multiplicacion(Datos datos){
        return new Resultado(datos.getNumero1() * datos.getNumero2());
       
        
    }
    @Override
    public Resultado Division(Datos datos){
        return new Resultado(datos.getNumero1() / datos.getNumero2());
        
    }
    @Override
    public String Saludo(String nombre) {
        return "Hola, " + nombre;
    }
    
}
