/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.restController;

import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Datos;
import com.digis01.MRamirezProgramacionNcapasWeb.Entity.Resultado;
import com.digis01.MRamirezProgramacionNcapasWeb.service.DemoServiceImplementation;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping("/api")
public class DemoRestController {
    @PostMapping("/suma")
    public Resultado suma(@RequestBody Datos numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Suma(numeros);
    }
    @PostMapping("/resta")
    public Resultado resta(@RequestBody Datos numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Resta(numeros);
    }
    @PostMapping("/multiplicacion")
    public Resultado multiplicacion(@RequestBody Datos numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Multiplicacion(numeros);
    }
    @PostMapping("/division")
    public Resultado division (@RequestBody Datos numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Division(numeros);
    }
     @GetMapping("/saludo")
    public Map<String, Object> Saludo() {
        Map<String,Object> response = new HashMap<>();
        response.put("Saludo", "Hola mundo");
        return response;
    }
    
}
