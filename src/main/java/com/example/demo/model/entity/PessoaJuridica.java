package com.example.demo.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Component
public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
