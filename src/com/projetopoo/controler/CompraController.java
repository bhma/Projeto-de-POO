/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;


import com.projetopoo.dao.CompraDAO;
import java.util.ArrayList;
import com.projetopoo.model.CompraModel;

/**
 *
 * @author Andrade
 */


public class CompraController {
   
    public static ArrayList<CompraModel> restaurarCompras(){
        ArrayList<CompraModel> c = new ArrayList();// c eh o array de compras
        CompraDAO cd = new CompraDAO();//cd onde está chamando os metodos do DAO
        c =cd.restaurarCompra();
        return c;
    }
    /* public  ArrayList<CompraModel> recuperarCompras(){
        ArrayList<CompraModel> compras = new ArrayList();// c eh o array de compras
        CompraDAO cd = new CompraDAO();//cd onde está chamando os metodos do DAO
        c =cd.restaurarCompra();
        return c;
    }*/
    public static void removerCompra(String id){
        int tamanho;
        CompraModel compra;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                compra=lista.get(i);                
                if(id.equals(compra.getIdCompra())){
                    lista.remove(i);
                    return;
                }
            }
        }    
    }
    public static void inserirCompra (CompraModel compra){
        CompraDAO cd = new CompraDAO();
        compra.setIdCompra(GeraIdCompra());
        cd.inserir(compra);
        System.out.println(compra.getItens().get(0).getDescricao());
    
    }
    public static String GeraIdCompra(){
        int novoId= 0;
        CompraModel ultimo;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(ultimo.getIdCompra());
            
            novoId= i +1;
            
        }
        String t = String.valueOf(novoId);
        return t;
    }
    public static CompraModel ConsultaCompra(String id){
        int tamanho;
        CompraModel compra;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                compra=lista.get(i);                
                if(id.equals(compra.getIdCompra())){
                    return lista.get(i);
                }
            }
        }
        return null;
    }
    
      
  public float somarTotalReceitas(String data){
        float total = 0;
      CompraDAO dao = new CompraDAO();
       ArrayList<CompraModel> receita = new ArrayList();
       receita = dao.restaurarCompra();
        for(int i = 0; i<receita.size(); i++){
             if((data.charAt(3) == receita.get(i).getData().charAt(3)) && ((data.charAt(4) == receita.get(i).getData().charAt(4)))){
                 if((data.charAt(6) == receita.get(i).getData().charAt(6)) && ((data.charAt(6) == receita.get(i).getData().charAt(6)))){
                     if((data.charAt(7) == receita.get(i).getData().charAt(7)) && ((data.charAt(7) == receita.get(i).getData().charAt(7)))){
                        if((data.charAt(8) == receita.get(i).getData().charAt(8)) && ((data.charAt(8) == receita.get(i).getData().charAt(8)))){
                           if((data.charAt(9) == receita.get(i).getData().charAt(9)) && ((data.charAt(9) == receita.get(i).getData().charAt(9)))){
           total +=(receita.get(i).getValorTot());
                        }
                     }
                 }
             }
             }
        }
        return total;
    }
 
}
// int i = Integer.parseInt(str);
    // String t = String.valueOf(123);

