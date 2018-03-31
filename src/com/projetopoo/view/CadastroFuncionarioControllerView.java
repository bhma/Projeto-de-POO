package com.projetopoo.view;


import com.projetopoo.model.FuncionarioModel;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.projetopoo.dao.FuncionarioDAO;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CadastroFuncionarioControllerView {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfFuncao;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfValorHora;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btCancelar;
    
    @FXML 
    private Button btn1;
    
    @FXML
    private Label lbl1;
    
    
    
    @FXML
    public void cadastrar(){
       // ArrayList<FuncionarioModel> funcionarioList = new ArrayList();
        FuncionarioModel funcionario = new FuncionarioModel(tfFuncao.getText(),/*tfValorHora.getText()*/2,tfNome.getText(),tfTelefone.getText(),tfCPF.getText(), "1");
      //  System.out.println("Nome: " + funcionario.getNome());
      FuncionarioDAO f = new FuncionarioDAO();
      //f.cadastrarFuncionario(funcionario);
        //lbl1.setText("Dannillo");
       // f.restaurarFuncionario();
        ArrayList<FuncionarioModel> list = new ArrayList();
         try {
                           FileInputStream restFile = new FileInputStream("s.txt");
                           ObjectInputStream stream = new ObjectInputStream(restFile);
                           // recupera o objeto
                         
                           list = (ArrayList<FuncionarioModel>)stream.readObject();
                           System.out.println("4");
                           stream.close();
                          

                    } catch (Exception e) {// caso de erro

                           e.printStackTrace();

                    }

        
        
        
    }
    @FXML
    public void loucura(){
        lbl1.setText("Dannillo");
    }

}
