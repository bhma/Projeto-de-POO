/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.dao.ItemDAO;
import com.projetopoo.model.ItemModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class ItemController {
     private ArrayList<ItemModel> itemList = new ArrayList();
    
    public ArrayList<ItemModel> recuperarLista(){
     ItemDAO dao = new ItemDAO();
      itemList = dao.recuperarItem();
      return itemList;
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
    
}

