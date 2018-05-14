package com.projetopoo.controler;

import com.projetopoo.dao.FuncionarioDAO;
import com.projetopoo.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrade
 */
public class CadastroFuncionarioController {
     public static ArrayList<FuncionarioModel> restaurarFuncionarios(){
        ArrayList<FuncionarioModel> c = new ArrayList();// c eh o array de compras
        FuncionarioDAO cd = new FuncionarioDAO();//cd onde está chamando os metodos do DAO
        c =cd.recuperarFuncionario();
        return c;
    }
     
     public static String GeraIdFuncionario(){
        int novoId= 0;
        FuncionarioModel ultimo;
        ArrayList<FuncionarioModel> lista;
        lista= restaurarFuncionarios();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(ultimo.getId());
            
            novoId= i +1;
            
        }
        String t = String.valueOf(novoId);
        return t;
     }
    public void InserirFuncionario (FuncionarioModel funcionario){
        FuncionarioDAO fd = new FuncionarioDAO();
        funcionario.setId(GeraIdFuncionario());
        fd.cadastrarFuncionario(funcionario);
        //System.out.println(compra.getItens().get(0).getDescricao());
    
    }
     public static FuncionarioModel ConsultaFuncionario(String id){
        int tamanho;
        FuncionarioModel funcionario;
        ArrayList<FuncionarioModel> lista;
        lista= restaurarFuncionarios();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                funcionario=lista.get(i);                
                if(id.equals(funcionario.getId())){
                    return lista.get(i);
                }
            }
        }
        return null;
    }
     public static void removerFuncionario(String id){
        int tamanho;
        FuncionarioModel funcionario;
        ArrayList<FuncionarioModel> lista;
        lista= restaurarFuncionarios();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                funcionario=lista.get(i);                
                if(id.equals(funcionario.getId())){
                    lista.remove(i);
                    return;
                }
            }
        }    
    }
}
