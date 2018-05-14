/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.dao.RequisicaoDAO;
import com.projetopoo.model.RequisicaoModel;
import java.util.ArrayList;

/**
 *
 * @author Túlio
 */
public class RequisicaoController {
    ArrayList<RequisicaoModel> lista= new ArrayList();
    
    public void cadastrar(ArrayList<RequisicaoModel> lista){
        RequisicaoDAO dao = new RequisicaoDAO();
        dao.inserir(lista);
    }
    
    public ArrayList<RequisicaoModel> recuperar(){
        RequisicaoDAO dao = new RequisicaoDAO();
        return dao.recuperar();
    }
    
    public void atualizarLista(ArrayList<RequisicaoModel> lista){
        RequisicaoDAO dao = new RequisicaoDAO();
        dao.salvarAlteracao(lista);
    }   
}
