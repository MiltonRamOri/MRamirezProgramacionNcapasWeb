/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.MRamirezProgramacionNcapasWeb.Dao;

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
public class UsuarioDAOImplementation implements IAUsuarioDAO { //Descargar ese contrato dentro la clase 

    private EntityManager entityManager;

    @Autowired //Inyeccion de dependencias
    public UsuarioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> GetAll(Usuario usuario) {

        TypedQuery<Usuario> query = entityManager.createQuery( //Definimos una consulta jpql 
                "FROM Usuario WHERE LOWER(TRIM(nombre)) LIKE LOWER(:nombreusuario) AND LOWER(TRIM(apellidopaterno)) LIKE LOWER(:apellidopaterno) AND LOWER(TRIM(apellidomaterno)) LIKE LOWER(:apellidomaterno) ", Usuario.class);

        query.setParameter("nombreusuario", ('%' + usuario.getNombre().trim() + '%'));
        query.setParameter("apellidopaterno", ('%' + usuario.getApellidopaterno().trim() + '%'));
        query.setParameter("apellidomaterno", ('%' + usuario.getApellidomaterno().trim() + '%'));
        List<Usuario> usuarios = query.getResultList();
        return usuarios;

    }

    @Override
    @Transactional //Se refiere a que existira una modificacion en la BD
    public int Add(Usuario usuario) {
        usuario.setFechanacimiento(new Date());
        entityManager.persist(usuario);

        return usuario.getIdusuario();
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        //JPQL
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void Delete(Usuario usuario) {
        entityManager.remove(usuario);
    }
    
    @Override
    @Transactional
    public void ChangeStatus(int idUsuario, boolean status){
        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        if(status){
            usuario.setStatus("Y");
        }else{
            usuario.setStatus("N");
        }
        entityManager.merge(usuario);
        
    }
    
    

}
