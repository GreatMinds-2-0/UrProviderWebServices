package com.acme.urproviderwebservices.security.mapping;

import com.acme.urproviderwebservices.security.domain.model.enumeration.Roles;
import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class RoleMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    Converter<Roles,String> roleToString = new AbstractConverter<Roles, String>() {
        @Override
        protected String convert(Roles roles) {
            return null;
        }
    }

}
