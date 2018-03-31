package com.projetopoo.model;

import java.io.Serializable;

public class FinanceiroModel implements Serializable{
    private int qtdFunc;
    private boolean compraSolicitada;

    public FinanceiroModel(int qtdFun, boolean compraSolicitada) {
        this.qtdFunc = qtdFun;
        this.compraSolicitada = compraSolicitada;
    }

    public int getQtdFun() {
        return qtdFunc;
    }

    public void setQtdFun(int qtdFun) {
        this.qtdFunc = qtdFun;
    }

    public boolean gteCompraSolicitada() {
        return compraSolicitada;
    }

    public void setCompraSolicitada(boolean compraSolicitada) {
        this.compraSolicitada = compraSolicitada;
    }
}
