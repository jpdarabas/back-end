package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

    public static void main(String[] args) throws Exception {
        String listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaIndiceAleatorio(listaDeNomes);
        nome = nome.substring(0, 1) + nome.substring(1).toLowerCase();

        String listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);
        
        String[] nomes = (nome + ' ' + sobrenome).split("\\s+");

        StringBuilder nomesCapitalizados = new StringBuilder();
        for (String palavra : nomes) {
            nomesCapitalizados.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1).toLowerCase()).append(" ");
        }
        String nomeCompleto = nomesCapitalizados.toString().trim();

        String listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retornaIndiceAleatorio(listaDePosicoes).replaceAll("[^a-zA-Z\\s-]", "");

        String listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
        String clube = retornaIndiceAleatorio(listaDeClubes);

        int idade = (int) Math.floor(Math.random() * 24) + 17;

        System.out.println(nomeCompleto
                + " é um futebolista brasileiro de " + idade + " anos que atua como "
                + posicao
                + ". Atualmente defende o "
                + clube + '.'
        );
    }


    public static String retornaListaDaURI(String minhaUri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }

    public static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }
}