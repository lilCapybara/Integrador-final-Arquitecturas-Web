package edu.unicen.exa.integradorarquitecturaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IntegradorArquitecturaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegradorArquitecturaWebApplication.class, args);
    }

}
