package com.projetopoo.view;



import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.model.FuncionarioModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroFuncionarioControllerView {

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfFuncao;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfSalario;

    @FXML
    private Button btCancelar;
    
    @FXML
    private PasswordField pfSenha;
    @FXML
    private Label lbValidacao;
    
    public void CadastroFuncionario(){
        if(tfNome.getText()!=null && tfCPF.getText()!=null && tfFuncao.getText()!=null && tfTelefone.getText()!=null &&tfSalario.getText()!=null && pfSenha.getText()!=null){
            lbValidacao.setText("CADASTRADO COM SUCESS1O!!");
            float salario= Float.parseFloat(tfSalario.getText());
        
            FuncionarioModel f = new FuncionarioModel(tfFuncao.getText(),pfSenha.getText(),salario,tfNome.getText(),tfTelefone.getText(),tfCPF.getText());
            
           CadastroFuncionarioController cf = new CadastroFuncionarioController();
            cf.InserirFuncionario(f);
            lbValidacao.setText("CADASTRADO COM SUCESSO!!");
        }
        else{
             lbValidacao.setText("EXISTE CAMPOS VAZIOS!");
        }
    
    }

}
