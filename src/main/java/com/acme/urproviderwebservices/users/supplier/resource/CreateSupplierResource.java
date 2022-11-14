package com.acme.urproviderwebservices.users.supplier.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String supplierName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String lastName;


    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;


    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address ;

    @NotNull
    @NotBlank
    private long ruc ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String category ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String description ;

    @NotNull
    @NotBlank
    private long phone ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String image;

    @NotNull
    @NotBlank
    public long Likes ;
}
