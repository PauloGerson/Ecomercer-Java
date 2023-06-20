package com.example.demo.model.entity;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component

public class Endereco  implements Serializable {

    @Id
    @GeneratedValue


    @OneToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    @ManyToOne
    private Pessoa pessoa;

    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    public String dados(){

        return "";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb
                .append("Logradouro: ").append(logradouro).append("\n")
                .append("Complemento: ").append(complemento).append("\n")
                .append("Bairro: ").append(bairro).append("\n")
                .append("CEP: ").append(cep).append("\n")
                .append("Cidade: ").append(cidade.toString()).append("\n")
                .toString();
    }

}
