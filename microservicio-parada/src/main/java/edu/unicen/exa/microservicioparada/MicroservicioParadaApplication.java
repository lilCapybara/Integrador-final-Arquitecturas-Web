package edu.unicen.exa.microservicioparada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class MicroservicioParadaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioParadaApplication.class, args);
    }

}
