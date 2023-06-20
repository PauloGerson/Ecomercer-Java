package com.example.demo.model.repository;

import com.example.demo.model.entity.PessoaJuridica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoaJuridica){
        em.persist(pessoaJuridica);
    }

    public List<PessoaJuridica> buscarPessoaJ(){
        Query query = em.createQuery("from PessoaJuridica ");
        return query.getResultList();
    }

    public PessoaJuridica pessoa(Long id){
        return em.find(PessoaJuridica.class,id);
    }

    public void remove(Long id){
        PessoaJuridica pessoaJuridica = em.find(PessoaJuridica.class, id);
        em.remove(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica){
        em.merge(pessoaJuridica);
    }
}
