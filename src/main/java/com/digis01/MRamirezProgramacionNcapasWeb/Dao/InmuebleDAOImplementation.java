/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Inmueble;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class InmuebleDAOImplementation implements IInmuebleDAO{
    private EntityManager entityManager;

    @Autowired
    public InmuebleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Inmueble> GetAll() {
        TypedQuery<Inmueble> query = entityManager.createQuery("FROM Inmueble", Inmueble.class);
        List<Inmueble> inmuebles = query.getResultList();
        return inmuebles;
    }

    
}
