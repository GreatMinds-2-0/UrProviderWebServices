package com.acme.urproviderwebservices.users.store.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("supplierMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public StoreMapper supplierMapper() {
        return new StoreMapper();
    }
}