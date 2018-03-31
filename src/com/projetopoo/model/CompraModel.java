package com.projetopoo.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CompraModel implements Serializable{
    private String idCompra;
    private int qtdItenCompra;
    private String data;
    private float valorTot;
    private List<ItemModel> itens;

    public CompraModel(String idCompra) {
        this.idCompra = idCompra;
        this.qtdItenCompra = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        this.data = sdf.format(new Date());
        this.valorTot = 0;
        //this.itens = itens;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public int getQtdItenCompra() {
        return qtdItenCompra;
    }

    public void setQtdItenCompra(int qtdItenCompra) {
        this.qtdItenCompra = qtdItenCompra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorTot() {
        return valorTot;
    }

    public void setValorTot(float valorTot) {
        this.valorTot = valorTot;
    }

   public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }
}
