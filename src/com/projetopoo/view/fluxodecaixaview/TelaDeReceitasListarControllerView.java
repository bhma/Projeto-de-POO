/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.controler.CompraController;
import static com.projetopoo.controler.CompraController.restaurarCompras;
import com.projetopoo.controler.ItemController;
import com.projetopoo.dao.CompraDAO;
import com.projetopoo.model.CompraModel;
import com.projetopoo.model.ItemModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeReceitasListarControllerView implements Initializable {
    
     @FXML
    private Button btVoltar;

    @FXML
    private ListView<?> lwListaItens;

       @FXML
    private TableView<CompraModel> tableViewCompra;

    @FXML
    private TableColumn<CompraModel, String> tableColumnData;

    @FXML
    private TableColumn<CompraModel, String> tableColumnCodigo;

    @FXML
    private TableColumn<CompraModel, String> tableColumnValor;
    
      @FXML
    private TableView<ItemModel> tableViewItens;

       @FXML
    private TableColumn<ItemModel, String> tableColumnId;

     @FXML
    private TableColumn<ItemModel, String>tableColumnPreco;
     
    @FXML
    private TableColumn<ItemModel, String> tableColumnDescricao;

    @FXML
    private TableColumn<ItemModel, String> tableColumnQuantidade;

    private ArrayList<CompraModel> list = new ArrayList<>();
    private ObservableList<CompraModel> ObservableListDebitos;
    
     ArrayList<ItemModel> iitemList = new ArrayList<>();
    private ObservableList<ItemModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
      // CompraController compraController = new CompraController();
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
          this.list = restaurarCompras();
         carregarTableViewReceitas(this.list);
         tableViewCompra.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewReceitas(newValue));
    }    
    
    public void carregarTableViewReceitas(ArrayList<CompraModel> listp){
        
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valorTot"));
        ObservableListDebitos = FXCollections.observableArrayList(listp);
        tableViewCompra.setItems(ObservableListDebitos);
       
    }
    
     public void carregarTableViewItens(ArrayList<ItemModel> listItemp){
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
         tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdDesejada"));
       ObservableListItens = FXCollections.observableArrayList(listItemp);
        tableViewItens.setItems(ObservableListItens);
    }
    
  /*  public void removerItemTableViewDebitos(){
            DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();
            tableViewDebitos.getItems().remove(debito);
            this.list.remove(debito);
    }*/
    public void inserirTableViewReceitas(){//????
         carregarTableViewReceitas(this.list);
    } 
    
       
    public void selecionarItemTableViewReceitas(CompraModel compra){
       // System.out.println(comprap.getDescricao());
       carregarTableViewItens(compra.getItens());
    }
    
    public void backToMenuDespesa(){
         MainFluxoDeCaixa.trocaTela("DespesasMenuView");
    }
   
}
