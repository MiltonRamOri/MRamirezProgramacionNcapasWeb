/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Estado;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IEstadoDAO {
    
    List<Estado> GetAll();
      List<Estado> GetByIdPais(int IdPais);
}