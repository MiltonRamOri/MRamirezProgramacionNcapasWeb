/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.restController;

import com.digis01.MRamirezProgramacionNcapasWeb.Dao.UsuarioDAOImplementation;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/UsuarioApi")
public class UsuarioRestController {
    private UsuarioDAOImplementation usuarioDAOImplementation;

    public UsuarioRestController(UsuarioDAOImplementation usuarioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }
    
    @GetMapping("/GetAll")
    public List<Usuario> GetAll(@RequestBody Usuario usuario) {
        
        
        return usuarioDAOImplementation.GetAll(new Usuario(usuario.getNombre(), usuario.getApellidopaterno(), usuario.getApellidopaterno()));
        
    }
    
    
}
