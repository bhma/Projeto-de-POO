package com.projetopoo.model;

import java.io.Serializable;

public class ItemModel extends ProdutoModel implements Serializable{
    private int idItem;
    private int qtdEstoque;
    private int qtdDesejada;
    private float preco;
    private String descricao;
    private String posicaoEstoque;

    public String getPosicaoEstoque() {
        return posicaoEstoque;
    }

    public void setPosicaoEstoque(String posicaoEstoque) {
        this.posicaoEstoque = posicaoEstoque;
    }

    public ItemModel(int idItem, int qtdDesejada) {
        super("validade");
        this.qtdEstoque = 0;
        this.preco = 0;
        this.idItem = idItem;
        this.qtdDesejada = qtdDesejada;
    }

    public ItemModel(int idItem, int qtdEstoque, float preco, String descricao, String validade, String posicaoEstoque) {
        super(validade);
        this.idItem = idItem;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.descricao = descricao;
        this.posicaoEstoque = posicaoEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(int x) {
        this.qtdDesejada = qtdDesejada;//???
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
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

