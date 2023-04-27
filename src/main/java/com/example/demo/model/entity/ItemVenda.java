/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.entity;
import com.example.demo.model.entity.Produto;
import com.example.demo.model.entity.Venda;

import javax.persistence.*;
import java.io.Serializable;


/**
 *
 * @author User
 */
@Entity

public class ItemVenda implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private double qtd;

    @OneToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    public Long getId() {
        if (this.produto != null) {
            return this.produto.getId();
        } else {
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double total(){
        return produto.getValor() * qtd;
    }
}
