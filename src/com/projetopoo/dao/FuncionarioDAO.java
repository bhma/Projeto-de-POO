/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import java.util.ArrayList;
import com.projetopoo.model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Túlio
 */
public class FuncionarioDAO  {
     ArrayList<FuncionarioModel> list = new ArrayList();
    
    
    public void cadastrarFuncionario(FuncionarioModel funcionario){//Inseri um novo funcionario na lista
        FuncionarioDAO dao = new FuncionarioDAO();
        list = dao.restaurarFuncionario();//recupera a lista do arquivo
        list.add(funcionario);
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroFuncionarios.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(list);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
         }catch (IOException ex) {
              Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
    public ArrayList<FuncionarioModel> restaurarFuncionario(){//Restaura lista
          try{
             FileInputStream restFile = new FileInputStream("CadastroFuncionarios.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
             ArrayList<FuncionarioModel> novo = (ArrayList) stream.readObject();
             stream.close();
             for(int i = 0; i < novo.size(); i++){
                 System.out.println(novo.get(i).getNome());
             }
              return novo;
         }catch(FileNotFoundException e){
                e.printStackTrace();
         } catch (IOException ex) {
              Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
         return null;
     }
    
    public void salvarAlteracao(ArrayList<FuncionarioModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroFuncionarios.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
         }catch (IOException ex) {
              Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}
