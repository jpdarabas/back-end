package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("filme")
public class Filme implements Indicavel {
    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes = 0;
    
    public Filme(String nome, String genero, boolean elegivel) {
        this.nome = nome;
        this.genero = genero;
        this.elegivel = elegivel;
    }

    public String getNome() {
        return nome;
    }
    
    public String getGenero() {
        return genero;
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
