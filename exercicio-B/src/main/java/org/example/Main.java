package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador gerador = new JogadorGerador();

        ArrayList<Jogador> jogadores = gerador.GerarJogadores();

        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
    }
}