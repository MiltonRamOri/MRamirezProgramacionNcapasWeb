/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.controller;

import com.digis01.MRamirezProgramacionNcapasWeb.Dao.InmuebleDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Inmueble;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/inmueble")
public class InmuebleController {
    private InmuebleDAOImplementation inmuebleDAOImplementation;
    

    @Autowired
    public InmuebleController(InmuebleDAOImplementation inmuebleDAOImplementation) {
        this.inmuebleDAOImplementation = inmuebleDAOImplementation;
    }

    @GetMapping("/inmuebleList")
    public String Inmuebles(Model model) {
        List<Inmueble> inmuebles = inmuebleDAOImplementation.GetAll();
        model.addAttribute("inmuebles", inmuebles); //Envio de datos para HTML
        model.addAttribute("inmueble", new Inmueble());
        return "inmuebleaListado"; // Esto hace referencia a .html
    }

    

   
    
}
