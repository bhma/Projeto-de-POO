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
        listp.get(i).setId(GeraIdDebito());
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
     
  public float somarTotalDespesas(String data){
        float total = 0;
 
       DebitoDAO dao = new DebitoDAO();
      debitoList = dao.recuperarDebito();
   
        for(int i = 0; i<debitoList.size(); i++){
          
            if((data.charAt(3) == debitoList.get(i).getData().charAt(3)) && ((data.charAt(4) == debitoList.get(i).getData().charAt(4)))){
                 if((data.charAt(6) == debitoList.get(i).getData().charAt(6)) && ((data.charAt(6) == debitoList.get(i).getData().charAt(6)))){
                     if((data.charAt(7) == debitoList.get(i).getData().charAt(7)) && ((data.charAt(7) == debitoList.get(i).getData().charAt(7)))){
                        if((data.charAt(8) == debitoList.get(i).getData().charAt(8)) && ((data.charAt(8) == debitoList.get(i).getData().charAt(8)))){
                           if((data.charAt(9) == debitoList.get(i).getData().charAt(9)) && ((data.charAt(9) == debitoList.get(i).getData().charAt(9)))){
                       System.out.println("oiiii");
           total +=(debitoList.get(i).getValor());
                           }
                        }
                     }
                 }
            }
        }
        return total;
        
    }
  
public String GeraIdDebito(){
        int novoId= 0;
       DebitoModel ultimo;
       
         DebitoDAO dao = new DebitoDAO();
        debitoList = dao.recuperarDebito();
              
        if(!debitoList.isEmpty()){
            ultimo = debitoList.get(debitoList.size()-1);
            int i = Integer.parseInt(ultimo.getId());
            
            novoId= i +1;
            
        }
        String id= String.valueOf(novoId);
        System.out.println(id);
        return id;
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
    

