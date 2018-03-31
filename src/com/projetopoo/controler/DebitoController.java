/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.dao.DebitoDAO;
import com.projetopoo.model.DebitoModel;
import java.util.ArrayList;

/**
 *
 * @author dkaus
 */
public class DebitoController {
    private ArrayList<DebitoModel> debitoList = new ArrayList();
    
    public ArrayList<DebitoModel> recuperarLista(){
      DebitoDAO dao = new DebitoDAO();
      debitoList = dao.recuperarDebito();
      return debitoList;
    }
    
     
public void salvarArrayList(ArrayList<DebitoModel> listp){
    if(listp != null){
    DebitoDAO dao = new DebitoDAO();
    for(int i = 0; i < listp.size(); i++){
        dao.inserir(listp.get(i));
    }
    }
}
    
  public void salvarAlteracao(ArrayList<DebitoModel> listp){
      if(listp != null){
          DebitoDAO dao = new DebitoDAO();
          dao.salvarAlteracao(listp);
      }
    }
    
}

//consultar
//remover
//listar

/* public void  consusltar(int id){
     ItemController p = new ItemController();
    p.cadastrar();
     
          ItemDAO dao = new ItemDAO();
         itemList = dao.restaurarItem();//recupera a lista do arquivo
           if(itemList == null){
               System.out.println("vazio");
           }
            if(id == itemList.get(0).getIdItem()){
                   System.out.println(itemList.get(0).getIdItem()+" "+itemList.get(0).getDescricao()+" "+itemList.get(0).getPreco());
               }
           /*for(int i =0; i < itemList.size(); i++){
              
           }*/
    

