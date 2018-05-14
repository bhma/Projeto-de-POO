/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.model;

import java.io.Serializable;

/**
 *
 * @author Túlio
 */
public class RequisicaoModel implements Serializable{
    private String dataDeEmissao;
    private String dataDeEntrega;
    private boolean status;
    private String descricao;
    private int qtdDesejada;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(int qtdDesejada) {
        this.qtdDesejada = qtdDesejada;
    }
    
    public String getDataDeEmissao() {
        return dataDeEmissao;
    }

    public void setDataDeEmissao(String dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
