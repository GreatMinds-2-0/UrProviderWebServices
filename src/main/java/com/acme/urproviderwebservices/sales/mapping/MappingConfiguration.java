package com.acme.urproviderwebservices.sales.mapping;

import com.acme.urproviderwebservices.inventory.mapping.ProductMapper;
import com.acme.urproviderwebservices.sales.domain.model.entity.Review;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reviewMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReviewMapper reviewMapper() {
        return new ReviewMapper();
    }
}
