/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;
import com.projetopoo.dao.CompraDAO;
import java.util.ArrayList;
import com.projetopoo.model.CompraModel;

public class CompraController {
    private static ArrayList<CompraModel> restaurarCompras(){
        ArrayList<CompraModel> c = new ArrayList();// c eh o array de compras
        CompraDAO cd = new CompraDAO();//cd onde está chamando os metodos do DAO
        c =cd.restaurarCompra();
        return c;
    }
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
 
}
// int i = Integer.parseInt(str);
    // String t = String.valueOf(123);

