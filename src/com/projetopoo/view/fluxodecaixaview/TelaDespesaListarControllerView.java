/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.view.fluxodecaixaview.MainFluxoDeCaixa;
import com.projetopoo.controler.DebitoController;
import com.projetopoo.dao.DebitoDAO;
import com.projetopoo.model.DebitoModel;
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
public class TelaDespesaListarControllerView implements Initializable {
    @FXML
    private TableView<DebitoModel> tableViewDebitos;

    @FXML
    private TableColumn<DebitoModel, String> tableColumnData;

    @FXML
    private TableColumn<DebitoModel, String> tableColumnDescricao;

    @FXML
    private TableColumn<DebitoModel, String> tableColumnValor;

    @FXML
    private Button btVoltar;
      @FXML
    private Button btAlterar;

    @FXML
    private Button btRemover;

   
    @FXML
    private Button btSalvar;
    
      @FXML
    private TextField tfDescricao;
        @FXML
    private DatePicker dpData;

    @FXML
    private TextField tfValor;
    
    private ArrayList<DebitoModel> list = new ArrayList<>();
    private ObservableList<DebitoModel> ObservableListDebitos;
     DebitoController debitoController = new DebitoController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          this.list = debitoController.recuperarLista();
         carregarTableViewDebitos(this.list);//carrega a tabela com os objetos do a lista
         tableViewDebitos.getSelectionModel().selectedItemProperty().addListener(//utilizado para seleceionar um objeto na lista
                (observable, oldValue, newValue)  -> selecionarItemTableViewDebitos(newValue));
         
    }    
    
    public void carregarTableViewDebitos(ArrayList<DebitoModel> listp){
        
        tableViewDebitos.refresh();
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ObservableListDebitos = FXCollections.observableArrayList(listp);
        tableViewDebitos.setItems(ObservableListDebitos);
       
    }
    
    public void removerItemTableViewDebitos(){
            DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();
            tableViewDebitos.getItems().remove(debito);
            this.list.remove(debito);
    }
    public void inserirTableViewDebitos(){
         carregarTableViewDebitos(this.list);
    } 
    
    public void alterarItemTableViewDebitos(){
          if(tfDescricao.getText() != null && tfValor.getText() != null && dpData.getValue() != null){
         DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();
         tableViewDebitos.getItems().remove(debito);
         DebitoModel debitoNovo = new DebitoModel(tfDescricao.getText(),Float.parseFloat(tfValor.getText()),dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
         for(int i =0; i < list.size(); i++){
             if(debito.getDescricao().equals(list.get(i).getDescricao())){
                 list.get(i).setDescricao(debitoNovo.getDescricao());
                  list.get(i).setValor(debitoNovo.getValor());
                   list.get(i).setData(debitoNovo.getData());
             }
         }
         this.ObservableListDebitos.clear();
        carregarTableViewDebitos(this.list);
       //  salvarTableViewDebitos();
        //  startListarDespesas();
        // carregarTableViewDebitos(this.list);
           // this.list.remove(debito);
          }
        
    }
    
      public void salvarTableViewDebitos(){
            debitoController.salvarAlteracao(list);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            //dialogoInfo.setTitle("");
            dialogoInfo.setHeaderText("SALVO COM SUCESSO");
            //dialogoInfo.setContentText("Informação importante!");
            dialogoInfo.showAndWait();
             tfDescricao.clear();
             tfValor.clear();
      }
      
    public void selecionarItemTableViewDebitos(DebitoModel debitop){
      //  System.out.println(debitop.getDescricao());
    }
    public void startListarDespesas(){
        MainFluxoDeCaixa.trocaTela("ListarDespesaView");
    }
     public void backToMenuDespesa(){
         MainFluxoDeCaixa.trocaTela("DespesasMenuView");
         
    }
     
}
