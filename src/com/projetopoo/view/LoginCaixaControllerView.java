
package com.projetopoo.view;

import com.projetopoo.model.MaskTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class LoginCaixaControllerView implements Initializable{

    @FXML
    private MaskTextField tfIdFuncionario;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private MaskTextField tfIdCaixa;
    
    @FXML
    private Button btEntrar;
    
    public void chamaCaixa(){
        projetoPOO.trocaTela("caixa");
    }
    
    public void chamaTelaInicial(){
        projetoPOO.trocaTela("principal");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfIdFuncionario.setMask("NNNN");
        tfIdCaixa.setMask("NNNN");
    }
}
