/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.controller;

import com.digis01.MRamirezProgramacionNcapasWeb.Dao.ServicioDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Servicio;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private ServicioDAOImplementation servicioDAOImplementataion;

    @Autowired
    public ServicioController(ServicioDAOImplementation servicioDAOImplementataion) {
        this.servicioDAOImplementataion = servicioDAOImplementataion;
    }

    @GetMapping("/servicioList")
    public String TiposDeInmuebles(Model model) {
        List<Servicio> servicios = servicioDAOImplementataion.GetAll();
        model.addAttribute("servicios", servicios); //Envio de datos para HTML
        model.addAttribute("servicio", new Servicio());
        return "servicioListado"; // Esto hace referencia a .html
    }

    @GetMapping("/formservicio/{idservicio}") //@GetMapping("/editarUsuario/{idusuario}")
    public String form(@PathVariable int idservicio, Model model) {

        if (idservicio == 0) {//Si no esta en la BD, ADD
            Servicio servicio = new Servicio();
            model.addAttribute("servicio", servicio);

            return "formServicioEditable";
        } else {//UPDATE
            Servicio servicio = servicioDAOImplementataion.GetById(idservicio);
            model.addAttribute("servicio", servicio);


            return "formServicioEditable";

        }

    }

    @PostMapping("/formservicio")
    public String Update(@Valid @ModelAttribute("servicio") Servicio servicio,
            Model model) {

        if (servicio.getIdservicio() > 0) {
            servicioDAOImplementataion.Update(servicio);

//            tipoinmuebleDAOImplementation.Update(tipoinmueble);

        } else {
            servicioDAOImplementataion.Add(servicio);
            
        }

        return "redirect:/servicio/servicioList";
    }
    
    @GetMapping("/eliminarServicio/{idservicio}")
    public String Delete(@PathVariable int idservicio, Model model) {
        Servicio servicio = servicioDAOImplementataion.GetById(idservicio);
        model.addAttribute("servicio", servicio);
        servicioDAOImplementataion.Delete(servicio);

        

        return "redirect:/servicio/servicioList";
    }

}
