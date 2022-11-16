package com.acme.urproviderwebservices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SecurityScheme(name = "urprovider", scheme = "bearer",type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@OpenAPIDefinition
@EnableJpaAuditing
@SpringBootApplication
public class UrProviderWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrProviderWebServicesApplication.class, args);
    }

}
