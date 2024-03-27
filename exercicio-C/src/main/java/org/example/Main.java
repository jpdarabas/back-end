package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        OscarService oscarService = context.getBean(OscarService.class);

        for (int i = 1; i<11; i++){
            short aleatorio = (short) Math.ceil(Math.random()*2);

            Indicavel indicado = (aleatorio == 0)? context.getBean(Ator.class, "Ator_"+ i, "Brasil") : context.getBean(Filme.class, "Filme_"+ i, "Ação");
            }
            Indicacao indicacao = context.getBean(Indicacao.class, indicado, "O melhor");

            oscarService.adicionarIndicacao(indicacao);
        }

        oscarService.mostrarListaIndicados();
}