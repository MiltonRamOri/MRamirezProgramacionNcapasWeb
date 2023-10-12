/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author digis
 */
@Controller//Indicar que es un contolador con notaciones
public class DemoController {
    //Indicar la ruta de la pagina
    
    @GetMapping("/") //Completar el URL
	public String greeting(@RequestParam(name="name", required=false,
                defaultValue = "Digis01") String name, Model model) {
		model.addAttribute("name", name);
		return "login";
	}
  

            
    
            
}
