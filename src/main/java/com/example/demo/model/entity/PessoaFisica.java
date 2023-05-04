package com.example.demo.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Component
public class PessoaFisica  extends Pessoa implements Serializable {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
