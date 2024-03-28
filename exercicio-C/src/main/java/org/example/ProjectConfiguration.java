package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class ProjectConfiguration {
    @Bean
    public String stringBean() {
        return "Exemplo de string";
    }
    @Bean
    public boolean booleanBean() {
        return true; 
    }
}
