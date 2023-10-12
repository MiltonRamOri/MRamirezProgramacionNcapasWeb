/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Servicio;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IServicioDAO {
    List<Servicio> GetAll();
    Servicio GetById(int idservicioeditable );
    int Add(Servicio servicio);
    void Delete(Servicio servicio);
     void Update(Servicio servicio);
    
}
