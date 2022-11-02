package com.acme.urproviderwebservices.users.supplier.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateSupplierResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @Size(max = 200)
    private Long phoneNumber;
}
