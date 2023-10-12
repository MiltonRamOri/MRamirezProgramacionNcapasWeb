/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.controller;

import com.digis01.MRamirezProgramacionNcapasWeb.Dao.TipoInmuebleDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/inmobilaria")
public class InmobilariaController {

    private TipoInmuebleDAOImplementation tipoinmuebleDAOImplementation;

    @Autowired
    public InmobilariaController(TipoInmuebleDAOImplementation tipoinmuebleDAOImplementation) {
        this.tipoinmuebleDAOImplementation = tipoinmuebleDAOImplementation;
    }

    @GetMapping("/inmobilariaList")
    public String TiposDeInmuebles(Model model) {
        List<TipoInmueble> tipoinmuebles = tipoinmuebleDAOImplementation.GetAll();
        model.addAttribute("tipoinmuebles", tipoinmuebles); //Envio de datos para HTML
        model.addAttribute("tipoinmueble", new TipoInmueble());
        return "inmobilariaListado"; // Esto hace referencia a .html
    }

    @PostMapping("/inmobilaria")
    public String procesarFormulario(@ModelAttribute("tipoinmueble") TipoInmueble tipoinmueble, Model model) {

        List<TipoInmueble> tipoinmuebles = tipoinmuebleDAOImplementation.GetAll();
        model.addAttribute("tipoinmuebles", tipoinmuebles);

        return "inmobilariaListado";
    }
    
    @GetMapping("/forminmobilaria/{idtipoinmueble}") //@GetMapping("/editarUsuario/{idusuario}")
    public String form(@PathVariable int idtipoinmueble, Model model) {

        if (idtipoinmueble == 0) {//Si no esta en la BD, ADD
            TipoInmueble tipoinmueble = new TipoInmueble();
            model.addAttribute("tipoinmueble", tipoinmueble);

            return "formTipoInmuebleEditable";
        } else {//UPDATE
            TipoInmueble tipoinmueble = tipoinmuebleDAOImplementation.GetById(idtipoinmueble);
            model.addAttribute("tipoinmueble", tipoinmueble);
                
             
            
                

            return "formTipoInmuebleEditable";

        }

    }
    @PostMapping("/forminmobilaria")
    public String Update(@Valid @ModelAttribute("tipoinmueble") TipoInmueble tipoinmueble,
            Model model) {
        
        if(tipoinmueble.getIdtipoinmueble() > 0){
            
            tipoinmuebleDAOImplementation.Update(tipoinmueble);
            
        }else{
            tipoinmuebleDAOImplementation.Add(tipoinmueble);
        }

        return "redirect:/inmobilaria/inmobilariaList";
    }
    
    @GetMapping("/eliminarTipoInmueble/{idtipoinmueble}")
    public String Delete(@PathVariable int idtipoinmueble, Model model) {

        TipoInmueble tipoinmueble = tipoinmuebleDAOImplementation.GetById(idtipoinmueble);
        model.addAttribute("tipoinmueble", tipoinmueble);
        tipoinmuebleDAOImplementation.Delete(tipoinmueble);

        return "redirect:/inmobilaria/inmobilariaList";
    }
    

}
