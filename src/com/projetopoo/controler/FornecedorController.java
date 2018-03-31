package com.projetopoo.controler;
import com.projetopoo.dao.FornecedorDAO;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;

public class FornecedorController { 
    public static ArrayList<FornecedorModel> restaurarFornecedor(){
        ArrayList<FornecedorModel> c = new ArrayList();// c eh o array de fornecedor
        FornecedorDAO fd = new FornecedorDAO();//cd onde está chamando os metodos do DAO
        c = fd.recuperar();
        return c;
    }
    
    public static void removerFornecedor(String id){
        int tamanho;
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                fornecedor = lista.get(i);                
                if(id.equals(fornecedor.getIdForn())){
                    lista.remove(i);
                    return;
                }
            }
        }    
    }
    
    public static void inserirFornecedor (FornecedorModel fornecedor){
        FornecedorDAO fd = new FornecedorDAO();
        fornecedor.setIdForn(Integer.parseInt(GeraIdFornecedor()));
        fd.inserir(fornecedor);
    
    }
    
    public static String GeraIdFornecedor(){
        int novoId= 0;
        FornecedorModel ultimo;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(Integer.toString(ultimo.getIdForn()));
            novoId = i +1;
        }
        String t = String.valueOf(novoId);
        return t;
    }
    
    public static FornecedorModel ConsultaFornecedor(String id){
        int tamanho;
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista= restaurarFornecedor();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                fornecedor =lista.get(i);                
                if(id.equals(fornecedor.getIdForn())){
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