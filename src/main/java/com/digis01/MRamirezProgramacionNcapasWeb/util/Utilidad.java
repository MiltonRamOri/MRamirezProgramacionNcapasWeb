/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.util;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.UsuarioDireccion;
import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.UsuarioDireccion;
import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
public class Utilidad {
    public static void Imagen(UsuarioDireccion usuarioDireccion, MultipartFile imagenFile) {
        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imagenBase64 = Base64.encodeBase64String(bytes);
                usuarioDireccion.getUsuario().setImagen(imagenBase64);
            } else {
                usuarioDireccion.getUsuario().setImagen(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
