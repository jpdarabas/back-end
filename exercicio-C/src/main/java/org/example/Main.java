package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        OscarService oscarService = context.getBean(OscarService.class);

        
        for (int i = 1; i < 11; i++) {
            boolean atorOuFilme = Math.random() < 0.5;
            boolean elegivel = Math.random() < 0.5;

            if (atorOuFilme) {
                Indicavel indicado = (Indicavel) context.getBean(Ator.class, "Ator_" + i, "Brasil", elegivel);
                
                Indicacao indicacao = context.getBean(Indicacao.class);
                indicacao.setIndicavelAtor(indicado, "Melhor Ator");
                if (elegivel){
                oscarService.adicionarIndicacao(indicacao);
                }else{
                    System.out.println("Erro: O ator não é elegível para a indicação.");
                }
            } else {
                Indicavel indicado = (Indicavel) context.getBean(Filme.class, "Filme_" + i, "Ação", elegivel);

                Indicacao indicacao = context.getBean(Indicacao.class);
                indicacao.setIndicavelFilme(indicado, "Melhor Filme");
                if (elegivel){
                oscarService.adicionarIndicacao(indicacao);
                }else{
                    System.out.println("Erro: O filme não é elegível para a indicação.");
                }
            }
            
        }
        System.out.println("------------------------------------------------------------------------------------");
        oscarService.mostrarListaIndicados();
    }
}