/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.controler.ItemController;
import com.projetopoo.model.ItemModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemListarControllerView implements Initializable {

   
    @FXML
    private Button btVoltar;
    
@FXML
   private TableView<ItemModel> tableViewItens;

    @FXML
    private TableColumn<ItemModel, String> tableColumnDescricao;

    @FXML
    private TableColumn<ItemModel, String> tableColumnQuantidade;

    @FXML
    private TableColumn<ItemModel, String> tableColumnPreco;

    @FXML
    private TableColumn<ItemModel, String> tableColumnValidade;

    @FXML
    private TableColumn<ItemModel, String> tableColumnPosicao;
    
    ArrayList<ItemModel> list = new ArrayList<>();
    private ObservableList<ItemModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.list = itemController.recuperarLista();
       carregarTableViewItens(this.list);
          tableViewItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
    }    
    
      public void carregarTableViewItens(ArrayList<ItemModel> listp){
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        tableColumnPosicao.setCellValueFactory(new PropertyValueFactory<>("posicaoEstoque"));
        ObservableListItens = FXCollections.observableArrayList(listp);
        tableViewItens.setItems(ObservableListItens);
       
    }
   public void selecionarItemTableViewItens(ItemModel item){
       // System.out.println(debitop.getDescricao());
    }
   
     public void backToMenuItem(){
    MainItem.trocaTela("itemMenu");
         
    }
   
}
