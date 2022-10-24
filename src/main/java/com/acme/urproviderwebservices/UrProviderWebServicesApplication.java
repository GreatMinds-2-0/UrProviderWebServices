package com.acme.urproviderwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UrProviderWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrProviderWebServicesApplication.class, args);
    }

}
