package com.example.demo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class  Pessoa implements Serializable {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name ="inc", strategy = "increment")
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "pessoa")
    private List<Venda> venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    public String teste(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        String nome = pessoaJuridica.getNome();

        return nome;
    }
}
