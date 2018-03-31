
package com.projetopoo.view;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Naira Gasai
 */
public class projetoPOO extends Application implements Initializable{
    private static Stage stage;
    private static Stage popup;
    
    
    private static Scene principalScene;
    private static Scene cadastroScene;
    private static Scene loginCaixaScene;
    private static Scene caixaScene;
    private static Scene consultarProdutoScene;
    private static Scene telaTroco;
    private static Scene telaAdmin;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("FXML.TelaInicial.fxml")); 
        principalScene = new Scene(fxmlPrincipal);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("FXML.CadastroFuncionario.fxml")); 
        cadastroScene = new Scene(fxmlCadastro);
        Parent fxmlLoginCaixa = FXMLLoader.load(getClass().getResource("FXML.LoginCaixa.fxml")); 
        loginCaixaScene = new Scene(fxmlLoginCaixa);
        Parent fxmlCaixa = FXMLLoader.load(getClass().getResource("FXML.Caixa.fxml")); 
        caixaScene = new Scene(fxmlCaixa);
        Parent fxmlConsultarProduto = FXMLLoader.load(getClass().getResource("FXML.ConsultarProduto.fxml")); 
        consultarProdutoScene = new Scene(fxmlConsultarProduto);
        Parent fxmlTelaTroco = FXMLLoader.load(getClass().getResource("FXML.TelaTroco.fxml"));
        telaTroco = new Scene(fxmlTelaTroco);
        Parent fxmlTelaAdmin = FXMLLoader.load(getClass().getResource("FXML.TelaAdmin.fxml"));
        telaAdmin = new Scene(fxmlTelaAdmin);
        
        stage.setScene(principalScene);
        stage.show();
    }
    
    
    
    public static void trocaTela(String scr){
        switch (scr){
            case"principal":
                stage.setScene(principalScene);
                break;
            case "cadastro":
                stage.setScene(cadastroScene);
                break;
            case"loginCaixa":
                stage.setScene(loginCaixaScene);
                break;
            case "caixa":
                stage.setScene(caixaScene);
                break;
            case"consultarProduto":
                stage.setScene(consultarProdutoScene);
               break;
            case"telaTroco":
                stage.setScene(telaTroco);
                break;
            case"telaAdmin":
                stage.setScene(telaAdmin);
                break;
        }
    
    }

    
    
    
    public static void main(String[] args) {
        System.out.println("oi");
        launch(args);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}