package com.acme.urproviderwebservices.users.store.resource;


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
public class CreateStoreResource {

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
    @Size(max = 200)
    @Column(unique = true)
    private String image;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String storeName;

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Size(max = 60)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String address;

    private long phone;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String password;
}
