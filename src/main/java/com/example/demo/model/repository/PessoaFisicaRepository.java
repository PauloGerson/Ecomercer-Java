package com.example.demo.model.repository;

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

    public List<PessoaFisica> buscarProdutos(){
        Query query = em.createQuery("from Produto ");
        return query.getResultList();
    }
}
