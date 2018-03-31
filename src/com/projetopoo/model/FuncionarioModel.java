package com.projetopoo.model;

import java.io.Serializable;


public class FuncionarioModel extends PessoaModel implements Serializable {
    private String funcao;
    private float valorHora;
    private float hrsTrabalhadas;

    public FuncionarioModel(String funcao, float valorHora, String nome, String tel, String cpf, String id) {
        super(nome, tel,id, cpf);
        
        this.funcao = funcao;
        this.valorHora = valorHora;
        this.hrsTrabalhadas = 0;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getHrsTrabalhadas() {
        return hrsTrabalhadas;
    }

    public void setHrsTrabalhadas(float hrsTrabalhadas) {
        this.hrsTrabalhadas = hrsTrabalhadas;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
