package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemModel extends ProdutoModel implements Serializable{
    private String idItem;
    private int qtdEstoque;
    private int qtdDesejada;
    private float preco;
    private String descricao;
    private String posicaoEstoque;
    private ArrayList<FornecedorModel> fornecedor;
    
    public String getPosicaoEstoque() {
        return posicaoEstoque;
    }

    public void setPosicaoEstoque(String posicaoEstoque) {
        this.posicaoEstoque = posicaoEstoque;
    }

    public ItemModel(String idItem, int qtdDesejada) {//??
        super("validade");
        this.qtdEstoque = 0;
        this.preco = 0;
        this.idItem = idItem;
        this.qtdDesejada = qtdDesejada;
    }
    
    
    public ItemModel(String idItem, int qtdEstoque, float preco, String descricao, String validade, String posicaoEstoque, ArrayList fornecedor) {
        super(validade);
        this.idItem = idItem;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.descricao = descricao;
        this.posicaoEstoque = posicaoEstoque;
          this.fornecedor = fornecedor;
    }
    
    public ArrayList<FornecedorModel> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(ArrayList<FornecedorModel> fornecedor) {
        this.fornecedor = fornecedor;
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
        return "IdItem : " + idItem + "\nDescrição: " + descricao;
    }
}

