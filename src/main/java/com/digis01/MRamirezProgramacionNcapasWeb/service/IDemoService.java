/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.service;

import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Datos;
import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Resultado;

/**
 *
 * @author digis
 */
public interface IDemoService {
    Resultado Suma(Datos datos);
    Resultado Resta(Datos datos);
    Resultado Multiplicacion(Datos datos);
    Resultado Division(Datos datos);
    String Saludo(String nombre);
    
}
