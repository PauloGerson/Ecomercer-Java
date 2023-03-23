package com.example.demo.model.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
