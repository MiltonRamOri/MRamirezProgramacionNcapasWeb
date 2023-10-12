/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IAUsuarioDAO {
    //firma de metodo
    //tipo de retorn 
    List<Usuario> GetAll(Usuario usuario);
    
    int Add(Usuario usuario);
    
    Usuario GetById(int idalumnoeditable);
    
    void Update(Usuario usuario);
    
    void Delete(Usuario usuario);
    
    void ChangeStatus(int idusuario, boolean status);
    
    
}
