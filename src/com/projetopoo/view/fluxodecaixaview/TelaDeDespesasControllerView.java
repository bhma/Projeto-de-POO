/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.view.fluxodecaixaview.MainFluxoDeCaixa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeDespesasControllerView implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startInserirDespesa(){
         MainFluxoDeCaixa.trocaTela("InserirDespesaView");
    }
    public void startListarDespesas(){
        MainFluxoDeCaixa.trocaTela("ListarDespesaView");
    }
    
}
