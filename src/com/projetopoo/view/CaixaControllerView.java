package com.projetopoo.view;

import com.projetopoo.controler.*;
import com.projetopoo.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CaixaControllerView implements Initializable{

    @FXML private TableView <ItemModel> tvItens;
    @FXML private TableColumn<?, ?> TCVDescricao;
    @FXML private TableColumn<?, ?> TVCidItem;
    @FXML private TableColumn<?, ?> TVCQtd;
    @FXML private TableColumn<?, ?> TVCPreco;
    @FXML private Label lbTotal;
    @FXML private MaskTextField tfCodigoProduto;
    @FXML private MaskTextField tfQtd;
    @FXML private Button btInserir;
    @FXML private Button btFcharCaixa;
    @FXML private Button btFinalizar;
    @FXML private Button btConsultar;
    @FXML private Button btRemover;
    @FXML private Label lbOperador;
    @FXML private Label lblAdicionado;
    
    CompraModel compraA = new CompraModel(CompraController.GeraIdCompra());
    private List<ItemModel> listaItensTV = new ArrayList<>();
    
    private ObservableList<ItemModel> observableListaItensTV;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        tvItens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
        btInserir.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                verificaEntradasItem();
            }});
        tfCodigoProduto.setMask("NNNN");
        tfQtd.setMask("NNN");
    }
   
    @FXML
    public void verificaEntradasItem(){
        TVCidItem.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        TVCQtd.setCellValueFactory(new PropertyValueFactory<>("qtdDesejada"));
        ItemModel es = new ItemModel(00,00);
        CaixaController.findItem(es, listaItensTV);
        try{
            if(tfCodigoProduto.getText() != null && tfQtd.getText() != null){
                ItemModel b = new ItemModel(Integer.parseInt(tfCodigoProduto.getText()),
                                            Integer.parseInt(tfQtd.getText()));
                System.out.println(b.getIdItem()+" "+b.getQtdDesejada());
                CaixaController.somaItemCaixa(b, listaItensTV, compraA);
                lblAdicionado.setText("Item Adicionado!");    
                refresh();
            }
        }catch(NumberFormatException e){
            lblAdicionado.setText("Campo Vazio!");
        }
    }
    
    public void ChamaConsultar(){
        projetoPOO.trocaTela("consultarProduto");
    }
    
    public void chamaTelaTroco(){
        projetoPOO.trocaTela("telaTroco");
    }
    
    public void FecharCaixa(){
        listaItensTV.clear();
        lbTotal.setText("0.0");
        tvItens.setItems(null);
        tfCodigoProduto.setText("");
        tfQtd.setText("");
        projetoPOO.trocaTela("principal");
    }
    
    private void selecionarItem(ItemModel a){
        if(a != null){
            System.out.println("Selecionado: " + a.getIdItem());
        }
    }
    
    @FXML
    public void removerItemCaixa(){
        ItemModel itemRe = tvItens.getSelectionModel().getSelectedItem();
        if(itemRe != null){
            CaixaController.removerItemCaixaController(itemRe, compraA);
            tvItens.getItems().remove(itemRe);
            listaItensTV.remove(itemRe);
            refresh();
        }
    }
    
    public void refresh(){
        String s;
        this.compraA.setItens(listaItensTV);
        observableListaItensTV = FXCollections.observableArrayList(listaItensTV);
        lbTotal.setText(s = Float.toString(compraA.getValorTot()));
        tvItens.setItems(observableListaItensTV);
    }
    public float getValorCompra(){
        float valor;
        valor = compraA.getValorTot();
        return valor;
    }
    
    public void finalizaCompra(){
        chamaTelaTroco();
        CompraController.inserirCompra(compraA);
    }
}
