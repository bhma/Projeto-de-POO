package com.projetopoo.view.requisicaocompraview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.projetopoo.model.ItemModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.projetopoo.controler.ItemController;
import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.RequisicaoModel;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

public class RequisicaoControllerView implements Initializable{
    
    
    @FXML
    private Button btConcluir;

    @FXML
    private Button btRemover;

    @FXML
    private TableView<RequisicaoModel> tbItens;

    @FXML
    private TableColumn<RequisicaoModel, String> tcNomeItem;

    @FXML
    private TableColumn<RequisicaoModel, String> tcQtdItem;

    @FXML
    private TableColumn<RequisicaoModel, String> tcDataDeEntrega;

    @FXML
    private Button btCancelar;

    @FXML
    private ComboBox<ItemModel> cbItens;

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;

    @FXML
    private Button btInserir;
    
    private ObservableList<ItemModel> obervableListItens;
    private List<ItemModel> listItens = new ArrayList<>();
    private ObservableList<RequisicaoModel> observableListTableView;
    private ArrayList<RequisicaoModel> requisicao = new ArrayList<>();
    RequisicaoModel novaRequisicao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        novaRequisicao = new RequisicaoModel();
        carregarComboBoxItens();
        tbItens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) 
                -> selecionarTableViewItens(newValue));
    }
    
    public void pegarDados (){
        carregarComboBoxItens();
        selecionarItem();
        selecionarData();
        selecionarQuantidade();
        requisicao.add(novaRequisicao);
        carregarTableView();
        novaRequisicao = new RequisicaoModel();
    }
    
    public void carregarComboBoxItens(){
        ItemController controller = new ItemController();
        listItens = controller.recuperarLista();
        obervableListItens = FXCollections.observableArrayList(listItens);
        cbItens.setItems(obervableListItens);
    }
    
     @FXML
    public void selecionarItem(){
        if(cbItens.getSelectionModel().getSelectedItem() != null){
            ItemModel item = cbItens.getSelectionModel().getSelectedItem();
            novaRequisicao.setDescricao(item.getDescricao());
        }
    }
    
    @FXML
    public void selecionarData(){
        if(dpDataDeEntrega.getValue().toString() != null){
            String data = dpDataDeEntrega.getValue().toString();
            novaRequisicao.setDataDeEntrega(data);
        }
    }
    
    @FXML
    public void selecionarQuantidade(){
        if(tfQtd.getText() != null){
        novaRequisicao.setQtdDesejada(Integer.parseInt(tfQtd.getText()));
        tfQtd.setText("");
        }
    }
    
    @FXML
    public void btConcluir(){
        RequisicaoController controller = new RequisicaoController();
        controller.cadastrar(requisicao);
    }
    
    @FXML
    public void btCancelar(){
        tfQtd.setText("");
        requisicao = null;
        projetoPOO.trocaTela("estoqueMenu");
        observableListTableView.clear();
    }
    
    public void carregarTableView(){
        observableListTableView = FXCollections.observableArrayList(requisicao);
        tbItens.setItems(observableListTableView);
        tcNomeItem.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tcQtdItem.setCellValueFactory(new PropertyValueFactory<>("qtdDesejada"));
        tcDataDeEntrega.setCellValueFactory(new PropertyValueFactory<>("dataDeEntrega"));
    }
    
    public void selecionarTableViewItens(RequisicaoModel Requisicao){
        
    }
    
    @FXML
    public void removerItem(){
        RequisicaoModel removerRequisicao = tbItens.getSelectionModel().getSelectedItem();
        tbItens.getItems().remove(removerRequisicao);
        requisicao.remove(removerRequisicao);
        
    }
}
