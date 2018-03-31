package com.projetopoo.model;
import java.io.Serializable;
import java.util.List;

public class ClienteModel extends PessoaModel implements Serializable {
    private boolean cadastrado;


    public ClienteModel(String nome, String tel, String id, String cpf) {
        super(nome, tel, id, cpf);
    }
    
    public ClienteModel(){
       super(null, null, null, null);
       this.cadastrado = false;
    }
    
    public boolean getCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    @Override
    public String toString() {
        return "===========================================\n" +
                "Cliente{" +
                "cadastrado = " + cadastrado +
                super.toString() +
                '}';
    }

    public void cadastrar(){
        this.cadastrado = true;
    }

    public void cancelarCadastro(){
        this.cadastrado = false;
    }
}
