/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.controler.FornecedorController;
import static com.projetopoo.controler.FornecedorController.ConsultaFornecedor;
import com.projetopoo.controler.ItemController;
import com.projetopoo.model.FornecedorModel;
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
import javafx.scene.control.Label;
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
    private Label lblTitulo;
    
      @FXML
    private TextField tfIdItem;

       @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpData;

    @FXML
    private TextField tfPreco;
    
      @FXML
    private TextField tfIdFornecedor;
   

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
    private TableColumn<ItemModel, String> tableColumnId;


    @FXML
    private TableColumn<ItemModel, String> tableColumnQuantidade;

    @FXML
    private TableColumn<ItemModel, String> tableColumnPreco;

    @FXML
    private TableColumn<ItemModel, String> tableColumnValidade;

    @FXML
    private TableColumn<ItemModel, String> tableColumnPosicao;
    
      @FXML
    private TableView<FornecedorModel> tableViewFornecedores;

    @FXML
    private TableColumn<FornecedorModel, String> tableColumnIdFornecedor;

    @FXML
    private TableColumn<FornecedorModel, String>  tableColumnRazaoSocial;

    @FXML
    private TableColumn<FornecedorModel, String>  tableColumnCnpj;



    @FXML
    private Button btVoltar;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfPosicao;
    
     ArrayList<ItemModel> list = new ArrayList<>();
    private ObservableList<ItemModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
      ArrayList<FornecedorModel> listFornecedor = new ArrayList<>();
     private ObservableList<FornecedorModel> ObservableListFornecedores;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        carregarTableViewItens(this.list);
        tableViewItens.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
        
           tableViewFornecedores.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue)  -> selecionarItemTableViewFornecedor(newValue));
    }    
    
    public void inseirTextFieldFornecedor(){
         FornecedorModel  fornecedor  = ConsultaFornecedor(tfIdFornecedor.getText());
         if(fornecedor != null){
         listFornecedor.add(fornecedor);
          carregarTableViewFornecedor(this.listFornecedor);
 
     }
         else{
             Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
             dialogoInfo.setTitle("AVISO");
             dialogoInfo.setHeaderText("FORCEDOR NÃO CADASTRADO");
                 //dialogoInfo.setContentText("Informação importante!");
              dialogoInfo.showAndWait();
         }
    }
    
    public void inseirTextFieldItem(){
      
             ItemModel i = itemController.consultarItem((tfIdItem.getText()));
             if(i != null){//se existir, já inserir no txtField
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                 dialogoInfo.setTitle("AVISO");
                 dialogoInfo.setHeaderText("PRODUTO JÁ CADASTRADO");
                 //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
                tfIdItem.clear();
             }
             else{
                   tfDescricao.setEditable(true);
                  tfPreco.setEditable(true);
                  tfQuantidade.setEditable(true);
                 tfPosicao.setEditable(true);
                 dpData.setEditable(true);
             }
          }
    
     public void inserirTableViewInserirItens(){
         if((tfIdItem.getText()).length()>0  &&tfIdItem.getText().isEmpty() == false ){
            ItemModel i = itemController.consultarItem((tfIdItem.getText()));
             if(i != null){//se existir, já inserir no txtField
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                 dialogoInfo.setTitle("AVISO");
                 dialogoInfo.setHeaderText("PRODUTO JÁ CADASTRADO");
                 //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
             }
             else if(tfDescricao.getText() != null && tfPreco.getText() != null && dpData.getValue() != null && tfQuantidade.getText() != null && tfPosicao.getText() !=null && listFornecedor.isEmpty()==false){
            ItemModel item = new ItemModel(tfIdItem.getText(),Integer.parseInt(tfQuantidade.getText()),Float.parseFloat(tfPreco.getText()), tfDescricao.getText(),dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),tfPosicao.getText(),listFornecedor);
             list.add(item);
              carregarTableViewItens(this.list);
         }
    } 
     }
     
    
    public void carregarTableViewItens(ArrayList<ItemModel> listp){
        
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));
         tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        tableColumnPosicao.setCellValueFactory(new PropertyValueFactory<>("posicaoEstoque"));
       ObservableListItens = FXCollections.observableArrayList(listp);
        tableViewItens.setItems(ObservableListItens);
       
    }
    
    public void carregarTableViewFornecedor(ArrayList<FornecedorModel> listFornecedorp){
        
        tableColumnIdFornecedor.setCellValueFactory(new PropertyValueFactory<>("idForn"));
        tableColumnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
         tableColumnCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
       ObservableListFornecedores = FXCollections.observableArrayList(listFornecedorp);
        tableViewFornecedores.setItems(ObservableListFornecedores);
       
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
    public void selecionarItemTableViewItens(ItemModel itemp){
       // System.out.println(debitop.getDescricao());
    }
    
     public void selecionarItemTableViewFornecedor(FornecedorModel fornecedorp){
       // System.out.println(debitop.getDescricao());
    }
    
     
    public void removerItemTableViewItens(){
           ItemModel item = tableViewItens.getSelectionModel().getSelectedItem();
            tableViewItens.getItems().remove(item);
            this.list.remove(item);
    }
     public void removerItemTableViewFornecedor(){
          FornecedorModel fornecedor = tableViewFornecedores.getSelectionModel().getSelectedItem();
         tableViewFornecedores.getItems().remove(fornecedor);
            this.listFornecedor.remove(fornecedor);
    }

      public void backToMenuItem(){
        MainItem.trocaTela("itemMenu");
         
    }
}
