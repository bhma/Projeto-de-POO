package com.projetopoo.model;

import java.io.Serializable;

public class ItemModel extends ProdutoModel implements Serializable{
    private String idItem;
    private int qtdEstoque;
    private int qtdDesejada;
    private float preco;

    public ItemModel(String idItem, int qtdDesejada) {
        super("validade");
        this.qtdEstoque = 0;
        this.preco = 0;
        this.idItem = idItem;
        this.qtdDesejada = qtdDesejada;
    }

    public int getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(int x) {
        this.qtdDesejada = qtdDesejada;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "==================================================\n'" +
                " Item{" +
                "idItem = " + idItem +
                ", qtdEstoque = " + qtdEstoque +
                ", preco = " + preco +
                this.detalhes() +
                '}' + "\n";
    }
}

