/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import static com.projetopoo.controler.FornecedorController.restaurarFornecedor;
import com.projetopoo.dao.ItemDAO;
import com.projetopoo.model.FornecedorModel;
import com.projetopoo.model.ItemModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class ItemController {
     private ArrayList<ItemModel> itemList = new ArrayList();
     private ArrayList<ItemModel> itemSpecificList = new ArrayList();
     
     
    public ArrayList<ItemModel> recuperarLista(){
     ItemDAO dao = new ItemDAO();
      itemList = dao.recuperarItem();
      return itemList;
    }
    
      public ArrayList<ItemModel> recuperarListaEspecifica(String item, String categoria){//restorna uma lista especifica
     ItemDAO dao = new ItemDAO();
      itemList = dao.recuperarItem();
      switch(categoria){
          case "ID":
              for(int i = 0; i< itemList.size(); i++){
                    if(item.equals(itemList.get(i).getIdItem())){
                     itemSpecificList.add(itemList.get(i));
                    }
               }
              break;
              case "POSIÇÃO":
              for(int i = 0; i< itemList.size(); i++){
                    if(item.equals(itemList.get(i).getPosicaoEstoque())){
                     itemSpecificList.add(itemList.get(i));
                    }
               }
              break;
               case "DESCRIÇÃO":
              for(int i = 0; i< itemList.size(); i++){
                    if(item.equalsIgnoreCase(itemList.get(i).getDescricao())){
                     itemSpecificList.add(itemList.get(i));
                    }
               }
              break;
      }
       return  itemSpecificList;
      }
      
    
    public ItemModel consultarItem(String idItem){
        ItemDAO dao = new ItemDAO();
        itemList = dao.recuperarItem();
        for(int i = 0; i< itemList.size(); i++){
            if(idItem.equals(itemList.get(i).getIdItem())){
                return itemList.get(i);
            }
        }
        return null;
    }
     
public void salvarArrayList(ArrayList<ItemModel> listp){
    if(listp != null){
     ItemDAO dao = new ItemDAO();
    for(int i = 0; i < listp.size(); i++){
        dao.inserir(listp.get(i));
    }
    }
}
    

        

  public void salvarAlteracao(ArrayList<ItemModel> listp){
      if(listp != null){
       ItemDAO dao = new ItemDAO();
          dao.salvarAlteracao(listp);
      }
    }
  
 /*  public String GeraIdItem(){
        int novoId= 0;
        ItemModel ultimo;
        ArrayList<ItemModel> lista;
        lista = recuperarLista();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(Integer.toString(ultimo.getIdItem()));
            novoId = i +1;
        }
        String t = String.valueOf(novoId);
        return t;
    }*/
    
}

