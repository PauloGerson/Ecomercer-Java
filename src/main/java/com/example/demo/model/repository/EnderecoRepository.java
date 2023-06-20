package com.example.demo.model.repository;

import com.example.demo.model.entity.Endereco;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Endereco endereco){
        em.persist(endereco);
    }

    public List<Endereco> buscarEndereco(){
        Query query = em.createQuery("from Endereco ");
        return query.getResultList();
    }

    public Endereco endereco(Long id){
        return em.find(Endereco.class,id);
    }

    public void remove(Long id){
        Endereco endereco = em.find(Endereco.class, id);
        em.remove(endereco);
    }

    public void update(Endereco endereco){
        em.merge(endereco);
    }
}
