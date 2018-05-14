/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dkaus
 */
public class FluxoDeCaixaModel {
    
   private String data;
    private float total;
    private String tipo;
    private String descricao;
    private ArrayList<DebitoModel> despesas = new ArrayList();
    private ArrayList<CompraModel> receitas =new ArrayList();
     //ArrayList<RequsicaoDecompraModel> requisicaoDeCompra = new ArrayList();
    //  ArrayList<FinanceiroModel> pagamentoFuncionario = new ArrayList();

   /* public FluxoDeCaixaModel(String data, float totalDespesa, float totalRecita, float saldoFinal) {
        this.data = data;
        this.totalDespesa = totalDespesa;
        this.totalRecita = totalRecita;
        this.saldoFinal = saldoFinal;
    }*/

  /*  public FluxoDeCaixaModel(String data, float totalDespesa, float totalReceita, float saldoFinal, String tipo, String descricao) {
        this.data = data;
        this.totalDespesa = totalDespesa;
        this.totalReceita = totalReceita;
        this.saldoFinal = saldoFinal;
        this.tipo = tipo;
        this.descricao = descricao;
    }
    */
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


   

   /* public float getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(float totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public float getTotalReceita() {
        return totalReceita;
    }

    public void setTotalReceita(float totalRecita) {
        this.totalReceita = totalRecita;
    }*/

    

    public ArrayList<DebitoModel> getDespesas() {
        return despesas;
    }

    public void setDespesas(ArrayList<DebitoModel> despesas) {
        this.despesas = despesas;
    }

    public ArrayList<CompraModel> getReceitas() {
        return receitas;
    }

    public void setReceitas(ArrayList<CompraModel> receitas) {
        this.receitas = receitas;
    }



    
    
    
}
