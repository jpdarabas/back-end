package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Indicacao {
    private Indicavel indicavel;
    private String categoria;

    public Indicacao() {
    }

    @Autowired
    public void setIndicavelFilme(@Qualifier("filme") Indicavel filmeIndicavel, @Value("Melhor Filme") String categoria) {
        this.indicavel = filmeIndicavel;
        this.categoria = categoria;
        filmeIndicavel.updateNumeroDeIndicacoes();
    }
    @Autowired
    public void setIndicavelAtor(@Qualifier("ator") Indicavel atorIndicavel, @Value("MelhorAtor") String categoria) {
        this.indicavel = atorIndicavel;
        this.categoria = categoria;
        atorIndicavel.updateNumeroDeIndicacoes();
    }

    public Indicavel getIndicavel() {
        return indicavel;
    }
    public String getCategoria() {
        return categoria;
    }

}
