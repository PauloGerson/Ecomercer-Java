package com.example.demo.model.repository;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.PessoaFisica;
import com.example.demo.model.entity.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaFisicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoaFisica){
        em.persist(pessoaFisica);
    }

    public List<PessoaFisica> buscarPessoaF(){
        Query query = em.createQuery("from PessoaFisica ");
        return query.getResultList();
    }

    public PessoaFisica pessoa(Long id){
        return em.find(PessoaFisica.class,id);
    }

    public void remove(Long id){
        PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
        em.remove(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica){
        em.merge(pessoaFisica);
    }
}
