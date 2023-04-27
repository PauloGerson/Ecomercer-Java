package com.example.demo.model.repository;

//import com.example.demo.model.entity.Venda;
import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.Venda;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VendaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Venda> buscarVendas(){
        Query query =  em.createQuery("from Venda ");
        return query.getResultList();
    }

    public Venda venda(Long id) {
        return em.find(Venda.class, id);
    }

    public void save(Venda venda) {
        em.persist(venda);
    }

    public void update(Venda venda){
        em.merge(venda);
    }



}
