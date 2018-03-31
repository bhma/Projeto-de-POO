/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.view.projetoPOO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dkaus
 */
public  class  MainItem extends projetoPOO {
    private static Stage stage;
    private static Stage popup;
    
     private static Scene itemMenu;
    private static Scene cadastroItemScene;
    private static Scene listarItemScene;
   
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
      
         Parent fxmlItemOpcoes= FXMLLoader.load(getClass().getResource("FXML.TelaDeItemOpcoes.fxml")); 
         itemMenu = new Scene(fxmlItemOpcoes);
         
          Parent fxmlItemCadastro = FXMLLoader.load(getClass().getResource("FXML.TelaDeItemCadastro.fxml")); 
        cadastroItemScene = new Scene(fxmlItemCadastro);
        
        Parent fxmlItemListar = FXMLLoader.load(getClass().getResource("FXML.TelaDeItemListar.fxml")); 
        listarItemScene = new Scene(fxmlItemListar);
       
      
         stage.setScene(itemMenu );
           stage.show();
    }
    
    public static void trocaTela(String scr){
       MainItem principalItem = new MainItem();
        switch (scr){
            case "itemMenu":
                stage.setScene(itemMenu);
                break;
            
            case "cadastroItem":      
       {
           try {
               principalItem.start(stage);
           } catch (Exception ex) {
               Logger.getLogger(MainItem.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
                 stage.setScene( cadastroItemScene);
                break;
                
                case "listarItem":
       {
           try {
               principalItem.start(stage);
           } catch (Exception ex) {
               Logger.getLogger(MainItem.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
                 stage.setScene( listarItemScene);
                break;
            
       
        }
    
    }

    
}
    