/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.controller;

import com.digis01.MRamirezProgramacionNcapasWeb.Dao.ColoniaDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.DireccionDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.EstadoDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.MunicipioDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.PaisDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.RolDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.TipoInmuebleDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.Dao.UsuarioDAOImplementation;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Colonia;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Direccion;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Estado;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Municipio;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Rol;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Usuario;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.UsuarioDireccion;
import com.digis01.MRamirezProgramacionNcapasWeb.controller.util.Utilidad;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
//localhost:8080/alumno/
@Controller
@RequestMapping("/usuario")//Establecer una ruta base
public class UsuarioController {

    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;

    //Realizar inyeccion 
    @Autowired//inyeccion de dependencias 
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation,
            DireccionDAOImplementation direccionDAOImplementation,
            RolDAOImplementation rolDAOImplementation,
            PaisDAOImplementation paisDAOImplementation,
            EstadoDAOImplementation estadoDAOImplementation,
            MunicipioDAOImplementation municipioDAOImplementation,
            ColoniaDAOImplementation coloniaDAOImplementation) {

        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;

    }

    //localhost:8080/usuario/listado
    @GetMapping("/listado")//Sobre que va a trabajr  Se ejecuta esta ruta por primera vez
    private String listadoUsuarios(Model model) { //model da la informacion a los html, se utiliz el objeto model para pasar datos a la vista
        //Inicializamos las propiedades al crear el objeto usuario
        Usuario usuario = new Usuario();   //Esto es para la busqueda de usuarios
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");

        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario);
        model.addAttribute("usuarios", usuarios); //Envio de datos para HTML, pasar la lista de usuarios a la vista HTML
        model.addAttribute("usuariobusqueda", new Usuario());//Hacer una busqueda en la vista 
        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        model.addAttribute("direcciones", direcciones);
//        return "listadoUsuarios";
        //List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        //Aqui me hacen falta para lista de direcciones

        return "listadoUsuarios";

    }

    @PostMapping("/listado") //Procesar y lugeo mostrar los resultados
    public String listadoUsuarios(@ModelAttribute("usuariodireccion") Usuario usuariobusqueda, Model model) { //Usuario usuariobusqueda, contendra los datos de soli post
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuariobusqueda);
        model.addAttribute("usuarios", usuarios); //Envio de datos para HTML, mostrar la lista 
        model.addAttribute("usuariobusqueda", usuariobusqueda);

        //Aqui me falta para las direcciones
        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        model.addAttribute("direcciones", direcciones);

        return "listadoUsuarios";
    }

//    @GetMapping("/GetEstadoByIdPais")//Sobre que va a trabajr
//    @ResponseBody
//    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais")int IdPais){
//        List<Estado> estados = estadoDAOImplementation.
//        
//        
//        
//        return estados;
//
//    }
//   
    @GetMapping("/form/{idusuario}") //@GetMapping("/editarUsuario/{idusuario}")

    public String form(@PathVariable int idusuario, Model model) {
//        List<Rol> roles = rolDAOImplementation.GetAll();
//        model.addAttribute("roles", roles);
        model.addAttribute("roles", rolDAOImplementation.GetAll());
        model.addAttribute("paises", paisDAOImplementation.GetAll());

        if (idusuario == 0) {//Si no esta en la BD, ADD
            model.addAttribute("usuariodireccion", new UsuarioDireccion());

            return "formUsuarioEditable";
        } else {//UPDATE
                Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
            Direccion direccion = direccionDAOImplementation.GetByIdUsuario(idusuario);

            UsuarioDireccion usuarioDireccion = new UsuarioDireccion(usuario, direccion);

            if (usuarioDireccion.getDireccion().getColonia() != null) {
                model.addAttribute("Estados", estadoDAOImplementation.GetByIdPais(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
                model.addAttribute("Municipios", municipioDAOImplementation.GetByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
                model.addAttribute("Colonias", coloniaDAOImplementation.GetByIdMunicipio(usuarioDireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));

            }

            model.addAttribute("usuariodireccion", usuarioDireccion);

            return "formUsuarioEditable";

        }

    }
//    //Validacion del lado del cliente 
//    @PostMapping("/form")
//    public String Update(@ModelAttribute UsuarioDireccion usuarioDireccion) {
//
//        if (usuarioDireccion.getUsuario().getIdusuario() > 0) { //UPDATE
//            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
//        } else {
//            int idUsuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario()); //Regresar el IDINSERTADO
//            usuarioDireccion.getDireccion().setUsuario(new Usuario(idUsuario));
//            usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());
//        }
//
//        return "redirect:/usuario/listado";
//    }

    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuarioDireccion,
            BindingResult bindingResult,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formUsuarioEditable";

        }
        Utilidad.Imagen(usuarioDireccion, imagenFile);

        if (usuarioDireccion.getUsuario().getIdusuario() > 0) { //UPDATE
            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
            
        } else {
            usuarioDireccion.getUsuario().setStatus("Y");
            int idUsuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario()); //Regresar el IDINSERTADO
            Direccion direccion = new Direccion(usuarioDireccion.getDireccion().getCalle(), usuarioDireccion.getDireccion().getNumerointerior(),
                    usuarioDireccion.getDireccion().getNumeroexterior(), usuarioDireccion.getDireccion().getColonia(), new Usuario(idUsuario));
            usuarioDireccion.setDireccion(direccion);
            direccionDAOImplementation.Add(direccion);
        }

        return "redirect:/usuario/listado";
    }

    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(IdPais); // Obtiene los datos del servicio
        return estados;
    }

    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(IdEstado); // Obtiene los datos del servicio
        return municipios;
    }

    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia> GetColoniaByIdMunicipio(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(IdMunicipio); // Obtiene los datos del servicio
        return colonias;
    }

    @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idUsuario") int IdUsuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementation.ChangeStatus(IdUsuario, status);

    }

    @GetMapping("/eliminarUsuario/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model) {

        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);

        model.addAttribute("usuario", usuario);
        usuarioDAOImplementation.Delete(usuario);

        //getByID --> precargar elforumalrio JPQL
        // precargarlo con el model 
        return "redirect:/usuario/listado";
    }

}
//@GetMapping("/add")
//    public String Add(Model model) {
//        // Alum alumno = new Alum(); puede ser igual de esta manera
//        model.addAttribute("usuario", new Usuario());
//        return "formusuario";
//    }

//@PostMapping("addusuario")
//    public String Add(@ModelAttribute Usuario usuario) {
//
//        //la logica necesaria para enviar dicha información a DAO
//        usuarioDAOImplementation.Add(usuario);
//
//        return "redirect:/usuario/listado";
//
//    }
