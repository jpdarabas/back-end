package org.example;
import org.springframework.stereotype.Component;

@Component
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
    public void setNumeroDeIndicacoes(short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }
}
