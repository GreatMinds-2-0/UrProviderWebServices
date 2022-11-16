package com.acme.urproviderwebservices.security.mapping;

import com.acme.urproviderwebservices.security.domain.model.entity.Role;
import com.acme.urproviderwebservices.security.domain.model.entity.User;
import com.acme.urproviderwebservices.security.resource.UserResource;
import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    Converter<Role, String> roleToStringConverter=new AbstractConverter<Role, String>(){
        @Override
        protected String convert(Role role){
            return role==null?null:role.getName().name();
        }
    };

    // Object Mapping
    public UserResource toResource(User model){
        mapper.addConverter(roleToStringConverter);
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable){
        mapper.addConverter(roleToStringConverter);
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}
