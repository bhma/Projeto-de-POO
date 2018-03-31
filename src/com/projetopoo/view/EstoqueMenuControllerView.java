/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view;

import com.projetopoo.view.itemview.MainItem;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class EstoqueMenuControllerView implements Initializable {
  @FXML
    private Button btControleEstoque;

    @FXML
    private Button btControleItens;
    
     private static Stage stage;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startItemMenu() throws Exception{
       projetoPOO.trocaTela("ItemMenu");

     }
    
}