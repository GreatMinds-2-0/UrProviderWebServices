package com.acme.urproviderwebservices.security.domain.service;

import com.acme.urproviderwebservices.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();
    List<Role> getAll();
}
