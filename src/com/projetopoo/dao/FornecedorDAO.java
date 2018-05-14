/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.model.FornecedorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkaus
 */
public class FornecedorDAO {
     ArrayList<FornecedorModel> list = new ArrayList();
    
    
    public void inserir(FornecedorModel fornecedor){//Inseri um novo funcionario na lista
      FornecedorDAO dao = new FornecedorDAO();
       list = dao.recuperar();//recupera a lista do arquivo
        if(list == null){//testar
        }
        list.add(fornecedor);
       
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroFornecedor.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(list);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
              
               }catch(FileNotFoundException e){
                e.printStackTrace();
     
    }    catch (IOException ex) {
             Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public ArrayList<FornecedorModel> recuperar(){//Recupera lista
        if(new File("CadastroFornecedor.txt").canRead() == true){ // se o arrquivo existir
        try{
             FileInputStream restFile = new FileInputStream("CadastroFornecedor.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
           ArrayList<FornecedorModel> novo = (ArrayList) stream.readObject();
             stream.close();
              return novo;
         }catch(FileNotFoundException e){
                 e.printStackTrace();
         
        }   catch (IOException ex) {
               Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    else{// se o arquivo não existir
            try{
             FileOutputStream saveFile = new FileOutputStream("CadastroFornecedor.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.close();//fecha objeto de gravação
        
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public void salvarAlteracao(ArrayList<FornecedorModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroFornecedor.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
      
    }     catch (IOException ex) {
              Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
}

}
