package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstoqueModel implements Serializable{
    private List<ItemModel> itensEst;
    private float valorTotEmEst;

    public EstoqueModel(List<ItemModel> itensEst) {
        this.itensEst = new ArrayList<>();
        this.valorTotEmEst = 0;
    }

    public float getValorTotEmEst() {
        return valorTotEmEst;
    }

    public void setValorTotEmEst() {
        for (ItemModel s:itensEst){
            this.valorTotEmEst += (s.getPreco() * s.getQtdEstoque());
        }
    }

    public void listarItensEst() {
       for(ItemModel s:itensEst){
           System.out.println(s.toString());
       }
    }

    public float consultaPreco(int id){
        for(ItemModel s:itensEst){
            if(s.getIdItem() == id){
                return s.getPreco();
            }
        }
        return 0;
    }

    private ItemModel findItem(int id) {
        for(ItemModel s:itensEst){
            if(s.getIdItem() == id){
                return s;
            }
        }
        return null;
    }

    public void addItemEst(ItemModel itensEst) {
        this.itensEst.add(itensEst);
    }

    public void removeItemEst(ItemModel a){
        if(a != null){
            if(a.getQtdEstoque() > a.getQtdDesejada()){
                a.setQtdEstoque(a.getQtdEstoque() - a.getQtdDesejada());
            }
        }
        this.setValorTotEmEst();
    }

    public List<ItemModel> getItensEst() {
        return itensEst;
    }
}
