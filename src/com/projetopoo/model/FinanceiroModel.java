package com.projetopoo.model;

import java.io.Serializable;

public class FinanceiroModel implements Serializable{
    private int qtdFunc;
    private float valorTotMercadoria;
    private boolean compraSolicitada;
    private EstoqueModel e;

    public FinanceiroModel(int qtdFun, float valorTotMercadoria, boolean compraSolicitada, EstoqueModel e) {
        this.qtdFunc = qtdFun;
        this.valorTotMercadoria = valorTotMercadoria;
        this.compraSolicitada = compraSolicitada;
        this.e = e;
    }

    public int getQtdFun() {
        return qtdFunc;
    }

    public void setQtdFun(int qtdFun) {
        this.qtdFunc = qtdFun;
    }

    public float getValorTotMercadoria() {
        return valorTotMercadoria;
    }

    public void setValorTotMercadoria() {
        this.valorTotMercadoria = this.e.getValorTotEmEst();
    }

    public boolean gteCompraSolicitada() {
        return compraSolicitada;
    }

    public void setCompraSolicitada(boolean compraSolicitada) {
        this.compraSolicitada = compraSolicitada;
    }

    public void calculaLucro(){

    }

    private void pagaFunc(){

    }

    public void pagaRequisicao(){

    }

    public void registroDeCompras(){

    }

}
