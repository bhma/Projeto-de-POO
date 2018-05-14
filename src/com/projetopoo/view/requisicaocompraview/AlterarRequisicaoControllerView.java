/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.RequisicaoModel;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Túlio
 */
public class AlterarRequisicaoControllerView implements Initializable {
    
    @FXML
    private Button btConcluir;

    @FXML
    private Button btRemover;

    @FXML
    private TableView<RequisicaoModel> tbItens;

    @FXML
    private TableColumn<String, RequisicaoModel> tcNomeItem;

    @FXML
    private TableColumn<String, RequisicaoModel> tcQtdItem;

    @FXML
    private TableColumn<String, RequisicaoModel> tcDataDeEntrega;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;
    
    ArrayList<RequisicaoModel> requisicaoList;
    RequisicaoModel requisicao;
    private ObservableList<RequisicaoModel> observableListTableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recuperarLista();
        carregarTableView();
        tbItens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) 
                -> selecionarTableViewItens(newValue));
    }    
    
    public void recuperarLista(){
        RequisicaoController controller = new RequisicaoController();
        requisicaoList = controller.recuperar();
    }
    
    
    public void alterarData(){
       requisicao = tbItens.getSelectionModel().getSelectedItem();
        int tam = requisicaoList.size(), i;
        if(dpDataDeEntrega.getValue().toString() != null){
            for(i = 0; i < tam; i++){
                if(requisicaoList.get(i) == requisicao){
                    String data = dpDataDeEntrega.getValue().toString();
                    requisicaoList.get(i).setDataDeEntrega(data);
                }
            }
        }
        carregarTableView();
    }
    
    public void alterarQtdDesejada(){
        requisicao = tbItens.getSelectionModel().getSelectedItem();
        int tam = requisicaoList.size(), i;
        if(tfQtd.getText() != null){
            for(i = 0; i < tam; i++){
                if(requisicaoList.get(i) == requisicao){
                    requisicaoList.get(i).setQtdDesejada(Integer.parseInt(tfQtd.getText()));
                    tfQtd.setText("");
                }
            }
        }
        carregarTableView();
    }
    
    public void selecionarTableViewItens(RequisicaoModel Requisicao){
        
    }
    
    public void carregarTableView(){
        observableListTableView = FXCollections.observableArrayList(requisicaoList);
        tbItens.setItems(observableListTableView);
        tcNomeItem.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tcQtdItem.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcDataDeEntrega.setCellValueFactory(new PropertyValueFactory<>("DataDeEntrega"));
    }
    
    
    public void removerItem(){
        RequisicaoModel removerRequisicao = tbItens.getSelectionModel().getSelectedItem();
        tbItens.getItems().remove(removerRequisicao);
        requisicaoList.remove(removerRequisicao);
    }
    

      public void btCancelar(){
        tfQtd.setText("");
        requisicaoList = null;
     
        projetoPOO.trocaTela("estoqueMenu");
        observableListTableView.clear();
    }
    public void btConcluir(){
        RequisicaoController controller = new RequisicaoController();
        controller.atualizarLista(requisicaoList);
    }    
}
