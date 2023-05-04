package com.example.demo.model.repository;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.PessoaFisica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaFisicaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<PessoaFisica> buscarPessoas(){
        Query query = em.createQuery("from PessoaFisica ");
        return query.getResultList();
    }

    public PessoaFisica pessoa(Long id){
        return em.find(PessoaFisica.class,id);
    }
}
