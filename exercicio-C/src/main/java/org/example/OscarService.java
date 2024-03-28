package org.example;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OscarService {

    private List<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicacao indicacao) {
        indicacoes.add(indicacao);
    }

    public void mostrarListaIndicados() {
        for (Indicacao indicacao : indicacoes) {
            Indicavel indicavel = indicacao.getIndicavel();
            String textinho = " foi indicado para o Oscar de " + indicacao.getCategoria() + ". É sua ";
    
            String mensagem = (indicavel instanceof Ator) ? ("O ator " + ((Ator) indicavel).getNome()) + textinho + indicavel.getNumeroDeIndicacoes() + "ª indicação." : ("O filme " + ((Filme) indicavel).getNome()) + textinho + indicavel.getNumeroDeIndicacoes() + "ª indicação.";
            System.out.println(mensagem);
        }
    }
}
