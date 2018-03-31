package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class ProdutoModel implements Serializable{
    private String marca;
    private String tipo;
    private String validade;
    private ArrayList<FornecedorModel> fornecedor;

    public ProdutoModel(String validade) {
        this.validade = validade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String detalhes() {
        return "==================================================\n" +
                " Produto{ " +
                "marca = '" + marca + '\'' +
                ", tipo = '" + tipo + '\'' +
                ", validade = '" + validade + '\'' +
                '}';
    }
}
