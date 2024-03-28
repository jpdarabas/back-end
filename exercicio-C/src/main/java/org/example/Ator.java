package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("ator")
public class Ator implements Indicavel {
    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes = 0;

    public Ator(String nome, String nacionalidade, boolean elegivel) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.elegivel = elegivel;
    }
    public String getNome() {
        return nome;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    @Override
    public boolean isElegivel() {
        return elegivel;
    }
    
    @Override
    public short getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }
    @Override
    public void updateNumeroDeIndicacoes() {
        this.numeroDeIndicacoes += 1;
    }
}
