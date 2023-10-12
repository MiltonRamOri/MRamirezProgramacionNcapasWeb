/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;


import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface ITipoInmuebleDAO {
    List<TipoInmueble> GetAll();
    void Update(TipoInmueble tipoinmueble);
    int Add(TipoInmueble tipoinmueble);
    TipoInmueble GetById(int idtipoinmuebleeditable); 
    void Delete(TipoInmueble tipoinmueble);
    
}
