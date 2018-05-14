/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.model.FluxoDeCaixaModel;
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
public class FluxoDeCaixaDAO {
   //  FluxoDeCaixaModel list = new FluxoDeCaixaModel();
    
   /* 
    public void inserir(FluxoDeCaixaModel fluxoDeCaixa){//Inseri um novo funcionario na lista
      FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
     /* list = dao.recuperarFluxoDeCaixa();//recupera a lista do arquivo
        list.add(fluxoDeCaixa);
       
          try{
             FileOutputStream saveFile = new FileOutputStream("FluxoDeCaixaRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(fluxoDeCaixa);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
              
               }catch(FileNotFoundException e){
                e.printStackTrace();
    }     catch (IOException ex) {
              Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    }    
    
    public FluxoDeCaixaModel recuperarFluxoDeCaixa(){//Restaura lista
        if(new File("FluxoDeCaixaRegistro.txt").canRead() == true){
        try{
             FileInputStream restFile = new FileInputStream("FluxoDeCaixaRegistro.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
             ArrayList<FluxoDeCaixaModel> novo = (ArrayList) stream.readObject();
             stream.close();
              return novo;
         }catch(FileNotFoundException e){
                 e.printStackTrace();
         
        }   catch (IOException ex) {
                Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    else{
            try{
             FileOutputStream saveFile = new FileOutputStream("FluxoDeCaixaRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.close();//fecha objeto de gravação
        
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public void salvarAlteracao(ArrayList<FluxoDeCaixaModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("FluxoDeCaixaRegistro.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
      
    }     catch (IOException ex) {
              Logger.getLogger(FluxoDeCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
}*/

}
    
