/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.controler.CompraController;
import static com.projetopoo.controler.CompraController.restaurarCompras;
import com.projetopoo.dao.CompraDAO;
import com.projetopoo.model.CompraModel;
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
    private TableView<CompraModel> tableViewReceitas;

    @FXML
    private TableColumn<CompraModel, String> tableColumnData;

    @FXML
    private TableColumn<CompraModel, String> tableColumnCodigo;

    @FXML
    private TableColumn<CompraModel, String> tableColumnValor;

    private ArrayList<CompraModel> list = new ArrayList<>();
    private ObservableList<CompraModel> ObservableListDebitos;
      // CompraController compraController = new CompraController();
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
          this.list = restaurarCompras();
         carregarTableViewReceitas(this.list);
         tableViewReceitas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewReceitas(newValue));
    }    
    
    public void carregarTableViewReceitas(ArrayList<CompraModel> listp){
        
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ObservableListDebitos = FXCollections.observableArrayList(listp);
        tableViewReceitas.setItems(ObservableListDebitos);
       
    }
    
  /*  public void removerItemTableViewDebitos(){
            DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();
            tableViewDebitos.getItems().remove(debito);
            this.list.remove(debito);
    }*/
    public void inserirTableViewReceitas(){
         carregarTableViewReceitas(this.list);
    } 
    
       
    public void selecionarItemTableViewReceitas(CompraModel compra){
       // System.out.println(comprap.getDescricao());
    }
   
}
