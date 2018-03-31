/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Andrade
 */
public class TelaAdminControllerView implements Initializable {

    @FXML
    private Button btFuncionario;

    @FXML
    private Button btFinanceiro;

    @FXML
    private Button btFornecedor;

    @FXML
    private Button btVoltarAdmin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    public void chamaTelaInicial(){
        projetoPOO.trocaTela("principal");
    }
    
}
