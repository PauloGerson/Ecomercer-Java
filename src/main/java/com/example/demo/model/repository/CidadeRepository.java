package com.example.demo.model.repository;

import com.example.demo.model.entity.Cidade;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CidadeRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Cidade cidade){
        em.persist(cidade);
    }

    public List<Cidade> buscarCidade(){
        Query query = em.createQuery("from Cidade ");
        return query.getResultList();
    }

    public Cidade cidade(Long id){
        return em.find(Cidade.class,id);
    }

    public void remove(Long id){
        Cidade cidade = em.find(Cidade.class, id);
        em.remove(cidade);
    }

    public void update(Cidade cidade){
        em.merge(cidade);
    }
}
