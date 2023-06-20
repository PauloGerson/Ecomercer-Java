package com.example.demo.model.entity;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component

public class Cidade implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne
    private Estado estado;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append(nome).append("\n")
                .append("Estado: ").append(estado.getNome()).append("-")
                .append(getEstado().getUf()).append("\n")
                .toString();
    }

}
