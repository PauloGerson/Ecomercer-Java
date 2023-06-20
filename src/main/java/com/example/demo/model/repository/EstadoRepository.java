package com.example.demo.model.repository;

import com.example.demo.model.entity.Cidade;
import com.example.demo.model.entity.Estado;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EstadoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Estado estado){
        em.persist(estado);
    }

    public List<Estado> buscarEstado(){
        Query query = em.createQuery("from Estado ");
        return query.getResultList();
    }

    public Estado estado(Long id){
        return em.find(Estado.class,id);
    }

    public void remove(Long id){
        Estado estado = em.find(Estado.class, id);
        em.remove(estado);
    }

    public void update(Estado estado){
        em.merge(estado);
    }
}
