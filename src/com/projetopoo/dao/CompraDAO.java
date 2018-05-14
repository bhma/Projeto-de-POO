    
package com.projetopoo.dao;

import com.projetopoo.model.CompraModel;
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
public class CompraDAO{      
    ArrayList<CompraModel> list = new ArrayList();
    public void inserir(CompraModel compra){//Inseri um novo funcionario na lista
       CompraDAO dao = new CompraDAO();
        list = dao.restaurarCompra();
        list.add(compra);
       
          try{
             FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(list);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
              
               }catch(FileNotFoundException e){
                e.printStackTrace();
  
    }     catch (IOException ex) {
              Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public ArrayList<CompraModel> restaurarCompra(){//Restaura lista
        if(new File("RegistroCompra.txt").canRead() == true){
         try{
             FileInputStream restFile = new FileInputStream("RegistroCompra.txt");
             ObjectInputStream stream = new ObjectInputStream(restFile);            
             ArrayList<CompraModel> novo = (ArrayList) stream.readObject();
             stream.close();
              return novo;
         }catch(FileNotFoundException e){
                 e.printStackTrace();
         
        }   catch (IOException ex) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try{
             FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.close();//fecha objeto de gravação
       
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             return list;
    }
        
    public void salvarAlteracao(ArrayList<CompraModel> listp ){
          try{
             FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
             stream.writeObject(listp);//salva a lista no arquivo
             stream.close();//fecha objeto de gravação
               }catch(FileNotFoundException e){
                e.printStackTrace();
}         catch (IOException ex) {
              Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}


