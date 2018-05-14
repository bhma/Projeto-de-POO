/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.model.DebitoModel;
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
public class DebitoDAO {
      ArrayList<DebitoModel> list = new ArrayList();
    
    
    public void inserir(DebitoModel debito){//Inseri um novo funcionario na lista
       DebitoDAO dao = new DebitoDAO ();
       list = dao.recuperarDebito();//recupera a lista do arquivo
        list.add(debito);
       
          try{
             FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(list);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
              
               }catch(FileNotFoundException e){
                e.printStackTrace();
    }     catch (IOException ex) {
              Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    }    
    
    public ArrayList<DebitoModel> recuperarDebito(){//Restaura lista
        if(new File("DebitoRegistro.txt").canRead() == true){
        try{
             FileInputStream restFile = new FileInputStream("DebitoRegistro.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
             ArrayList<DebitoModel> novo = (ArrayList) stream.readObject();
             stream.close();
              return novo;
         }catch(FileNotFoundException e){
                 e.printStackTrace();
         
        }   catch (IOException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    else{
            try{
             FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.close();//fecha objeto de gravação
        
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public void salvarAlteracao(ArrayList<DebitoModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
      
    }     catch (IOException ex) {
              Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
}

}
