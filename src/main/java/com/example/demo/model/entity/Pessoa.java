package com.example.demo.model.entity;

import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Component
@ToString
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc")
    @GenericGenerator(name ="inc", strategy = "increment")

    private Long id;
    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "pessoa")
    private List<Venda> venda;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> endereco;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}

