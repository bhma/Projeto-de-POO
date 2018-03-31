/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.controler.ItemController;
import com.projetopoo.model.ItemModel;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemCadastroController implements Initializable {
       @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpData;

    @FXML
    private TextField tfPreco;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btInserir;

    @FXML
    private Button btRemover;

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

    @FXML
    private Button btVoltar;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfPosicao;
    
     ArrayList<ItemModel> list = new ArrayList<>();
    private ObservableList<ItemModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewItens(this.list);
        tableViewItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
    }    
    
     public void inserirTableViewInserirItens(){
          if(tfDescricao.getText() != null && tfPreco.getText() != null && dpData.getValue() != null && tfQuantidade.getText() != null && tfPosicao.getText() !=null){
            ItemModel item = new ItemModel(1,Integer.parseInt(tfQuantidade.getText()),Float.parseFloat(tfPreco.getText()), tfDescricao.getText(),dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),tfPosicao.getText());
              System.out.println(item.getQtdEstoque());
              System.out.println(item.getDescricao());
             list.add(item);
              carregarTableViewItens(this.list);
         }
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
    
    public void salvarTableViewItens(){
        if(this.list.isEmpty() == false){
            itemController.salvarArrayList(list);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            //dialogoInfo.setTitle("");
            dialogoInfo.setHeaderText("SALVO COM SUCESSO");
            //dialogoInfo.setContentText("Informação importante!");
            dialogoInfo.showAndWait();
        this.list.clear();
        this.ObservableListItens.clear();
        }
    }
    public void selecionarItemTableViewItens(ItemModel debitop){
       // System.out.println(debitop.getDescricao());
    }
    
      public void backToMenuItem(){
        MainItem.trocaTela("itemMenu");
         
    }
    public void removerItemTableViewItens(){
           ItemModel item = tableViewItens.getSelectionModel().getSelectedItem();
            tableViewItens.getItems().remove(item);
            this.list.remove(item);
    }
    

}
