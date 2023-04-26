package com.example.demo.model.entity;

import com.example.demo.model.entity.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Scope("session")
@Component
@Entity
public class Venda implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremento
    @Id
    private Long id;
    private LocalDate date;

    @ManyToOne
    private Pessoa pessoa;
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> venda  =  new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ItemVenda> getVenda() {
        return venda;
    }

    public void setVenda(List<ItemVenda> venda) {
        this.venda = venda;
    }

    public double total(){
        double somaValor  = 0;

        for(ItemVenda i : venda){
            somaValor = somaValor + i.total();
        }

        return somaValor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
