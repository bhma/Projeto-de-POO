package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.RequisicaoModel;
import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RequisicaoControllerView {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btConcluir;

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;
    
    @FXML
    private TextField tfDescricao;
    
    RequisicaoModel requisicao = new RequisicaoModel();

    @FXML
    void btCancelar() {
       tfDescricao.setText("");
       tfQtd.setText("");
       dpDataDeEntrega.setValue(null);
       projetoPOO.trocaTela("estoqueMenu");
    }

    @FXML
    void btConcluir() {
        RequisicaoController controller = new RequisicaoController();
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        selecionarData();
        selecionarDescricao();
        selecionarQuantidade();
        controller.cadastrar(requisicao);
        dialogoInfo.setTitle("AVISO");
        dialogoInfo.setHeaderText("Requisição realizada!");
        dialogoInfo.showAndWait();
        tfDescricao.setText("");
        tfQtd.setText("");
        dpDataDeEntrega.setValue(null);
    }

    @FXML
    void selecionarData() {
       String data;
       data = dpDataDeEntrega.getValue().toString();
       requisicao.setDataDeEntrega(data);
    }
    
    @FXML
    void selecionarDescricao(){
        String descricao;
        descricao = tfDescricao.getText();
        requisicao.setDescricao(descricao);
    }
    
    @FXML 
    void selecionarQuantidade(){
        int quantidade;
        quantidade = Integer.parseInt(tfQtd.getText());
        requisicao.setQtdDesejada(quantidade);
    }
}
