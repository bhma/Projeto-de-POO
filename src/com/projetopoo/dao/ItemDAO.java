package com.projetopoo.dao;

import com.projetopoo.model.ItemModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkaus
 */
public class ItemDAO {
      ArrayList<ItemModel> list = new ArrayList();
    public void inserir(ItemModel item){//Inseri um novo funcionario na lista
        ItemDAO dao = new ItemDAO();
       list = dao.recuperarItem();//recupera a lista do arquivo

        list.add(item);
       
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroItem.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(list);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
              
               }catch(FileNotFoundException e){
                e.printStackTrace();
    }     catch (IOException ex) {
              Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
     
    }    
    
    public ArrayList<ItemModel> recuperarItem(){//Restaura lista
        if(new File("CadastroItem.txt").canRead() == true){
        try{
             FileInputStream restFile = new FileInputStream("CadastroItem.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
             ArrayList<ItemModel> novo = (ArrayList) stream.readObject();
             stream.close();
             for(int i = 0; i < novo.size(); i++){
             }
              return novo;
         }catch(FileNotFoundException e){
                 e.printStackTrace();
         
        }   catch (IOException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    else{
            try{
             FileOutputStream saveFile = new FileOutputStream("CadastroItem.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.close();//fecha objeto de gravação
        
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public void salvarAlteracao(ArrayList<ItemModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("CadastroItem.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
      
    }     catch (IOException ex) {
              Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
}

}
