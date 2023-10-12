/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

import com.digis01.MRamirezProgramacionNcapasWeb.JPA.TipoInmueble;
import com.digis01.MRamirezProgramacionNcapasWeb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class TipoInmuebleDAOImplementation implements ITipoInmuebleDAO {

    private EntityManager entityManager;

    @Autowired
    public TipoInmuebleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TipoInmueble> GetAll() {
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble", TipoInmueble.class);
        List<TipoInmueble> tipoinmuebles = query.getResultList();
        return tipoinmuebles;
    }

    @Override
    @Transactional //Se refiere a que existira una modificacion en la BD
    public int Add(TipoInmueble tipoinmueble) {
        entityManager.persist(tipoinmueble);
        return tipoinmueble.getIdtipoinmueble();
    }

    @Override
    @Transactional
    public void Update(TipoInmueble tipoinmueble) {
        entityManager.merge(tipoinmueble);
    }
    
    @Override
    public TipoInmueble GetById(int idtipoinmuebleeditable) {
        //JPQL
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble WHERE idtipoinmueble=:idtipoinmuebleeditable", TipoInmueble.class);
        query.setParameter("idtipoinmuebleeditable", idtipoinmuebleeditable);

        return query.getSingleResult();
    }
    
    @Override
    @Transactional
    public void Delete(TipoInmueble tipoinmueble) {
        entityManager.remove(tipoinmueble);
    }
   

}
