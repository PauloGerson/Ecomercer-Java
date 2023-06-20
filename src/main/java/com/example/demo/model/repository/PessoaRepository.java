package com.example.demo.model.repository;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.PessoaJuridica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class PessoaRepository {
    @PersistenceContext
    private EntityManager em;



    public List<Pessoa> buscarPessoa(){
        Query query = em.createQuery("from Pessoa ");
        return query.getResultList();
    }

    public Pessoa pessoa(Long id){
        return em.find(Pessoa.class,id);
    }


}
