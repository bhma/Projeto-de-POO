package com.projetopoo.controler;
import com.projetopoo.dao.ItemDAO;
import com.projetopoo.model.ItemModel;
import java.util.ArrayList;

public class ItemController { 
    public static ArrayList<ItemModel> restaurarItem(){
        ArrayList<ItemModel> c;// c eh o array de fornecedor
        ItemDAO itemDao = new ItemDAO();//cd onde está chamando os metodos do DAO
        c = itemDao.restaurarItem();
        return c;
    }
    
    public static void removerItem(String id){
        int tamanho;
        ItemModel itemA;
        ArrayList<ItemModel> lista;
        lista = restaurarItem();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                itemA = lista.get(i);                
                if(id.equals(itemA.getIdItem())){
                    lista.remove(i);
                    return;
                }
            }
        }    
    }
    
    public static void inserirItem (ItemModel itemA){
        ItemDAO itemDao = new ItemDAO();
        itemA.setIdItem(GeraIdItem());
        itemDao.inserirItem(itemA);
    
    }
    
    public static String GeraIdItem(){
        int novoId= 0;
        ItemModel ultimo;
        ArrayList<ItemModel> lista;
        lista = restaurarItem();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(ultimo.getIdItem());
            novoId = i +1;
        }
        String t = String.valueOf(novoId);
        return t;
    }
    
    public static ItemModel ConsultaItem(String id){
        int tamanho;
        ItemModel itemA;
        ArrayList<ItemModel> lista;
        lista= restaurarItem();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                itemA =lista.get(i);                
                if(id.equals(itemA.getIdItem())){
                    return lista.get(i);
                }
            }
        }
        return null;
    }
    
    /*private static ArrayList<FornecedorModel> fornecedorList = new ArrayList();     
    public static void recuperarLista(){
        FornecedorDAO dao = new FornecedorDAO();
        fornecedorList = dao.recuperar();
    }
    
    public static boolean buscar(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
               return true;
            }
        }
        return false;
    }
    
    public static boolean inserir(String cnpj, int idForn, String razao){
        FornecedorModel novo = new FornecedorModel(cnpj, idForn, razao);
        if(buscar(cnpj)){
            return false;
        }
        else{
        FornecedorDAO save = new FornecedorDAO();
        save.inserir(novo);
        return true;
        }
    }
    
    public boolean remover(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
                fornecedorList.remove(i);
                FornecedorDAO remove = new FornecedorDAO();
                remove.salvarAlteracao(fornecedorList);
            }
        }
        return false;
    }
    
    public void listar(){
        for(int i = 0; i <= fornecedorList.size(); i++){
            System.out.println(fornecedorList.get(i).toString());
        }
    }
    
    public boolean alterar(String cnpj, String novoCnpj, String novaRazao){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
                fornecedorList.get(i).setCnpj(novoCnpj);
                fornecedorList.get(i).setCnpj(novaRazao);
                return true;
            }
        }
        return false;
    }
    
    public void exibir(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
               System.out.println(fornecedorList.get(i).toString());
            }
        }
    }*/
}