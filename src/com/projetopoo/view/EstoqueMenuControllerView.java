/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view;

import com.projetopoo.view.itemview.MainItem;
import com.projetopoo.view.projetoPOO;
import com.projetopoo.view.requisicaocompraview.MainRequisicaoDeCompra;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class EstoqueMenuControllerView implements Initializable {

    @FXML
    private Button btCriarRequisicao;
      @FXML
    private Button btAlterarRequisicao;

    @FXML
    private Button btControleItens;
    
    
    @FXML
    private Button btVoltar;

    @FXML
    private Label lblTitulo;
    
     private static Stage stage;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startItemMenu() throws Exception{
       projetoPOO.trocaTela("ItemMenu");

    }
        public void backToAdiminMenu(){
        projetoPOO.trocaTela("telaAdmin");
        
        
}
         public void startMenueRequisicao() throws Exception{
       projetoPOO.trocaTela("requisicao");
         }
            public void startAlterarRequisicao() throws Exception{
     MainRequisicaoDeCompra.trocaTela("alterarRequisicao");

    }
     }
    
